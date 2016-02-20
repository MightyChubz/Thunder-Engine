package com.MightyChubz.core;

import org.lwjgl.BufferUtils;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALContext;
import org.lwjgl.openal.ALDevice;
import org.lwjgl.stb.STBVorbisInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static com.MightyChubz.core.IOUtil.ioResourceToByteBuffer;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALUtil.checkALError;
import static org.lwjgl.stb.STBVorbis.*;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * This class handles every to do with audio, it does this by converting the .ogg file into memory.
 * It’s much like the texture.
 */
public class Audio {
    private int source;
    private ALDevice device;
    private ALContext context;

    /**
     * This initializes the context of the audio and initializes the device.
     */
    public void initContext() {
        device = ALDevice.create(null);
        context = ALContext.create(device);

        ALCCapabilities capabilities = device.getCapabilities();
    }

    /**
     * This method controls the loading of the file, this controls how its put into the memory,
     * how it should buffer and what type of speaker it should player through.
     *
     * @param resource
     * @param shouldLoop
     */
    public void loadAudioFile(InputStream resource, boolean shouldLoop) {
        STBVorbisInfo info = STBVorbisInfo.calloc();
        ByteBuffer pcm = readVorbis(resource, 32 * 1026, info);

        int buffer = alGenBuffers();
        checkALError();

        source = alGenSources();
        checkALError();

        alBufferData(buffer, AL_FORMAT_STEREO16, pcm, info.sample_rate());
        checkALError();

        info.free();

        alSourcei(source, AL_BUFFER, buffer);
        checkALError();

        alSourcei(source, AL_LOOPING, shouldLoop ? AL_TRUE : AL_FALSE);
        checkALError();
    }

    /**
     * This plays the audio.
     */
    public void play() {
        alSourcePlay(source);
        checkALError();
    }

    /**
     * This pauses the audio.
     */
    public void pause() {
        alSourcePause(source);
        checkALError();
    }

    /**
     * This stops the audio.
     */
    public void stop() {
        alSourceStop(source);
        checkALError();
    }

    /**
     * This is a very important class as it disposes of both context and device, thus freeing up memory.
     */
    public void close() {
        device.destroy();
        context.destroy();
    }

    /**
     * This is a method to test the waters and to see if the audio plays fine.
     *
     * @param path
     */
    public void demo(String path) {
        STBVorbisInfo info = STBVorbisInfo.calloc();
        ByteBuffer pcm = readVorbis(ResourceLoader.LoadResource(path), 32 * 1026, info);

        int buffer = alGenBuffers();
        checkALError();

        int source = alGenSources();
        checkALError();

        alBufferData(buffer, AL_FORMAT_STEREO16, pcm, info.sample_rate());
        checkALError();

        info.free();

        alSourcei(source, AL_BUFFER, buffer);
        checkALError();

        alSourcei(source, AL_LOOPING, AL_TRUE);
        checkALError();

        alSourcePlay(source);
        checkALError();
    }

    /**
     * This hand the file to IOUtil to handle converting into memory,
     * after this opens the memory form of the .ogg file and start setting it up for use.
     *
     * @param resource
     * @param bufferSize
     * @param info
     * @return ByteBuffer
     */
    private ByteBuffer readVorbis(InputStream resource, int bufferSize, STBVorbisInfo info) {
        ByteBuffer vorbis = null;

        try {
            vorbis = ioResourceToByteBuffer(resource, bufferSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

        IntBuffer error = BufferUtils.createIntBuffer(1);
        assert vorbis != null;
        long decoder = stb_vorbis_open_memory(vorbis, error, null);
        if (decoder == NULL)
            throw new RuntimeException("Failed to open Ogg Vorbis file. Error: " + error.get(0));

        stb_vorbis_get_info(decoder, info);

        int channels = info.channels();
        int lengthSamples = stb_vorbis_stream_length_in_samples(decoder);

        ByteBuffer pcm = BufferUtils.createByteBuffer(lengthSamples * 4);

        stb_vorbis_get_samples_short_interleaved(decoder, channels, pcm, lengthSamples * 2);
        stb_vorbis_close(decoder);

        return pcm;
    }
}

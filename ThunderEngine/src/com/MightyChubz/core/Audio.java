package com.MightyChubz.core;

import org.lwjgl.BufferUtils;
import org.lwjgl.openal.ALCCapabilities;
import org.lwjgl.openal.ALContext;
import org.lwjgl.openal.ALDevice;
import org.lwjgl.stb.STBVorbisInfo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static com.MightyChubz.core.IOUtil.ioResourceToByteBuffer;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALUtil.checkALError;
import static org.lwjgl.stb.STBVorbis.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Audio {

    public void init() {
        ALDevice device = ALDevice.create(null);
        ALContext.create(device);

        ALCCapabilities capabilities = device.getCapabilities();
    }

    public void demo() {
        STBVorbisInfo info = STBVorbisInfo.calloc();
        ByteBuffer pcm = readVorbis("/Sad_Dreams.ogg", 32 * 1026, info);

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

    private ByteBuffer readVorbis(String resource, int bufferSize, STBVorbisInfo info) {
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

package com.MightyChubz.core;

import org.lwjgl.BufferUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class IOUtil {
    public IOUtil() {
    }

    private static ByteBuffer resizeBuffer(ByteBuffer buffer, int newCapacity) {
        ByteBuffer newBuffer = BufferUtils.createByteBuffer(newCapacity);
        buffer.flip();
        newBuffer.put(buffer);
        return newBuffer;
    }

    public static ByteBuffer ioResourceToByteBuffer(String resource, int bufferSize) throws IOException {
        ByteBuffer buffer;

        buffer = BufferUtils.createByteBuffer(bufferSize);

        InputStream source = ResourceLoader.LoadResource(resource);
        if (source == null)
            throw new FileNotFoundException("Could not load file!");

        ReadableByteChannel rbc = Channels.newChannel(source);

        try {
            while (true) {
                int bytes = rbc.read(buffer);
                if (bytes == -1)
                    break;
                if (buffer.remaining() == 0)
                    buffer = resizeBuffer(buffer, buffer.capacity() * 2);
            }
        } finally {
            rbc.close();
        }

        buffer.flip();
        return buffer;
    }
}

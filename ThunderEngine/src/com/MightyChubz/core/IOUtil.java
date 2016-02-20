package com.MightyChubz.core;

import org.lwjgl.BufferUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * This handles the converting of the file to memory.
 * Do not use this file for any reason, for the fact it works only with .ogg files and nothing more.
 */
public class IOUtil {
    /**
     * This resizes the buffer.
     *
     * @param buffer
     * @param newCapacity
     * @return ByteBuffer
     */
    private static ByteBuffer resizeBuffer(ByteBuffer buffer, int newCapacity) {
        ByteBuffer newBuffer = BufferUtils.createByteBuffer(newCapacity);
        buffer.flip();
        newBuffer.put(buffer);
        return newBuffer;
    }

    /**
     * This gets the file and converts it into memory.
     *
     * @param resource
     * @param bufferSize
     * @return ByteBuffer
     * @throws IOException
     */
    public static ByteBuffer ioResourceToByteBuffer(InputStream resource, int bufferSize) throws IOException {
        ByteBuffer buffer;

        buffer = BufferUtils.createByteBuffer(bufferSize);

        if (resource == null)
            throw new FileNotFoundException("Could not load file!");

        ReadableByteChannel rbc = Channels.newChannel(resource);

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

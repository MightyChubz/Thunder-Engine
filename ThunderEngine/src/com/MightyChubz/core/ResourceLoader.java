package com.MightyChubz.core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoader {
    public static InputStream LoadResource(String path) {
        InputStream inputStream = ResourceLoader.class.getResourceAsStream(path);
        if (inputStream == null) {
            inputStream = ResourceLoader.class.getResourceAsStream("/" + path);
        }

        return inputStream;
    }

    public static BufferedImage LoadImageResource(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(LoadResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}

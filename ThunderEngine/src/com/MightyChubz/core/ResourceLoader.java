package com.MightyChubz.core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * The resource loader class handle anything IO.
 * It does this to allow texture to appear in the JAR versions of games.
 */
public class ResourceLoader {
    /**
     * The load resource method does exactly as tell.
     * It loads anything from a folder that in the category Resource.
     *
     * @param path
     * @return InputStream
     */
    public static InputStream LoadResource(String path) {
        InputStream inputStream = ResourceLoader.class.getResourceAsStream(path);
        if (inputStream == null) {
            inputStream = ResourceLoader.class.getResourceAsStream("/" + path);
        }

        return inputStream;
    }

    /**
     * This is the same as load resource but it loads images exclusively.
     *
     * @param path
     * @return BufferedImage
     */
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

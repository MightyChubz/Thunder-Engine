package com.MightyChubz.core.gfx;

import java.awt.image.BufferedImage;

/**
 * This class quad image helps setup everything for a sprite sheet.
 */
public class QuadImage {
    public int rows, cols;
    public BufferedImage[] sprites;

    private BufferedImage big;

    /**
     * This sets the amount of rows and cols that are in the image, it also loads the full image.
     * Rows and cols are commonly one pixel less than the width and height of the section of the quad image.
     *
     * @param rows
     * @param cols
     * @param big
     */
    public QuadImage(int rows, int cols, BufferedImage big) {
        this.rows = rows;
        this.cols = cols;
        this.big = big;
    }

    /**
     * This method initializes the quad for use.
     *
     * @param sW
     * @param sH
     */
    public void initQuad(int sW, int sH) {
        sprites = new BufferedImage[rows * cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sprites[(r * cols) + c] = big.getSubimage(c * sW, r * sH, sW, sH);
            }
        }
    }
}

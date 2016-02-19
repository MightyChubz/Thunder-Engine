package com.MightyChubz.core.gfx;

import java.awt.image.BufferedImage;

/**
 * This class quad image helps setup everything for a sprite sheet.
 */
public class QuadImage {
    public int rows, cols;
    int sourceW;
    int sourceH;
    public BufferedImage[] sprites;

    private BufferedImage big;

    /**
     * This sets the amount of rows and cols that are in the image, it also loads the full image.
     * Rows and cols are commonly one pixel less than the width and height of the section of the quad image.
     *
     * @param sourceW
     * @param sourceH
     * @param big
     */
    public QuadImage(int sourceW, int sourceH, BufferedImage big) {
        this.sourceW = sourceW;
        this.sourceH = sourceH;
        this.big = big;

        int framesH = big.getHeight() / sourceH;
        int framesW = big.getWidth() / sourceW;
        this.sourceH = (int) Math.floor(framesH);
        this.sourceW = (int) Math.floor(framesW);

        rows = this.sourceH;
        cols = this.sourceW;
    }

    /**
     * This method initializes the quad for use.
     */
    public void initQuad() {
        sprites = new BufferedImage[rows * cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sprites[(r * cols) + c] = big.getSubimage(c * sourceW, r * sourceH, sourceW, sourceH);
            }
        }

        big.flush();
    }
}

package com.MightyChubz.core.gfx;

import java.awt.image.BufferedImage;

public class QuadImage {
    public int rows, cols;
    public BufferedImage[] sprites;

    private BufferedImage big;

    public QuadImage(int rows, int cols, BufferedImage big) {
        this.rows = rows;
        this.cols = cols;
        this.big = big;
    }

    public void initQuad(int sW, int sH) {
        sprites = new BufferedImage[rows * cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                sprites[(r * cols) + c] = big.getSubimage(c * sW, r * sH, sW, sH);
            }
        }
    }
}

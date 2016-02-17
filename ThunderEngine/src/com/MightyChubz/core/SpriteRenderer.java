package com.MightyChubz.core;

import com.MightyChubz.core.gfx.QuadImage;
import com.MightyChubz.core.gfx.Texture;

import java.awt.image.BufferedImage;

public class SpriteRenderer {
    private QuadImage image;
    public int texture;
    public boolean shouldInvert;

    public void initQuadImage(BufferedImage bigImage, int sourceWidth, int sourceHeight) {
        image = new QuadImage(sourceHeight - 1, sourceWidth - 1, bigImage);
        image.initQuad(sourceWidth, sourceHeight);
    }

    public void setTextureFromQuad(int index) {
        texture = Texture.LoadTexturePNG(image.sprites[index], shouldInvert);
    }

    public void loadTexture(BufferedImage image) {
        texture = Texture.LoadTexturePNG(image, shouldInvert);
    }
}

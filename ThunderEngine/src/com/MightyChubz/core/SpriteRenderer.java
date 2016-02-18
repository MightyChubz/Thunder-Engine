package com.MightyChubz.core;

import com.MightyChubz.core.gfx.QuadImage;
import com.MightyChubz.core.gfx.Texture;
import com.MightyChubz.core.mathf.Vector2f;

import java.awt.image.BufferedImage;

public class SpriteRenderer {
    private QuadImage image;
    public int texture;
    public boolean shouldInvert;
    public int renderWidth, renderHeight, width, height;

    public void initQuadImage(BufferedImage bigImage, int sourceWidth, int sourceHeight) {
        image = new QuadImage(sourceHeight - 1, sourceWidth - 1, bigImage);
        image.initQuad(sourceWidth, sourceHeight);
    }

    public void setTextureFromQuad(int index, Vector2f scale, int imageSize) {
        renderWidth = (int) (imageSize * scale.x);
        renderHeight = (int) (imageSize * scale.y);
        width = image.sprites[index].getWidth();
        height = image.sprites[index].getHeight();
        texture = Texture.LoadTexturePNG(image.sprites[index], shouldInvert);
    }

    public void loadTexture(BufferedImage image, Vector2f scale, int imageSize) {
        renderWidth = (int) (imageSize * scale.x);
        renderHeight = (int) (imageSize * scale.y);
        width = image.getWidth();
        height = image.getHeight();
        texture = Texture.LoadTexturePNG(image, shouldInvert);
    }
}

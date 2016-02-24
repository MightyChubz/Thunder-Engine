package com.MightyChubz.core.gfx;

import com.MightyChubz.core.mathf.Vector2f;

import java.awt.image.BufferedImage;

/**
 * Sprite renderer class is only used by the game object class,
 * as this handles anything relating towards the player sprites.
 */
public class SpriteRenderer {
    private QuadImage image;
    public int texture;
    public int renderWidth, renderHeight, width, height;
    public int centerRWidth, centerRHeight;
    public Vector2f offset;

    /**
     * This method initializes the quad image class to allow sprite sheets to be used.
     *
     * @param bigImage
     * @param sourceWidth
     * @param sourceHeight
     */
    public void initQuadImage(BufferedImage bigImage, int sourceWidth, int sourceHeight) {
        image = new QuadImage(sourceHeight, sourceWidth, bigImage);
        image.initQuad();

        bigImage.flush();
    }

    /**
     * This method sets the texture to what index of the sprite sheet the is set.
     * This also sets the render width and height, including the real image width and height.
     *
     * @param index
     * @param scale
     * @param imageSize
     */
    public void setTextureFromQuad(int index, Vector2f scale, int imageSize) {
        renderWidth = (int) (imageSize * scale.x);
        renderHeight = (int) (imageSize * scale.y);
        width = image.sprites[index].getWidth();
        height = image.sprites[index].getHeight();
        centerRWidth = renderWidth / 2;
        centerRHeight = renderHeight / 2;
        texture = Texture.LoadTexturePNG(image.sprites[index]);
    }

    /**
     * Instead of loading through quad this loads a full image.
     * This also sets the render width and height, as well as the real image width and height.
     *
     * @param image
     * @param scale
     * @param imageSize
     */
    public void loadTexture(BufferedImage image, Vector2f scale, int imageSize) {
        renderWidth = (int) (imageSize * scale.x);
        renderHeight = (int) (imageSize * scale.y);
        width = image.getWidth();
        height = image.getHeight();
        centerRWidth = renderWidth / 2;
        centerRHeight = renderHeight/ 2;
        texture = Texture.LoadTexturePNG(image);
    }
}

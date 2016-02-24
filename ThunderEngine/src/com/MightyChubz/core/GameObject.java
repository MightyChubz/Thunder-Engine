package com.MightyChubz.core;

import com.MightyChubz.core.gfx.SpriteRenderer;
import com.MightyChubz.core.mathf.Transform;

import static org.lwjgl.opengl.GL11.*;

/**
 * While this class is still under heavy work it is still very usable.
 * This is the game object class and it gives you multiple tools to make a full character.
 * However, there are things that still need to be added to this class such as,
 * easy animation, physics and the ability to spawn other objects.
 */
// TODO: Add full rotation support (as it doesn't work at the moment).
public class GameObject {
    public SpriteRenderer renderer = new SpriteRenderer();
    public Transform transform = new Transform();
    public Collide collider = new Collide();

    /**
     * This is the most basic method in the class as all it does is draws images.
     * It does this by getting a memory format of the image and handing it to OpenGL
     * which then converts it to a full image.
     */
    public void renderTexture() {
        glPushMatrix();
        glTranslatef(transform.position.x, transform.position.y, 0);
        glBindTexture(GL_TEXTURE_2D, renderer.texture);
        glColor3d(1, 1, 1);
        glBegin(GL_QUADS);
        {
            glTexCoord2d(0, 0);
            glVertex2d(0, 0);

            glTexCoord2d(1, 0);
            glVertex2d(renderer.renderWidth * transform.scale.x, 0);

            glTexCoord2d(1, 1);
            glVertex2d(renderer.renderWidth * transform.scale.x,
                    renderer.renderHeight * transform.scale.y);

            glTexCoord2d(0, 1);
            glVertex2d(0, renderer.renderHeight * transform.scale.y);
        }
        glEnd();
        glPopMatrix();
    }
}

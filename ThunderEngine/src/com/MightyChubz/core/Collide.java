package com.MightyChubz.core;

import com.MightyChubz.core.mathf.Vector2f;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;

public class Collide {
    public Vector2f keepWithinScreen(Vector2f position, SpriteRenderer renderer) {
        if (position.x < 0)
            position.x += 5;

        if (position.y < 0)
            position.y += 5;

        if (position.x + renderer.width > Screen.width)
            position.x -= 5;

        if (position.y + renderer.height > Screen.height)
            position.y -= 5;

        return position;
    }

    public void rayCastX(Vector2f position, Vector2f rotation, int angle,int length) {
        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(position.x, position.y, 0.5f);
        glColor3d(0, 1, 0);
        glBegin(GL_LINES);
        {
            glVertex2d(0, 0);
            glVertex2d(length, 0);
        }
        glEnd();
        glPopMatrix();
        glEnable(GL_TEXTURE_2D);
    }
}

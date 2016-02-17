package com.MightyChubz.core;

import com.MightyChubz.core.gfx.Color;

import static org.lwjgl.opengl.GL11.*;

public class Screen {
    public static void renderTexture(int textureID, int x, int y) {
        glPushMatrix();
        glTranslatef(x, y, 0);
        glBindTexture(GL_TEXTURE_2D, textureID);
        glBegin(GL_QUADS);
        {
            glTexCoord2d(0, 0);
            glVertex2d(0, 0);

            glTexCoord2d(1, 0);
            glVertex2d(128, 0);

            glTexCoord2d(1, 1);
            glVertex2d(128, 128);

            glTexCoord2d(0, 1);
            glVertex2d(0, 128);
        }
        glEnd();
        glPopMatrix();
    }

    public static void setScreenColor(Color color) {
        glClearColor(color.r, color.b, color.g, color.a);
    }

    public static void setScreenColor(int r, int g, int b, int a) {
        glClearColor(r, g, b, a);
    }
}

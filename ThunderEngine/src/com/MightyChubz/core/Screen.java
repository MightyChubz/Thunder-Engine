package com.MightyChubz.core;

import com.MightyChubz.core.gfx.Color;
import com.MightyChubz.core.mathf.Vector2f;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

/**
 * Screen handles anything towards rendering images or setting up what gets rendered on the window.
 */
public class Screen {
    public static int width, height;

    /**
     * This is the most basic method in the class as all it does is draws images.
     * It does this by getting a memory format of the image and handing it to OpenGL
     * which then converts it to a full image.
     *
     * @param textureID
     * @param position
     * @param width
     * @param height
     */
    public static void renderTexture(int textureID, Vector2f position, int width, int height) {
        glPushMatrix();
        glTranslatef(position.x, position.y, 0);
        glBindTexture(GL_TEXTURE_2D, textureID);
        glColor3d(1, 1, 1);
        glBegin(GL_QUADS);
        {
            glTexCoord2d(0, 0);
            glVertex2d(0, 0);

            glTexCoord2d(1, 0);
            glVertex2d(width, 0);

            glTexCoord2d(1, 1);
            glVertex2d(width, height);

            glTexCoord2d(0, 1);
            glVertex2d(0, height);
        }
        glEnd();
        glPopMatrix();
    }

    /**
     * This allows you to set how much buffering you want your program to take.
     *
     * @param vsyncBufferAmount
     */
    public static void setVsyncBuffer(int vsyncBufferAmount) {
        glfwSwapInterval(vsyncBufferAmount);
    }

    /**
     * This allows you to set screen color through the Color class format.
     *
     * @param color
     */
    public static void setScreenColor(Color color) {
        glClearColor(color.r, color.b, color.g, color.a);
    }

    /**
     * This allows you to set screen color through the rgba format.
     *
     * @param r
     * @param g
     * @param b
     * @param a
     */
    public static void setScreenColor(int r, int g, int b, int a) {
        glClearColor(r, g, b, a);
    }

    /**
     * Notice: This method should only be used by the Main class and it only.
     * This class sets the dimension for the user to use if making collision around the boundaries of the window.
     *
     * @param width
     * @param height
     */
    public static void setScreenSize(int width, int height) {
        Screen.width = width - 109;
        Screen.height = height / 2 + 192;
    }
}

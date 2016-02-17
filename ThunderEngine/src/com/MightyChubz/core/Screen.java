package com.MightyChubz.core;

import com.MightyChubz.core.gfx.Color;

import static org.lwjgl.opengl.GL11.*;

public class Screen {
    public static void setScreenColor(Color color) {
        glClearColor(color.r, color.b, color.g, color.a);
    }

    public static void setScreenColor(int r, int g, int b, int a) {
        glClearColor(r, g, b, a);
    }
}

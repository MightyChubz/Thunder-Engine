package com.MightyChubz.core.gfx;

public class Color {
    public float r, g, b, a;

    public static final Color RED = new Color(1, 0, 0, 0);
    public static final Color GREEN = new Color(0, 1, 0, 0);
    public static final Color BLUE = new Color(0, 0, 1, 0);
    public static final Color WHITE = new Color(1, 1, 1, 1);
    public static final Color BLACK = new Color(0, 0, 0, 0);

    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }
}

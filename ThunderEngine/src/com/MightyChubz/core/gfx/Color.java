package com.MightyChubz.core.gfx;

/**
 * This color class is only for setting screen color at the moment.
 */
public class Color {
    public float r, g, b, a;

    public static final Color RED = new Color(1, 0, 0, 0);
    public static final Color GREEN = new Color(0, 1, 0, 0);
    public static final Color BLUE = new Color(0, 0, 1, 0);
    public static final Color WHITE = new Color(1, 1, 1, 1);
    public static final Color BLACK = new Color(0, 0, 0, 0);

    /**
     * Besides having prebuilt colors, it does support custom colors as well.
     *
     * @param r
     * @param g
     * @param b
     * @param a
     */
    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }
}

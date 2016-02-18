package com.MightyChubz.core.mathf;

/**
 * This is a two dimensional vector;
 * this is only a storage in a way of speaking but is very useful in a lot of situations.
 */
public class Vector2f {
    public static final Vector2f ZERO = new Vector2f(0, 0);
    public static final Vector2f LEFT = new Vector2f(-1, 0);
    public static final Vector2f UP = new Vector2f(0, -1);
    public static final Vector2f RIGHT = new Vector2f(1, 0);
    public static final Vector2f DOWN = new Vector2f(0, 1);

    public float x, y;

    /**
     * This constructor only sets the x and y of the vector.
     *
     * @param x
     * @param y
     */
    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
}

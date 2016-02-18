package com.MightyChubz.core.mathf;

/**
 * This is a three dimensional vector;
 * this is only a storage in a way of speaking but is very useful in a lot of situations.
 */
public class Vector3f {
    public float x, y, z;

    /**
     * This constructor only sets the x, y and z of the vector.
     *
     * @param x
     * @param y
     */
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

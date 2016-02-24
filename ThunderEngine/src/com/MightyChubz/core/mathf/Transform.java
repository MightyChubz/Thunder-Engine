package com.MightyChubz.core.mathf;

/**
 * This class is used only in the game object class.
 * This class hold three 2 dimensional vectors, position, rotation and scale.
 * They all have their own function and do their own things.
 * For instance, position controls where the game object is positioned,
 * rotation allow the object to rotate (at the moment it actually doesn’t but will be added somewhere in the future)
 * and the scale allow the game object texture, collision and geometry (if any) to expand.
 */
public class Transform {
    // TODO: Figure weather or not to delete rotation.
    public Vector2f position = new Vector2f(0, 0);
    public Vector2f rotation = new Vector2f(0, 0);
    public Vector2f scale = new Vector2f(1, 1);
}

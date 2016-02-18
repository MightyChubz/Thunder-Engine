package com.MightyChubz.core;

import com.MightyChubz.core.mathf.Vector2f;

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
}

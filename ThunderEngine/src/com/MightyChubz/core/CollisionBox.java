package com.MightyChubz.core;

import com.MightyChubz.core.mathf.Size;
import com.MightyChubz.core.mathf.Vector2f;

// TODO: Fully incorporate the collision box.
public class CollisionBox {
    public Vector2f position = new Vector2f(1, 1);
    public Vector2f alignMode = new Vector2f(1, 1);
    public Size size = new Size(1, 1);
    public Size imageSize = new Size(16, 16);
    public int multiplier = 3;

    public void initAlignMode() {
        alignMode.x = size.width / 2;
        alignMode.y = size.height / 2;
    }
}

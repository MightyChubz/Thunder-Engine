package com.MightyChubz.core;

import com.MightyChubz.core.gfx.Behavior;
import com.MightyChubz.core.mathf.Vector2f;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;

/**
 * This class handles everything collision based.
 */
public class Collide {
    /**
     * This method if used right, will prevent the game object from leaving the windows boundaries.
     *
     * @param position
     * @param renderer
     * @return Vector2f
     */
    public void keepWithinScreen(Vector2f position, SpriteRenderer renderer) {
        if (position.x < 0)
            position.x += 5;

        if (position.y < 0)
            position.y += 5;

        if (position.x + renderer.width > Behavior.width)
            position.x -= 5;

        if (position.y + renderer.height > Behavior.height)
            position.y -= 5;
    }

    /**
     * Creates collision box for trigger event.
     *
     * @param object
     * @param collider
     * @return boolean
     */
    public boolean boundingBoxTrigger(GameObject object, GameObject collider) {
        if (Math.abs(object.transform.position.x - collider.transform.position.x) <
                ((object.renderer.width * 3) + (collider.renderer.width + object.renderer.centerRWidth)) * collider.transform.scale.x) {
            if (Math.abs(object.transform.position.y - collider.transform.position.y) <
                    ((object.renderer.height * 3) + (collider.renderer.height + object.renderer.centerRHeight)) * collider.transform.scale.y) {
                return true;
            }
        }

        return false;
    }

    /**
     * Creates an invisible, one-pixel thick line for directional collision.
     *
     * @param object
     * @param position
     * @param direction
     * @param length
     * @return boolean
     */
    public boolean rayCast(GameObject object, Vector2f position, Vector2f direction, Vector2f length) {
        int size = 1;

        if (Math.abs(object.transform.position.x - (position.x + direction.x)) <
                ((object.renderer.width * 3) + (size + length.x) + Math.sqrt(object.renderer.centerRWidth * 4)) * object.transform.scale.x) {
            if (Math.abs(object.transform.position.y - (position.y + direction.y)) <
                    ((object.renderer.width * 3) + (size + length.y) + Math.sqrt(object.renderer.centerRHeight * 4)) * object.transform.scale.x) {
                return true;
            }
        }

        return false;
    }
}

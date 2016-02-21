package com.MightyChubz.core;

import com.MightyChubz.core.gfx.Behavior;
import com.MightyChubz.core.mathf.Vector2f;

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
            position.x += 2;

        if (position.y < 0)
            position.y += 2;

        if (position.x + renderer.width > Behavior.width)
            position.x -= 2;

        if (position.y + renderer.height > Behavior.height)
            position.y -= 2;
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

    // TODO: Rewrite whole collision.
}

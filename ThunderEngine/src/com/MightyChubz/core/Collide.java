package com.MightyChubz.core;

/**
 * This class handles everything collision based.
 */
public class Collide {
    /**
     * Creates collision box for collider event.
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
     * Creates collision box for collision event.
     *
     * @param box
     * @param collider
     * @return boolean
     */
    public boolean boundingBoxCollider(CollisionBox box, GameObject collider) {
        if (Math.abs((box.position.x + box.offset.x) - (collider.transform.position.x + collider.renderer.offset.x)) <
                ((box.imageSize.width * box.multiplier.x) + box.imageSize.width) * collider.transform.scale.x) {
            if (Math.abs((box.position.y + box.offset.y) - (collider.transform.position.y + collider.renderer.offset.y)) <
                    ((box.imageSize.height * box.multiplier.y) + (collider.renderer.height + box.alignMode.y)) * collider.transform.scale.y) {
                return true;
            }
        }

        return false;
    }
}

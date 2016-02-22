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

    // TODO: Make a optional simple method of setting up collision.
    public boolean boundingBoxCollision(Vector2f direction) {
        if (direction == Vector2f.LEFT)
            return false;

        if (direction == Vector2f.RIGHT)
            return false;

        if (direction == Vector2f.UP)
            return false;

        if (direction == Vector2f.DOWN)
            return false;

        return false;
    }

    // Determine the distance between the two objects and see of collision occurred.
    // TODO: Make directional collision.
    public boolean boundingBoxCollisionRight(CollisionBox box, GameObject collider) {
        if (Math.abs((box.position.x + (box.alignMode.x - (box.imageSize.width * 2) + 1)) - collider.transform.position.x) <
                ((box.imageSize.width * box.multiplier) + (collider.renderer.width + collider.renderer.centerRWidth)) * collider.transform.scale.x) {
            if (Math.abs((box.position.y + (box.alignMode.y - (box.imageSize.height * 3 + 16))) - collider.transform.position.y) <
                    ((box.imageSize.height * box.multiplier) +
                            (collider.renderer.height + (collider.renderer.centerRHeight * 3) / 2) - 16) * collider.transform.scale.y) {
                return true;
            }
        }

        return false;
    }

    public boolean boundingBoxCollisionLeft(CollisionBox box, GameObject collider) {
        if (Math.abs((box.position.x - collider.transform.position.x - (collider.renderer.centerRWidth + (collider.renderer.width * 2)))) <
                ((box.imageSize.width * box.multiplier) - (collider.renderer.width - collider.renderer.centerRWidth + 30)) * collider.transform.scale.x) {
            if (Math.abs((box.position.y + (box.alignMode.y - (box.imageSize.height * 3 + 16))) - collider.transform.position.y) <
                    ((box.imageSize.height * box.multiplier) +
                            (collider.renderer.height + (collider.renderer.centerRHeight * 3) / 2) - 16) * collider.transform.scale.y) {
                return true;
            }
        }

        return false;
    }

    // Seeing of y axis collision will work.
//    public boolean boundingBoxCollisionTop(CollisionBox box, GameObject collider) {
//        if (Math.abs((box.position.x - collider.transform.position.x + (collider.renderer.width * 4) + 2)) <
//                ((box.imageSize.width * box.multiplier) - (collider.renderer.width - collider.renderer.centerRWidth) - 10) * collider.transform.scale.x) {
//            if (Math.abs((box.position.y + (box.alignMode.y - (box.imageSize.height * 3))) - collider.transform.position.y + 100) <
//                    ((box.imageSize.height * box.multiplier) + ((collider.renderer.height / 5) - 4)) * collider.transform.scale.y) {
//                return true;
//            }
//        }
//
//        return false;
//    }

//    public boolean boundingBoxCollisionBottom(CollisionBox box, GameObject collider) {
//        // Testing to see if x axis works.
//        if (Math.abs((box.position.x + (box.alignMode.x - (box.imageSize.width * 2))) - collider.transform.position.x) <
//                ((box.imageSize.width * box.multiplier) + (collider.renderer.width + collider.renderer.centerRWidth)) * collider.transform.scale.x) {
//            if (Math.abs((box.position.y + (box.alignMode.y - (box.imageSize.height * 4))) - collider.transform.position.y) <
//                    ((box.imageSize.width * box.multiplier) +
//                            (collider.renderer.height + (collider.renderer.centerRHeight * 3) / 2)) * collider.transform.scale.y) {
//                return true;
//            }
//        }
//
//        return false;
//    }
}

package com.MightyChubz.core;

import com.MightyChubz.core.mathf.Transform;
import com.MightyChubz.core.mathf.Vector2f;

import java.util.HashMap;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

/**
 * While this class is still under heavy work it is still very usable.
 * This is the game object class and it gives you multiple tools to make a full character.
 * However, there are things that still need to be added to this class such as,
 * easy animation, physics and the ability to spawn other objects.
 */
public class GameObject {
    public SpriteRenderer renderer = new SpriteRenderer();
    public Transform transform = new Transform();
    public Collide collider = new Collide();

    /**
     * This is the most basic method in the class as all it does is draws images.
     * It does this by getting a memory format of the image and handing it to OpenGL
     * which then converts it to a full image.
     */
    public void renderTexture() {
        glPushMatrix();
        glTranslatef(transform.position.x, transform.position.y, 0);
        glBindTexture(GL_TEXTURE_2D, renderer.texture);
        glColor3d(1, 1, 1);
        glBegin(GL_QUADS);
        {
            glTexCoord2d(0, 0);
            glVertex2d(0, 0);

            glTexCoord2d(1, 0);
            glVertex2d(renderer.renderWidth, 0);

            glTexCoord2d(1, 1);
            glVertex2d(renderer.renderWidth, renderer.renderHeight);

            glTexCoord2d(0, 1);
            glVertex2d(0, renderer.renderHeight);
        }
        glEnd();
        glPopMatrix();
    }

    /**
     * Currently this only draws the ray caster but has no logic toward it.
     */
    public void rayCastRight() {
        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(transform.position.x + renderer.centerRWidth,
                transform.position.y + renderer.centerRHeight, 0.5f);
        glColor3d(0, 1, 0);
        glBegin(GL_LINES);
        {
            glVertex2d(0, 0);
            glVertex2d(150, 0);
        }
        glEnd();
        glPopMatrix();
        glEnable(GL_TEXTURE_2D);
    }

    /**
     * Currently this only draws the ray caster but has no logic toward it.
     */
    public void rayCastLeft() {
        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(transform.position.x + renderer.centerRWidth,
                transform.position.y + renderer.centerRHeight, 0.5f);
        glColor3d(0, 1, 0);
        glBegin(GL_LINES);
        {
            glVertex2d(0, 0);
            glVertex2d(-150, 0);
        }
        glEnd();
        glPopMatrix();
        glEnable(GL_TEXTURE_2D);
    }

    /**
     * Currently this only draws the ray caster but has no logic toward it.
     */
    public void rayCastUp() {
        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(transform.position.x + renderer.centerRWidth,
                transform.position.y + renderer.centerRHeight, 0.5f);
        glColor3d(0, 1, 0);
        glBegin(GL_LINES);
        {
            glVertex2d(0, 0);
            glVertex2d(0, 150);
        }
        glEnd();
        glPopMatrix();
        glEnable(GL_TEXTURE_2D);
    }

    /**
     * Currently this only draws the ray caster but has no logic toward it.
     */
    public void rayCastDown() {
        glDisable(GL_TEXTURE_2D);
        glPushMatrix();
        glTranslatef(transform.position.x + renderer.centerRWidth,
                transform.position.y + renderer.centerRHeight, 0.5f);
        glColor3d(0, 1, 0);
        glBegin(GL_LINES);
        {
            glVertex2d(0, 0);
            glVertex2d(0, -150);
        }
        glEnd();
        glPopMatrix();
        glEnable(GL_TEXTURE_2D);
    }

    /**
     * This return one of three components.
     *
     * @param className
     * @return Object
     */
    public Object GetComponent(String className) {
        HashMap<String, Object> objectStringHashMap = new HashMap<>();
        objectStringHashMap.put("SpriteRenderer", renderer);
        objectStringHashMap.put("Transform", transform);
        objectStringHashMap.put("Collide", collider);

        return objectStringHashMap.get(className);
    }
}

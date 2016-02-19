package com.MightyChubz.core;

import com.MightyChubz.core.mathf.Transform;

import java.util.HashMap;
import java.util.Objects;

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

    public Object GetComponet(String className) {
        HashMap<String, Object> objectStringHashMap = new HashMap<>();
        objectStringHashMap.put("SpriteRenderer", renderer);
        objectStringHashMap.put("Transform", transform);
        objectStringHashMap.put("Collide", collider);

        return objectStringHashMap.get(className);
    }
}

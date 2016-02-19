package com.MightyChubz.core;

import com.MightyChubz.core.gfx.Behavior;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.nio.DoubleBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class Mouse extends GLFWMouseButtonCallback {
    public static final boolean[] mouseButtons = new boolean[55536];

    public static final int THUNDER_MOUSE_LEFT = GLFW_MOUSE_BUTTON_LEFT;
    public static final int THUNDER_MOUSE_RIGHT = GLFW_MOUSE_BUTTON_RIGHT;
    public static final int THUNDER_MOUSE_MIDDLE = GLFW_MOUSE_BUTTON_MIDDLE;
    public static final int THUNDER_MOUSE_LAST = GLFW_MOUSE_BUTTON_LAST;
    public static final int THUNDER_MOUSE_BUTTON_1 = GLFW_MOUSE_BUTTON_1;
    public static final int THUNDER_MOUSE_BUTTON_2 = GLFW_MOUSE_BUTTON_2;
    public static final int THUNDER_MOUSE_BUTTON_3 = GLFW_MOUSE_BUTTON_3;
    public static final int THUNDER_MOUSE_BUTTON_4 = GLFW_MOUSE_BUTTON_4;
    public static final int THUNDER_MOUSE_BUTTON_5 = GLFW_MOUSE_BUTTON_5;
    public static final int THUNDER_MOUSE_BUTTON_6 = GLFW_MOUSE_BUTTON_6;
    public static final int THUNDER_MOUSE_BUTTON_7 = GLFW_MOUSE_BUTTON_7;
    public static final int THUNDER_MOUSE_BUTTON_8 = GLFW_MOUSE_BUTTON_8;

    public void invoke(long window, int button, int action, int mods) {
        mouseButtons[button] = action != GLFW_RELEASE;
    }

    public static boolean isKeyReleased(int button) {
        return mouseButtons[button];
    }

    public static void getMousePosition(long window, double newX, double newY) {
        DoubleBuffer xpos = BufferUtils.createDoubleBuffer(8);
        DoubleBuffer ypos = BufferUtils.createDoubleBuffer(8);

        glfwGetCursorPos(window, xpos, ypos);

        xpos.rewind();
        ypos.rewind();

        newY = ypos.get();
        newX = xpos.get();

        double deltaX = newX;
        double deltaY = newY;

        Behavior.setDeltaMousePos(deltaX, deltaY);

        xpos.clear();
        ypos.clear();
    }
}
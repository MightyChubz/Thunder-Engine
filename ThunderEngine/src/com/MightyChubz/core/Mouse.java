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

    public static boolean isKeyPressed(int button) {
        return mouseButtons[button];
    }

    public static void setMousePosition(long window) {
        DoubleBuffer xPos = BufferUtils.createDoubleBuffer(8);
        DoubleBuffer yPos = BufferUtils.createDoubleBuffer(8);

        glfwGetCursorPos(window, xPos, yPos);

        xPos.rewind();
        yPos.rewind();

        double x, y;
        x = xPos.get();
        y = yPos.get();

        Behavior.setMousePos(x, y);

        xPos.clear();
        yPos.clear();
    }

    public static void setDeltaMousePosition(long window, double newX, double newY) {
        DoubleBuffer xPos = BufferUtils.createDoubleBuffer(8);
        DoubleBuffer yPos = BufferUtils.createDoubleBuffer(8);

        glfwGetCursorPos(window, xPos, yPos);

        xPos.rewind();
        yPos.rewind();

        newY = yPos.get();
        newX = xPos.get();

        double deltaX = newX;
        double deltaY = newY;

        Behavior.setDeltaMousePos(deltaX, deltaY);

        xPos.clear();
        yPos.clear();
    }
}

package com.MightyChubz.core;

import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.*;

/**
 * The input class allows up to the input of 40+ at the moment.
 */
public class Input extends GLFWKeyCallback {
    public static final int THUNDER_W = GLFW_KEY_W;
    public static final int THUNDER_S = GLFW_KEY_S;
    public static final int THUNDER_A = GLFW_KEY_A;
    public static final int THUNDER_D = GLFW_KEY_D;
    public static final int THUNDER_Q = GLFW_KEY_Q;
    public static final int THUNDER_E = GLFW_KEY_E;
    public static final int THUNDER_R = GLFW_KEY_R;
    public static final int THUNDER_T = GLFW_KEY_T;
    public static final int THUNDER_Y = GLFW_KEY_Y;
    public static final int THUNDER_U = GLFW_KEY_U;
    public static final int THUNDER_I = GLFW_KEY_I;
    public static final int THUNDER_O = GLFW_KEY_O;
    public static final int THUNDER_P = GLFW_KEY_P;
    public static final int THUNDER_F = GLFW_KEY_F;
    public static final int THUNDER_G = GLFW_KEY_G;
    public static final int THUNDER_H = GLFW_KEY_H;
    public static final int THUNDER_J = GLFW_KEY_J;
    public static final int THUNDER_K = GLFW_KEY_K;
    public static final int THUNDER_L = GLFW_KEY_L;
    public static final int THUNDER_Z = GLFW_KEY_Z;
    public static final int THUNDER_X = GLFW_KEY_X;
    public static final int THUNDER_C = GLFW_KEY_C;
    public static final int THUNDER_V = GLFW_KEY_V;
    public static final int THUNDER_B = GLFW_KEY_B;
    public static final int THUNDER_N = GLFW_KEY_N;
    public static final int THUNDER_M = GLFW_KEY_M;
    public static final int THUNDER_1 = GLFW_KEY_1;
    public static final int THUNDER_2 = GLFW_KEY_2;
    public static final int THUNDER_3 = GLFW_KEY_3;
    public static final int THUNDER_4 = GLFW_KEY_4;
    public static final int THUNDER_5 = GLFW_KEY_5;
    public static final int THUNDER_6 = GLFW_KEY_6;
    public static final int THUNDER_7 = GLFW_KEY_7;
    public static final int THUNDER_8 = GLFW_KEY_8;
    public static final int THUNDER_9 = GLFW_KEY_9;
    public static final int THUNDER_0 = GLFW_KEY_0;
    public static final int THUNDER_UP = GLFW_KEY_UP;
    public static final int THUNDER_RIGHT = GLFW_KEY_RIGHT;
    public static final int THUNDER_LEFT = GLFW_KEY_LEFT;
    public static final int THUNDER_DOWN = GLFW_KEY_DOWN;
    public static final int THUNDER_ESCAPE = GLFW_KEY_ESCAPE;
    public static final int THUNDER_LEFT_SHIFT = GLFW_KEY_LEFT_SHIFT;
    public static final int THUNDER_RIGHT_SHIFT = GLFW_KEY_RIGHT_SHIFT;
    public static final int THUNDER_LEFT_CONTROL = GLFW_KEY_LEFT_CONTROL;
    public static final int THUNDER_RIGHT_CONTROL = GLFW_KEY_RIGHT_CONTROL;

    public static final boolean[] keys = new boolean[55536];

    /**
     * The invoke method detects any input with the keyboard and handles it.
     * It also adds the key code to an array if the key is held down.
     *
     * @param window
     * @param key
     * @param scancode
     * @param action
     * @param mods
     */
    public void invoke(long window, int key, int scancode, int action, int mods) {
        keys[key] = action != GLFW_RELEASE;
    }

    /**
     * Checks weather or not a key is held down
     *
     * @param keycode
     * @return Boolean
     */
    public static boolean isKeyDown(int keycode) {
        return keys[keycode];
    }
}

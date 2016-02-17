package com.MightyChubz.core;

import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.*;

public class Input extends GLFWKeyCallback {
    public static final int W = GLFW_KEY_W;
    public static final int S = GLFW_KEY_S;
    public static final int A = GLFW_KEY_A;
    public static final int D = GLFW_KEY_D;
    public static final int Q = GLFW_KEY_Q;
    public static final int E = GLFW_KEY_E;
    public static final int R = GLFW_KEY_R;
    public static final int T = GLFW_KEY_T;
    public static final int Y = GLFW_KEY_Y;
    public static final int U = GLFW_KEY_U;
    public static final int I = GLFW_KEY_I;
    public static final int O = GLFW_KEY_O;
    public static final int P = GLFW_KEY_P;
    public static final int F = GLFW_KEY_F;
    public static final int G = GLFW_KEY_G;
    public static final int H = GLFW_KEY_H;
    public static final int J = GLFW_KEY_J;
    public static final int K = GLFW_KEY_K;
    public static final int L = GLFW_KEY_L;
    public static final int Z = GLFW_KEY_Z;
    public static final int X = GLFW_KEY_X;
    public static final int C = GLFW_KEY_C;
    public static final int V = GLFW_KEY_V;
    public static final int B = GLFW_KEY_B;
    public static final int N = GLFW_KEY_N;
    public static final int M = GLFW_KEY_M;
    public static final int UP = GLFW_KEY_UP;
    public static final int RIGHT = GLFW_KEY_RIGHT;
    public static final int LEFT = GLFW_KEY_LEFT;
    public static final int DOWN = GLFW_KEY_DOWN;
    public static final int ESCAPE = GLFW_KEY_ESCAPE;
    public static final int LEFT_SHIFT = GLFW_KEY_LEFT_SHIFT;
    public static final int RIGHT_SHIFT = GLFW_KEY_RIGHT_SHIFT;
    public static final int LEFT_CONTROL = GLFW_KEY_LEFT_CONTROL;
    public static final int RIGHT_CONTROL = GLFW_KEY_RIGHT_CONTROL;

    public static final boolean[] keys = new boolean[55536];

    public void invoke(long window, int key, int scancode, int action, int mods) {
        keys[key] = action != GLFW_RELEASE;
    }

    public static boolean isKeyDown(int keycode) {
        return keys[keycode];
    }
}

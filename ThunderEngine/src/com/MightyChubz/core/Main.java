package com.MightyChubz.core;

import com.MightyChubz.core.gfx.Color;
import com.MightyChubz.core.interfaces.MainGameMethods;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Main implements Runnable {
    public Thread thread;
    public boolean running = false;
    public int width = 1200;
    public int height = 600;
    public String name = "Untitled Game";

    private long window;
    private MainGameMethods methods;

    private GLFWKeyCallback keyCallback;

    public Main(Object className) {
        if (className instanceof MainGameMethods) {
            methods = (MainGameMethods) className;
        } else
            throw new IllegalArgumentException(className.getClass().getName() +
                    " has no MainGameMethods interface!");
    }

    public void start() {
        running = true;
        thread = new Thread(this, "Main");
        thread.start();
    }

    public void stop() {
        running = false;
    }

    public void run() {
        load();

        while (running) {
            update();
            render();

            if (glfwWindowShouldClose(window) == GLFW_TRUE)
                running = false;
        }
    }

    private void load() {
        if (glfwInit() != GLFW_TRUE)
            throw new IllegalArgumentException("GLFW could not be initialized!");

        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        window = glfwCreateWindow(width, height, name, NULL, NULL);
        if (window == NULL)
            throw new RuntimeException("Could not create window!");

        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);
        glfwMakeContextCurrent(window);
        glfwSwapInterval(2);

        GL.createCapabilities();

        methods.load();

        glfwShowWindow(window);
    }

    private void update() {
        glfwPollEvents();

        methods.update();
    }

    private void render() {
        glEnable(GL_TEXTURE_2D);

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        Screen.setScreenColor(Color.BLACK);

        glDepthFunc(GL_DEPTH_FUNC);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        methods.render();

        glfwSwapBuffers(window);
    }
}

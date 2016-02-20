package com.MightyChubz.core;

import com.MightyChubz.core.gfx.Behavior;
import com.MightyChubz.core.interfaces.MainGameMethods;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import java.io.File;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * The main class is what handle the thread and most of the OpenGL.
 */
public class Main implements Runnable {
    public Thread thread;
    public boolean running = false;
    public int width = 1200;
    public int height = 600;
    public String name = "Untitled Game";

    private long window;
    private MainGameMethods methods;
    private double newY = 400, newX = 500;

    private GLFWKeyCallback keyCallback;
    private GLFWMouseButtonCallback mouseButtonCallback;

    /**
     * The constructer gets the object that was given to it and checks if it was the MainGameMethods interface.
     * If it does, the class will start using calling it a parts of the class.
     * @param className
     *
     * @exception IllegalArgumentException;
     */
    public Main(Object className) {
        if (className instanceof MainGameMethods) {
            methods = (MainGameMethods) className;
        } else
            throw new IllegalArgumentException(className.getClass().getName() +
                    " has no MainGameMethods interface!");
    }

    /**
     * The start method will the start the thread causing it to call the run method.
     */
    public void start() {
        System.setProperty("org.lwjgl.librarypath", new File("native").getAbsolutePath());
        running = true;
        thread = new Thread(this, "Main");
        thread.start();
    }

    /**
     * The run method control nearly all logic in the class,
     * this class is responsible for the game loop and all other methods in this class.
     */
    public void run() {
        load();

        long lastTime = System.nanoTime();
        double unprocessed = 0;
        double nsPerTick = 1000000000.0 / 60.0;
        int frame = 0;
        int tick = 0;
        long lastTimer1 = System.currentTimeMillis();
        boolean shouldRender = false;

        while (running) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            shouldRender = true;

            while (unprocessed > 1) {
                unprocessed -= 1;
                update();
                tick++;
            }

            if (shouldRender) {
                render();
                frame++;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (System.currentTimeMillis() - lastTimer1 > 1000) {
                lastTimer1 += 1000;
                System.out.println(frame + " fps " + tick + " ticks");
                frame = 0;
                tick = 0;
            }

            if (glfwWindowShouldClose(window) == GLFW_TRUE) {
                methods.windowClose();
                running = false;
            }
        }
    }

    /**
     * The load method sets up the window, context and viewport.
     * Without this method most of the code given to the LWJGL would not work.
     *
     * @exception IllegalArgumentException
     * @exception RuntimeException
     */
    private void load() {
        if (glfwInit() != GLFW_TRUE)
            throw new IllegalArgumentException("GLFW could not be initialized!");

        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        window = glfwCreateWindow(width, height, name, NULL, NULL);
        if (window == NULL)
            throw new RuntimeException("Could not create window!");


        GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);
        glfwSetKeyCallback(window, keyCallback = new Input());
        glfwSetMouseButtonCallback(window, mouseButtonCallback = new Mouse());
        glfwMakeContextCurrent(window);
        Behavior.setVsyncBuffer(1);
        GL.createCapabilities();

        Behavior.setScreenSize(width, height);
        glfwSetCursorPos(window, Behavior.width / 2 + 25, Behavior.height / 2 + 25);

        glViewport(0, 0, width, height);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, height, 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);

        methods.load();

        glfwShowWindow(window);
    }

    /**
     * This method calls the poll events and the update for the interface.
     */
    private void update() {
        glfwPollEvents();

        Mouse.getMousePosition(window, newX, newY);

        methods.update();
    }

    /**
     * This method sets up OpenGL for rendering texture.
     */
    private void render() {
        glEnable(GL_TEXTURE_2D);

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        glDepthFunc(GL_DEPTH_FUNC);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        methods.render();

        glfwSwapBuffers(window);
    }
}

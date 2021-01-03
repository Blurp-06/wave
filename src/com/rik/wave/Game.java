package com.rik.wave;

import com.rik.wave.entities.CoinBase;
import com.rik.wave.entities.CoinEaterBase;
import com.rik.wave.entities.PlayerBase;
import com.rik.wave.hud.HealthBar;
import com.rik.wave.hud.Timer;
import com.rik.wave.util.EntityHandler;
import com.rik.wave.util.KeyInput;
import com.rik.wave.util.spawn.CoinEaterSpawn;
import com.rik.wave.util.spawn.RedEnemySpawn;
import com.rik.wave.util.spawn.StalkerEnemySpawn;
import com.rik.wave.window.WindowInit;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    // Public for access later
    public WindowInit window;

    // Dimensions of window
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    // Threads
    private Thread thread;
    private boolean running = false;

    // Handler
    private final EntityHandler entityHandler = new EntityHandler();

    public static int frames = 0;

    public Game() {
        window = new WindowInit(WIDTH, HEIGHT, this);

        // Player movement
        this.addKeyListener(new KeyInput());

        // Player rendering
        int playerX = WIDTH / 2;
        int playerY = HEIGHT / 2;

        // Player
        entityHandler.addEntity(new PlayerBase(playerX, playerY));

        // Spawning enemies
        RedEnemySpawn.spawn(4, playerX, playerY, 100);
        StalkerEnemySpawn.spawn(2, playerX, playerY, 50);
        CoinEaterSpawn.spawn(1, playerX, playerY, 100);

        // HUD rendering
        entityHandler.addEntity(new HealthBar());
        entityHandler.addEntity(new Timer());
        entityHandler.addEntity(new CoinBase(60, 60));
    }

    public synchronized void start(){
        // Starting the thread
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        // Tries to stop program, on error prints it out
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // Main loop
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0f;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1){
                tick();
                --delta;
            }
            if(running)render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }
        }

        stop();
    }

    private void tick(){
        entityHandler.tick();
    }

    private void render(){
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if(bufferStrategy == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bufferStrategy.getDrawGraphics();

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        entityHandler.render(g);

        g.dispose();
        bufferStrategy.show();
    }

    public static void main(String[] args) {
        new Game();
    }
}
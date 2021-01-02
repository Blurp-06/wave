package com.rik.wave.window;

import com.rik.wave.Game;

import javax.swing.*;
import java.awt.*;

public class WindowInit extends Canvas {

    public WindowInit(int WIDTH, int HEIGHT, Game game){
        JFrame frame = new JFrame();

        // Setting size
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);

        // Adding the game to the window
        frame.add(game);

        // Some finishing touches
        frame.setTitle("Wave");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.requestFocus();

        // Starting the game
        game.start();
    }
}

package com.rik.wave.util;

import com.rik.wave.entities.EntityBase;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    public KeyInput(){}


    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        EntityBase player = EntityHandler.getPlayer();

        // Move in ONE straight line
        if(key == KeyEvent.VK_W){
            player.setVelY(-5);
            player.setVelX(0);
        }
        if(key == KeyEvent.VK_S){
            player.setVelY(5);
            player.setVelX(0);
        }
        if(key == KeyEvent.VK_A){
            player.setVelX(-5);
            player.setVelY(0);
        }
        if(key == KeyEvent.VK_D){
            player.setVelX(5);
            player.setVelY(0);
        }

    }

}
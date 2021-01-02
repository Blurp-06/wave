package com.rik.wave.entities;

import com.rik.wave.Game;
import com.rik.wave.hud.Timer;
import com.rik.wave.util.ID;

import java.awt.*;
import java.util.Random;

public class RedEnemyBase extends EntityBase {

    static private final Random rnd = new Random();
    static private final int standardVel = 2;

    public RedEnemyBase(int x, int y){
        super(x, y, 0, 0, ID.Enemy);
        setDamage(2);
        setHeight(16);
        setWidth(16);
    }


    @Override
    public void setup() {
        final int velX = rnd.nextBoolean() ? -standardVel: standardVel;
        final int velY = rnd.nextBoolean() ? -standardVel: standardVel;

        setVelX(velX);
        setVelY(velY);
    }

    @Override
    public void tick() {

        if(Timer.timePast < 3L){
            return;
        }

        setX(getX() + getVelX());
        setY(getY() + getVelY());

        // Checking for window border collision
        if(getX() <= 0 || getX() >= Game.WIDTH - width * 2){
            velX *= -1;
        }

        if(getY() <= 0 || getY() >= Game.HEIGHT - height * 3){
            velY *= -1;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}

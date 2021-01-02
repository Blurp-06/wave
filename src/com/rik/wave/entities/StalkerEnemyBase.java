package com.rik.wave.entities;

import com.rik.wave.Game;
import com.rik.wave.hud.Timer;
import com.rik.wave.util.EntityHandler;
import com.rik.wave.util.ID;

import java.awt.*;

public class StalkerEnemyBase extends EntityBase{

    private final EntityBase player = EntityHandler.getPlayer();

    public StalkerEnemyBase(int x, int y) {
        super(x, y, 0, 0, ID.Enemy);
        setWidth(20);
        setHeight(20);
        setDamage(3);
    }

    @Override
    public void setup() {

    }

    @Override
    public void tick() {
        if(Timer.timePast < 3L){
            return;
        }


        if(player.getVelX() != 0){
            if(player.getVelX() > 0){
                velX = player.getVelX() - 1;
            }else{
                velX = player.getVelX() + 1;
            }
        } else{
            velX = 0;
        }

        if(player.getVelY() != 0){
            if(player.getVelY() > 0){
                velY = player.getVelY() - 1;
            }else{
                velY = player.getVelY() + 1;
            }
        } else{
            velY = 0;
        }

        x += velX;
        y += velY;

        // Checking for window border collision
        if(getX() <= 0){
            setX(0);
        } else if(getX() >= Game.WIDTH - getWidth()){
            setX(Game.WIDTH - getWidth());
        }

        if(getY() <= 0){
            setY(0);
        } else if(getY() >= Game.HEIGHT - getHeight() * 2){
            setY(Game.HEIGHT - getHeight() * 2);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(0, 255, 0, 127));
        g.fillRect(x, y, width, height);
    }
}

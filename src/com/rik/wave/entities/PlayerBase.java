package com.rik.wave.entities;

import com.rik.wave.Game;
import com.rik.wave.util.EntityHandler;
import com.rik.wave.util.ID;

import java.awt.*;

public class PlayerBase extends EntityBase{

    private static EntityHandler entityHandler = new EntityHandler();

    public PlayerBase(int x, int y) {
        super(x, y, 0, 0, ID.Player);
        setMaxHealth(100);
        setHealth(100);
        setHeight(20);
        setWidth(20);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        // Checks for player collision
        for(EntityBase entity: EntityHandler.entities){
            if(getBounds().intersects(entity.getBounds())){
                // Gets colliding entity
                switch (entity.getId()) {
                    case Enemy, CoinEater -> setHealth(getHealth() - entity.damage);
                }
            }
        }

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
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void setHealth(int health){
        if(health > maxHealth){
            this.health = maxHealth;
        }else if(health < minHealth){
            this.health = minHealth;
        }else {
            this.health = health;
        }
    }
}

package com.rik.wave.entities;

import com.rik.wave.hud.Timer;
import com.rik.wave.util.EntityHandler;
import com.rik.wave.util.ID;

import java.awt.*;

public class CoinEaterBase extends EntityBase{

    public CoinEaterBase(int x, int y) {
        super(x, y, 0, 0, ID.CoinEater);
        setWidth(10);
        setHeight(10);
        setDamage(1);
    }

    @Override
    public void tick() {
        if(Timer.timePast < 3L){
            return;
        }

        EntityBase coin = new CoinBase(0, 0);

        for(EntityBase entity: EntityHandler.entities){
            if(entity.getId() == ID.Coin){
                coin = entity;
            }
        }

        if(coin.x > this.x){
            velX = 2;
        } else if(coin.x < this.x){
            velX = -2;
        }

        if(coin.y > this.y){
            velY = 2;
        } else if(coin.y < this.y){
            velY = -2;
        }

        x += velX;
        y += velY;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
}

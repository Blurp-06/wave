package com.rik.wave.entities;

import com.rik.wave.util.EntityHandler;
import com.rik.wave.util.ID;
import com.rik.wave.util.spawn.CoinSpawn;

import java.awt.*;

public class CoinBase extends EntityBase{

    EntityBase player = EntityHandler.getPlayer();

    public CoinBase(int x, int y) {
        super(x, y, 0, 0, ID.Coin);
        setHeight(16);
        setWidth(16);
    }

    @Override
    public void setup(){
        // In PlayerBase amount of damage is amount of healing.
        setDamage(3);
    }

    @Override
    public void tick() {
        EntityBase coinEater = new CoinEaterBase(0, 0);

        for(EntityBase entity: EntityHandler.entities){
            if(entity.getId() == ID.CoinEater){
                coinEater = entity;
            }
        }


        if(getBounds().intersects(coinEater.getBounds())){
            Point nextLocation = CoinSpawn.newLocation(player.x, player.y, 60);
            x = nextLocation.x;
            y = nextLocation.y;
            setDamage(3);
            player.setHealth(player.getHealth() - coinEater.getDamage() * 10);
        } else if(getBounds().intersects(player.getBounds())){
            Point nextLocation = CoinSpawn.newLocation(player.x, player.y, 60);
            x = nextLocation.x;
            y = nextLocation.y;
            setDamage(3);
            player.setHealth(player.getHealth() + damage);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
    }
}

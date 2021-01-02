package com.rik.wave.util.spawn;

import com.rik.wave.Game;
import com.rik.wave.entities.EntityBase;
import com.rik.wave.entities.StalkerEnemyBase;
import com.rik.wave.util.EntityHandler;

import java.awt.geom.Point2D;
import java.util.Random;

public class StalkerEnemySpawn {

    static private final Random rnd = new Random();
    static private final EntityHandler entityHandler = new EntityHandler();

    public static void spawn(int amount, int playerX, int playerY, int distance){
        for(int i = 0; i < amount; i++){
            int x = playerX;
            int y = playerY;

            EntityBase tempEntity = new StalkerEnemyBase(0, 0);

            while(!(Point2D.distance(x, y, playerX, playerY) > distance)) {

                x = rnd.nextInt(Game.WIDTH - tempEntity.getWidth());
                y = rnd.nextInt(Game.HEIGHT - tempEntity.getHeight());

                // Extra randomizing
                for (int j = 0; j < 3; j++) {
                    rnd.nextInt();
                }
            }

            tempEntity.setX(x);
            tempEntity.setY(y);
            entityHandler.addEntity(tempEntity);
        }
    }
}

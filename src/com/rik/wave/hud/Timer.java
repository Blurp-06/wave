package com.rik.wave.hud;

import com.rik.wave.Game;
import com.rik.wave.entities.EntityBase;
import com.rik.wave.util.EntityHandler;
import com.rik.wave.util.ID;

import java.awt.*;

public class Timer extends EntityBase {

    private static long beginTime;
    private static long previousTime;
    public static long timePast = 0;

    public Timer() {
        super(Game.WIDTH / 2, 10, 0, 0, ID.HUD);
        setHeight(40);
    }

    @Override
    public void setup() {
        beginTime = System.currentTimeMillis() / 1000L;
    }

    @Override
    public void tick() {
        previousTime = timePast;
        long currentTime = System.currentTimeMillis() / 1000L;
        timePast = currentTime - beginTime;

        if(previousTime < timePast){
            for(EntityBase entity: EntityHandler.entities){
                entity.setTimeAlive(entity.getTimeAlive() + 1);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, height));
        g.drawString(String.valueOf(timePast), x, y + height);
    }
}

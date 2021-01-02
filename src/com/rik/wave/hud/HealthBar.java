package com.rik.wave.hud;

import com.rik.wave.Game;
import com.rik.wave.entities.EntityBase;
import com.rik.wave.util.EntityHandler;
import com.rik.wave.util.ID;

import java.awt.*;

public class HealthBar extends EntityBase {

    private final int firstHealth;
    private final EntityBase player;

    public HealthBar() {
        super(10, 10, 0, 0, ID.HUD);
        player = EntityHandler.getPlayer();
        firstHealth = player.getMaxHealth();
        setHeight(40);
        setWidth(firstHealth * 2);
    }

    @Override
    public void setup() {

    }

    @Override
    public void tick() {
        if(player.getBounds().intersects(getBounds())){
            final int bottom = Game.HEIGHT - (height * 2) - 10;
            if(y == bottom){
                y = 10;
            } else {
                y = bottom;
            }
        }
    }

    @Override
    public void render(Graphics g) {

        // Choosing color for life bar
        Color lifeColor = Color.GREEN;

        if(firstHealth * .15f >= player.getHealth()){
            lifeColor = Color.RED;
        }else if(firstHealth * .45f >= player.getHealth()){
            lifeColor = Color.ORANGE;
        }


        g.setColor(Color.GRAY);
        g.fillRect(x, y, firstHealth * 2, height);
        g.setColor(lifeColor);
        g.fillRect(x, y, player.getHealth() * 2, height);
        g.setColor(Color.BLACK);
        g.drawRect(x - 1, y - 1, firstHealth * 2 + 1, height + 1);
    }
}

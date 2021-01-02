package com.rik.wave.util;

import com.rik.wave.entities.EntityBase;
import com.rik.wave.entities.PlayerBase;

import java.awt.*;
import java.util.LinkedList;

public class EntityHandler {

    public static LinkedList<EntityBase> entities = new LinkedList<>();

    public void tick(){
        for(EntityBase entity: entities){
            entity.tick();
        }
    }

    public void render(Graphics g){
        for(EntityBase entity: entities){
            entity.render(g);
        }
    }

    public void addEntity(EntityBase entity){
        entities.add(entity);
        entity.setup();
    }

    public void removeEntity(EntityBase entity){
        entities.remove(entity);
    }

    static public EntityBase getPlayer(){
        EntityBase player = new PlayerBase(0, 0);

        for(EntityBase entity: entities){
            if(entity.getId() == ID.Player){
                player = entity;
                break;
            }
        }

        return player;
    }

}

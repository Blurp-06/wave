package com.rik.wave.entities;

import com.rik.wave.util.ID;

import java.awt.*;

public abstract class EntityBase {

    protected int x, y, velX, velY;
    protected int damage = 0;
    protected int health = 0;
    protected int maxHealth = 0;
    protected int minHealth = 0;

    protected int timeAlive = 0;

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMinHealth() { return minHealth; }

    public void setMinHealth(int minHealth) {
        this.minHealth = minHealth;
    }

    protected int width = 16;
    protected int height = 16;
    protected ID id;

    public EntityBase(int x, int y, int velX, int velY, ID id) {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
        this.id = id;

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setup(){}
    public abstract void tick();
    public abstract void render(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getVelX() {
        return velX;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVelY() {
        return velY;
    }

    public ID getId() {
        return id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public int getTimeAlive() {
        return timeAlive;
    }

    public void setTimeAlive(int timeAlive) {
        this.timeAlive = timeAlive;
    }
}

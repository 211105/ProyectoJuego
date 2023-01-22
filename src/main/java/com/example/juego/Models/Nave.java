
package com.example.juego.Models;

public class Nave {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;

    private int y;

    public Nave(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}

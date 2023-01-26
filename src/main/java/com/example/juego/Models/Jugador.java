package com.example.juego.Models;

import java.util.Observable;

public class Jugador extends Observable implements Runnable {
    private Nave pos;
    private boolean status,left=false,right=false;

    public void setPos(Nave pos) {
        this.pos = pos;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setRightChange(){
        pos.setX(pos.getX() + 0);
    }
    public void setLeftChange(){
        pos.setX(pos.getX() + 0);
    }
    public Jugador(){
        status = true;
    }

    @Override
    public void run() {
        while (status){
            setChanged();
            notifyObservers(pos);
            try {
                Thread.sleep(40L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(left == true){
                if(pos.getX() >= 0){
                    pos.setX(pos.getX() - 20);
                }
                left = false;
            }
            else if (right == true){
                if (pos.getX() <= 640){
                    pos.setX(pos.getX() + 20);
                }
                right=false;
            }
        }
    }
}

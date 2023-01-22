package com.example.juego.Models;

import java.util.Observable;

public class Jugador extends Observable implements Runnable {
    private int distancia =10;
    private Nave pos;// posicion de la nave

    private Boolean status;

    public Jugador(){
        status= true;
    }
    public void setPosicion(Nave pos){this.pos= pos;}

    @Override
    public void run() {
        while (status){
            pos.setX(pos.getX()+  distancia);
            setChanged();
            notifyObservers(pos);
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            if(pos.getX() >=590)
                distancia *= -1;
            if(pos.getX() <14)
                distancia *= -1;
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

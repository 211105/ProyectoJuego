package com.example.juego.Models;

import java.util.Observable;
import java.util.Random;

public class ObjetosGalaxia extends Observable implements Runnable {
    private Objetos objetosPos;
    private boolean status;
    private Random random;

    public void setObjetosPos(Objetos objetosPos){
        this.objetosPos=objetosPos;
    }
    public ObjetosGalaxia(){
        status = true;
    }
    int numero = (int)(Math.random()*640+1);

    @Override
    public void run() {
        objetosPos.setX(numero);

        while (status){

            objetosPos.setY((objetosPos.getY() + 2));
            setChanged();
            notifyObservers(objetosPos);

            try {
                Thread.sleep(50l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (objetosPos.getY() >=331){
                numero = (int)(Math.random()*640+1);
                objetosPos.setY(0);
                objetosPos.setX(numero);

            }

        }
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}

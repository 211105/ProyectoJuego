package com.example.juego.Controllers;

import com.example.juego.Models.Jugador;
import com.example.juego.Models.Nave;
import com.example.juego.Models.Objetos;
import com.example.juego.Models.ObjetosGalaxia;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {
    @FXML
    private ImageView Cohete;

    @FXML
    private ImageView planeta1;

    @FXML
    private Button btnAbajo;

    @FXML
    private Button btnArriba;

    @FXML
    private Button btnDerecha;

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnIzquierda;

    @FXML
    private Button btnPreparar;

    @FXML
    private Button btnSalir;

    @FXML
    private AnchorPane rootScene;

    private Jugador jugador;

    private ObjetosGalaxia objetosMov;

    private ObjetosGalaxia [] pos = new ObjetosGalaxia[7];

    @FXML
    void btnAbajoOnMause(MouseEvent event) {

    }

    @FXML
    void btnArribaOnMause(MouseEvent event) {

    }

    @FXML
    void btnDerechaOnMause(MouseEvent event) {
        jugador.setRightChange();
        jugador.setRight(true);
        System.out.println("Derecha");
    }

    @FXML
    void btnIniciarOnMause(MouseEvent event) {
        planeta1 = new ImageView(new Image(getClass().getResourceAsStream("/assets/imgs/tierra.gif")));
        planeta1.setFitHeight(57);
        planeta1.setFitWidth(60);
        planeta1.setLayoutX(0);
        planeta1.setLayoutY(0);
        rootScene.getChildren().addAll(planeta1);
        //Genera los obstaculos
        pos[0] = new ObjetosGalaxia();
        pos[0].setObjetosPos(new Objetos(1, 0, 0));
        pos[0].addObserver(this);
        Thread hilo2 = new Thread(pos[0]);
        hilo2.start();
        System.out.println(Thread.currentThread().getName());

        //Incia el hilo del cohete
        jugador = new Jugador();
        jugador.setPos(new Nave(1, 276, 256));
        jugador.addObserver(this);
        Thread hilo1 = new Thread(jugador);
        hilo1.start();



    }

    @FXML
    void btnIzquierdaOnMause(MouseEvent event) {
        jugador.setLeftChange();
        jugador.setLeft(true);
        System.out.println("Izquierda");
    }
    @FXML
    void btnPrepararOnMause(MouseEvent event) {

    }


    @FXML
    void btnSalirOnMause(MouseEvent event) {
        System.exit(1);
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Jugador) {
            Nave positionPersonage = (Nave) arg;
            Cohete.setLayoutX(positionPersonage.getX());
        }
        else if (o instanceof ObjetosGalaxia){
            Objetos ObP = (Objetos) arg;
            switch (ObP.getId()){
                case 1:
                    planeta1.setLayoutY(ObP.getY());
                    planeta1.setLayoutX((ObP.getX()));
                    break;
            }
        }
    }
}
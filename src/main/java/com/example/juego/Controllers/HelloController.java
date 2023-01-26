package com.example.juego.Controllers;

import com.example.juego.Models.Jugador;
import com.example.juego.Models.Nave;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {
    @FXML
    private ImageView Cohete;

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
    }

    @FXML
    void btnIniciarOnMause(MouseEvent event) {
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
    }
}
package com.example.juego.Controllers;

import com.example.juego.Models.Jugador;

import com.example.juego.Models.Nave;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnPreparar;

    @FXML
    private Button btnSalir;

    @FXML
    private AnchorPane rootScene;

    private Circle c1;

    private Jugador juega1;

    private int distancia = 10;

    @FXML
    void btnIniciarOnMause(MouseEvent event) {
        juega1 = new Jugador();
        juega1.setPosicion(new Nave(1,300,351));
        juega1.addObserver(this);
        Thread inicio = new Thread(juega1);
        inicio.start();
        System.out.println("derecha");
    }

    @FXML
    void btnPrepararOnMause(MouseEvent event) {
        c1 = new Circle(10, Color.BLACK);
        c1.setLayoutX(300);
        c1.setLayoutY(351);
        rootScene.getChildren().add(c1);
        System.out.println("Preparar");
    }

    @FXML
    void btnSalirOnMause(MouseEvent event) {
        System.exit(1);

    }

    @Override
    public void update(Observable o, Object arg) {
        Nave pos =(Nave) arg;
        switch (pos.getId()){
            case 1:
                Platform.runLater(()-> c1.setLayoutX(pos.getX()));
                break;
        }

    }
}
package com.example.juego.Controllers;

import com.example.juego.Models.Jugador;
import com.example.juego.Models.Nave;
import com.example.juego.Models.Objetos;
import com.example.juego.Models.ObjetosGalaxia;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {
    private Line line;
    @FXML
    private ImageView Cohete;

    @FXML
    private ImageView planeta1;
    @FXML
    private ImageView imagen2;

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
    void btnDerechaOnMause(MouseEvent event) {
        jugador.setRightChange();
        jugador.setRight(true);
        System.out.println("Derecha");
    }

    @FXML
    void btnIniciarOnMause(MouseEvent event) {
        planeta1 = new ImageView(new Image(getClass().getResourceAsStream("/assets/imgs/neptune3.sp.jpg")));
        planeta1.setFitHeight(57);
        planeta1.setFitWidth(60);
        rootScene.getChildren().addAll(planeta1);
        //Genera los obstaculos
        pos[0] = new ObjetosGalaxia();
        pos[0].setObjetosPos(new Objetos(1, 0, 0));
        pos[0].addObserver(this);
        Thread hilo2 = new Thread(pos[0]);
        hilo2.start();
        System.out.println(Thread.currentThread().getName());

        imagen2 = new ImageView(new Image(getClass().getResourceAsStream("/assets/imgs/pia00271_detail.jpg")));
        imagen2.setFitHeight(67);
        imagen2.setFitWidth(80);
        rootScene.getChildren().addAll(imagen2);
        //Genera los obstaculos
        pos[1] = new ObjetosGalaxia();
        pos[1].setObjetosPos(new Objetos(2, 0, 0));
        pos[1].addObserver(this);
        Thread hilo3 = new Thread(pos[1]);
        hilo3.start();
        System.out.println("Holitasss" + hilo3);
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

                    Platform.runLater(() -> planeta1.setLayoutY(ObP.getY()));
                    Platform.runLater(() -> planeta1.setLayoutX(ObP.getX()));
                    break;
                case 2:
                    Platform.runLater(() -> imagen2.setLayoutY(ObP.getY()));
                    Platform.runLater(() -> imagen2.setLayoutX(ObP.getX()));
                    break;

            }
        } if (planeta1.getBoundsInParent().intersects(Cohete.getBoundsInParent())) {
            pos[1].setStatus(false);
            jugador.setStatus(false);
            pos[0].setStatus(false);
        }



    }
}
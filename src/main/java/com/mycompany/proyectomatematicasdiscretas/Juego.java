/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomatematicasdiscretas;

import com.mycompany.proyectomatematicasdiscretas.data.Pregunta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author luidbrav
 */
public class Juego {

    private final int tiempoPreg = 60;
    private ArrayList<Pregunta> listaPreguntas;
    private boolean continued;
    private int puntaje = 0;
    private int tiempo = 60;
    private int numPreg = 0;
    private Label temp = new Label("Tiempo: " + Integer.toString(tiempo));
    private VBox seccionPreguntas = new VBox();
    private Tiempo t;
    private Label puntuacion = new Label("Puntuacion: " + Integer.toString(puntaje));
    private Label nPreg = new Label("Pregunta Numero: " + Integer.toString(numPreg));

    public Juego(ArrayList<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
        this.continued = true;
        this.t = new Tiempo();
    }

    public void iniciarJuego() {
        ImageView polito;

        try {
            HBox zonaBot = new HBox();
            polito = new ImageView(
                    new Image(
                            new FileInputStream("src/recursos/imagenes/polito.png"), 200, 200, false, false)
            );
            zonaBot.getChildren().add(polito);
            MenuPrincipal.root.setBottom(zonaBot);
            zonaBot.setAlignment(Pos.BOTTOM_RIGHT);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        VBox zonaTop = new VBox();
        HBox zonaInfo = new HBox();
        temp.setStyle("-fx-text-fill: #00FF00");
        puntuacion.setStyle("-fx-text-fill: #0000FF");
        nPreg.setStyle("-fx-text-fill: #FF0000; -fx-font-size: 30;");
        zonaInfo.getChildren().addAll(temp, puntuacion);
        zonaTop.getChildren().addAll(nPreg, zonaInfo);
        zonaTop.setSpacing(20);
        zonaTop.setAlignment(Pos.TOP_CENTER);
        MenuPrincipal.root.setTop(zonaTop);
        zonaInfo.setAlignment(Pos.TOP_CENTER);
        zonaInfo.setSpacing(20);

        formarPregunta();
        t.start();
    }

    public void formarPregunta() {
        if (!listaPreguntas.isEmpty()) {
            System.out.println("pregutas en cola "+ listaPreguntas.size());
            numPreg += 1;
            nPreg.setText("Pregunta Numero :" + Integer.toString(numPreg));
            Pregunta preg = obtenerPregunta(listaPreguntas);
            Label enunciado = new Label(preg.getEnunciado());
            seccionPreguntas.getChildren().add(enunciado);
            seccionPreguntas.setSpacing(20);
            VBox seccionOpciones = new VBox();
            seccionOpciones.setSpacing(10);
            ArrayList<String> opciones = preg.getAlternativas();
            for (String opcion : opciones) {
                Button opc = new Button(opcion);
                opc.setPadding(new Insets(10, 10, 10, 10));
                seccionOpciones.getChildren().add(opc);
                seccionOpciones.setAlignment(Pos.CENTER);
                opc.setOnAction((e -> {
                    String res = opc.getText();
                    if (res.equals(preg.getOpcionCorrecta())) {
                        puntaje += tiempo;
                        tiempo += tiempoPreg;
                        puntuacion.setText("Puntuacion: " + Integer.toString(puntaje));
                        seccionPreguntas.getChildren().clear();
                        if (listaPreguntas.size() > 0 || !continued) {
                            formarPregunta();
                        }
                    } else {
                        continued = false;
                        t.stop();
                        seccionPreguntas.getChildren().clear();
                        String razon = " TE HAS EQUIVOCADO\n\n\n LA OPCION CORRECTA ERA:\n\n\n" + preg.getOpcionCorrecta() + "\n\n\n";

                        Label finalizacion = new Label(razon + " PUNTOS OBTENIDOS:\n\n\n" + puntaje);
                        Button cancel = new Button("menu Principal");
                        Button salir = new Button("Salir");
                        seccionPreguntas.getChildren().addAll(finalizacion, cancel, salir);
                        cancel.setOnAction(f -> {
                            seccionPreguntas.getChildren().clear();
                            MenuPrincipal.root.getChildren().clear();
                            App.pn.VentanaInicial();
                        });
                        salir.setOnMouseClicked(
                                (h) -> {
                                    ((Stage) (((Button) h.getSource()).getScene().getWindow())).close();
                                }
                        );

                        finalizacion.setAlignment(Pos.CENTER);

                    }
                }));
            }
            seccionPreguntas.getChildren().add(seccionOpciones);
            MenuPrincipal.root.setCenter(seccionPreguntas);
            seccionPreguntas.setAlignment(Pos.CENTER);
        }
        if (tiempo == 0 || listaPreguntas.isEmpty()) {
            t.stop();
            seccionPreguntas.getChildren().clear();
            String razon;
            if (tiempo == 0) {
                razon = " EL TIEMPO SE HA ACABADO\n\n\n";
            } else {
                razon = " SE TERMINARON LAS PREGUNTAS\n\n\n";
            }
            Label finalizacion = new Label(razon + " PUNTOS OBTENIDOS:\n\n\n" + puntaje);
            Button cancel = new Button("menu Principal");
            Button salir = new Button("Salir");
            seccionPreguntas.getChildren().addAll(finalizacion, cancel, salir);
            cancel.setOnAction(f -> {
                seccionPreguntas.getChildren().clear();
                MenuPrincipal.root.getChildren().clear();
                App.pn.VentanaInicial();
            });
            salir.setOnMouseClicked(
                    (e) -> {
                        ((Stage) (((Button) e.getSource()).getScene().getWindow())).close();
                    }
            );

            finalizacion.setAlignment(Pos.CENTER);
        }

    }

    public void verificarIntegridad() {
        if (!continued || tiempo == 0) {
            t.stop();
            seccionPreguntas.getChildren().clear();
            String razon;
            if (tiempo == 0) {
                razon = " EL TIEMPO SE HA ACABADO\n\n\n";
            }
            else {
                razon = " SE TERMINARON LAS PREGUNTAS\n\n\n";
            }
            Label finalizacion = new Label(razon + " PUNTOS OBTENIDOS:\n\n\n" + puntaje);
            Button cancel = new Button("menu Principal");
            Button salir = new Button("Salir");
            seccionPreguntas.getChildren().addAll(finalizacion, cancel, salir);
            cancel.setOnAction(f -> {
                seccionPreguntas.getChildren().clear();
                MenuPrincipal.root.getChildren().clear();
                App.pn.VentanaInicial();
            });
            salir.setOnMouseClicked(
                    (e) -> {
                        ((Stage) (((Button) e.getSource()).getScene().getWindow())).close();
                    }
            );

            finalizacion.setAlignment(Pos.CENTER);

        }
    }

    public Pregunta obtenerPregunta(ArrayList<Pregunta> p) {
        Pregunta pregunta;
        Random rd = new Random();
        int ind = rd.nextInt(p.size());
        pregunta = p.get(ind);
        p.remove(pregunta);
        return pregunta;
    }

    private class Tiempo extends Thread {

        @Override
        public void run() {
            try {
                while (tiempo > 0) {
                    Thread.sleep(1000);
                    tiempo -= 1;
                    Platform.runLater(() -> {
                        temp.setText("tiempo: " + Integer.toString(tiempo));
                    });
                }
                Platform.runLater(() -> {
                verificarIntegridad();
                });

            } catch (InterruptedException ex) {
                System.out.println("Algo ocurrio:Tiempo");
            }
        }
    }
}

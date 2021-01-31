/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectomatematicasdiscretas;

import com.mycompany.proyectomatematicasdiscretas.data.Pregunta;
import com.mycompany.proyectomatematicasdiscretas.data.Prueba;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author luidbrav
 */
public class MenuPrincipal {

    public static BorderPane root;
    public VBox menu;
    public ImageView icono;
    public Label linea1, linea2, linea3;
    public Button dif, selCap, maxPunt, salir;

    public MenuPrincipal() {
        //Prueba.cargarPreguntasPrueba();
        root = new BorderPane();
        menu = new VBox();
        try {
            icono = new ImageView(new Image(new FileInputStream("src/recursos/imagenes/polito.png"), 200, 200, false, false));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        menu.getChildren().add(icono);
        linea1 = new Label("Poliestudios");
        linea1.setFont(new Font("Verdana", 40));
        linea1.setTextFill(Color.RED);
        linea2 = new Label("Matematicas");
        linea2.setFont(new Font("Verdana", 32));
        linea2.setTextFill(Color.GREEN);
        linea3 = new Label("Discretas");
        linea3.setFont(new Font("kalinko hand", 32));
        linea3.setTextFill(Color.GREEN);
        dif = new Button("Dificultad");
        selCap = new Button("Seleccionar\n   Capitulo");
        maxPunt = new Button("Mostrar Informacion Grupo");
        salir = new Button("Salir");
        root.setPadding(new Insets(0, 0, 20, 0));
        menu.setSpacing(10);
        VentanaInicial();
        dif.setOnAction((e) -> {
            menu.getChildren().clear();
            try {
                ImageView polo = new ImageView(new Image(new FileInputStream("src/recursos/imagenes/polito2.png"), 200, 200, false, false));
                root.setBottom(polo);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            Label title = new Label("Dificultad");
            title.setFont(new Font("Verdana", 40));
            title.setTextFill(Color.RED);
            Button eas = new Button("Facil");
            Button med = new Button("Medio");
            Button hard = new Button("Dificil");
            Button cancel = new Button("Cancelar");
            menu.getChildren().addAll(title, eas, med, hard, cancel);
            menu.setAlignment(Pos.CENTER);
            eas.setOnAction((r) -> {
                try {
                    ArrayList<Pregunta> preguntas = Prueba.obtenerPreguntasDificultad("Facil ");
                    root.getChildren().clear();
                    menu.getChildren().clear();
                    Juego jg = new Juego(preguntas);
                    jg.iniciarJuego();
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }

            });

            med.setOnAction((r) -> {
                try {
                    ArrayList<Pregunta> preguntas = Prueba.obtenerPreguntasDificultad("Media ");
                    root.getChildren().clear();
                    menu.getChildren().clear();
                    Juego jg = new Juego(preguntas);
                    jg.iniciarJuego();
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }

            });

            hard.setOnAction((r) -> {
                try {
                    ArrayList<Pregunta> preguntas = Prueba.obtenerPreguntasDificultad("Dificil ");
                    root.getChildren().clear();
                    menu.getChildren().clear();
                    Juego jg = new Juego(preguntas);
                    jg.iniciarJuego();
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }
            });

            cancel.setOnAction((r) -> {
                menu.getChildren().clear();
                VentanaInicial();
            });
        });
        selCap.setOnAction((e) -> {
            menu.getChildren().clear();
            try {
                ImageView polo = new ImageView(new Image(new FileInputStream("src/recursos/imagenes/polito2.png"), 200, 200, false, false));
                root.setBottom(polo);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            Label title = new Label("Seleccionar\n Capitulo");
            title.setFont(new Font("Verdana", 40));
            title.setTextFill(Color.RED);
            Button prep = new Button("Preposiciones");
            Button operLog = new Button("Operadores Logico");
            Button formProp = new Button("Formas Proposicionales");
            Button conj = new Button("Conjuntos");
            Button rel = new Button("Relaciones");
            /*Button parOrd = new Button("Pares Ordenados y\n Producto Cartesiano");*/
            Button cancel = new Button("Cancelar");
            menu.getChildren().addAll(title, prep, operLog,formProp, conj, rel, cancel);
            menu.setAlignment(Pos.CENTER);
            cancel.setOnAction((r) -> {
                menu.getChildren().clear();
                VentanaInicial();
            });

            prep.setOnAction((r) -> {
                try {
                    ArrayList<Pregunta> preguntas = Prueba.obtenerPreguntasTema("Preposiciones ");
                    root.getChildren().clear();
                    menu.getChildren().clear();
                    Juego jg = new Juego(preguntas);
                    jg.iniciarJuego();
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }
            });

            operLog.setOnAction((r) -> {
                try {
                    ArrayList<Pregunta> preguntas = Prueba.obtenerPreguntasTema("Operadores Logico ");
                    root.getChildren().clear();
                    menu.getChildren().clear();
                    Juego jg = new Juego(preguntas);
                    jg.iniciarJuego();
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }
            });

            formProp.setOnAction((r) -> {
                try {
                    ArrayList<Pregunta> preguntas = Prueba.obtenerPreguntasTema("Formas Proposicionales ");
                    root.getChildren().clear();
                    menu.getChildren().clear();
                    Juego jg = new Juego(preguntas);
                    jg.iniciarJuego();
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }
            });

            conj.setOnAction((r) -> {
                try {
                    ArrayList<Pregunta> preguntas = Prueba.obtenerPreguntasTema("Conjuntos ");
                    root.getChildren().clear();
                    menu.getChildren().clear();
                    Juego jg = new Juego(preguntas);
                    jg.iniciarJuego();
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }
            });

            rel.setOnAction((r) -> {
                try {
                    ArrayList<Pregunta> preguntas = Prueba.obtenerPreguntasTema("Relaciones ");
                    root.getChildren().clear();
                    menu.getChildren().clear();
                    Juego jg = new Juego(preguntas);
                    jg.iniciarJuego();
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }
            });
            cancel.setOnAction((r) -> {
                menu.getChildren().clear();
                VentanaInicial();
            });

        });

        maxPunt.setOnAction(g -> {
            menu.getChildren().clear();
            Label NG = new Label("GRUPO # 6");
            VBox integrantes = new VBox();
            Button luis = new Button("Donoso Luis");
            Button carlos = new Button("Gomez Carlos");
            Button stefany = new Button("Stefany Farias");
            Button daniela = new Button("Daniela Litardo");
            Button cancel = new Button("cancelar");
            integrantes.getChildren().addAll(luis, carlos, stefany, daniela, cancel);
            integrantes.setSpacing(10);
            integrantes.setAlignment(Pos.CENTER);
            menu.getChildren().addAll(NG, integrantes);
            luis.setOnAction((d) -> {
                menu.getChildren().clear();
                Label nam = new Label("Nombre: ");
                nam.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label nomb = new Label("Donoso Bravo Luis Alejandro");
                nomb.setStyle("-fx-font-size: 15;");
                Label matr = new Label("Matricula: ");
                matr.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label mat = new Label("201909827");
                mat.setStyle("-fx-font-size: 15;");
                Label cor = new Label("Correo: ");
                cor.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Button menuPrincipal = new Button("menu Principal");
                Label email = new Label("luidbrav@espol.edu.ec");
                email.setStyle("-fx-font-size: 15;");
                menu.getChildren().addAll(nam, nomb, matr, mat, cor, email, menuPrincipal);
                menuPrincipal.setOnAction((r) -> {
                    menu.getChildren().clear();
                    VentanaInicial();
                });
            });
            carlos.setOnAction((c) -> {
                menu.getChildren().clear();
                Label nam = new Label("Nombre: ");
                nam.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label nomb = new Label("Carlos Danilo Gomez Tello");
                nomb.setStyle("-fx-font-size: 15;");
                Label matr = new Label("Matricula: ");
                matr.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label mat = new Label("201605987");
                mat.setStyle("-fx-font-size: 15;");
                Label cor = new Label("Correo: ");
                cor.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Button menuPrincipal = new Button("menu Principal");
                Label email = new Label("cdangome@espol.edu.ec");
                email.setStyle("-fx-font-size: 15;");
                menu.getChildren().addAll(nam, nomb, matr, mat, cor, email, menuPrincipal);
                menuPrincipal.setOnAction((r) -> {
                    menu.getChildren().clear();
                    VentanaInicial();
                });
            });
            stefany.setOnAction((c) -> {
                menu.getChildren().clear();
                Label nam = new Label("Nombre: ");
                nam.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label nomb = new Label("Stefany Farias Mera");
                nomb.setStyle("-fx-font-size: 15;");
                Label matr = new Label("Matricula: ");
                matr.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label mat = new Label("201601457");
                mat.setStyle("-fx-font-size: 15;");
                Label cor = new Label("Correo: ");
                cor.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Button menuPrincipal = new Button("menu Principal");
                Label email = new Label("snfarias@espol.edu.ec");
                email.setStyle("-fx-font-size: 15;");
                menu.getChildren().addAll(nam, nomb, matr, mat, cor, email, menuPrincipal);
                menuPrincipal.setOnAction((r) -> {
                    menu.getChildren().clear();
                    VentanaInicial();
                });
            });
            daniela.setOnAction((c) -> {
                menu.getChildren().clear();
                Label nam = new Label("Nombre: ");
                nam.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label nomb = new Label("Daniela Elizabeth Litardo Espinoza");
                nomb.setStyle("-fx-font-size: 15;");
                Label matr = new Label("Matricula: ");
                matr.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Label mat = new Label("201800844");
                mat.setStyle("-fx-font-size: 15;");
                Label cor = new Label("Correo: ");
                cor.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
                Button menuPrincipal = new Button("menu Principal");
                Label email = new Label("dlitardo@espol.edu.ec");
                email.setStyle("-fx-font-size: 15;");
                menu.getChildren().addAll(nam, nomb, matr, mat, cor, email, menuPrincipal);
                menuPrincipal.setOnAction((r) -> {
                    menu.getChildren().clear();
                    VentanaInicial();
                });
            });
            cancel.setOnAction((r) -> {
                menu.getChildren().clear();
                VentanaInicial();
            });

        });
        salir.setOnMouseClicked(
                (e) -> {
                    ((Stage) (((Button) e.getSource()).getScene().getWindow())).close();
                }
        );
    }

    public void VentanaInicial() {
        menu.getChildren().addAll(linea1, linea2, linea3, dif, selCap, maxPunt, salir);
        menu.setAlignment(Pos.CENTER);
        root.setCenter(menu);

    }

    public BorderPane getRoot() {
        return root;
    }
}

package com.mycompany.proyectomatematicasdiscretas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    static MenuPrincipal pn;

    @Override
    public void start(Stage primaryStage) {
        pn = new MenuPrincipal();
        try {
            primaryStage.getIcons().add(new Image(new FileInputStream("src/recursos/imagenes/logoEspol.png")));
        } catch (FileNotFoundException ex) {
        }
        primaryStage.setTitle("Proyecto Matematicas Discretas");
        Scene sc = new Scene(pn.getRoot(), 1300, 800);
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
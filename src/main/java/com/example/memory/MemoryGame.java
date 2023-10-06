package com.example.memory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MemoryGame extends Application {

    private Pane root;

    @Override
    public void start(Stage mainStage) {
        // Sæt scene og vindue
        mainStage.setTitle("Memory Game");

        root = new Pane();
        root.setPrefSize(1920, 1000);      // Brikkerne er 80*80 på et 4*4 bræt

        Scene scene = new Scene(root);
        mainStage.setScene(scene);

        mainStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
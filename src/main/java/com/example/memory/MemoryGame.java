package com.example.memory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MemoryGame extends Application {

    private Pane root;

    @Override
    public void start(Stage mainStage) {
        // Sæt scene og vindue
        mainStage.setTitle("Memory Game");

        root = new Pane();
        root.setPrefSize(1920, 1000);

        Scene scene = new Scene(root);
        mainStage.setScene(scene);

        mainStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
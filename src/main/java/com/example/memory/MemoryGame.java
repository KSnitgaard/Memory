package com.example.memory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MemoryGame extends Application {

    private Pane root;
    private Pane root2;
    private Pane root3;

    @Override
    public void start(Stage mainStage) {
        // Sæt scene og vindue
        mainStage.setTitle("Memory Game");

        root = new Pane();
        root.setPrefSize(1920, 1000);

        root2 = new Pane();
        root2.setPrefSize(1920, 1000);

        root3 = new Pane();
        root3.setPrefSize(1920, 1000);

        Scene start = new Scene(root);
        mainStage.setScene(start);

        Scene game = new Scene(root2);

        Scene end = new Scene(root3);


        mainStage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}
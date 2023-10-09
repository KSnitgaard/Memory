package com.example.memory;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MemoryGame extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Pane scenegraf = new Pane();
        Scene scene = new Scene(scenegraf, 1920, 1000);
        stage.setScene(scene);
        stage.setTitle("Start");
        stage.show();

        ImageView menu = new ImageView(new Image(getClass().getResource("Startscreen.png").toString()));
        scenegraf.getChildren().add(menu);

        Button startButton = new Button("Start!");
        startButton.setTranslateX(940);
        startButton.setTranslateY(614);
        startButton.setScaleX(3);
        startButton.setScaleY(3);
        startButton.setStyle("-fx-background-radius: 15");
        scenegraf.getChildren().add(startButton);

        startButton.setOnAction(event -> {
            // Switch to the second scene when the "Start!" button is clicked
            stage.setScene(createMemoryGameScene());
            stage.setTitle("Memory Game");
        });
    }

    private Scene createMemoryGameScene() {
        Pane scenegraf2 = new Pane();
        EventHandler<MouseEvent> eventHandler = e -> {
            Plate b = (Plate) e.getSource();
            b.vend();
        };

        Plate[][] plates = new Plate[6][4];
        for (int i=0; i<6; i++)
            for (int j=0; j<4; j++) {
                plates[i][j] = new Plate(i, j, "brik1.png");
                scenegraf2.getChildren().add(plates[i][j]);
                plates[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            }
        return new Scene(scenegraf2, 1920, 1000);
    }

    public static void main(String[] args) {
        launch();
    }
}
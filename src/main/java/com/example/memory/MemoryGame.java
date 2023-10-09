package com.example.memory;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MemoryGame extends Application {

    private Plate[][] plates;

    @Override
    public void start(Stage stage) throws IOException {
        Pane scenegraf = new Pane();

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Plate b = (Plate) e.getSource();
                b.vend();
            }
        };

        plates = new Plate[6][4];
        for (int i=0; i<6; i++)
            for (int j=0; j<4; j++) {
                plates[i][j] = new Plate(i, j, "brik1.png");
                scenegraf.getChildren().add(plates[i][j]);
                plates[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            }

        Scene scene = new Scene(scenegraf, 1000, 1000);
        stage.setTitle("MemorySkelet!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
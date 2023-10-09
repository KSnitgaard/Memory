package com.example.memory;

import javafx.application.Application;
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

    private Pane scenegraf;
    private Pane scenegraf2;
    private Pane scenegraf3;




    private Plate[][] plates;

    @Override
    public void start(Stage stage) throws IOException {
        Pane scenegraf = new Pane();
        Scene scene = new Scene(scenegraf, 1920, 1000);
        stage.setScene(scene);
        stage.setTitle("Start");
        stage.show();

        ImageView menu = new ImageView(new Image(getClass().getResource("Startscreen.png").toString()));
        scenegraf.getChildren().add(menu);

        Button Start = new Button("Start!");
        Start.setTranslateX(945);
        Start.setTranslateY(600);
        Start.setScaleX(4);
        Start.setScaleY(4);
        scenegraf.getChildren().add(Start);



        Pane scenegraf2 = new Pane();

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
                scenegraf2.getChildren().add(plates[i][j]);
                plates[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            }

        Scene scene2 = new Scene(scenegraf2, 1920, 1000);
        stage.setTitle("Memory Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
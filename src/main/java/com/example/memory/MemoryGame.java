package com.example.memory;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MemoryGame extends Application {
    private Plate plate;
    private Plate firstFlippedPlate = null;
    private boolean isFlippingInProgress = false;
    private int counterPair = 0;
    private int counterTræk = 0;

    private Scoreboard scoreboard;


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
        Start.setTranslateX(925);
        Start.setTranslateY(600);
        Start.setScaleX(4);
        Start.setScaleY(4);
        Start.getStyleClass().add("startButton");

        scenegraf.getChildren().add(Start);
        Start.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        Start.setOnAction(event -> {
            stage.setScene(createMemoryGameScene(stage, scene));
            stage.setTitle("Memory Game");
        });

        //scoreboard = new Scoreboard();


    }

    public void handlePlateFlip(Plate plate) {
        if (firstFlippedPlate == null) {
            firstFlippedPlate = plate;
            plate.vend();
        } else {
            isFlippingInProgress = true;
            if (firstFlippedPlate.getPlateId().equals(plate.getPlateId())) {
                System.out.println("MATCHED");
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> {
                    firstFlippedPlate.setOpacity(0.0);
                    plate.setOpacity(0.0);
                    firstFlippedPlate = null;
                    isFlippingInProgress = false;
                    //scoreboard.incrementCorrectMatches();
                    counterTræk++;
                    counterPair++;

                    //updateLabels();
                });
                pause.play();
            } else {
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(e -> {
                    firstFlippedPlate.vendTilbage();
                    plate.vendTilbage();
                    firstFlippedPlate = null;
                    isFlippingInProgress = false;
                    counterTræk++;
                    //updateLabels();  // Update the labels
                    System.out.println(counterTræk);
                });
                pause.play();
                if (counterPair == 12) {
                    Pane scenegraf3 = new Pane();
                    Scene endscene = new Scene(scenegraf3, 1920, 1000);
                    scoreboard = new Scoreboard();

                    ImageView EndScene = new ImageView(new Image(getClass().getResource("EndScreen.png").toString()));
                    scenegraf3.getChildren().add(EndScene);
                }
                }
                //scoreboard.incrementTotalGuesses();
                //updateLabels();


            }
            //totalGuessesLabel.setText("Total Guesses: " + scoreboard.getTotalGuesses());
            //correctMatchesLabel.setText("Correct Matches: " + scoreboard.getCorrectMatches());


        }


    /*private void updateLabels()
    {
        correctMatchesLabel.setText(Integer.toString(counterPair));
        totalGuessesLabel.setText(Integer.toString(counterTræk));
    }*/

    public Scene createMemoryGameScene(Stage stage, Scene prevScene) {
        Pane scenegraf2 = new Pane();
        Scene memoryGameScene = new Scene(scenegraf2, 1920, 1000);
        scoreboard = new Scoreboard();
        Label totalGuessesLabel = new Label();

        ImageView game = new ImageView(new Image(getClass().getResource("BaggrundBord.png").toString()));
        scenegraf2.getChildren().add(game);

        EventHandler<MouseEvent> eventHandler = e -> {
            Plate plate = (Plate) e.getSource();
            plate.vend();
            handlePlateFlip(plate);
        };

        bland(scenegraf2, eventHandler);

        Button backButton = new Button("Back to Start");
        backButton.setTranslateX(1700);
        backButton.setTranslateY(40);
        backButton.setScaleX(2.5);
        backButton.setScaleY(2.5);
        backButton.getStyleClass().add("backButton");

        scenegraf2.getChildren().add(backButton);
        backButton.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        backButton.setOnAction(event -> {
            stage.setScene(prevScene);
            stage.setTitle("Start");
        });

        totalGuessesLabel.setText("Total guesses: " + counterTræk);
        totalGuessesLabel.setTranslateX(20);
        totalGuessesLabel.setTranslateY(20);


        Label correctMatchesLabel = new Label("Correct Matches: " + counterPair);
        correctMatchesLabel.setTranslateX(20);
        correctMatchesLabel.setTranslateY(40);
        scenegraf2.getChildren().addAll(totalGuessesLabel, correctMatchesLabel);


        return memoryGameScene;
    }

    public static void main(String[] args) {
        launch();
    }


    public void bland(Pane scenegraf2, EventHandler<MouseEvent> eventHandler) {

        String liste[] = {"ida", "PlateArgentina.png", "ida", "PlateEmpanadas.png", "idb", "PlateBelgium.png", "idb", "PlateFries.png", "idc", "PlateChina.png", "idc", "PlateChinabox.png",
                "idd", "PlateFrance.png", "idd", "PlateCrossaint.png", "ide", "PlateGermany.png", "ide", "PlateSchnitzel.png", "idf", "PlateIndia.png", "idf", "PlateCurry.png", "idg", "PlateItaly.png",
                "idg", "PlatePizza.png", "idh", "PlateJapan.png", "idh", "PlateSushi.png", "idi", "PlateMexico.png", "idi", "PlateTaco.png", "idj", "PlateSpain.png", "idj", "PlateChurros.png",
                "idk", "PlateSweden.png", "idk", "PlateMeatballs.png", "idl", "PlateTurkey.png", "idl", "PlateKebab.png"};

        for (int i = 0; i < liste.length; i++) System.out.println(liste[i]);
        System.out.println("----------------------");

        for (int i = 0; i < 100; i++) {
            String a_id, a_fil;

            int x = (int) (Math.random() * 24.0) * 2;
            a_id = liste[x];
            a_fil = liste[x + 1];
            int y = (int) (Math.random() * 24.0) * 2;
            liste[x] = liste[y];
            liste[x + 1] = liste[y + 1];
            liste[y] = a_id;
            liste[y + 1] = a_fil;
        }

        Plate[][] plates = new Plate[6][4];
        int t = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 4; j++) {
                plates[i][j] = new Plate(i, j, liste[t], liste[t + 1]);
                plates[i][j].setMemoryGame(this);
                t = t + 2;
                scenegraf2.getChildren().add(plates[i][j]);
                plates[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            }


        for (int i = 0; i < liste.length; i++) System.out.println(liste[i]);
        System.out.println("----------------------");

    }

    public void gameStop() {
        if (counterPair == 12) {
            Pane scenegraf3 = new Pane();
            Scene EndScene = new Scene(scenegraf3, 1920, 1000);
            scoreboard = new Scoreboard();

            ImageView game = new ImageView(new Image(getClass().getResource("EndScreen.png").toString()));
            scenegraf3.getChildren().add(game);
        }
    }

    /*public Scene createEndScene(Stage stage, Scene prevScene) {
        Pane scenegraf3 = new Pane();
        Scene EndScene = new Scene(scenegraf3, 1920, 1000);
        scoreboard = new Scoreboard();

        ImageView game = new ImageView(new Image(getClass().getResource("EndScreen.png").toString()));
        scenegraf3.getChildren().add(game);

        return EndScene;
    }*/
}
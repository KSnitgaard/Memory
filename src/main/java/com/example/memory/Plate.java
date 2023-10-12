package com.example.memory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Plate extends ImageView {

    private Image forside, bagside;
    private MemoryGame memoryGame;
    private String id;
    public void setMemoryGame(MemoryGame memoryGame) {
        this.memoryGame = memoryGame;
    }

    public Plate(int x, int y, String s, String filnavn) {
        forside = new Image(getClass().getResource(filnavn).toString());
        bagside = new Image(getClass().getResource("Lid.png").toString());
        setImage(bagside);
        setX(x*300);
        setY(y*200);
        setTranslateX(100);
        setTranslateY(100);
        id = s;
    }

        public String getPlateId(){
        return id;
    }

    public void vend() {
        System.out.println("brik " + getX() + "," + getY());
        setImage(forside);
    }

    public void vendTilbage() {
        setImage(bagside);
    }


}
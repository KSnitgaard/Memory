package com.example.memory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Plate extends ImageView {

    private Image forside, bagside;

    public Plate(int x, int y, String filnavn) {
        forside = new Image(getClass().getResource(filnavn).toString());
        bagside = new Image(getClass().getResource("PlatePizza.png").toString());
        setImage(forside);
        setX(x*300);
        setY(y*200);
        setTranslateX(100);
        setTranslateY(100);
    }

    public void vend() {
        System.out.println("brik " + getX() + "," + getY());
        setImage(bagside);
    }
}
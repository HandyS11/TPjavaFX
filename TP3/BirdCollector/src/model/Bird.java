package model;

import java.time.LocalDate;

public class Bird {

    private String name;
    private int hungerStrength;
    private Color wingsColor;
    private LocalDate lastMeal;
    private boolean needEat;

    public Bird(String name, int hungerStrength) {
        this.name = name;
        this.hungerStrength = hungerStrength;
        wingsColor = new Color(255, 255, 255);
        lastMeal = LocalDate.now();
        needEat = false;
    }
}

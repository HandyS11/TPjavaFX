package model;

import java.io.Serializable;

public class Color implements Serializable {

    private double red;
    private double green;
    private double blue;

    public Color(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }
}

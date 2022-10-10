package model;

public class Color {

    private int red;
    private int green;
    private int blue;


    public Color(double red, double green, double blue) {
        this.red = (int) red*255;
        this.green = (int) green*255;
        this.blue = (int) blue*255;
    }


    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBleu() {
        return blue;
    }

    public void editColor(int red, int green, int blue) {
        this.red = (int) red*255;
        this.green = (int) green*255;
        this.blue = (int) blue*255;
    }
}

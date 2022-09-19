package model;

public class Dice {

    private int value;
    private int nbFaces;

    public Dice(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    public int getValue() {
        return value;
    }

    public int roll() {
        value = (int) (Math.random() * nbFaces);
        return value;
    }
}

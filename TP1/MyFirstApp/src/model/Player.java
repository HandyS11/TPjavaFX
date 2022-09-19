package model;

public class Player {

    private String name;
    private int nbPoint;

    public Player(String name) {
        this.name = name;
        this.nbPoint = 0;
    }

    public String getName() {
        return name;
    }

    public int getNbPoint() {
        return nbPoint;
    }

    public void incrementScore(int pointsToAdd) {
        nbPoint += pointsToAdd;
    }
}

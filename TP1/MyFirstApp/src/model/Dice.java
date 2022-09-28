package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

public class Dice {

    private int nbFaces;
    private Random random = new Random();

    public Dice(int nbFaces) {
        this.nbFaces = nbFaces;
    }

    private IntegerProperty diceValue = new SimpleIntegerProperty();
        public int getDiceValue() { return diceValue.get(); }
        public IntegerProperty diceValueProperty() { return diceValue; }
        public void setDiceValue(int diceValue) { this.diceValue.set(diceValue); }

    public int roll() {
        int value = random.nextInt(nbFaces)+1;
        setDiceValue(value);
        return getDiceValue();
    }
}

package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
        throwDice(value);
        return getDiceValue();
    }

    public void resetDice() {
        dice0.set(false);
        dice1.set(false);
        dice2.set(false);
        dice3.set(false);
        dice4.set(false);
        dice5.set(false);
        dice6.set(false);
    }

    private void throwDice(int value) {
        resetDice();
        switch (value) {
            case 1 -> {
                dice0.set(true);
            } case 2 -> {
                dice3.set(true);
                dice4.set(true);
            } case 3 -> {
                dice0.set(true);
                dice1.set(true);
                dice6.set(true);
            } case 4 -> {
                dice1.set(true);
                dice3.set(true);
                dice4.set(true);
                dice6.set(true);
            } case 5 -> {
                dice0.set(true);
                dice1.set(true);
                dice3.set(true);
                dice4.set(true);
                dice6.set(true);
            } case 6 -> {
                dice1.set(true);
                dice2.set(true);
                dice3.set(true);
                dice4.set(true);
                dice5.set(true);
                dice6.set(true);
            }
        }
    }

    private BooleanProperty dice0 = new SimpleBooleanProperty();
        public boolean getDice0() { return dice0.get(); }
        public BooleanProperty dice0Property() { return dice0; }
        public void setDice0(boolean gameRunning) { this.dice0.set(gameRunning); }

    private BooleanProperty dice1 = new SimpleBooleanProperty();
        public boolean getDice1() { return dice1.get(); }
        public BooleanProperty dice1Property() { return dice1; }
        public void setDice1(boolean dice1) { this.dice1.set(dice1); }

    private BooleanProperty dice2 = new SimpleBooleanProperty();
        public boolean getDice2() { return dice2.get(); }
        public BooleanProperty dice2Property() { return dice2; }
        public void setDice2(boolean dice2) { this.dice2.set(dice2); }

    private BooleanProperty dice3 = new SimpleBooleanProperty();
        public boolean getDice3() { return dice3.get(); }
        public BooleanProperty dice3Property() { return dice3; }
        public void setDice3(boolean dice3) { this.dice3.set(dice3); }

    private BooleanProperty dice4 = new SimpleBooleanProperty();
        public boolean getDice4() { return dice4.get(); }
        public BooleanProperty dice4Property() { return dice4; }
        public void setDice4(boolean dice4) { this.dice4.set(dice4); }

    private BooleanProperty dice5 = new SimpleBooleanProperty();
        public boolean getDice5() { return dice5.get(); }
        public BooleanProperty dice5Property() { return dice5; }
        public void setDice5(boolean dice5) { this.dice5.set(dice5); }

    private BooleanProperty dice6 = new SimpleBooleanProperty();
        public boolean getDice6() { return dice6.get(); }
        public BooleanProperty dice6Property() { return dice6; }
        public void setDice6(boolean dice6) { this.dice6.set(dice6); }
}

package model;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<Player>();
    private Dice dice;

    public Game(int nbFaces, String playerName1, String playerName2) {
        Player player1 = new Player();
        player1.setPlayerName(playerName1);
        players.add(player1);

        Player player2 = new Player();
        player2.setPlayerName(playerName2);
        players.add(player2);

        dice = new Dice(nbFaces);

        setGameRunning(true);
        setGameWinner("No winner yet!");

        resetDice();
    }

    public List<Player> getPlayers() {
        return players;
    }

    private BooleanProperty gameRunning = new SimpleBooleanProperty();
        public boolean getGameRunning() { return gameRunning.get(); }
        public BooleanProperty gameRunningProperty() { return gameRunning; }
        public void setGameRunning(boolean gameRunning) { this.gameRunning.set(gameRunning); }

    private StringProperty gameWinner = new SimpleStringProperty();
        public String getGameWinner() { return gameWinner.get(); }
        public StringProperty gameWinnerProperty() { return gameWinner; }
        public void setGameWinner(String gameWinner) { this.gameWinner.set(gameWinner); }

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


    public void play(int player) {
        int value = dice.roll();
        throwDice(value);
        Player p = players.get(player - 1);
        if (value == 1) {
            whoWon(player);
        } else {
            p.setPlayerScore(p.getPlayerScore() + value);
        }

    }

    private void whoWon(int player) {
        Player p1 = players.get(0);
        Player p2 = players.get(1);
        String str = new String();
        if (p1.getPlayerScore() == p2.getPlayerScore()) {
            str += (player == 1) ? p2.getPlayerName() : p1.getPlayerName();
        } else {
            str += (p1.getPlayerScore() > p2.getPlayerScore()) ? p1.getPlayerName() : p2.getPlayerName();
        }
        str += " won!";
        setGameWinner(str);
        setGameRunning(false);
    }

    public void playAgain() {
        players.forEach((player -> {
            player.setPlayerScore(0);
        }));
        setGameWinner("No winner yet!");
        setGameRunning(true);

        resetDice();
    }

    private void resetDice() {
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
}

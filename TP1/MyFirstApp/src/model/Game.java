package model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<Player>();

    public Game(int nbFaces, String playerName1, String playerName2) {
        Player player1 = new Player(nbFaces);
        player1.setPlayerName(playerName1);
        players.add(player1);

        Player player2 = new Player(nbFaces);
        player2.setPlayerName(playerName2);
        players.add(player2);

        setGameRunning(true);
        setGameWinner("No winner yet!");
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player returnOtherPlayer(Player p) {
        return (p.equals(players.get(0))) ? players.get(1) : players.get(0);
    }

    ObservableList<Score> scoresObs = FXCollections.observableList(new ArrayList<Score>());
    private ListProperty<Score> scores = new SimpleListProperty<Score>(scoresObs);
        public ObservableList<Score> getScores() { return scores.get(); }
        public ListProperty<Score> scoresProperty() { return scores; }
        public void setScores(ObservableList<Score> scores) { this.scores.set(scores); }

    private BooleanProperty gameRunning = new SimpleBooleanProperty();
        public boolean getGameRunning() { return gameRunning.get(); }
        public BooleanProperty gameRunningProperty() { return gameRunning; }
        public void setGameRunning(boolean gameRunning) { this.gameRunning.set(gameRunning); }

    private StringProperty gameWinner = new SimpleStringProperty();
        public String getGameWinner() { return gameWinner.get(); }
        public StringProperty gameWinnerProperty() { return gameWinner; }
        public void setGameWinner(String gameWinner) { this.gameWinner.set(gameWinner); }


    public void play(Player p) {
        Dice dice = p.getDice();
        int value = dice.roll();
        if (value == 1) {
            whoWon(p);
        } else {
            p.setPlayerScore(p.getPlayerScore() + value);
        }
    }

    private void whoWon(Player p) {
        Player other = returnOtherPlayer(p);
        String str;

        if (p.getPlayerScore() == other.getPlayerScore()) {
            str = "This is a draw!";
            logScore("Draw", p.getPlayerScore(),  p.getPlayerScore());
        } else if (p.getPlayerScore() > other.getPlayerScore()) {
            str = p.getPlayerName() + " won!";
            logScore(p.getPlayerName(), p.getPlayerScore(),  other.getPlayerScore());
        } else {
            str = other.getPlayerName() + " won!";
            logScore(other.getPlayerName(), other.getPlayerScore(),  p.getPlayerScore());
        }
        setGameWinner(str);
        setGameRunning(false);
    }

    public void playAgain() {
        players.forEach((player -> {
            player.setPlayerScore(0);
            player.getDice().resetDice();
        }));
        setGameWinner("No winner yet!");
        setGameRunning(true);
    }

    private void logScore(String winner, int winnerScore, int looserScore) {
        scoresObs.add(new Score(winner, winnerScore, looserScore));
    }

    public void clearScores() {
            scoresObs.clear();
    }

    public void removeScore(Score score) {
            scoresObs.remove(score);
    }
}

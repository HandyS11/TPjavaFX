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


    public void play(int playerThatStoppedTheGame) {
        Player p = players.get(playerThatStoppedTheGame - 1);
        Dice dice = p.getDice();
        int value = dice.roll();
        if (value == 1) {
            whoWon();
        } else {
            p.setPlayerScore(p.getPlayerScore() + value);
        }
    }

    private void whoWon() {
        Player p1 = players.get(0);
        Player p2 = players.get(1);
        String str = new String();

        // J'ai jamais rien écris d'aussi dégeulasse mais idk comment faire ça mieux
        if (p1.getPlayerScore() == p2.getPlayerScore()) {
            str = "This is a draw!";
            logScore("Draw", p1.getPlayerScore(),  p1.getPlayerScore());
        } else if(p1.getPlayerScore() > p2.getPlayerScore()) {
            str = p1.getPlayerName() + " won!";
            logScore(p1.getPlayerName(), p1.getPlayerScore(),  p2.getPlayerScore());
        } else {
            str = p2.getPlayerName() + " won!";
            logScore(p2.getPlayerName(), p2.getPlayerScore(),  p1.getPlayerScore());
        }
        // fin du truc horrible

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

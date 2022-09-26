package view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.shape.Circle;
import model.Game;
import model.Player;
import model.Score;
import view.part.ScoreCell;

public class MainWindow {

    private Game game;

    @FXML
    private Circle dice0, dice1, dice2, dice3, dice4, dice5, dice6;

    @FXML
    private Label playerName1, playerName2, gameStatus, scoreJ1, scoreJ2;

    @FXML
    private Button throwPlayer1, throwPlayer2, playAgainButton;

    @FXML
    private ListView listScore;

    @FXML
    private void player1throw() {
        game.play(1);
    }

    @FXML
    private void player2throw() {
        game.play(2);
    }

    @FXML
    private void playAgain() {
        game.playAgain();
    }

    @FXML
    private void deleteSelected() {
        game.removeScore((Score) listScore.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void deleteAll() {
        game.clearScores();
    }


    public void initialize() {
        game = new Game(6, "Jean", "Kevin");

        Player player1 = game.getPlayers().get(0);
        Player player2 = game.getPlayers().get(1);

        playerName1.textProperty().bind(player1.playerNameProperty());
        playerName2.textProperty().bind(player2.playerNameProperty());

        scoreJ1.textProperty().bind(player1.playerScoreProperty().asString());
        scoreJ2.textProperty().bind(player2.playerScoreProperty().asString());

        gameStatus.textProperty().bind(game.gameWinnerProperty());
        playAgainButton.disableProperty().bind(game.gameRunningProperty());

        throwPlayer1.disableProperty().bind(game.gameRunningProperty().not());
        throwPlayer2.disableProperty().bind(game.gameRunningProperty().not());

        listScore.itemsProperty().bind(game.scoresProperty());
        listScore.setCellFactory(__ -> new ScoreCell());

        dice0.visibleProperty().bind(game.getPlayers().get(0).getDice().dice0Property());
        dice1.visibleProperty().bind(game.getPlayers().get(0).getDice().dice1Property());
        dice2.visibleProperty().bind(game.getPlayers().get(0).getDice().dice2Property());
        dice3.visibleProperty().bind(game.getPlayers().get(0).getDice().dice3Property());
        dice4.visibleProperty().bind(game.getPlayers().get(0).getDice().dice4Property());
        dice5.visibleProperty().bind(game.getPlayers().get(0).getDice().dice5Property());
        dice6.visibleProperty().bind(game.getPlayers().get(0).getDice().dice6Property());
    }
}

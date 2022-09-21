package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import model.Game;
import model.Player;

public class MainWindow {

    private Game game;

    @FXML
    private Circle dice0, dice1, dice2, dice3, dice4, dice5, dice6;

    @FXML
    private Label playerName1;

    @FXML
    private Label playerName2;

    @FXML
    private Label gameStatus;

    @FXML
    private Label scoreJ1;

    @FXML
    private Label scoreJ2;

    @FXML
    private Button throwPlayer1;

    @FXML
    private Button throwPlayer2;

    @FXML
    private Button playAgainButton;

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

        dice0.visibleProperty().bind(game.dice0Property());
        dice1.visibleProperty().bind(game.dice1Property());
        dice2.visibleProperty().bind(game.dice2Property());
        dice3.visibleProperty().bind(game.dice3Property());
        dice4.visibleProperty().bind(game.dice4Property());
        dice5.visibleProperty().bind(game.dice5Property());
        dice6.visibleProperty().bind(game.dice6Property());
    }
}

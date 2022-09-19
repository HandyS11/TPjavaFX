package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

import static launch.Launcher.game;

public class MainWindow {

    @FXML
    private Label playerName1;

    @FXML
    private Label playerName2;

    @FXML
    private Label scoreJ1;

    @FXML
    private Label scoreJ2;

    @FXML
    private void player1throw() {
        int value = game.play(1);
        scoreJ1.setText(String.valueOf(value));
    }

    @FXML
    private void player2throw() {
        int value = game.play(2);
        scoreJ2.setText(String.valueOf(value));
    }

    @FXML
    private void playAgain() {
        List<String> names = game.getPlayersNames();
        playerName1.setText(names.get(0));
        playerName2.setText(names.get(1));
        scoreJ1.setText("0");
        scoreJ2.setText("0");
    }

    public void initialize() {
        playAgain();
    }
}

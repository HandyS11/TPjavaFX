package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import model.Game;
import model.Player;
import model.Score;
import view.part.ScoreCell;
import view.uc.PlayerGui;

public class MainWindow {

    @FXML
    private Label gameStatus;

    @FXML
    private Button playAgainButton;

    @FXML
    private ListView<Score> listScore;

    @FXML
    private HBox hBox;

    @FXML
    private void playAgain() {
        game.playAgain();
    }

    @FXML
    private void deleteSelected() {
        game.removeScore(listScore.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void deleteAll() {
        game.clearScores();
    }

    public static Game game;


    public void initialize() {
        game = new Game(6, "Jean", "Kevin");

        Player player1 = game.getPlayers().get(0);
        Player player2 = game.getPlayers().get(1);

        PlayerGui playerGui1 = new PlayerGui(player1);
        PlayerGui playerGui2 = new PlayerGui(player2);

        hBox.getChildren().add(0, playerGui1);
        hBox.getChildren().add(2, playerGui2);

        gameStatus.textProperty().bind(game.gameWinnerProperty());
        playAgainButton.disableProperty().bind(game.gameRunningProperty());

        listScore.itemsProperty().bind(game.scoresProperty());
        listScore.setCellFactory(__ -> new ScoreCell());
    }
}

package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Game;
import model.Player;
import model.Score;
import view.part.CellScore;
import view.uc.GuiPlayer;

public class MainWindow {

    @FXML
    private Label gameStatus;

    @FXML
    private Button playAgainButton;

    @FXML
    private ListView<Score> listScore;

    @FXML
    private TextField playerOneEntry, playerTwoEntry;

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

        GuiPlayer guiPlayer1 = new GuiPlayer(player1);
        GuiPlayer guiPlayer2 = new GuiPlayer(player2);

        hBox.getChildren().add(0, guiPlayer1);
        hBox.getChildren().add(2, guiPlayer2);

        gameStatus.textProperty().bind(game.gameWinnerProperty());
        playAgainButton.disableProperty().bind(game.gameRunningProperty());

        playerOneEntry.textProperty().bindBidirectional(game.getPlayers().get(0).playerNameProperty());
        playerTwoEntry.textProperty().bindBidirectional(game.getPlayers().get(1).playerNameProperty());

        listScore.itemsProperty().bind(game.scoresProperty());
        listScore.setCellFactory(__ -> new CellScore());
    }
}

package view.uc;

import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Player;
import view.MainWindow;

import java.io.IOException;


public class GuiPlayer extends VBox {

    @FXML
    private Circle dice0, dice1, dice2, dice3, dice4, dice5, dice6;

    @FXML
    private Rectangle squareDice;

    @FXML
    private Button throwPlayer;

    @FXML
    private Label playerName, playerScore;

    @FXML
    private void playerThrow() {
        MainWindow.game.play(player);
    }

    private Player player;

    public GuiPlayer(Player player) {
        this.player = player;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UC/PlayerGui.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        playerName.textProperty().bind(player.playerNameProperty());
        playerScore.textProperty().bind(player.playerScoreProperty().asString());

        throwPlayer.disableProperty().bind(MainWindow.game.gameRunningProperty().not());

        squareDice.visibleProperty().bind(player.getDice().diceValueProperty().isNotEqualTo(0));

        Circle[] dices = { dice0, dice1, dice2, dice3, dice4, dice5, dice6 };

        IntegerProperty p = player.getDice().diceValueProperty();
        dices[0].visibleProperty().bind(p.isEqualTo(1).or(p.isEqualTo(3)).or(p.isEqualTo(5)));
        dices[1].visibleProperty().bind(p.greaterThanOrEqualTo(3));
        dices[2].visibleProperty().bind(p.isEqualTo(6));
        dices[3].visibleProperty().bind(p.greaterThanOrEqualTo(4).or(p.isEqualTo(2)));
        dices[4].visibleProperty().bind(p.isEqualTo(2).or(p.greaterThanOrEqualTo(4)));
        dices[5].visibleProperty().bind(p.isEqualTo(6));
        dices[6].visibleProperty().bind(p.greaterThanOrEqualTo(3));
    }
}

package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {

    private StringProperty playerName = new SimpleStringProperty();
        public String getPlayerName() { return playerName.get(); }
        public StringProperty playerNameProperty() { return playerName; }
        public void setPlayerName(String playerName) { this.playerName.set(playerName); }

    private IntegerProperty playerScore = new SimpleIntegerProperty();
        public int getPlayerScore() { return playerScore.get(); }
        public IntegerProperty playerScoreProperty() { return playerScore; }
        public void setPlayerScore(int playerScore) { this.playerScore.set(playerScore); }
}

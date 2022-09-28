package view.part;

import javafx.scene.control.ListCell;
import model.Score;

public class CellScore extends ListCell<Score> {

    @Override
    protected void updateItem(Score item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            this.setText(String.format("%s: %s (%d) - %s (%d)", item.getDate(), item.getWinner(), item.getScoreWinner(), item.getLooser(), item.getScoreLooser()));
        } else {
            this.setText("");
        }
    }
}

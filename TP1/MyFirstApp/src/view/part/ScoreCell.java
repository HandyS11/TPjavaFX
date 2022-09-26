package view.part;

import javafx.scene.control.ListCell;
import model.Score;

public class ScoreCell extends ListCell<Score> {

    @Override
    protected void updateItem(Score item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            this.setText(item.toString());
        } else {
            this.setText("");
        }
    }
}

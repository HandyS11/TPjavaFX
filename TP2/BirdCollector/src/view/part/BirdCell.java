package view.part;

import javafx.scene.control.ListCell;
import model.Bird;

public class BirdCell extends ListCell<Bird> {

    @Override
    protected void updateItem(Bird item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            this.textProperty().bind(item.nameProperty());
        } else {
            this.textProperty().unbind();
            this.setText("");
        }
    }
}

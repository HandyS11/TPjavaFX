package view.part;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import model.Bird;

public class BirdCell extends ListCell<Bird> {

    @Override
    protected void updateItem(Bird item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            this.textProperty().bind(item.nameProperty());
            this.textFillProperty().bind(Bindings.when(item.needEatProperty()).then(Color.RED).otherwise(Color.BLACK));

        } else {
            this.textProperty().unbind();
            this.setText("");
        }
    }
}

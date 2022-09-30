package view.part;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import model.Bird;


public class BirdCell extends ListCell<Bird> {

    @Override
    protected void updateItem(Bird item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            this.textProperty().bind(item.nameProperty());
            if (item.getTimeSinceLastMeal() >= item.getHungerStrenght()) {
                this.textFillProperty().set(Color.RED);
            } else {
                this.textFillProperty().set(Color.BLACK);
            }
        } else {
            this.textProperty().unbind();
            this.setText("");
        }
    }
}

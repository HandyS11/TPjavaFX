package view.cell;

import javafx.scene.control.ListCell;
import javafx.scene.shape.Rectangle;
import viewmodel.ColorVM;

public class ColorCell extends ListCell<ColorVM> {

    @Override
    protected void updateItem(ColorVM item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            Rectangle rectangle = new Rectangle();
            rectangle.fillProperty().bind(item.colorProperty());
            rectangle.setHeight(50);
            rectangle.setWidth(150);
            setGraphic(rectangle);
        } else {
            setGraphic(null);
        }
    }
}

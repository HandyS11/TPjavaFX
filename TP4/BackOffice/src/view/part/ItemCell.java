package view.part;

import javafx.scene.control.ListCell;
import viewmodel.ItemVM;

public class ItemCell extends ListCell<ItemVM> {

    @Override
    protected void updateItem(ItemVM item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            this.textProperty().bind(item.nameProperty());

        } else {
            this.textProperty().unbind();
            this.setText("");
        }
    }
}

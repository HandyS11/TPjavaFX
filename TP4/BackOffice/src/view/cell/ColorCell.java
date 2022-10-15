package view.cell;

import javafx.scene.control.ListCell;
import view.uc.ColorUC;
import viewmodel.ColorVM;

import java.io.IOException;

public class ColorCell extends ListCell<ColorVM> {

    @Override
    protected void updateItem(ColorVM item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            try {
                ColorUC colorUC = new ColorUC(item);
                setGraphic(colorUC);
            } catch (IOException e) {
                System.err.println(e);
                textProperty().set("Error while loading ColorUC");
            }
        } else {
            setText("");
        }
    }
}

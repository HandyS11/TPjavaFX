package view;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import utils.Sizes;
import viewmodel.ColorVM;

public class ClothesUC extends VBox {

    @FXML
    private ListView<ColorVM> colorsListView;

    @FXML
    private ListView<Sizes> sizesListView;

    @FXML
    private void addColor() {
    }

    @FXML
    private void removeColor() {
    }

    @FXML
    private void addSize() {
    }

    @FXML
    private void removeSize() {
    }


    private void initialize() {

    }
}

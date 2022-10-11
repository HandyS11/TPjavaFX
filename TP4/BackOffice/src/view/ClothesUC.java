package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import utils.Sizes;
import viewmodel.ColorVM;

import java.io.IOException;

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

    @FXML
    private VBox clothesUC;

    private VBox itemUC;

    public ClothesUC() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/UC/ClothesUC.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public void initialize() {
        try {
            itemUC = new ItemUC();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clothesUC.getChildren().add(0, itemUC);
    }
}

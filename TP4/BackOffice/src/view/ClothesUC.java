package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import utils.Sizes;
import viewmodel.ClothesVM;
import viewmodel.ColorVM;

import java.io.IOException;

public class ClothesUC extends VBox {

    @FXML
    private ListView<ColorVM> colorsListView;

    @FXML
    private ListView<Sizes> sizesListView;

    private ClothesVM viewModel;

    @FXML
    private VBox clothesUC;

    private VBox itemUC;

    @FXML
    private Button addSizeButton;

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

    public ClothesUC() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/UC/ClothesUC.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public void initialize() {
        //addSizeButton.disableProperty().bindBidirectional();
    }

    public void setViewModel(ClothesVM clothesVM) {
        viewModel = clothesVM;

        colorsListView.itemsProperty().bind(viewModel.colorsProperty());
        //colorsListView.setCellFactory(__ -> new ColorCell());

        sizesListView.itemsProperty().bind(viewModel.sizesProperty());
        //sizesListView.setCellFactory(__ -> new SizesCell());
    }
}

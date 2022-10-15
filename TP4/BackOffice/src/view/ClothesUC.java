package view;

import javafx.css.Size;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import utils.Sizes;
import viewmodel.ClothesVM;
import viewmodel.ColorVM;

import java.io.IOException;

public class ClothesUC extends VBox {

    @FXML
    private ListView<ColorVM> colorsListView;

    @FXML
    private ListView<Sizes> sizesListView;

    @FXML
    private ComboBox sizeSelector;

    @FXML
    private ColorPicker colorPicker;

    private ClothesVM viewModel;

    @FXML
    private VBox clothesUC;

    @FXML
    private Button addColorButton, removeColorButton, addSizeButton, removeSizeButton;

    @FXML
    private void addColor() {
        Color c = colorPicker.getValue();
        viewModel.addColor(c);
    }

    @FXML
    private void removeColor() {
        viewModel.removeColor(colorsListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void addSize() {
        viewModel.addSize(sizeSelector.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void removeSize() {
        viewModel.removeSize(sizesListView.getSelectionModel().getSelectedItem());
    }

    public ClothesUC() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/UC/ClothesUC.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public void initialize() {
        setupSizeSelector();

        addSizeButton.disableProperty().bind(sizeSelector.getSelectionModel().selectedItemProperty().isEqualTo(-1));

        removeColorButton.disableProperty().bind(colorsListView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
        removeSizeButton.disableProperty().bind(sizesListView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
    }

    public void setViewModel(ClothesVM clothesVM) {
        viewModel = clothesVM;

        colorsListView.itemsProperty().bind(viewModel.colorsProperty());
        //colorsListView.setCellFactory(__ -> new ColorCell());

        sizesListView.itemsProperty().bind(viewModel.sizesProperty());
    }

    private void setupSizeSelector() {
        sizeSelector.getItems().addAll(Sizes.values());
        sizeSelector.getSelectionModel().select(0);
    }
}

package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import view.part.ItemCell;
import viewmodel.ClothesVM;
import viewmodel.ItemVM;
import viewmodel.PerfumeVM;
import viewmodel.ProductsVM;

import java.io.IOException;

public class MainWindow {

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private VBox details;

    @FXML
    private TextField itemName, itemPrice;

    @FXML
    private ListView<ItemVM> itemsListView;

    @FXML
    private void addPerfume() {
        viewModel.addPerfume();
    }

    @FXML
    private void addClothes() {
        viewModel.addClothes();
    }

    @FXML
    private void deleteSelected() {
        viewModel.deleteItem(itemsListView.getSelectionModel().getSelectedItem());
        itemsListView.getSelectionModel().select(0);
    }

    private VBox perfumeUC, clothesUC;

    private ProductsVM viewModel;

    public void initialize() {
        viewModel = new ProductsVM();

        setupChoiceBox();
        instantiateUC();
        bindListViewAndMore();
    }

    private void instantiateUC() {
        try {
            perfumeUC = new PerfumeUC();
            clothesUC = new ClothesUC();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        details.getChildren().add(clothesUC);
    }

    private void bindListViewAndMore() {
        itemsListView.itemsProperty().bind(viewModel.itemsProperty());
        itemsListView.setCellFactory(__ -> new ItemCell());
        itemsListView.getSelectionModel().selectedItemProperty().addListener((__, oldV, newV) -> {
            if (newV instanceof ClothesVM) {
                setDetail(clothesUC);
            } else if (newV instanceof PerfumeVM) {
                setDetail(perfumeUC);
                ((PerfumeUC) perfumeUC).setViewModel((PerfumeVM) newV);
            }
            if (oldV != null) {
                itemName.textProperty().unbindBidirectional(oldV.nameProperty());
                itemPrice.textProperty().unbindBidirectional(oldV.priceProperty());
            }
            if (newV != null) {
                itemName.textProperty().bindBidirectional(newV.nameProperty());
                itemPrice.textProperty().bindBidirectional(newV.priceProperty(), new NumberStringConverter());
            }
        });
        itemsListView.getSelectionModel().select(0);
    }

    private void setupChoiceBox() {
        choiceBox.getItems().addAll("ALL", "Perfume", "Clothes");
        choiceBox.getSelectionModel().select(0);
    }

    private void setDetail(VBox child) {
     details.getChildren().removeAll(perfumeUC, clothesUC);
     details.getChildren().add(child);
    }
}

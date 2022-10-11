package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    private Pane details;

    @FXML
    private ListView<ItemVM> itemsListView;

    @FXML
    private void addPerfume() {
    }

    @FXML
    private void addClothes() {
    }

    @FXML
    private void deleteSelected() {
        products.deleteItem(itemsListView.getSelectionModel().getSelectedItem());
    }

    private VBox perfumeUC;
    private VBox clothesUC;

    private ProductsVM products;

    public void initialize() {
        products = new ProductsVM();

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
        itemsListView.itemsProperty().bind(products.itemsProperty());
        itemsListView.setCellFactory(__ -> new ItemCell());
        itemsListView.getSelectionModel().selectedItemProperty().addListener((__, oldV, newV) -> {
            if (newV instanceof ClothesVM) {
                setDetail(clothesUC);
            } else if (newV instanceof PerfumeVM) {
                setDetail(perfumeUC);
            }
        });
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

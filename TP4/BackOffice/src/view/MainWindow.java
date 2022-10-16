package view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import view.cell.ItemCell;
import view.uc.ClothesUC;
import view.uc.PerfumeUC;
import viewmodel.ClothesVM;
import viewmodel.ItemVM;
import viewmodel.PerfumeVM;
import viewmodel.ProductsVM;

import java.io.IOException;

public class MainWindow {

    @FXML
    private ComboBox itemFilter;

    @FXML
    private VBox details;

    private VBox perfumeUC, clothesUC;

    @FXML
    private TextField itemName, itemPrice;

    @FXML
    private ListView<ItemVM> itemsListView;

    ProductsVM viewModel;

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

    public MainWindow(ProductsVM productsVM) {
        viewModel = productsVM;
    }

    public void initialize() {
        setupComboBox();
        instantiateUC();
        bindListViewAndMore();
        bindItemList();
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
                ((ClothesUC) clothesUC).setViewModel((ClothesVM) newV);
            } else if (newV instanceof PerfumeVM) {
                setDetail(perfumeUC);
                ((PerfumeUC) perfumeUC).setViewModel((PerfumeVM) newV);
            }
            actions(newV, oldV);
        });
        itemsListView.getSelectionModel().select(0);
    }

    private void actions(ItemVM newV, ItemVM oldV) {
        if (oldV != null) {
            itemName.textProperty().unbindBidirectional(oldV.nameProperty());
            itemPrice.textProperty().unbindBidirectional(oldV.priceProperty());
        }
        if (newV != null) {
            itemName.textProperty().bindBidirectional(newV.nameProperty());
            itemPrice.textProperty().bindBidirectional(newV.priceProperty(), new NumberStringConverter());
        }
    }

    private void bindItemList() {
        itemFilter.getSelectionModel().selectedItemProperty().addListener((__, ___, newValue) -> {
            if (newValue == "CLOTHES") {
                viewModel.sortItemList("CLOTHES");
            } else if (newValue == "PERFUME") {
                viewModel.sortItemList("PERFUME");
            } else {
                viewModel.sortItemList(null);
            }
        });
    }

    private void setupComboBox() {
        itemFilter.getItems().addAll("ALL", "CLOTHES", "PERFUME");
        itemFilter.getSelectionModel().select(0);
    }

    private void setDetail(VBox child) {
     details.getChildren().removeAll(perfumeUC, clothesUC);
     details.getChildren().add(child);
    }
}

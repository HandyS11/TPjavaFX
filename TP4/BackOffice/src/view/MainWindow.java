package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import viewmodel.ProductsVM;

import java.io.IOException;

public class MainWindow {

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private Pane details;

    @FXML
    private ListView<ProductsVM> itemsListView;

    @FXML
    private void addPerfume() {
    }

    @FXML
    private void addClothes() {
    }

    @FXML
    private void deleteSelected() {
    }

    private VBox perfumeUC;
    private VBox clothesUC;

    public void initialize() {
        choiceBox.getItems().addAll("ALL", "Perfume", "Clothes");
        choiceBox.getSelectionModel().select(0);

        try {
            perfumeUC = new PerfumeUC();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        details.getChildren().add(perfumeUC);
    }
}

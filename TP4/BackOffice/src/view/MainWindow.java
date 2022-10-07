package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import viewmodel.ItemVM;

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
    }

    public void initialize() {
        //choiceBox.getItems().addAll("item1", "item2", "item3");
    }
}

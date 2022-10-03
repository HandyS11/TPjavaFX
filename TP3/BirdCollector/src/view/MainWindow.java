package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.NumberStringConverter;
import view.part.BirdCell;
import viewmodel.BirdVM;
import viewmodel.CollectionVM;

public class MainWindow {

    @FXML
    private Label dateLabel, lastMealLabel, timeSinceLastMealLabel;

    @FXML
    private Button deleteSelectedButton, feedTheBirdButton;

    @FXML
    private TextField birdName, hungerStrength;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private ListView<BirdVM> birdListView;

    @FXML
    private void addBird() {

    }

    @FXML
    private void  deleteBird() {

    }

    @FXML
    private void feedBird() {

    }

    @FXML void nextDay() {

    }

    private int getIndex() {
        return 0;
    }


    public void initialize() {
        CollectionVM collectionVM = new CollectionVM();

        dateLabel.textProperty().bind(collectionVM.dateProperty().asString());

        birdListView.itemsProperty().bind(collectionVM.birdsProperty());
        birdListView.setCellFactory(__ -> new BirdCell());

        deleteSelectedButton.disableProperty().bind(birdListView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
        feedTheBirdButton.disableProperty().bind(birdListView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));

        addListener();
    }

    private void addListener() {
        birdListView.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if (oldValue != null) {
                birdName.textProperty().unbindBidirectional(oldValue.nameProperty());
                hungerStrength.textProperty().unbindBidirectional(oldValue.hungerStrengthProperty());
            }
            if (newValue != null) {
                bind(newValue);
            }
        });
    }

    private void bind(BirdVM newValue) {
        birdName.textProperty().bindBidirectional(newValue.nameProperty());
        hungerStrength.textProperty().bindBidirectional(newValue.hungerStrengthProperty(), new NumberStringConverter());
        lastMealLabel.textProperty().bind(newValue.dateProperty().asString());
    }
}

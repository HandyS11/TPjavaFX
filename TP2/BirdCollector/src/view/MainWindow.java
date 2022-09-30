package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Bird;
import model.Manager;
import view.part.BirdCell;

public class MainWindow {

    @FXML
    private Label dateLabel, birdTimeSinceLastMealLabel;

    @FXML
    private Button deleteSelectedButton;

    @FXML
    private TextField birdName, birdWingsColor;

    @FXML
    private ListView<Bird> birdListView;

    @FXML
    private void addBird() { manager.addBirdToCollection(); }

    @FXML
    private void  deleteBird() {
        int index = birdListView.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            manager.deleteBirdFromCollection(index);
        }
    }

    @FXML
    private void feedBird() {
        int index = birdListView.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            manager.feedTheBird(index);
        }
    }

    @FXML void nextDay() { manager.addDay(); }

    private Manager manager;

    public void initialize() {
        manager = new Manager();
        manager.loadData();

        dateLabel.textProperty().bind(manager.dateProperty().asString());

        birdListView.itemsProperty().bind(manager.birdsProperty());
        birdListView.setCellFactory(__ -> new BirdCell());

        deleteSelectedButton.disableProperty().bind(birdListView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));

        addListener();
    }

    private void addListener() {
        birdListView.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if (oldValue != null) {
                birdName.textProperty().unbindBidirectional(oldValue.nameProperty());
                birdWingsColor.textProperty().unbindBidirectional(oldValue.wingsColorProperty());
            }
            if (newValue != null) {
                birdName.textProperty().bindBidirectional(newValue.nameProperty());
                birdWingsColor.textProperty().bindBidirectional(newValue.wingsColorProperty());
                birdTimeSinceLastMealLabel.textProperty().bind(newValue.dateProperty().asString());
            }
        });
    }
}

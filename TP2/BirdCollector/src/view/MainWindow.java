package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Bird;
import model.Manager;
import view.part.BirdCell;

public class MainWindow {

    @FXML
    private Label dateLabel, birdNameLabel, birdWingsColorLabel, birdTimeSinceLastMealLabel;

    @FXML
    private ListView<Bird> birdListView;

    @FXML
    private void addBird() { manager.addBirdToCollection(); }

    @FXML
    private void feedBird() {}

    @FXML void nextDay() {}

    private Manager manager;

    public void initialize() {
        manager = new Manager();
        manager.loadData();

        dateLabel.textProperty().bind(manager.dateProperty().asString());

        birdListView.itemsProperty().bind(manager.birdsProperty());
        birdListView.setCellFactory(__ -> new BirdCell());

        birdListView.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if (newValue != null) {
                birdNameLabel.textProperty().bind(newValue.nameProperty());
                birdWingsColorLabel.textProperty().bind(newValue.wingsColorProperty());
                birdTimeSinceLastMealLabel.textProperty().bind(newValue.dateProperty().asString());
            }
        });
    }
}

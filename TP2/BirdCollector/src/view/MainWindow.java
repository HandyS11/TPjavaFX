package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import model.Bird;
import model.Manager;
import view.part.BirdCell;

public class MainWindow {

    @FXML
    private Label dateLabel, lastMealLabel, timeSinceLastMealLabel;

    @FXML
    private Button deleteSelectedButton, feedTheBirdButton;

    @FXML
    private TextField birdName, birdWingsColor, hungerStrength;

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
        if (getIndex() != -1) {
            manager.feedTheBird(getIndex());
            manager.getBirds().get(getIndex()).setTimeSinceLastMeal(manager.getDate());
        }
    }

    @FXML void nextDay() {
        manager.addDay();
        manager.getBirds().forEach((bird -> {
            bird.setTimeSinceLastMeal(manager.getDate());
        }));
    }

    private int getIndex() {
        return birdListView.getSelectionModel().getSelectedIndex();
    }

    private Manager manager;

    public void initialize() {
        manager = new Manager();
        manager.loadData();

        dateLabel.textProperty().bind(manager.dateProperty().asString());

        birdListView.itemsProperty().bind(manager.birdsProperty());
        birdListView.setCellFactory(__ -> new BirdCell());

        deleteSelectedButton.disableProperty().bind(birdListView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
        feedTheBirdButton.disableProperty().bind(birdListView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));

        addListener();
    }

    private void addListener() {
        birdListView.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if (oldValue != null) {
                birdName.textProperty().unbindBidirectional(oldValue.nameProperty());
                birdWingsColor.textProperty().unbindBidirectional(oldValue.wingsColorProperty());
                hungerStrength.textProperty().unbindBidirectional(oldValue.hungerStrenghtProperty());
            }
            if (newValue != null) {
                bind(newValue);
            }
        });
    }

    private void bind(Bird newValue) {
        birdName.textProperty().bindBidirectional(newValue.nameProperty());
        birdWingsColor.textProperty().bindBidirectional(newValue.wingsColorProperty());
        hungerStrength.textProperty().bindBidirectional(newValue.hungerStrenghtProperty(), new NumberStringConverter());
        lastMealLabel.textProperty().bind(newValue.dateProperty().asString());
        timeSinceLastMealLabel.textProperty().bind(newValue.timeSinceLastMealProperty().asString());
    }
}

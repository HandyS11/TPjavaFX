package model;

import data.IDataLoader;
import data.Stub;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Manager {

    IDataLoader dataLoader = new Stub();

    ObservableList<Bird> birdsObs = FXCollections.observableList(new ArrayList<Bird>());
    private ListProperty<Bird> birds = new SimpleListProperty<Bird>(birdsObs);
        public ObservableList<Bird> getBirds() { return birds.get(); }
        public ListProperty<Bird> birdsProperty() { return birds; }
        public void setBirds(ObservableList<Bird> birds) { this.birds.set(birds); }


    LocalDate localDate = LocalDate.now();
    private ObjectProperty<LocalDate> date = new SimpleObjectProperty<LocalDate>(localDate);
        public LocalDate getDate() { return date.get(); }
        public ObjectProperty<LocalDate> dateProperty() { return date; }
        public void setDate(LocalDate date) { this.date.set(date); }


    public void loadData() {
            birdsObs.addAll(dataLoader.load());
    }

    public void addBirdToCollection() {
            birdsObs.add(new Bird("Bird", "N/A"));
    }
}

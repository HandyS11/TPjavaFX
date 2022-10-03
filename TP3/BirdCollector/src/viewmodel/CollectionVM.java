package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class CollectionVM {

    ObservableList<BirdVM> birdsObs = FXCollections.observableList(new ArrayList<BirdVM>());
    private ListProperty<BirdVM> birds = new SimpleListProperty<BirdVM>(birdsObs);
    public ObservableList<BirdVM> getBirds() { return birds.get(); }
    public ListProperty<BirdVM> birdsProperty() { return birds; }
    public void setBirds(ObservableList<BirdVM> birds) { this.birds.set(birds); }

    LocalDate localDate = LocalDate.now();
    private ObjectProperty<LocalDate> date = new SimpleObjectProperty<LocalDate>(localDate);
    public LocalDate getDate() { return date.get(); }
    public ObjectProperty<LocalDate> dateProperty() { return date; }
    public void setDate(LocalDate date) { this.date.set(date); }


    public void addBirdToCollection() {
        birdsObs.add(new BirdVM("New Bird", 5));
    }

    public void deleteBirdFromCollection(int index) { birdsObs.remove(index); }

    public void addDay() { setDate(getDate().plusDays(1)); }

    public void feedTheBird(int index) { birdsObs.get(index).setDate(getDate()); }
}

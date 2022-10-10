package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Perfume;

import java.util.ArrayList;

public class PerfumeVM extends ItemVM {

    private Perfume model;

    ObservableList<String> fragrancesObs = FXCollections.observableList(new ArrayList<String>());
    private ListProperty<String> fragrances = new SimpleListProperty<>(fragrancesObs);
        public ObservableList<String> getFragrances() { return fragrances.get(); }
        public ListProperty<String> fragrancesProperty() { return fragrances; }
        public void setFragrances(ObservableList<String> fragrances) { this.fragrances.set(fragrances); }


    public PerfumeVM(Perfume perfume) {
        super(perfume.getName(), perfume.getPrice());
        perfume.getFlagrance().forEach((flagrance -> fragrances.add(flagrance)));
    }
}

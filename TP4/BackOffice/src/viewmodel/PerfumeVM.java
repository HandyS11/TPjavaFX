package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Perfume;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class PerfumeVM extends ItemVM implements PropertyChangeListener {

    private Perfume model;

    ObservableList<String> fragrancesObs = FXCollections.observableList(new ArrayList<String>());
    private ListProperty<String> fragrances = new SimpleListProperty<>(fragrancesObs);
        public ObservableList<String> getFragrances() { return fragrances.get(); }
        public ListProperty<String> fragrancesProperty() { return fragrances; }
        public void setFragrances(ObservableList<String> fragrances) { this.fragrances.set(fragrances); }


    public PerfumeVM(Perfume perfume) {
        super(perfume.getName(), perfume.getPrice());
        perfume.getFlagrance().forEach((flagrance -> fragrances.add(flagrance)));
        model = perfume;
        model.addListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;
        if (e.getPropagationId() == Perfume.flagranceID) {
            fragrances.set(e.getIndex(), ((String) e.getNewValue()));
        }
    }
}

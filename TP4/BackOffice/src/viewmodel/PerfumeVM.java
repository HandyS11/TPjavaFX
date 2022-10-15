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

    private final Perfume model;

    ObservableList<String> fragrancesObs = FXCollections.observableList(new ArrayList<>());
    private final ListProperty<String> fragrances = new SimpleListProperty<>(fragrancesObs);
        public ObservableList<String> getFragrances() { return fragrances.get(); }
        public ListProperty<String> fragrancesProperty() { return fragrances; }
        public void setFragrances(ObservableList<String> fragrances) { this.fragrances.set(fragrances); }


    public PerfumeVM(Perfume perfume) {
        super(perfume);
        fragrances.addAll(perfume.getFlagrance());
        model = perfume;
        model.addListener(this);
    }

    public void addFragrance(String str) {
        model.addFlagrance(str, 0);
    }

    public void removeFragrance(String str) {
        model.removeFlagrance(str);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);
        IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;
        if (e.getPropertyName().equals(String.valueOf(Perfume.PROP_FLAGRANCE_ADD))) {
            fragrances.add(e.getIndex(), ((String) e.getNewValue()));
        } else if (e.getPropertyName().equals(String.valueOf(Perfume.PROP_FLAGRANCE_REMOVE))) {
            fragrances.remove(e.getIndex());
        }
    }
}

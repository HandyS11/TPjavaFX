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

    private final ObservableList<String> fragrancesObs = FXCollections.observableList(new ArrayList<>());
    private final ListProperty<String> fragrances = new SimpleListProperty<>(fragrancesObs);
        public ObservableList<String> getFragrances() { return fragrances.get(); }
        public ListProperty<String> fragrancesProperty() { return fragrances; }
        public void setFragrances(ObservableList<String> fragrances) { this.fragrances.set(fragrances); }


    public PerfumeVM(Perfume perfume) {
        super(perfume);
        fragrancesObs.addAll(perfume.getFlagrance());
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
        IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;
        var newV = e.getNewValue();
        var oldV = e.getOldValue();
        var prop = e.getPropertyName();
        var index = e.getIndex();

        if (newV != null) {
            if (prop.equals(String.valueOf(Perfume.PROP_FLAGRANCE_ADD))) {
                fragrancesObs.add(index, ((String) e.getNewValue()));
            }
        }
        if (oldV != null) {
            if (prop.equals(String.valueOf(Perfume.PROP_FLAGRANCE_REMOVE))) {
                fragrancesObs.remove(index);
            }
        }
    }
}

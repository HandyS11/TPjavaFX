package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Perfume extends Item {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static final UUID PROP_FLAGRANCE_ADD = UUID.randomUUID();
    public static final UUID PROP_FLAGRANCE_REMOVE = UUID.randomUUID();

    private List<String> flagrance;

    public Perfume(String name, int price, List<String> flagrance) {
        super(name, price);
        this.flagrance = flagrance;
    }

    public List<String> getFlagrance() {
        return Collections.unmodifiableList(flagrance);
    }

    public void addFlagrance(String str, int index) {
        String s = flagrance.get(index);
        flagrance.add(str);
        support.fireIndexedPropertyChange(String.valueOf(PROP_FLAGRANCE_ADD), index, s, str);
    }

    public void removeFlagrance(int index) {
        String s = flagrance.get(index);
        flagrance.remove(index);
        support.fireIndexedPropertyChange(String.valueOf(PROP_FLAGRANCE_REMOVE), index, s, null);
    }

    public void addListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }
}

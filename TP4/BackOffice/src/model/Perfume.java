package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Perfume extends Item implements Serializable {

    private transient PropertyChangeSupport support = null;
    public static final UUID PROP_FLAGRANCE_ADD = UUID.randomUUID();
    public static final UUID PROP_FLAGRANCE_REMOVE = UUID.randomUUID();

    private final List<String> flagrance;

    public Perfume(String name, int price, List<String> flagrance) {
        super(name, price);
        this.flagrance = flagrance;
    }

    public List<String> getFlagrance() {
        return Collections.unmodifiableList(flagrance);
    }

    public void addFlagrance(String str, int index) {
        String s = null;
        if (flagrance.size() > 0) {
            s = flagrance.get(index);
            flagrance.add(index, str);
        } else {
            flagrance.add(str);
        }
        getSupport().fireIndexedPropertyChange(String.valueOf(PROP_FLAGRANCE_ADD), index, s, str);
    }

    public void removeFlagrance(String str) {
        int index = flagrance.indexOf(str);
        flagrance.remove(str);
        getSupport().fireIndexedPropertyChange(String.valueOf(PROP_FLAGRANCE_REMOVE), index, str, null);
    }

    public void addListener(PropertyChangeListener propertyChangeListener) {
        getSupport().addPropertyChangeListener(propertyChangeListener);
    }

    private PropertyChangeSupport getSupport() {
        if (support == null) {
            support = new PropertyChangeSupport(this);
        }
        return support;
    }
}

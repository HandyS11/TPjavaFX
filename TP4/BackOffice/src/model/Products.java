package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Products implements Serializable {

    private transient PropertyChangeSupport support = null;
    public static final UUID PROP_ITEMS_ADD = UUID.randomUUID();
    public static final UUID PROP_ITEMS_REMOVE = UUID.randomUUID();

    private List<Item> items;

    public Products(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(Item item, int index) {
        items.add(index, item);
        getSupport().fireIndexedPropertyChange(String.valueOf(PROP_ITEMS_ADD), index, null, item);
    }

    public void removeItem(Item item) {
        int index = items.indexOf(item);
        items.remove(item);
        getSupport().fireIndexedPropertyChange(String.valueOf(PROP_ITEMS_REMOVE), index, item, null);
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

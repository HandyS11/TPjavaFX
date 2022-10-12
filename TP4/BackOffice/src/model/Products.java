package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Products {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
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
        Item i = items.get(index);
        items.add(index, item);
        support.fireIndexedPropertyChange(String.valueOf(PROP_ITEMS_ADD), index, i, item);
    }

    public void removeItem(int index) {
        Item i = items.get(index);
        items.remove(index);
        support.fireIndexedPropertyChange(String.valueOf(PROP_ITEMS_REMOVE), index, i, null);
    }

    public void addListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }
}

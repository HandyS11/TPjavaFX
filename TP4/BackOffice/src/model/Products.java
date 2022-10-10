package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Products {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static final UUID itemsID = UUID.randomUUID();

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
        support.fireIndexedPropertyChange(String.valueOf(itemsID), index, i, item);
    }

    public void addListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }
}

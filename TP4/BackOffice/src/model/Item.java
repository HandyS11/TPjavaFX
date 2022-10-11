package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.UUID;

public abstract class Item {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static final UUID nameID = UUID.randomUUID();
    public static final UUID priceID = UUID.randomUUID();

    private String name;
    private int price;


    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        support.firePropertyChange(String.valueOf(nameID), null, name);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        support.firePropertyChange(String.valueOf(priceID), null, price);
    }

    public void addListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }
}

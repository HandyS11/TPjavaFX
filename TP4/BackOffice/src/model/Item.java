package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.UUID;

public abstract class Item implements Serializable {

    private transient PropertyChangeSupport support = null;
    public static final UUID PROP_NAME = UUID.randomUUID();
    public static final UUID PROP_PRICE = UUID.randomUUID();

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
        String n = this.name;
        this.name = name;
        getSupport().firePropertyChange(String.valueOf(PROP_NAME), n, name);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        int p = this.price;
        this.price = price;
        getSupport().firePropertyChange(String.valueOf(PROP_PRICE), p, price);
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

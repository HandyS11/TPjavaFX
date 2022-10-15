package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Color implements Serializable {

    private transient PropertyChangeSupport support = null;
    public static final UUID PROP_RED = UUID.randomUUID();
    public static final UUID PROP_GREEN = UUID.randomUUID();
    public static final UUID PROP_BLUE = UUID.randomUUID();

    private int red;
    private int green;
    private int blue;

    public Color(double red, double green, double blue) {
        this.red = (int) red*255;
        this.green = (int) green*255;
        this.blue = (int) blue*255;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public List<Integer> getColors() {
        List<Integer> list = new ArrayList<>();
        list.add(getRed());
        list.add(getGreen());
        list.add(getBlue());
        return list;
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

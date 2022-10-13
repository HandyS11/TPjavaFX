package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Color {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
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

    public void editColor(int red, int green, int blue) {
        int r = getRed();
        int g = getGreen();
        int b = getBlue();
        this.red = red*255;
        this.green = green*255;
        this.blue = blue*255;
        support.firePropertyChange(String.valueOf(PROP_RED), r, red);
        support.firePropertyChange(String.valueOf(PROP_GREEN), g, green);
        support.firePropertyChange(String.valueOf(PROP_BLUE), b, blue);
    }

    public void addListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }
}

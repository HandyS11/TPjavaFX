package model;

import utils.Sizes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Clothes extends Item {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static final UUID colorsID = UUID.randomUUID();
    public static final UUID sizesID = UUID.randomUUID();

    private List<Color> colors;
    private List<Sizes> sizes;

    public Clothes(String name, int price, List<Color> colors, List<Sizes> sizes) {
        super(name, price);
        this.colors = colors;
        this.sizes = sizes;
    }

    public List<Color> getColors() {
        return Collections.unmodifiableList(colors);
    }

    public List<Sizes> getSizes() {
        return Collections.unmodifiableList(sizes);
    }

    public void addColor(Color color) {
        colors.add(color);
        support.firePropertyChange(String.valueOf(colorsID), null, color);
    }

    public void removeColor(Color color) {
        colors.remove(color);
        support.firePropertyChange(String.valueOf(colorsID), color, null);
    }

    public void addSize(Sizes size) {
        sizes.add(size);
        support.firePropertyChange(String.valueOf(sizesID), null, size);
    }

    public void removeSize(Sizes size) {
        sizes.remove(size);
        support.firePropertyChange(String.valueOf(sizesID), size, null);
    }

    public void addListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }
}

package model;

import utils.Sizes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Clothes extends Item implements Serializable {

    private transient PropertyChangeSupport support = null;
    public static final UUID PROP_COLORS_ADD = UUID.randomUUID();
    public static final UUID PROP_COLORS_REMOVE = UUID.randomUUID();
    public static final UUID PROP_SIZES_ADD = UUID.randomUUID();
    public static final UUID PROP_SIZES_REMOVE = UUID.randomUUID();

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

    public void addColor(Color color, int index) {
        if (colors.size() > 0 ) {
            colors.add(index, color);
        } else {
            colors.add(color);
        }
        getSupport().fireIndexedPropertyChange(String.valueOf(PROP_COLORS_ADD), index, null, color);
    }

    public void removeColor(Color color) {
        int index = colors.indexOf(color);
        colors.remove(color);
        getSupport().fireIndexedPropertyChange(String.valueOf(PROP_COLORS_REMOVE), index, color, null);
    }

    public List<Sizes> getSizes() {
        return Collections.unmodifiableList(sizes);
    }

    public void addSize(Sizes size, int index) {
        if (sizes.size() > 0) {
            sizes.add(index, size);
        } else {
            sizes.add(size);
        }
        getSupport().fireIndexedPropertyChange(String.valueOf(PROP_SIZES_ADD), index, null, size);
    }

    public void removeSize(Sizes size) {
        int index = sizes.indexOf(size);
        sizes.remove(size);
        getSupport().fireIndexedPropertyChange(String.valueOf(PROP_SIZES_REMOVE), index, size, null);
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

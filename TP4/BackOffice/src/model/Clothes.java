package model;

import utils.Sizes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Clothes extends Item {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
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
        Color c = null;
        if (colors.size() > 0 ) {
            c = colors.get(index);
            colors.add(index, color);
        } else {
            colors.add(color);
        }
        support.fireIndexedPropertyChange(String.valueOf(PROP_COLORS_ADD), index, c, color);
    }

    public void removeColor(int index) {
        Color c = colors.get(index);
        colors.remove(index);
        support.fireIndexedPropertyChange(String.valueOf(PROP_COLORS_REMOVE), index, c, null);
    }

    public List<Sizes> getSizes() {
        return Collections.unmodifiableList(sizes);
    }

    public void addSize(Sizes size, int index) {
        Sizes s = null;
        if (sizes.size() > 0) {
            s = sizes.get(index);
            sizes.add(index, size);
        } else {
            sizes.add(size);
        }
        support.fireIndexedPropertyChange(String.valueOf(PROP_SIZES_ADD), index, s, size);
    }

    public void removeSize(int index) {
        Sizes s = sizes.get(index);
        sizes.remove(index);
        support.fireIndexedPropertyChange(String.valueOf(PROP_SIZES_REMOVE), index, s, null);
    }

    public void addListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }
}

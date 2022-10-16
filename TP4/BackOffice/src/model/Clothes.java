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

    private List<MineColor> mineColors;
    private List<Sizes> sizes;

    public Clothes(String name, int price, List<MineColor> mineColors, List<Sizes> sizes) {
        super(name, price);
        this.mineColors = mineColors;
        this.sizes = sizes;
    }

    public List<MineColor> getColors() {
        return Collections.unmodifiableList(mineColors);
    }

    public void addColor(MineColor mineColor) {
        mineColors.add(mineColor);
        getSupport().firePropertyChange(String.valueOf(PROP_COLORS_ADD), null, mineColor);
    }

    public void removeColor(MineColor mineColor) {
        int index = mineColors.indexOf(mineColor);
        mineColors.remove(mineColor);
        getSupport().fireIndexedPropertyChange(String.valueOf(PROP_COLORS_REMOVE), index, mineColor, null);
    }

    public List<Sizes> getSizes() {
        return Collections.unmodifiableList(sizes);
    }

    public void addSize(Sizes size) {
        sizes.add(size);
        getSupport().firePropertyChange(String.valueOf(PROP_SIZES_ADD), null, size);
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

package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Clothes;
import model.Color;
import utils.Sizes;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ClothesVM extends ItemVM implements PropertyChangeListener {

    private final Clothes model;

    ObservableList<ColorVM> colorsObs = FXCollections.observableList(new ArrayList<>());
    private final ListProperty<ColorVM> colors = new SimpleListProperty<>(colorsObs);

    public ObservableList<ColorVM> getColors() { return colors.get(); }
        public ListProperty<ColorVM> colorsProperty() { return colors; }
        public void setColors(ObservableList<ColorVM> colors) { this.colors.set(colors); }

    ObservableList<Sizes> sizesObs = FXCollections.observableList(new ArrayList<>());
    private final ListProperty<Sizes> sizes = new SimpleListProperty<>(sizesObs);
        public ObservableList<Sizes> getSizes() { return sizes.get(); }
        public ListProperty<Sizes> sizesProperty() { return sizes; }
        public void setSizes(ObservableList<Sizes> sizes) { this.sizes.set(sizes); }


    public ClothesVM(Clothes clothes) {
        super(clothes);
        clothes.getColors().forEach((color -> colors.add(new ColorVM(new Color(color.getRed(), color.getGreen(), color.getBlue())))));
        sizes.addAll(clothes.getSizes());
        model = clothes;
        model.addListener(this);
    }

    public void addColor(javafx.scene.paint.Color color) {    // To fix
        Color c = new Color(color.getRed(), color.getGreen(), color.getBlue());
        model.addColor(c, colors.size());
    }

    public void removeColor(ColorVM colorVM) {
        model.removeColor(colorVM.getModel());
    }

    public void addSize(Object size) {
        model.addSize((Sizes) size, sizes.size());
    }

    public void removeSize(Sizes size) {
        model.removeSize(size);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);
        IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;
        if (e.getPropertyName().equals(String.valueOf(Clothes.PROP_COLORS_ADD))) {
            colorsObs.add(e.getIndex(), (ColorVM) e.getNewValue());
        } else if (e.getPropertyName().equals(String.valueOf(Clothes.PROP_COLORS_REMOVE))) {
            colorsObs.remove(e.getIndex());
        } else if (e.getPropertyName().equals(String.valueOf(Clothes.PROP_SIZES_ADD))) {
            sizesObs.add(e.getIndex(), (Sizes) e.getNewValue());
        } else if (e.getPropertyName().equals(String.valueOf(Clothes.PROP_SIZES_REMOVE))) {
            sizesObs.remove(e.getIndex());
        }
    }
}

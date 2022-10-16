package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import model.Clothes;
import model.MineColor;
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
        clothes.getColors().forEach((mineColor -> colors.add(new ColorVM(new MineColor(mineColor.getRed(), mineColor.getGreen(), mineColor.getBlue())))));
        sizes.addAll(clothes.getSizes());
        model = clothes;
        model.addListener(this);
    }

    public void addColor(Color color) {
        model.addColor(new MineColor((int) (color.getRed() * 255), (int) (color.getGreen() * 255), (int) (color.getBlue()) * 255));
    }

    public void removeColor(ColorVM colorVM) {
        model.removeColor(colorVM.getModel());
    }

    public void addSize(Object size) {
        model.addSize((Sizes) size);
    }

    public void removeSize(Sizes size) {
        model.removeSize(size);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        var newV = evt.getNewValue();
        var oldV = evt.getOldValue();
        var prop = evt.getPropertyName();

        if (newV != null) {
            if (prop.equals(String.valueOf(Clothes.PROP_COLORS_ADD))) {
                colorsObs.add(new ColorVM((MineColor) newV));
            } else if (prop.equals(String.valueOf(Clothes.PROP_SIZES_ADD))) {
                sizesObs.add((Sizes) newV);
            }
        }
        if (oldV != null) {
            IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;
            var index = e.getIndex();
            if (prop.equals(String.valueOf(Clothes.PROP_COLORS_REMOVE))) {
                colorsObs.remove(index);
            } else if (prop.equals(String.valueOf(Clothes.PROP_SIZES_REMOVE))) {
                sizesObs.remove(index);
            }
        }
    }
}

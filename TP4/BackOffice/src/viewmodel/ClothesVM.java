package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Clothes;
import utils.Sizes;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ClothesVM extends ItemVM implements PropertyChangeListener {

    private Clothes model;

    ObservableList<ColorVM> colorsObs = FXCollections.observableList(new ArrayList<ColorVM>());
    private ListProperty<ColorVM> colors = new SimpleListProperty<>(colorsObs);

    public ObservableList<ColorVM> getColors() { return colors.get(); }
        public ListProperty<ColorVM> colorsProperty() { return colors; }
        public void setColors(ObservableList<ColorVM> colors) { this.colors.set(colors); }

    ObservableList<Sizes> sizesObs = FXCollections.observableList(new ArrayList<Sizes>());
    private ListProperty<Sizes> sizes = new SimpleListProperty<>(sizesObs);
        public ObservableList<Sizes> getSizes() { return sizes.get(); }
        public ListProperty<Sizes> sizesProperty() { return sizes; }
        public void setSizes(ObservableList<Sizes> sizes) { this.sizes.set(sizes); }


    public ClothesVM(Clothes clothes) {
        super(clothes.getName(), clothes.getPrice());
        clothes.getColors().forEach((color -> colors.add(new ColorVM(color.getRed(), color.getGreen(), color.getBlue()))));
        clothes.getSizes().forEach((size -> sizes.add(size)));
        model = clothes;
        model.addListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;
        if (e.getPropagationId() == Clothes.colorsID) {
            colors.set(e.getIndex() ,new ColorVM((List<Integer>) e.getNewValue()));
        } else if (e.getPropagationId() == Clothes.sizesID) {
            sizes.set(e.getIndex(), (Sizes) e.getNewValue());
        }
    }
}

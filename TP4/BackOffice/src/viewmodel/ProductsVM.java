package viewmodel;

import data.*;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import model.Clothes;
import model.Item;
import model.Perfume;
import model.Products;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;

public class ProductsVM implements PropertyChangeListener {

    private Products model;

    private final ObservableList<ItemVM> itemsObs = FXCollections.observableList(new ArrayList<>());
    private final FilteredList<ItemVM> filteredList = new FilteredList<>(itemsObs);
    private final ListProperty<ItemVM> items = new SimpleListProperty<>(filteredList);
        public ObservableList<ItemVM> getItems() { return items.get(); }
        public ListProperty<ItemVM> itemsProperty() { return items; }
        public void setItems(ObservableList<ItemVM> items) { this.items.set(items); }

    public ProductsVM() {
        try {
            model = new FileLoader().load();
        } catch (Exception e) {
            model = new Stub().load();
        } finally {
            model.getItems().forEach(item -> {
                if (item instanceof Clothes) {
                    itemsObs.add(new ClothesVM((Clothes) item));
                } else if (item instanceof Perfume) {
                    itemsObs.add(new PerfumeVM((Perfume) item));
                }
            });
            model.addListener(this);
        }
    }

    public void addPerfume() {
        Item item = (new Perfume("Name", 0, new ArrayList<>()));
        addItem(item);
    }

    public void addClothes() {
        Item item = new Clothes("Name", 0, new ArrayList<>(), new ArrayList<>());
        addItem(item);
    }

    public void addItem(Item item) {
        model.addItem(item, 0);
    }

    public void deleteItem(ItemVM item) {
        model.removeItem(item.getModel());
    }

    public void sortItemList(String type) {
        if (type == "CLOTHES") {
            filteredList.setPredicate(itemVM -> itemVM instanceof ClothesVM);
        } else if (type == "PERFUME") {
            filteredList.setPredicate(itemVM -> itemVM instanceof PerfumeVM);
        } else {
            filteredList.setPredicate(null);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        IndexedPropertyChangeEvent e = (IndexedPropertyChangeEvent) evt;
        var newV = e.getNewValue();
        var oldV = e.getOldValue();
        var prop = e.getPropertyName();

        if (newV != null) {
            if (newV instanceof Clothes) {
                if (prop.equals(String.valueOf(Products.PROP_ITEMS_ADD))) {
                    itemsObs.add(e.getIndex(), new ClothesVM((Clothes) newV));
                }
            } else if (newV instanceof Perfume) {
                if (prop.equals(String.valueOf(Products.PROP_ITEMS_ADD))) {
                    itemsObs.add(e.getIndex() , new PerfumeVM((Perfume) newV));
                }
            }
        }
        if (oldV != null) {
            if (prop.equals(String.valueOf(Products.PROP_ITEMS_REMOVE))) {
                itemsObs.remove(e.getIndex());
            }
        }
    }

    public void save() throws IOException {
        IDataSaver saver = new FileSaver();
        saver.save(model);
    }
}

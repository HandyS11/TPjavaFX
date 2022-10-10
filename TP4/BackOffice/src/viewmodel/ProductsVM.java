package viewmodel;

import data.IDataLoader;
import data.Stub;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Clothes;
import model.Perfume;
import model.Products;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import static model.Products.itemsID;

public class ProductsVM implements PropertyChangeListener {

    private Products model;

    private IDataLoader dataLoader = new Stub();

    ObservableList<ItemVM> itemsObs = FXCollections.observableList(new ArrayList<>());
    private ListProperty<ItemVM> items = new SimpleListProperty<>(itemsObs);
        public ObservableList<ItemVM> getItems() { return items.get(); }
        public ListProperty<ItemVM> itemsProperty() { return items; }
        public void setItems(ObservableList<ItemVM> items) { this.items.set(items); }

    public ProductsVM() {
        model = new Products(dataLoader.load());
        model.getItems().forEach((item -> {
            if (item instanceof Clothes) {
                addItem(new ClothesVM((Clothes) item));
            } else if (item instanceof Perfume) {
                addItem(new PerfumeVM((Perfume) item));
            }
        }));
        model.addListener(this);
    }

    public void deleteItem(ItemVM item) {
        items.remove(item);
    }

    public void addItem(ItemVM item) {
        items.add(item);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropagationId() == itemsID) {
            if (evt.getNewValue() instanceof Clothes) {
                items.add(new ClothesVM((Clothes) evt.getNewValue()));
            } else if (evt.getNewValue() instanceof Perfume) {
                items.add(new PerfumeVM((Perfume) evt.getNewValue()));
            }
        }
    }
}

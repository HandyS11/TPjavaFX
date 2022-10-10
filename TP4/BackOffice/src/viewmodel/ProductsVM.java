package viewmodel;

import data.IDataLoader;
import data.Stub;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Products;

import java.util.ArrayList;

public class ProductsVM {

    private Products model;

    private IDataLoader dataLoader = new Stub();

    ObservableList<ItemVM> itemsObs = FXCollections.observableList(new ArrayList<ItemVM>());
    private ListProperty<ItemVM> items = new SimpleListProperty<ItemVM>(itemsObs);


    public ObservableList<ItemVM> getItems() { return items.get(); }
        public ListProperty<ItemVM> itemsProperty() { return items; }
        public void setItems(ObservableList<ItemVM> items) { this.items.set(items); }


    public ProductsVM() {
        model = new Products(dataLoader.load());
    }
}

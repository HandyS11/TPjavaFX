package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Item;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class ItemVM implements PropertyChangeListener {

    private StringProperty name = new SimpleStringProperty();
        public String getName() { return name.get(); }
        public StringProperty nameProperty() { return name; }
        public void setName(String name) { this.name.set(name); }

    private IntegerProperty price = new SimpleIntegerProperty();
        public int getPrice() { return price.get(); }
        public IntegerProperty priceProperty() { return price; }
        public void setPrice(int price) { this.price.set(price); }

    public ItemVM(String name, int price) {
        setName(name);
        setPrice(price);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(String.valueOf(Item.PROP_NAME))) {
            name.set((String) evt.getNewValue());
        } else if (evt.getPropertyName().equals(String.valueOf(Item.PROP_PRICE))) {
            price.set((int) evt.getNewValue());
        }
    }
}

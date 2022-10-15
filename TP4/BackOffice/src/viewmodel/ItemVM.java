package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Item;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class ItemVM implements PropertyChangeListener {

    private Item model;

    private final StringProperty name = new SimpleStringProperty();
        public String getName() { return name.get(); }
        public StringProperty nameProperty() { return name; }
        public void setName(String name) { this.name.set(name); }

    private final IntegerProperty price = new SimpleIntegerProperty();
        public int getPrice() { return price.get(); }
        public IntegerProperty priceProperty() { return price; }
        public void setPrice(int price) { this.price.set(price); }

    public ItemVM(Item model) {
        this.model = model;
        setName(model.getName());
        setPrice(model.getPrice());

        name.addListener((observable, oldValue, newValue) -> {
            model.setName(newValue);
        });

        price.addListener((observable, oldValue, newValue) -> {
            model.setPrice(newValue.intValue());
        });
    }

    @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals(String.valueOf(Item.PROP_NAME))) {
                name.set((String) evt.getNewValue());
            } else if (evt.getPropertyName().equals(String.valueOf(Item.PROP_PRICE))) {
            price.set((int) evt.getNewValue());
        }
    }

    public Item getModel() {
        return model;
    }
}

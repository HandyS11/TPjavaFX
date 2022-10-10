package model;

import java.util.Collections;
import java.util.List;

public class Products {

    private List<Item> items;

    public Products(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItems(List<Item> items) {
        items.forEach((item -> addItem(item, -1)));
    }

    public void addItem(Item item, int index) {
        if (index == -1) {
            items.add(item);
        } else {
            items.add(index, item);
        }
    }
}

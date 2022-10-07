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
}

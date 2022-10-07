package model;

import java.util.Collections;
import java.util.List;

public class Clothes extends Item {

    private List<Color> colors;
    private List<Sizes> sizes;

    public Clothes(String name, int price, List<Color> colors, List<Sizes> sizes) {
        super(name, price);
        this.colors = colors;
        this.sizes = sizes;
    }


    public List<Color> getColors() {
        return Collections.unmodifiableList(colors);
    }

    public List<Sizes> getSizes() {
        return Collections.unmodifiableList(sizes);
    }
}

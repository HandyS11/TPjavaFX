package data;

import model.*;
import utils.Sizes;

import java.util.ArrayList;
import java.util.List;

public class Stub implements IDataLoader {

    @Override
    public List<Item> load() {
        List<Item> items = new ArrayList<>();

        List<String> smelt = new ArrayList<>();
        smelt.add("Wood");
        smelt.add("Honey");
        smelt.add("Forest");
        smelt.add("Ocean");
        smelt.add("Rose");

        List<String> fragrances1 = new ArrayList<>();
        List<String> fragrances2 = new ArrayList<>();
        List<String> fragrances3 = new ArrayList<>();

        fragrances1.add(smelt.get(0));
        fragrances1.add(smelt.get(1));
        fragrances1.add(smelt.get(2));

        fragrances2.add(smelt.get(3));
        fragrances2.add(smelt.get(4));

        fragrances3.add(smelt.get(0));
        fragrances3.add(smelt.get(4));

        List<Sizes> sizes1 = new ArrayList<>();
        List<Sizes> sizes2 = new ArrayList<>();
        List<Sizes> sizes3 = new ArrayList<>();

        sizes1.add(Sizes.S);
        sizes1.add(Sizes.XL);

        sizes2.add(Sizes.M);
        sizes2.add(Sizes.XL);

        sizes3.add(Sizes.L);
        sizes3.add(Sizes.M);
        sizes3.add(Sizes.XXL);

        List<Color> colors1 = new ArrayList<>();
        List<Color> colors2 = new ArrayList<>();
        List<Color> colors3 = new ArrayList<>();

        colors1.add(new Color(1, 0, 0));
        colors1.add(new Color(1, 1, 0));
        colors1.add(new Color(1, 0, 1));

        colors2.add(new Color(0, 1, 0));
        colors2.add(new Color(0, 0.5, 0));
        colors2.add(new Color(0, 0.5, 1));

        colors3.add(new Color(0, 0, 0));
        colors3.add(new Color(0.5, 1, 0));
        colors3.add(new Color(0.25, 0.25, 0.5));


        items.add(new Perfume("Good smell", 100, fragrances1));
        items.add(new Clothes("T-Shirt", 50, colors1, sizes1));
        items.add(new Perfume("Chanel n°666", 666, fragrances2));
        items.add(new Clothes("Jean", 55, colors2, sizes2));
        items.add(new Perfume("The Rose", 124, fragrances3));
        items.add(new Clothes("Jacket", 48, colors3, sizes3));

        return items;
    }
}

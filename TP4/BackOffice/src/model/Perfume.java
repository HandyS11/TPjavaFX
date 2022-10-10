package model;

import java.util.Collections;
import java.util.List;

public class Perfume extends Item {

    private List<String> flagrance;

    public Perfume(String name, int price, List<String> flagrance) {
        super(name, price);
        this.flagrance = flagrance;
    }

    public List<String> getFlagrance() {
        return Collections.unmodifiableList(flagrance);
    }

    public void addFlagrance(String str) {
        flagrance.add(str);
    }
}

package data;

import model.Bird;

import java.util.ArrayList;
import java.util.List;

public class Stub implements IDataLoader {

    @Override
    public List<Bird> load() {
        List<Bird> birds = new ArrayList<Bird>();
        birds.add(new Bird("Bird 1", "Blue", 2));
        birds.add(new Bird("Bird 2", "Red", 3));
        birds.add(new Bird("Bird 3", "Green", 4));
        birds.add(new Bird("Bird 4", "Black", 3));
        birds.add(new Bird("Bird 5", "White", 2));
        return birds;
    }
}

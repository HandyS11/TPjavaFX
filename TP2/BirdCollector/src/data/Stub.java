package data;

import model.Bird;

import java.util.ArrayList;
import java.util.List;

public class Stub implements IDataLoader {

    @Override
    public List<Bird> load() {
        List<Bird> birds = new ArrayList<Bird>();
        birds.add(new Bird("Bird 1", "Blue"));
        birds.add(new Bird("Bird 2", "Red"));
        birds.add(new Bird("Bird 3", "Green"));
        birds.add(new Bird("Bird 4", "Black"));
        birds.add(new Bird("Bird 5", "White"));
        return birds;
    }
}

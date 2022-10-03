package data;

import model.Bird;

import java.util.ArrayList;
import java.util.List;

public class Stub implements IDataLoader {

    @Override
    public List<Bird> load() {
        List<Bird> birds = new ArrayList<Bird>();
        birds.add(new Bird("Bird 1", 5));
        birds.add(new Bird("Bird 2", 3));
        birds.add(new Bird("Bird 3", 4));
        birds.add(new Bird("Bird 4", 3));
        birds.add(new Bird("Bird 5", 2));
        return birds;
    }
}

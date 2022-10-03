package model;

import data.IDataLoader;
import data.Stub;

import java.time.LocalDate;
import java.util.List;

public class Collection {

    List<Bird> birds;
    LocalDate date;


    public Collection() {
        IDataLoader loader = new Stub();
        birds = loader.load();
        date = LocalDate.now();
    }
}

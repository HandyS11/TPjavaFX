package data;

import model.Products;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileSaver implements IDataSaver {

    @Override
    public void save(Products products) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.bin"))) {
            oos.writeObject(products);
        }
    }
}

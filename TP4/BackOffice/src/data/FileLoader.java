package data;

import model.Products;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileLoader implements IDataLoader {

    @Override
    public Products load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.bin"))) {
            return (Products) ois.readObject();
        }
    }
}

package data;

import model.Products;

import java.io.IOException;

public interface IDataLoader {

    Products load() throws IOException, ClassNotFoundException;
}

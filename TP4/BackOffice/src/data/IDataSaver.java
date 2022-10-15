package data;

import model.Products;

import java.io.IOException;

public interface IDataSaver {

    void save(Products products) throws IOException;
}

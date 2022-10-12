package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import viewmodel.ItemVM;

import java.io.IOException;

public class ItemUC extends VBox {

    @FXML
    private TextField itemName, itemPrice;

    private ItemVM viewModel;

    public ItemUC() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/UC/ItemUC.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public void setViewModel(ItemVM itemVM) {
        viewModel = itemVM;

        itemName.textProperty().bindBidirectional(viewModel.nameProperty());
        itemPrice.textProperty().bindBidirectional(viewModel.priceProperty(), new NumberStringConverter());
    }
}

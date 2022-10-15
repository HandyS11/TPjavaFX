package view.uc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import viewmodel.ColorVM;

import java.io.IOException;

public class ColorUC extends HBox {

    @FXML
    private Rectangle colorPic;

    @FXML
    private Label redLabel, greenLabel, blueLabel;

    public ColorUC(ColorVM colorVM) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/UC/ColorUC.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();

        colorPic.fillProperty().bind(colorVM.colorProperty());

        redLabel.textProperty().bind(colorVM.redProperty().asString());
        greenLabel.textProperty().bind(colorVM.redProperty().asString());
        blueLabel.textProperty().bind(colorVM.blueProperty().asString());
    }
}
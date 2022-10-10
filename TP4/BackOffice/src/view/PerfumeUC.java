package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PerfumeUC extends VBox {

    @FXML
    private ListView<String> fragrancesListView;

    @FXML
    private void addSmell() {
    }

    @FXML
    private void removeSmell() {
    }

    @FXML
    private void deselectSmell() {
    }

    @FXML
    private VBox perfumeUC;

    private VBox itemUC;

    public PerfumeUC() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/UC/PerfumeUC.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public void initialize() {
        try {
            itemUC = new ItemUC();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        perfumeUC.getChildren().add(0, itemUC);
    }
}

package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import viewmodel.PerfumeVM;

import java.io.IOException;

public class PerfumeUC extends VBox {

    @FXML
    private ListView<String> fragrancesListView;

    @FXML
    private TextField smellTextField;

    @FXML
    private Button addSmellButton, removeSmellButton;

    @FXML
    private VBox perfumeUC;

    private VBox itemUC;

    private PerfumeVM viewModel;

    @FXML
    private void addSmell() {
        viewModel.addFragrance(fragrancesListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void removeSmell() {
        viewModel.removeFragrance(fragrancesListView.getSelectionModel().getSelectedIndex());
    }


    public PerfumeUC(VBox itemUC) throws IOException {
        this.itemUC = itemUC;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/UC/PerfumeUC.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();
    }

    public void initialize() {
        perfumeUC.getChildren().add(0, itemUC);

        addSmellButton.disableProperty().bind(smellTextField.textProperty().isEmpty());
        removeSmellButton.disableProperty().bind(fragrancesListView.getSelectionModel().selectedIndexProperty().isEqualTo(-1));
    }

    public void setViewModel(PerfumeVM perfumeVM) {
        viewModel = perfumeVM;
        ((ItemUC) itemUC).setViewModel(viewModel);
        fragrancesListView.itemsProperty().bind(viewModel.fragrancesProperty());
    }
}

package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainWindow;
import viewmodel.ProductsVM;

public class Launcher extends Application {

    ProductsVM viewModel = new ProductsVM();

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainWindow mainWindow = new MainWindow(viewModel);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/MainWindow.fxml"));
        fxmlLoader.setController(mainWindow);
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BackOffice");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        viewModel.save();
        super.stop();
    }
}

package userInterfaceTier;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application class responsible for initializing and displaying the user
 * interface.
 *
 * 
 * This class extends {@code javafx.application.Application} and serves as the
 * entry point to launch the JavaFX application. It loads the FXML file for the
 * user interface and sets the scene on the primary stage.
 *
 * @author meylin y olaia
 */
public class Application extends javafx.application.Application {

    /**
     * Starts the JavaFX application by loading the FXML file and setting the
     * scene on the primary stage.
     *
     * 
     * This method is automatically called when the application is launched. It
     * loads the {@code UserDataView.fxml} file, creates a scene, and displays
     * the primary stage.
     *
     * @param stage the primary stage for this application.
     * @throws Exception if there is an error during loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UserDataView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main entry point for the JavaFX application.
     *
     * 
     * This method is called when the application is started, passing any
     * command-line arguments to the JavaFX {@code launch} method.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

}

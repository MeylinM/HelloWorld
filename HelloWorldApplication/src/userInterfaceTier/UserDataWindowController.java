package userInterfaceTier;

import dataAccessTier.UserManagerFactory;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import model.User;

/**
 * Controller class for the User Data Window.
 *
 * 
 * This class is responsible for handling user interface interactions in the
 * User Data Window. It retrieves user data from the data access layer and
 * displays it in the corresponding labels in the JavaFX UI.
 *
 * @author meylin y olaia
 */
public class UserDataWindowController {

    @FXML
    private Label dni;

    @FXML
    private Label userName;

    @FXML
    private Label fullName;

    @FXML
    private Label passwd;

    /**
     * Handles the action triggered by the user when interacting with the UI.
     *
     *
     * This method retrieves user data using the {@code UserManagerFactory} and
     * sets the data into the respective labels in the user interface. If an
     * error occurs during data retrieval, an error message is shown to the
     * user.
     *
     * @param event the action event triggered by the user.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            // Retrieve and assign user data to the corresponding labels.
            User user = UserManagerFactory.getDataAccssesible().getUserData();
            dni.setText(user.getDni());
            userName.setText(user.getUserName());
            fullName.setText(user.getFullName());
            passwd.setText(user.getPasswd());
        } catch (Exception e) {
            Logger.getLogger("userInterfaceTier").severe(e.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR, "User information can not be found", ButtonType.OK).showAndWait();
        }
    }

}

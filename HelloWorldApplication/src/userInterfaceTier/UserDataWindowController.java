/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author 2dam
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

    @FXML
    private void handleButtonAction(ActionEvent event) {
        //declarar los labels a los que les vamos a asignar la info del usuario
        try {
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

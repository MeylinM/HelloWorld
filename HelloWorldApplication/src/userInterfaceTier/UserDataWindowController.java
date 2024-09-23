/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier;

import dataAccessTier.DBUserDataAccessor;
import dataAccessTier.DataAccessible;
import dataAccessTier.UserManagerFactory;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

        User user = UserManagerFactory.getDataAccssesible().getUserData();
        dni.setText(user.getDni());
        userName.setText(user.getUserName());
        fullName.setText(user.getFullName());
        passwd.setText(user.getPasswd());

    }

}

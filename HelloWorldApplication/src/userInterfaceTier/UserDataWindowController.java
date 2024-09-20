/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier;

import dataAccessTier.DataAccessible;
import dataAccessTier.UserManagerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.User;

/**
 *
 * @author 2dam
 */
public class UserDataWindowController {
    
    @FXML
    private Label label;
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //declarar los labels a los que les vamos a asignar la info del usuario
        User user= UserManagerFactory.getDataAccssesible().getUserData();
      
        
    }
  
    
}

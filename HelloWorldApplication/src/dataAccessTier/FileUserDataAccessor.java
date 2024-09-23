/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;


import java.util.ResourceBundle;
import model.User;

public class FileUserDataAccessor implements DataAccessible {

    /**
     *
     * @author meylin
     * @return User
     */
    @Override
    public User getUserData() {
        //Lee el archivo de propiedades.
        ResourceBundle configFile = ResourceBundle.getBundle("resources.DATA");
        User user = new User();
        
        user.setDni(configFile.getString("dni"));
        user.setUserName(configFile.getString("username"));
        user.setFullName(configFile.getString("fullname"));
        user.setPasswd(configFile.getString("passwd"));
        return user;
    }

}

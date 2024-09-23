/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class UserManagerFactory {

    public static DataAccessible getDataAccssesible() {
        //Mirar otro archivo de propiedades para saber si debe leer de la DB o del File
        ResourceBundle configFile = ResourceBundle.getBundle("resources.Config");
        if (configFile.containsKey("optGetData")) {
            String optGetData = configFile.getString("optGetData");
            if ("0".equals(optGetData)) {
                return new FileUserDataAccessor();
            } else if ("1".equals(optGetData)) {
                return new DBUserDataAccessor();
            } else {
                throw new IllegalArgumentException("Valor inválido para optGetData: " + optGetData);
            }
        }else {
            throw new IllegalArgumentException("La clave 'optGetData' no se encuentra en el archivo de configuración.");
        }
    }
}

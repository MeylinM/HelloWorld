/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author 2dam
 */
public class UserManagerFactory {

    public static DataAccessible getDataAccssesible() {
        //Mirar otro archivo de propiedades para saber si debe leer de la DB o del File

        return new FileUserDataAccessor();
    }

}

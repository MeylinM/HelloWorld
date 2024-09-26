package dataAccessTier;

import java.util.ResourceBundle;

/**
 * Factory class responsible for determining the data access mechanism.
 *
 * 
 * This class reads a configuration file to decide whether to use a database or
 * a file-based system for accessing user data, and returns an appropriate
 * implementation of the {@code DataAccessible} interface.
 *
 * @author meylin y olaia
 */
public class UserManagerFactory {

    /**
     * Determines the data access method (file or database) based on the
     * configuration file and returns the appropriate implementation of
     * {@code DataAccessible}.
     *
     * 
     * This method reads from a configuration file to check the key
     * {@code optGetData}. If the key's value is "0", it returns an instance of
     * {@code FileUserDataAccessor}. If the value is "1", it returns an instance
     * of {@code DBUserDataAccessor}. If an invalid value is found, or if the
     * key does not exist, an exception is thrown.
     *
     * @return an implementation of {@code DataAccessible} based on the
     * configuration.
     * @throws IllegalArgumentException if the configuration key is invalid or
     * missing.
     */
    public static DataAccessible getDataAccssesible() {
    // Reads another properties file to determine whether to read from the DB or from a file.
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
        } else {
            throw new IllegalArgumentException("La clave 'optGetData' no se encuentra en el archivo de configuración.");
        }
    }
}

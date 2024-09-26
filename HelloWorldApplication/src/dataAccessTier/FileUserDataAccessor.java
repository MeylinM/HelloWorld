package dataAccessTier;

import java.util.ResourceBundle;
import model.User;

/**
 * Class responsible for accessing user data from a properties file.
 *
 *
 * This class reads user information from a resource bundle (properties file)
 * and creates a {@code User} object with the retrieved data.
 *
 * @author meylin y olaia
 */
public class FileUserDataAccessor implements DataAccessible {

    /**
     * Retrieves the data of a user from a properties file.
     *
     *
     * This method reads from a properties file located in the resources folder
     * using {@code ResourceBundle} and creates a {@code User} object with the
     * data retrieved (DNI, username, full name, and password).
     *
     * @return a {@code User} object containing the user data.
     */
    @Override
    public User getUserData() {
    // Reads the properties file.
        ResourceBundle configFile = ResourceBundle.getBundle("resources.DATA");
        User user = new User();

        user.setDni(configFile.getString("dni"));
        user.setUserName(configFile.getString("username"));
        user.setFullName(configFile.getString("fullname"));
        user.setPasswd(configFile.getString("passwd"));
        return user;
    }
}

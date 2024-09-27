package model;

/**
 * Represents a user with basic attributes such as DNI, username, full name, and
 * password.
 *
 * 
 * This class provides getter and setter methods to access and modify user
 * information.
 *
 * @author meylin y olaia 
 */
public class User {

    /**
     * The user's DNI (Document National Identity).
     */
    private String dni;

    /**
     * The user's username.
     */
    private String userName;

    /**
     * The user's full name.
     */
    private String fullName;

    /**
     * The user's password.
     */
    private String passwd;

    /**
     * Gets the user's DNI.
     *
     * @return the user's DNI.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Sets the user's DNI.
     *
     * @param dni the new DNI to set.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Gets the user's username.
     *
     * @return the user's username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user's username.
     *
     * @param userName the new username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the user's full name.
     *
     * @return the user's full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the user's full name.
     *
     * @param fullName the new full name to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the user's password.
     *
     * @return the user's password.
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * Sets the user's password.
     *
     * @param passwd the new password to set.
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.User;

/**
 * Class responsible for accessing user data from the database. Implements the
 * DataAccessible interface and provides methods to retrieve user data from a
 * MySQL database.
 *
 * 
 * This class uses JDBC for database connectivity and executes SQL queries to
 * fetch data related to users from the "usuario" table.
 *
 * @author meylin y olaia
 */
public class DBUserDataAccessor implements DataAccessible {

    /**
     * Connection object to the MySQL database.
     */
    private Connection con;

    /**
     * PreparedStatement object used to execute the SQL query.
     */
    private PreparedStatement stmt;

    /**
     * SQL query to retrieve all user data from the "usuario" table.
     */
    final String GETUSERDATA = "SELECT * FROM usuario";

    /**
     * Retrieves the data of a user from the database.
     *
     * 
     * This method opens a connection to the database, executes a query to fetch
     * the user information, and returns a User object containing the retrieved
     * data.
     *
     * @return a User object containing the user data, or null if no user is
     * found.
     */
    @Override
    public User getUserData() {
        User user = null;
        openConnection();
        try {
            stmt = con.prepareStatement(GETUSERDATA);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setDni(resultSet.getString("DNI"));
                user.setUserName(resultSet.getString("USERNAME"));
                user.setFullName(resultSet.getString("FULLNAME"));
                user.setPasswd(resultSet.getString("PASSWD"));
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger("dataAccessTier").severe(ex.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK).showAndWait();
        }
        closeConnection(stmt, con);
        return user;
    }

    /**
     * Opens a connection to the MySQL database.
     *
     * 
     * This method uses JDBC to establish a connection to a MySQL database
     * hosted at the URL "jdbc:mysql://localhost:3306/user" using the
     * credentials "root" and "abcd*1234".
     *
     * @return a Connection object representing the connection to the database.
     */
    public Connection openConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/user?serverTimezone=Europe/Madrid&useSSL=false";
            con = DriverManager.getConnection(url, "root", "abcd*1234");
        } catch (SQLException e) {
            Logger.getLogger("dataAccessTier").severe(e.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR, "Data Base can not be open", ButtonType.OK).showAndWait();
        }
        return con;
    }

    /**
     * Closes the database connection and the PreparedStatement.
     *
     * 
     * This method ensures that both the statement and connection objects are
     * properly closed to avoid memory leaks.
     *
     * @param stmt the PreparedStatement to be closed.
     * @param con the Connection to be closed.
     */
    public void closeConnection(PreparedStatement stmt, Connection con) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            Logger.getLogger("dataAccessTier").severe(e.getLocalizedMessage());
            new Alert(Alert.AlertType.ERROR, "Data Base can not be closed", ButtonType.OK).showAndWait();
        }
    }
}

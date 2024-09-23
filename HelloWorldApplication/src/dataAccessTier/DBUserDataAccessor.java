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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.User;

/**
 *
 * @author 2dam
 */
public class DBUserDataAccessor implements DataAccessible {

    private Connection con;
    private PreparedStatement stmt;
    final String GETUSERDATA = "SELECT * FROM usuario";

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

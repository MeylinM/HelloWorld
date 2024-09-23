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
        User user=null;
        openConnection();
        try {
            stmt = con.prepareStatement(GETUSERDATA);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setDni(resultSet.getNString("DNI"));
                user.setUserName(resultSet.getString("USERNAME"));
                user.setFullName(resultSet.getString("FULLNAME"));
                user.setPasswd(resultSet.getString("PASSWD"));
            }else{
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUserDataAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            closeConnection(stmt,con);
        } catch (SQLException ex) {
            Logger.getLogger(DBUserDataAccessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public Connection openConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/user?serverTimezone=Europe/Madrid&useSSL=false";
            con = DriverManager.getConnection(url, "root", "abcd*1234");
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD");
        }
        return con;
    }
    
    public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {
        System.out.println("Conexion cerrada");
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
        System.out.println("--------------------");
    }
}

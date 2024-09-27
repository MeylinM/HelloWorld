/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import model.User;

/**
 * Interface defining methods for accessing user data.
 *
 * 
 * This interface provides the contract for retrieving user data from a data
 * source, typically a database. Implementing classes are responsible for the
 * actual data access logic.
 *
 * @author meylin y olaia
 */
public interface DataAccessible {

    /**
     * Retrieves the data of a user from a data source.
     *
     * 
     * Implementations of this method should provide the necessary logic to
     * retrieve and return a User object containing user information.
     *
     * @return a User object containing user data, or null if no data is found.
     */
    public User getUserData();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class User {

    private String username;
    private String password;
    private String name;
    private String surname;

    public User() {
        
        username = "";
        password = "";
        name = "";
        surname = "";
    }
    
    public static final String PROP_SURNAME = "surname";

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        String oldSurname = this.surname;
        this.surname = surname;
        propertyChangeSupport.firePropertyChange(PROP_SURNAME, oldSurname, surname);
    }

    public static final String PROP_NAME = "name";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange(PROP_NAME, oldName, name);
    }

    public static final String PROP_PASSWORD = "password";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        propertyChangeSupport.firePropertyChange(PROP_PASSWORD, oldPassword, password);
    }
        
    public static final String PROP_USERNAME = "username";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        propertyChangeSupport.firePropertyChange(PROP_USERNAME, oldUsername, username);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
}

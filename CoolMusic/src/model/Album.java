/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;


/**
 *
 * @author usu21
 */
public class Album {

    private String name;
    private Date dateA;

    public static final String PROP_DATE = "date";

    public Album() {
        name = "";
        dateA = new Date();
    }

    public Date getDate() {
        return dateA;
    }

    public void setDate(Date date) {
        Date oldDate = this.dateA;
        this.dateA = date;
        propertyChangeSupport.firePropertyChange(PROP_DATE, oldDate, date);
    }

    public static final String PROP_NAME = "name";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    
    
    
    
    
    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange(PROP_NAME, oldName, name);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}

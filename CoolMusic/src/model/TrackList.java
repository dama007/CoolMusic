/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class TrackList {
    
     private ObservableList<Track> list;

    public TrackList() {
        list = ObservableCollections.observableList(new ArrayList<Track>());
    }
  
    public static final String PROP_LIST = "list";

    public ObservableList<Track> getList() {
        return list;
    }
    
    public void insertTrack(Track t) {
        list.add(t);
    }
    
    public void removeTrack(Track t) {
        list.remove(t);
    }
    
    public void setList(ObservableList<Track> list) {
        ObservableList<Track> oldList = this.list;
        this.list = list;
        propertyChangeSupport.firePropertyChange(PROP_LIST, oldList, list);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
   
    
    
}

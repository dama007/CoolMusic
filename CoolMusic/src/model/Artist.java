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
public class Artist {
    
    
    private String singer;   
    private String genre;

    public Artist() {
        
    singer = "";
    genre = "";
    
    }

    public static final String PROP_GENRE = "genre";

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        String oldGenre = this.genre;
        this.genre = genre;
        propertyChangeSupport.firePropertyChange(PROP_GENRE, oldGenre, genre);
    }


    public static final String PROP_SINGER = "singer";

    @Override
    public String toString() {
        return singer;
    }

    
    
    
    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        String oldSinger = this.singer;
        this.singer = singer;
        propertyChangeSupport.firePropertyChange(PROP_SINGER, oldSinger, singer);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
    
}

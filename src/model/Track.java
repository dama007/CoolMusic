/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Track {

    private String trackname;
    private Artist artist;
    private Album album;
    private double duration;
    private double price;

    public Track() {

        trackname = "";
        artist = new Artist();
        album = new Album();
    }

    public static final String PROP_PRICE = "price";

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;
        propertyChangeSupport.firePropertyChange(PROP_PRICE, oldPrice, price);
    }

    public static final String PROP_DURATION = "duration";

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        double oldDuration = this.duration;
        this.duration = duration;
        propertyChangeSupport.firePropertyChange(PROP_DURATION, oldDuration, duration);
    }

    public static final String PROP_ALBUM = "album";

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        Album oldAlbum = this.album;
        this.album = album;
        propertyChangeSupport.firePropertyChange(PROP_ALBUM, oldAlbum, album);
    }

    public static final String PROP_ARTIST = "artist";

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        Artist oldArtist = this.artist;
        this.artist = artist;
        propertyChangeSupport.firePropertyChange(PROP_ARTIST, oldArtist, artist);
    }

    public static final String PROP_TRACKNAME = "trackname";

    public String getTrackname() {
        return trackname;
    }

    public void setTrackname(String trackname) {
        String oldTrackname = this.trackname;
        this.trackname = trackname;
        propertyChangeSupport.firePropertyChange(PROP_TRACKNAME, oldTrackname, trackname);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.trackname);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Track other = (Track) obj;
        if (!Objects.equals(this.trackname, other.trackname)) {
            return false;
        }
        return true;
    }

    
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}

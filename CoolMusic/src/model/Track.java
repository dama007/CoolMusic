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
public class Track {

    private String trackName;
    private Artist artist;
    private Album album;
    private double duracion;
    private double price;

    public Track() {

        trackName = "";
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

    public static final String PROP_DURACION = "duracion";

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        double oldDuracion = this.duracion;
        this.duracion = duracion;
        propertyChangeSupport.firePropertyChange(PROP_DURACION, oldDuracion, duracion);
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

    public static final String PROP_TRACKNAME = "trackName";

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        String oldTrackName = this.trackName;
        this.trackName = trackName;
        propertyChangeSupport.firePropertyChange(PROP_TRACKNAME, oldTrackName, trackName);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}

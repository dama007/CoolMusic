/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Album;
import model.Artist;
import model.Invoice;
import model.InvoiceList;
import model.Track;
import model.TrackList;
import model.User;

/**
 *
 * @author usu21
 */
public class TrackDAO {

    private Connection conexion;

    public double totalPrice (TrackList u){
    double total = 0;
        for (Track t : u.getList()) {
            total += t.getPrice();
        }
    return total;
    }
   
    public TrackList myInvoicetracks(Invoice in) throws MyException{
        conectar();
        if(conexion != null){
            try {                             
                String query = "SELECT invoicelines.trackname, track.price FROM invoicelines join track on invoicelines.trackname = track.trackname where invoicelines.invoicenum=1;";
                Statement st;
                st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Track mtr = new Track();
                    mtr.setTrackname(rs.getString("trackname"));
                    mtr.setPrice(rs.getDouble("price"));
                    in.getInvoiceTracks().insertTrack(mtr);
                }
            } catch (SQLException ex) {
                throw new MyException("Error al actualizar datos: "+ex.getLocalizedMessage());
              } finally {
                desconectar();
            }
        }
        return in.getInvoiceTracks();
    }
    
    
    

public TrackList selectAlltracks() throws MyException{
        TrackList trackList = new TrackList();
        conectar();
        if(conexion != null){
            try {
                String query = "SELECT * FROM track join artist join album on artist = singer and album = name;";
                Statement st;
                st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    Track p = new Track();
                    p.setTrackname(rs.getString("trackname"));
                    Artist a = new Artist();
                    a.setSinger(rs.getString("singer"));
                    a.setGenre(rs.getString("genre"));
                    p.setArtist(a);
                    p.setDuration(rs.getDouble("duration"));
                    Album l = new Album();
                    l.setName(rs.getString("name"));
                    l.setDate(rs.getInt("date"));
                    p.setAlbum(l);
                    p.setPrice(rs.getDouble("price"));
                    trackList.insertTrack(p);
                }
            } catch (SQLException ex) {
                throw new MyException("Error al actualizar datos: "+ex.getLocalizedMessage());
              } finally {
                desconectar();
            }
        }
        return trackList;
    }
    



    

    private void conectar() throws MyException {
        try {
            String url = "jdbc:mysql://localhost:3306/musica";
            String user = "root";
            String password = "jeveris";
            conexion = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {

            throw new MyException("Error al conectar " + ex.getLocalizedMessage());
        }

    }

    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al desconectar " + ex.getMessage());
        }
    }

}

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
import model.Invoice;
import model.Track;
import model.TrackList;
import model.User;

/**
 *
 * @author usu21
 */
public class InvoiceDAO {

    private Connection conexion;

    public void addFraComplete(Invoice invoice) throws MyException {
        // insertamos en la tabla invoice 
        insertInvoice(invoice);
        // Cogemos el nº de la fra que hemos insertado
        invoice.setInvoiceNum(getLastInvoiceNum());
        // Insertamos las canciones compradas en invoicelines
        insertInvoiceLines(invoice);
    }

    private void insertInvoiceLines(Invoice invoice) throws MyException {
        conectar();
        try {
            for (Track t : invoice.getInvoiceTracks().getList()) {
                String insert = "insert into invoicelines values (?,?)";
                PreparedStatement ps = conexion.prepareStatement(insert);
                ps.setInt(1, invoice.getInvoiceNum());
                ps.setString(2, t.getTrackname());
                ps.executeUpdate();
                ps.close();
            }

        } catch (SQLException ex) {
            throw new MyException("Error al insertar " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }

    public int getLastInvoiceNum() throws MyException {
        conectar();
        try {
            Invoice i = new Invoice();
            String query = "select invoicenum from invoice order by invoicenum desc limit 1";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            int a = 0;
            if (rs.next()) {
                a = rs.getInt("invoicenum");
            }
            rs.close();
            st.close();
            return a;
        } catch (SQLException ex) {
            throw new MyException("Error al consultar" + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }

    public void insertInvoice(Invoice invoice) throws MyException {
        conectar();
        try {
            String insert = "insert into invoice values (null,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, invoice.getClient().getUsername());
            ps.setDate(2, new java.sql.Date(invoice.getDate().getTime()));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new MyException("Error al insertar " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
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

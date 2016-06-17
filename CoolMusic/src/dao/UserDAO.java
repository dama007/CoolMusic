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
import model.User;

/**
 *
 * @author usu21
 */
public class UserDAO {

    private Connection conexion;

    public void updateUser (User user) throws MyException{
       
        conectar();
        try {            
            String update = "update user set name=?, surname=? where username=?;";
            PreparedStatement ps = conexion.prepareStatement(update);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getUsername());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            throw new MyException("Error al actualizar datos: "+ex.getLocalizedMessage());
        } finally{
        desconectar();
        }   
    }
    
    public User getUserByUsername(String username) throws MyException {

        conectar();
        try {
            String query = "select * from user where username='" + username + "';";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            User user = new User();
            if (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
            }
            rs.close();
            st.close();
            return user;
        } catch (SQLException ex) {
            throw new MyException("Error al consultar" + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }

    public boolean validateUser(String username, String password) throws MyException {

        conectar();
        try {
            String query = "select username, password from user where username=? and password=?;";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            boolean found = false;
            if (rs.next()) {
                found = true;
                return true;
            }
            rs.close();
            ps.close();
            return found;
        } catch (SQLException ex) {
            throw new MyException("Error al validad: " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
    }

    public void insertUser(User user) throws MyException {
        try {
            conectar();
            String insert = "insert into user values (?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(insert);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getSurname());
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

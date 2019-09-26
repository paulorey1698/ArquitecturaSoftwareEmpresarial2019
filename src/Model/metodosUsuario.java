/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class metodosUsuario {
    Conexion conexion;

    public metodosUsuario() {
        conexion = new Conexion();
    }

   
    
    public ArrayList<Usuario> login (String user, String pass){
        Connection conectar = null;
        PreparedStatement pst;
        ResultSet rs;
        Usuario usuario;
        ArrayList list = new ArrayList();
        
        try{
            conectar  = conexion.getConexion();
            if (conectar!=null){
                String sql = "Select User, Pass From usuarios Where User=? And Pass=?";
                pst=conectar.prepareStatement(sql);
                pst.setString(1, user);
                pst.setString(2, pass);
                rs=pst.executeQuery();
                while(rs.next()){
                    usuario = new Usuario();
                    usuario.setUser(rs.getString("User"));
                    usuario.setPassword(rs.getString("Pass"));
                    list.add(usuario);
                    
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }finally{
            try{
                conectar.close();
            }catch(Exception e){
                
            }
        }
        return list;
    }
    public boolean registrar(Usuario usr){
        PreparedStatement pst = null;
        Connection conectar = conexion.getConexion();
        String sql = "Insert into usuarios (id,Nombre,Apellido,User,Pass, email) values (?,?,?,?,?,?)";
        try{
            pst=conectar.prepareStatement(sql);
             pst.setInt(1, usr.getId());
            pst.setString(2, usr.getNombre());
            pst.setString(3, usr.getApellido());
            pst.setString(4, usr.getUser());
            pst.setString(5, usr.getPassword());
            pst.setString(6, usr.getEmail());
            pst.execute();
            return true;
        }catch(Exception e){
            System.err.print(e);
            return false;
        }finally{
            try{
                conectar.close();
            }catch(Exception e){
                System.err.print(e);
            }
        }
    }
    
    public boolean modificar(Usuario usr){
        PreparedStatement pst = null;
        Connection conectar = conexion.getConexion();
        String sql = "update usuarios set Pass=? where User=?";
        try{
            pst=conectar.prepareStatement(sql);
            
            pst.setString(1, usr.getPassword());
            pst.setString(2, usr.getUser());
            
            pst.execute();
            return true;
        }catch(Exception e){
            System.err.print(e);
            return false;
        }finally{
            try{
                conectar.close();
            }catch(Exception e){
                System.err.print(e);
            }
        }
    }
    
}

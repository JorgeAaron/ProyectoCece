/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.proyecto.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mx.itson.persistencia.Conexion;

/**
 *
 * @author QuickT
 */
public class Usuario {

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

   
    private int id;
    private String nombre;
    private String telefono;
    private String correo;
    private int tipo;
    private String contraseña;
    
    
    

   
    List<Usuario> usuarios = new ArrayList<>();
    public List<Usuario> ObtenerTodos() {
       
        try {
            Connection conx = Conexion.getConnection();
            Statement st = conx.createStatement();
            ResultSet rs = st.executeQuery("Select id, nombre, telefono, correo, tipo, contraseña from usuario");
            while(rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setTelefono(rs.getString(3));
                u.setCorreo(rs.getString(4));
                u.setTipo(rs.getInt(5));
                u.setContraseña(rs.getString(6));
                usuarios.add(u);
                      
               
            
            }
            conx.close();

            } catch(Exception e) {
                System.out.println(e);
}
        return usuarios;
       
        
        
       }
  
    public boolean guardar(String nombre, String telefono, String correo,  int tipo, String contraseña){

    boolean exito = false;

	try {

	Connection conx = Conexion.getConnection();
        
	String query = "INSERT INTO usuario (nombre, telefono, correo, tipo, contraseña) VALUES (?,?,?,?,? )";

PreparedStatement st = conx.prepareStatement(query);


st.setString(1, nombre);
st.setString(2, telefono);
st.setString(3, correo);
st.setInt(4, tipo);
st.setString(5, contraseña);
st.execute();
conx.close();
exito =true;


        }catch (Exception ex) {
System.out.println(ex);
        }
        
        return false;
}
    //Creamos un metodo que jala la contraseña cuando el ingresas el correo
    public String login(String correo){
            Usuario u = new Usuario();
try{
  
            Connection conx = Conexion.getConnection();
            Statement st = conx.createStatement();
            ResultSet rs = st.executeQuery("Select contraseña from usuario WHERE correo='"+correo+"'");
    while(rs.next()) {
        
             u.setContraseña(rs.getString(1));
             //Probamos que se almacena la contraseña
            System.out.println(u.getContraseña());
    }

}catch(Exception e){
System.out.println(e);


}return u.getContraseña();


}
        public int Tipo(String correo){
            Usuario u = new Usuario();
try{
  
            Connection conx = Conexion.getConnection();
            Statement st = conx.createStatement();
            ResultSet rs = st.executeQuery("Select tipo from usuario WHERE correo='"+correo+"'");
    while(rs.next()) {
        
             u.setTipo(rs.getInt(1));
             //Probamos que se almacena la contraseña
            System.out.println(u.getTipo());
    }

}catch(Exception e){
System.out.println(e);


}return u.getTipo();


}
    
    
    
}

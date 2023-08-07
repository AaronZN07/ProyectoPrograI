package Modelo;

import java.sql.*;

/**
 *
 * @author aaron
 */
public class Usuario {
    
    private String usuario;
    private String nombre;
    private String apellidos;
    private int idRol;
    
    public boolean iniciarSesion(String usuario, String password){
        Conexion connect = new Conexion();
        Connection conn = connect.conectar();
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            ps = conn.prepareStatement("SELECT nombre, apellidos, id_rol FROM usuarios "
                    + "WHERE usuario = ? AND contrasegna = ?");
            ps.setString(1, usuario);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            if(!rs.next()){
                return false;
            }
            
            this.usuario = usuario;
            this.nombre = rs.getString("nombre");
            this.apellidos = rs.getString("apellidos");
            this.idRol = rs.getInt("id_rol");
            
            return true;
        }catch(SQLException ex){
            System.out.println(ex);
            return false;
        }finally{
            connect.desconectar();
        }
    }
    
    public void cerrarSesion(){
        this.usuario = null;
        this.nombre = null;
        this.apellidos = null;
        this.idRol = 0;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre + " " + apellidos;
    }

    public int getIdRol() {
        return idRol;
    }

}

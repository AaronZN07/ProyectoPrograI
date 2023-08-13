package Modelo;

import java.sql.*;
import Vistas.Main;

/**
 *
 * @author aaron
 */
public class Usuario {
    
    private String usuario;
    private String nombre;
    private String apellidos;
    private String contrasegna;
    private int idRol;
    private boolean estado;

    public Usuario(String usuario, String nombre, String apellidos, String contrasegna, int idRol) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasegna = contrasegna;
        this.idRol = idRol;
        this.estado = true;
    }
    
    public Usuario(){
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters and setters">

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasegna() {
        return contrasegna;
    }

    public void setContrasegna(String contrasegna) {
        this.contrasegna = contrasegna;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    //</editor-fold>
}

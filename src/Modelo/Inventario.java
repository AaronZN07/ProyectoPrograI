package Modelo;

import java.util.Date;

/**
 *
 * @author aaron
 */
public class Inventario {
    final public static char INGRESO = 'I';
    final public static char SALIDA = 'S';
    private static int autoIncrement = 0;
    
    private int id;
    private char tipoInventario;
    private Date fechaRegistro;
    private int cantidad;
    private int idProducto;
    private int idAlmacen;
    private String usuarioRegistra;
    private boolean estado;

    public Inventario(char tipoInventario, Date fechaRegistro, int cantidad, int idProducto, int idAlmacen, String usuarioRegistra) {
        autoIncrement++;
        
        this.id = autoIncrement;
        this.tipoInventario = tipoInventario;
        this.fechaRegistro = fechaRegistro;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
        this.idAlmacen = idAlmacen;
        this.usuarioRegistra = usuarioRegistra;
        this.estado = tipoInventario == INGRESO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getTipoInventario() {
        return tipoInventario;
    }

    public void setTipoInventario(char tipoInventario) {
        this.tipoInventario = tipoInventario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getUsuarioRegistra() {
        return usuarioRegistra;
    }

    public void setUsuarioRegistra(String usuarioRegistra) {
        this.usuarioRegistra = usuarioRegistra;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}

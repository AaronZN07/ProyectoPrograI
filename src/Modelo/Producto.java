package Modelo;

import Vistas.Main;

/**
 *
 * @author aaron
 */
public class Producto {
    private static int autoIncrement = 0;
    
    private int id;
    private String nombre;
    private String marca;
    private int costo;
    private int idCategoria;
    private boolean estado;

    public Producto(String nombre, String marca, int costo,int idCategoria) {
        autoIncrement++;
        
        this.id = autoIncrement;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.idCategoria = idCategoria;
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String getStock(){
        int stock = 0;
        
        for(int i = 0; i < Main.listaInventario.size(); i++){
            if(Main.listaInventario.get(i).getIdProducto() == this.id){
                if(Main.listaInventario.get(i).getTipoInventario() == Inventario.INGRESO){
                    stock += Main.listaInventario.get(i).getCantidad();
                }else if(Main.listaInventario.get(i).getTipoInventario() == Inventario.SALIDA){
                    stock -= Main.listaInventario.get(i).getCantidad();
                }
            }
        }
        
        return stock + " unidades";
    }
}

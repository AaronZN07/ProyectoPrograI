package Modelo;

import Vistas.Main;

/**
 *
 * @author aaron
 */
public class Almacen {
    private static int autoIncrement = 0;
    
    private int id;
    private String ubicacion;
    private boolean estado;

    public Almacen(String ubicacion) {
        autoIncrement++;
        
        this.id = autoIncrement;
        this.ubicacion = ubicacion;
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
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
            if(Main.listaInventario.get(i).getIdAlmacen()== this.id){
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

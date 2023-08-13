
package Modelo;

/**
 *
 * @author aaron
 */
public class Categoria {
    private static int autoIncrement = 0;
    
    private int idCategoria;
    private String nombreCategoria;
    private boolean estado;

    public Categoria(String nombreCategoria) {
        autoIncrement++;
        
        this.idCategoria = autoIncrement;
        this.nombreCategoria = nombreCategoria;
        this.estado = true;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}

package Vistas;

import Modelo.Almacen;
import Modelo.Categoria;
import Modelo.Inventario;
import Modelo.Producto;
import Modelo.Rol;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author aaron
 */

public class Main {
    
    //Usuario
    public static Usuario usuario;
    
    //Listas
    public static ArrayList<Rol> listaRoles;
    public static ArrayList<Usuario> listaUsuarios;
    public static ArrayList<Categoria> listaCategorias;
    public static ArrayList<Producto> listaProductos;
    public static ArrayList<Almacen> listaAlmacenes;
    public static ArrayList<Inventario> listaInventario;
    
    public static void main(String[] args) {
        //Listas centralizadas
        listaRoles = new ArrayList<Rol>();
        listaUsuarios = new ArrayList<Usuario>();
        listaCategorias = new ArrayList<Categoria>();
        listaProductos = new ArrayList<Producto>();
        listaAlmacenes = new ArrayList<Almacen>();
        listaInventario = new ArrayList<Inventario>();
        
        //Generar registros
        generarRegistros();
        
        //Mostrar Login
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
    }
    
    private static void generarRegistros(){
        //Roles
        Rol administrador = new Rol(1, "Administrador");
        Rol encargadoAlmacen = new Rol(2, "Encargado Almacenes");
        
        listaRoles.add(administrador);
        listaRoles.add(encargadoAlmacen);
        
        //Usuarios
        Usuario admin = new Usuario("admin", "Administrador", "Administrador", "123", 1);
        Usuario encargado = new Usuario("encargado", "Encargado", "Encargado", "123", 2);
        
        listaUsuarios.add(admin);
        listaUsuarios.add(encargado);
        
        //Categorias
        Categoria hogar = new Categoria("Hogar");
        Categoria entretenimiento = new Categoria("Entretenimiento");
        Categoria ferreteria = new Categoria( "Ferreteria");
        
        listaCategorias.add(hogar);
        listaCategorias.add(entretenimiento);
        listaCategorias.add(ferreteria);
        
        //Productos
        Producto martillo = new Producto("Martillo", "Marca martillo", 10, 3);
        Producto segueta = new Producto("Segueta", "Marca segueta", 75, 3);
        Producto pala = new Producto("Pala", "Marca pala", 30, 3);
        Producto mueble = new Producto("Mueble", "Marca Mueble", 300, 1);
        
        listaProductos.add(martillo);
        listaProductos.add(segueta);
        listaProductos.add(pala);
        listaProductos.add(mueble);
        
        //Almacenes
        Almacen puntarenas = new Almacen("Puntarenas");
        Almacen heredia = new Almacen("Heredia");
        Almacen guanacaste = new Almacen("Guanacaste");
        
        listaAlmacenes.add(puntarenas);
        listaAlmacenes.add(heredia);
        listaAlmacenes.add(guanacaste);
    }
}

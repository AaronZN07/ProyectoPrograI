package Vistas;

import Modelo.Usuario;
import javax.swing.JFrame;

/**
 *
 * @author aaron
 */

public class Main {
    
    static Usuario usuario;
    
    public static void main(String[] args) {
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
    }
}

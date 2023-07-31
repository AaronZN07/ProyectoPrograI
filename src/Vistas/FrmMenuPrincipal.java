package Vistas;

import Modelo.Usuario;

/**
 *
 * @author aaron
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {
    
    public FrmMenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnbBarraMenu = new javax.swing.JMenuBar();
        mnuInventario = new javax.swing.JMenu();
        mniIngreso = new javax.swing.JMenuItem();
        mniSalida = new javax.swing.JMenuItem();
        mniMovimientos = new javax.swing.JMenuItem();
        mnuGestion = new javax.swing.JMenu();
        mniAlmacenes = new javax.swing.JMenuItem();
        mniArticulos = new javax.swing.JMenuItem();
        mnuConfig = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mniManual = new javax.swing.JMenuItem();
        mnuSistema = new javax.swing.JMenu();
        mniCerrarSesion = new javax.swing.JMenuItem();
        mniSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuInventario.setText("Inventario");

        mniIngreso.setText("Entrada de Inventario");
        mnuInventario.add(mniIngreso);

        mniSalida.setText("Salida de Inventario");
        mnuInventario.add(mniSalida);

        mniMovimientos.setText("Movimientos de Inventario");
        mnuInventario.add(mniMovimientos);

        mnbBarraMenu.add(mnuInventario);

        mnuGestion.setText("Gestión Almacenes");

        mniAlmacenes.setText("Almacenes");
        mnuGestion.add(mniAlmacenes);

        mniArticulos.setText("Articulos");
        mnuGestion.add(mniArticulos);

        mnbBarraMenu.add(mnuGestion);

        mnuConfig.setText("Configuracion");

        jMenuItem1.setText("Categorias");
        mnuConfig.add(jMenuItem1);

        jMenuItem2.setText("Usuarios");
        mnuConfig.add(jMenuItem2);

        mnbBarraMenu.add(mnuConfig);

        mnuAyuda.setText("Ayuda");

        mniManual.setText("Manual de Usuario");
        mnuAyuda.add(mniManual);

        mnbBarraMenu.add(mnuAyuda);

        mnuSistema.setText("Sistema");

        mniCerrarSesion.setText("Cerra sesión");
        mnuSistema.add(mniCerrarSesion);

        mniSalir.setText("Salir");
        mnuSistema.add(mniSalir);

        mnbBarraMenu.add(mnuSistema);

        setJMenuBar(mnbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar mnbBarraMenu;
    private javax.swing.JMenuItem mniAlmacenes;
    private javax.swing.JMenuItem mniArticulos;
    private javax.swing.JMenuItem mniCerrarSesion;
    private javax.swing.JMenuItem mniIngreso;
    private javax.swing.JMenuItem mniManual;
    private javax.swing.JMenuItem mniMovimientos;
    private javax.swing.JMenuItem mniSalida;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenu mnuConfig;
    private javax.swing.JMenu mnuGestion;
    private javax.swing.JMenu mnuInventario;
    private javax.swing.JMenu mnuSistema;
    // End of variables declaration//GEN-END:variables
}

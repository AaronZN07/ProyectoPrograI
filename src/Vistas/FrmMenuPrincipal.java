package Vistas;

import Vistas.Configuracion.IfrmCategorias;
import Vistas.Configuracion.IfrmUsuarios;
import Vistas.Gestion.IfrmAlmacenes;
import Vistas.Gestion.IfrmProductos;
import Vistas.Inventario.IfrmIngresos;
import Vistas.Inventario.IfrmMovimientos;
import Vistas.Inventario.IfrmSalidas;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author aaron
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {
    
    public FrmMenuPrincipal() {
        initComponents();
        
        Image icono = new ImageIcon(this.getClass().getResource("/Icono/inventario.png")).getImage();
        this.setIconImage(icono);
        
        if(Main.usuario.getIdRol() == 2){
            mniAlmacenes.setVisible(false);
            mniUsuarios.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dkpContenedor = new javax.swing.JDesktopPane();
        mnbBarraMenu = new javax.swing.JMenuBar();
        mnuInventario = new javax.swing.JMenu();
        mniIngreso = new javax.swing.JMenuItem();
        mniSalida = new javax.swing.JMenuItem();
        mniMovimientos = new javax.swing.JMenuItem();
        mnuGestion = new javax.swing.JMenu();
        mniAlmacenes = new javax.swing.JMenuItem();
        mniProductos = new javax.swing.JMenuItem();
        mnuConfig = new javax.swing.JMenu();
        mniCategorias = new javax.swing.JMenuItem();
        mniUsuarios = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mniManual = new javax.swing.JMenuItem();
        mnuSistema = new javax.swing.JMenu();
        mniCerrarSesion = new javax.swing.JMenuItem();
        mniSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Control de Inventario");

        javax.swing.GroupLayout dkpContenedorLayout = new javax.swing.GroupLayout(dkpContenedor);
        dkpContenedor.setLayout(dkpContenedorLayout);
        dkpContenedorLayout.setHorizontalGroup(
            dkpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        dkpContenedorLayout.setVerticalGroup(
            dkpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        mnuInventario.setText("Inventario");

        mniIngreso.setText("Ingreso de Inventario");
        mniIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniIngresoActionPerformed(evt);
            }
        });
        mnuInventario.add(mniIngreso);

        mniSalida.setText("Salida de Inventario");
        mniSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalidaActionPerformed(evt);
            }
        });
        mnuInventario.add(mniSalida);

        mniMovimientos.setText("Movimientos de Inventario");
        mniMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMovimientosActionPerformed(evt);
            }
        });
        mnuInventario.add(mniMovimientos);

        mnbBarraMenu.add(mnuInventario);

        mnuGestion.setText("Gestión Almacenes");

        mniAlmacenes.setText("Almacenes");
        mniAlmacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAlmacenesActionPerformed(evt);
            }
        });
        mnuGestion.add(mniAlmacenes);

        mniProductos.setText("Productos");
        mniProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProductosActionPerformed(evt);
            }
        });
        mnuGestion.add(mniProductos);

        mnbBarraMenu.add(mnuGestion);

        mnuConfig.setText("Configuracion");

        mniCategorias.setText("Categorias");
        mniCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCategoriasActionPerformed(evt);
            }
        });
        mnuConfig.add(mniCategorias);

        mniUsuarios.setText("Usuarios");
        mniUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUsuariosActionPerformed(evt);
            }
        });
        mnuConfig.add(mniUsuarios);

        mnbBarraMenu.add(mnuConfig);

        mnuAyuda.setText("Ayuda");

        mniManual.setText("Manual de Usuario");
        mniManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniManualActionPerformed(evt);
            }
        });
        mnuAyuda.add(mniManual);

        mnbBarraMenu.add(mnuAyuda);

        mnuSistema.setText("Sistema");

        mniCerrarSesion.setText("Cerra sesión");
        mniCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCerrarSesionActionPerformed(evt);
            }
        });
        mnuSistema.add(mniCerrarSesion);

        mniSalir.setText("Salir");
        mniSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSalirActionPerformed(evt);
            }
        });
        mnuSistema.add(mniSalir);

        mnbBarraMenu.add(mnuSistema);

        setJMenuBar(mnbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dkpContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dkpContenedor)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mniSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniSalirActionPerformed

    private void mniCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCerrarSesionActionPerformed
        Main.usuario = null;
        this.setVisible(false);
        
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
    }//GEN-LAST:event_mniCerrarSesionActionPerformed

    private void mniUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUsuariosActionPerformed
        IfrmUsuarios frame = new IfrmUsuarios();
        
        dkpContenedor.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_mniUsuariosActionPerformed

    private void mniCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCategoriasActionPerformed
        IfrmCategorias frame = new IfrmCategorias();
        
        dkpContenedor.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_mniCategoriasActionPerformed

    private void mniAlmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAlmacenesActionPerformed
        IfrmAlmacenes frame = new IfrmAlmacenes();
        
        dkpContenedor.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_mniAlmacenesActionPerformed

    private void mniProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProductosActionPerformed
        IfrmProductos frame = new IfrmProductos();
        
        dkpContenedor.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_mniProductosActionPerformed

    private void mniIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniIngresoActionPerformed
        IfrmIngresos frame = new IfrmIngresos();
        
        dkpContenedor.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_mniIngresoActionPerformed

    private void mniSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSalidaActionPerformed
        IfrmSalidas frame = new IfrmSalidas();
        
        dkpContenedor.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_mniSalidaActionPerformed

    private void mniMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniMovimientosActionPerformed
        IfrmMovimientos frame = new IfrmMovimientos();
        
        dkpContenedor.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_mniMovimientosActionPerformed

    private void mniManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniManualActionPerformed
        IfrmAyuda frame = new IfrmAyuda();
        
        dkpContenedor.add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_mniManualActionPerformed

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
    private javax.swing.JDesktopPane dkpContenedor;
    private javax.swing.JMenuBar mnbBarraMenu;
    private javax.swing.JMenuItem mniAlmacenes;
    private javax.swing.JMenuItem mniCategorias;
    private javax.swing.JMenuItem mniCerrarSesion;
    private javax.swing.JMenuItem mniIngreso;
    private javax.swing.JMenuItem mniManual;
    private javax.swing.JMenuItem mniMovimientos;
    private javax.swing.JMenuItem mniProductos;
    private javax.swing.JMenuItem mniSalida;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JMenuItem mniUsuarios;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenu mnuConfig;
    private javax.swing.JMenu mnuGestion;
    private javax.swing.JMenu mnuInventario;
    private javax.swing.JMenu mnuSistema;
    // End of variables declaration//GEN-END:variables
}

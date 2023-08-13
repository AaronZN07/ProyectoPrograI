package Vistas.Inventario;

import Modelo.Inventario;
import Vistas.Main;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author aaron
 */
public class IfrmSalidas extends javax.swing.JInternalFrame {

    public IfrmSalidas() {
        initComponents();
        
        cargarIngresos();
    }

    private void limpiar(){
        txtAlmacen.setText("");
        txtCantidad.setText("");
        txtProducto.setText("");
        cbxIngreso.setSelectedIndex(0);
    }
    
    private void cargarIngresos(){
        DefaultComboBoxModel comboIngresos = new DefaultComboBoxModel();
        
        for(Inventario ingresos : Main.listaInventario){
            if(!ingresos.isEstado()) continue;
            comboIngresos.addElement(ingresos.getId());
        }
        
        cbxIngreso.setModel(comboIngresos);
    }
    
    private void cargarDatosIngreso(){
        int idIngreso = (int) cbxIngreso.getSelectedItem();
        
        for(int i = 0; i < Main.listaInventario.size(); i++){
            if(Main.listaInventario.get(i).getId() == idIngreso){
                Inventario obtenerInventario = Main.listaInventario.get(i);
                
                txtProducto.setText(Main.listaProductos.get(obtenerInventario.getIdProducto()-1).getNombre());
                txtAlmacen.setText(Main.listaAlmacenes.get(obtenerInventario.getIdAlmacen()-1).getUbicacion());
                txtCantidad.setText((String.valueOf(obtenerInventario.getCantidad())));
            }
        }
    }
    
    private void salidaInventario(){
        int idIngreso = (int) cbxIngreso.getSelectedItem();
        
        for(int i = 0; i < Main.listaInventario.size(); i++){
            if(Main.listaInventario.get(i).getId() == idIngreso){
                Inventario obtenerInventario = Main.listaInventario.get(i);
                
                Inventario nuevoInventario = new Inventario(Inventario.SALIDA, new Date(), 
                        obtenerInventario.getCantidad(), obtenerInventario.getIdProducto(), 
                        obtenerInventario.getIdAlmacen(), Main.usuario.getUsuario());
                
                Main.listaInventario.add(nuevoInventario);
                obtenerInventario.setEstado(false);
            }
        }
        
        JOptionPane.showMessageDialog(null, "¡Se realizó la salida del inventario!");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIngresoo = new javax.swing.JLabel();
        cbxIngreso = new javax.swing.JComboBox<>();
        lblProducto = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblAlmacén = new javax.swing.JLabel();
        txtAlmacen = new javax.swing.JTextField();
        btnSalida = new javax.swing.JButton();

        setClosable(true);
        setTitle("Salida de inventario");

        lblIngresoo.setText("ID Ingreso:");

        cbxIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxIngresoActionPerformed(evt);
            }
        });

        lblProducto.setText("Producto:");

        txtProducto.setEditable(false);
        txtProducto.setFocusable(false);

        lblCantidad.setText("Cantidad:");

        txtCantidad.setEditable(false);
        txtCantidad.setFocusable(false);

        lblAlmacén.setText("Almacén:");

        txtAlmacen.setEditable(false);
        txtAlmacen.setFocusable(false);

        btnSalida.setText("Realizar Salida de Inventario");
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIngresoo)
                    .addComponent(lblProducto)
                    .addComponent(lblCantidad)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAlmacén)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalida)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbxIngreso, javax.swing.GroupLayout.Alignment.TRAILING, 0, 248, Short.MAX_VALUE)
                        .addComponent(txtAlmacen)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresoo)
                    .addComponent(cbxIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlmacén)
                    .addComponent(txtAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalida)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxIngresoActionPerformed
        cargarDatosIngreso();
    }//GEN-LAST:event_cbxIngresoActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
        salidaInventario();
        cargarIngresos();
        limpiar();
    }//GEN-LAST:event_btnSalidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalida;
    private javax.swing.JComboBox<String> cbxIngreso;
    private javax.swing.JLabel lblAlmacén;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblIngresoo;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JTextField txtAlmacen;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}

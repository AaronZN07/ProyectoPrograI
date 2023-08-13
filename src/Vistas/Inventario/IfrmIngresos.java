package Vistas.Inventario;

import Modelo.Almacen;
import Modelo.Inventario;
import Modelo.Producto;
import Vistas.Main;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author aaron
 */
public class IfrmIngresos extends javax.swing.JInternalFrame {

    public IfrmIngresos() {
        initComponents();
        
        cargarProductos();
        cargarAlmacenes();
    }

    private void limpiar(){
        spnCantidad.setValue(0);
        cbxAlmacen.setSelectedIndex(0);
        cbxProducto.setSelectedIndex(0);
    }
    
    private void cargarProductos(){
        DefaultComboBoxModel comboProductos = new DefaultComboBoxModel();
        for(Producto productos : Main.listaProductos){
            if(!productos.isEstado()) continue;
            comboProductos.addElement(productos.getNombre());
        }
        
        cbxProducto.setModel(comboProductos);
    }
    
    private void cargarAlmacenes(){
        DefaultComboBoxModel comboAlmacenes = new DefaultComboBoxModel();
        for (Almacen almacenes : Main.listaAlmacenes) {
            if(!almacenes.isEstado()) continue;
            comboAlmacenes.addElement(almacenes.getUbicacion());
        }
        
        cbxAlmacen.setModel(comboAlmacenes);
    }
    
    private void ingresoInventario(){
        int idProducto = 0;
        int cantidad = (int) spnCantidad.getValue();
        int idAlmacen = 0;
        
        for(int i = 0; i < Main.listaProductos.size(); i++){
            if(Main.listaProductos.get(i).getNombre().equals(cbxProducto.getSelectedItem())){
                idProducto = Main.listaProductos.get(i).getId();
            }
        }
        
        for(int i = 0; i < Main.listaAlmacenes.size(); i++){
            if(Main.listaAlmacenes.get(i).getUbicacion().equals(cbxAlmacen.getSelectedItem())){
                idAlmacen = Main.listaAlmacenes.get(i).getId();
            }
        }
        
        Inventario nuevoInventario = new Inventario(Inventario.INGRESO, new Date(), cantidad, idProducto, idAlmacen, Main.usuario.getUsuario());
        
        Main.listaInventario.add(nuevoInventario);
        
        JOptionPane.showMessageDialog(null, "¡Se realizó el ingreso del inventario!");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProducto = new javax.swing.JLabel();
        cbxProducto = new javax.swing.JComboBox<>();
        lblCantidad = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        lblAlmacen = new javax.swing.JLabel();
        cbxAlmacen = new javax.swing.JComboBox<>();
        btnIngreso = new javax.swing.JButton();

        setClosable(true);
        setTitle("Ingreso de Inventario");

        lblProducto.setText("Producto:");

        lblCantidad.setText("Cantidad:");

        lblAlmacen.setText("Almacén:");

        btnIngreso.setText("Realizar Ingreso de Inventario");
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnCantidad))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngreso)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(cbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidad)
                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlmacen)
                    .addComponent(cbxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIngreso)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed
        ingresoInventario();
        limpiar();
    }//GEN-LAST:event_btnIngresoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngreso;
    private javax.swing.JComboBox<String> cbxAlmacen;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JSpinner spnCantidad;
    // End of variables declaration//GEN-END:variables
}

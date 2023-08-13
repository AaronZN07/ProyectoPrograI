package Vistas.Gestion;

import Modelo.Almacen;
import Vistas.Main;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aaron
 */
public class IfrmAlmacenes extends javax.swing.JInternalFrame {

    DefaultTableModel tablaAlmacenes;
    
    public IfrmAlmacenes() {
        initComponents();
        
        iniciarTabla();
        cargarAlmacenes();
    }

    private void limpiar(){
        txtAlmacen.setText("");
    }
    
    private void iniciarTabla(){
        tablaAlmacenes = new DefaultTableModel();
        tablaAlmacenes.addColumn("ID");
        tablaAlmacenes.addColumn("Ubicación Almacén");
        tablaAlmacenes.addColumn("Stock Actual");
        tblAlmacenes.setModel(tablaAlmacenes);
    }
    
    private void cargarAlmacenes(){
        for(Almacen almacenes : Main.listaAlmacenes){
            if(!almacenes.isEstado()) continue;
            Object[] fila = {almacenes.getId(), almacenes.getUbicacion(), almacenes.getStock()};
            tablaAlmacenes.addRow(fila);
        }
    }
    
    private void crearAlmacen(){
        String almacen = txtAlmacen.getText();
        
        Almacen nuevoAlmacen = new Almacen(almacen);
        
        Main.listaAlmacenes.add(nuevoAlmacen);
        
        JOptionPane.showMessageDialog(null, "¡Almacén creado!");
    }
    
    private void editarAlmacen(){
        int fila = tblAlmacenes.getSelectedRow();
        int id = (int) tablaAlmacenes.getValueAt(fila, 0);
        
        if(txtAlmacen.equals("") && fila == -1){
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
            return;
        }
        
        for(int i = 0; i < Main.listaAlmacenes.size(); i++){
            if(Main.listaAlmacenes.get(i).getId()== id){
                Almacen obtenerAlmacen = Main.listaAlmacenes.get(i);
                
                obtenerAlmacen.setUbicacion(txtAlmacen.getText());
                
                JOptionPane.showMessageDialog(null, "¡Almacén actualizado!");
            }
        }
    }
    
    private void eliminarAlmacen(){
        int fila = tblAlmacenes.getSelectedRow();
        int id = (int) tablaAlmacenes.getValueAt(fila, 0);
        
        for(int i = 0; i < Main.listaAlmacenes.size(); i++){
            if(Main.listaAlmacenes.get(i).getId() == id){
                Almacen obtenerAlmacen = Main.listaAlmacenes.get(i);
                
                obtenerAlmacen.setEstado(false);
                
                JOptionPane.showMessageDialog(null, "¡Almacén eliminado!");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAlmacen = new javax.swing.JLabel();
        txtAlmacen = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        scpAlmacenes = new javax.swing.JScrollPane();
        tblAlmacenes = new javax.swing.JTable(){

            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        setClosable(true);
        setTitle("Almacenes");

        lblAlmacen.setText("Ubicación Almacén:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        tblAlmacenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAlmacenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlmacenesMouseClicked(evt);
            }
        });
        scpAlmacenes.setViewportView(tblAlmacenes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAlmacen))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpAlmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlmacen)
                    .addComponent(txtAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnBorrar)
                    .addComponent(btnEditar))
                .addGap(20, 20, 20)
                .addComponent(scpAlmacenes, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        crearAlmacen();
        iniciarTabla();
        cargarAlmacenes();
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarAlmacen();
        iniciarTabla();
        cargarAlmacenes();
        limpiar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminarAlmacen();
        iniciarTabla();
        cargarAlmacenes();
        limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tblAlmacenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlmacenesMouseClicked
        if(evt.getClickCount() != 2) return;
        limpiar();

        int fila = tblAlmacenes.getSelectedRow();
        int id = (int) tablaAlmacenes.getValueAt(fila, 0);

        for(int i = 0; i < Main.listaAlmacenes.size(); i++){
            if(Main.listaAlmacenes.get(i).getId() == id){
                Almacen obtenerCategoria = Main.listaAlmacenes.get(i);

                txtAlmacen.setText(obtenerCategoria.getUbicacion());
                
            }
        }
    }//GEN-LAST:event_tblAlmacenesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JScrollPane scpAlmacenes;
    private javax.swing.JTable tblAlmacenes;
    private javax.swing.JTextField txtAlmacen;
    // End of variables declaration//GEN-END:variables
}

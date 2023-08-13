
package Vistas.Configuracion;

import Modelo.Categoria;
import Vistas.Main;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aaron
 */
public class IfrmCategorias extends javax.swing.JInternalFrame {

    DefaultTableModel tablaCategorias;
    
    public IfrmCategorias() {
        initComponents();
        
        iniciarTabla();
        cargarCategorias();
    }

    private void limpiar(){
        txtCategoria.setText("");
    }

    private void iniciarTabla(){
        tablaCategorias = new DefaultTableModel();
        tablaCategorias.addColumn("ID");
        tablaCategorias.addColumn("Categoria");
        tblCategorias.setModel(tablaCategorias);
    }
    
    private void cargarCategorias(){
        for(Categoria categorias : Main.listaCategorias){
            if(!categorias.isEstado()) continue;
            Object[] fila = {categorias.getIdCategoria(), categorias.getNombreCategoria()};
            tablaCategorias.addRow(fila);
        }
    }
    
    private void crearCategoria(){
        String categoria = txtCategoria.getText();
        
        Categoria nuevaCategoria = new Categoria(categoria);
        
        Main.listaCategorias.add(nuevaCategoria);
        
        JOptionPane.showMessageDialog(null, "¡Categoria creada!");
    }
    
    private void editarCategoria(){
        int fila = tblCategorias.getSelectedRow();
        int id = (int) tablaCategorias.getValueAt(fila, 0);
        
        if(txtCategoria.equals("") && fila == -1){
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
            return;
        }
        
        for(int i = 0; i < Main.listaCategorias.size(); i++){
            if(Main.listaCategorias.get(i).getIdCategoria() == id){
                Categoria obtenerCategoria = Main.listaCategorias.get(i);
                
                obtenerCategoria.setNombreCategoria(txtCategoria.getText());
                
                JOptionPane.showMessageDialog(null, "¡Categoria actualizada!");
            }
        }
    }
    
    private void eliminarCategoria(){
        int fila = tblCategorias.getSelectedRow();
        int id = (int) tablaCategorias.getValueAt(fila, 0);
        
        for(int i = 0; i < Main.listaCategorias.size(); i++){
            if(Main.listaCategorias.get(i).getIdCategoria() == id){
                Categoria obtenerCategoria = Main.listaCategorias.get(i);
                
                obtenerCategoria.setEstado(false);
                
                JOptionPane.showMessageDialog(null, "¡Categoria eliminada!");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        scpCategorias = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable(){

            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        setClosable(true);
        setTitle("Categorias");

        lblCategoria.setText("Nombre de categoria:");

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

        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriasMouseClicked(evt);
            }
        });
        scpCategorias.setViewportView(tblCategorias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCategoria))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scpCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnBorrar)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        crearCategoria();
        iniciarTabla();
        cargarCategorias();
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarCategoria();
        iniciarTabla();
        cargarCategorias();
        limpiar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminarCategoria();
        iniciarTabla();
        cargarCategorias();
        limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tblCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriasMouseClicked
        if(evt.getClickCount() != 2) return;
        limpiar();
        
        int fila = tblCategorias.getSelectedRow();
        int id = (int) tablaCategorias.getValueAt(fila, 0);
        
        for(int i = 0; i < Main.listaCategorias.size(); i++){
            if(Main.listaCategorias.get(i).getIdCategoria() == id){
                Categoria obtenerCategoria = Main.listaCategorias.get(i);
                
                txtCategoria.setText(obtenerCategoria.getNombreCategoria());
            }
        }
    }//GEN-LAST:event_tblCategoriasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JScrollPane scpCategorias;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables
}

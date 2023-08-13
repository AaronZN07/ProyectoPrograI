package Vistas.Gestion;

import Modelo.Categoria;
import Modelo.Producto;
import Vistas.Main;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aaron
 */
public class IfrmProductos extends javax.swing.JInternalFrame {

    DefaultTableModel tablaProductos;

    public IfrmProductos() {
        initComponents();

        iniciarTabla();
        cargarProductos();
        cargarCategorias();
    }

    private void limpiar() {
        txtProducto.setText("");
        txtMarca.setText("");
        cbxCategoria.setSelectedIndex(0);
        spnCoste.setValue(0);
    }

    private void iniciarTabla() {
        tablaProductos = new DefaultTableModel();
        tablaProductos.addColumn("ID");
        tablaProductos.addColumn("Producto");
        tablaProductos.addColumn("Categoría");
        tablaProductos.addColumn("Coste");
        tablaProductos.addColumn("Marca");
        tablaProductos.addColumn("Stock");
        tblProductos.setModel(tablaProductos);
    }

    private void cargarProductos() {
        for (Producto productos : Main.listaProductos) {
            if (!productos.isEstado()) {
                continue;
            }
            Object[] fila = {
                productos.getId(),
                productos.getNombre(),
                Main.listaCategorias.get(productos.getIdCategoria() - 1).getNombreCategoria(),
                productos.getCosto(),
                productos.getMarca(),
                productos.getStock()
            };
            tablaProductos.addRow(fila);
        }
    }

    private void cargarCategorias() {
        DefaultComboBoxModel comboCategorias = new DefaultComboBoxModel();
        for (Categoria categoria : Main.listaCategorias) {
            comboCategorias.addElement(categoria.getNombreCategoria());
        }

        cbxCategoria.setModel(comboCategorias);
    }

    private void crearProducto() {
        String producto = txtProducto.getText();
        String marca = txtMarca.getText();
        int idCategoria = 0;
        int coste = (int) spnCoste.getValue();

        for (int i = 0; i < Main.listaCategorias.size(); i++) {
            if (Main.listaCategorias.get(i).getNombreCategoria().equals(cbxCategoria.getSelectedItem())) {
                idCategoria = Main.listaCategorias.get(i).getIdCategoria();
            }
        }

        Producto nuevoProducto = new Producto(producto, marca, coste, idCategoria);

        Main.listaProductos.add(nuevoProducto);

        JOptionPane.showMessageDialog(null, "¡Producto creado!");
    }

    private void editarProducto() {
        int fila = tblProductos.getSelectedRow();
        int id = (int) tablaProductos.getValueAt(fila, 0);

        if (txtProducto.equals("") && fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
            return;
        }

        for (int i = 0; i < Main.listaProductos.size(); i++) {
            if (Main.listaProductos.get(i).getId() == id) {
                Producto obtenerProducto = Main.listaProductos.get(i);
                int idCategoria = 0;
                
                for (int j = 0; j < Main.listaCategorias.size(); j++) {
                    if (Main.listaCategorias.get(j).getNombreCategoria().equals(cbxCategoria.getSelectedItem())) {
                        idCategoria = Main.listaCategorias.get(j).getIdCategoria();
                    }
                }

                obtenerProducto.setNombre(txtProducto.getText());
                obtenerProducto.setMarca(txtMarca.getText());
                obtenerProducto.setIdCategoria(idCategoria);
                obtenerProducto.setCosto((int) spnCoste.getValue());

                JOptionPane.showMessageDialog(null, "¡Producto actualizado!");
            }
        }
    }

    private void eliminarProducto() {
        int fila = tblProductos.getSelectedRow();
        int id = (int) tablaProductos.getValueAt(fila, 0);

        for (int i = 0; i < Main.listaProductos.size(); i++) {
            if (Main.listaProductos.get(i).getId() == id) {
                Producto obtenerProducto = Main.listaProductos.get(i);

                obtenerProducto.setEstado(false);

                JOptionPane.showMessageDialog(null, "¡Producto eliminado!");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProducto = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        lblCoste = new javax.swing.JLabel();
        spnCoste = new javax.swing.JSpinner();
        lblMarca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        scpProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable(){

            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Productos");

        lblProducto.setText("Producto:");

        lblCategoria.setText("Categoría:");

        lblCoste.setText("Coste:");

        lblMarca.setText("Marca:");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        scpProductos.setViewportView(tblProductos);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProducto)
                            .addComponent(lblCoste)
                            .addComponent(lblCategoria)
                            .addComponent(lblMarca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarca)
                            .addComponent(txtProducto)
                            .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnCoste)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCoste)
                    .addComponent(spnCoste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnBorrar)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addComponent(scpProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        if (evt.getClickCount() != 2) {
            return;
        }
        limpiar();

        int fila = tblProductos.getSelectedRow();
        int id = (int) tablaProductos.getValueAt(fila, 0);

        for (int i = 0; i < Main.listaProductos.size(); i++) {
            if (Main.listaProductos.get(i).getId() == id) {
                Producto obtenerProducto = Main.listaProductos.get(i);

                txtProducto.setText(obtenerProducto.getNombre());
                cbxCategoria.setSelectedIndex(obtenerProducto.getIdCategoria() - 1);
                spnCoste.setValue(obtenerProducto.getCosto());
                txtMarca.setText(obtenerProducto.getMarca());
            }
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        crearProducto();
        iniciarTabla();
        cargarProductos();
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarProducto();
        iniciarTabla();
        cargarProductos();
        limpiar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminarProducto();
        iniciarTabla();
        cargarProductos();
        limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCoste;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JScrollPane scpProductos;
    private javax.swing.JSpinner spnCoste;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}

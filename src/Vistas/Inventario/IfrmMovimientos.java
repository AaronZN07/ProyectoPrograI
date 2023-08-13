package Vistas.Inventario;

import Modelo.Almacen;
import Modelo.Categoria;
import Modelo.Inventario;
import Modelo.Producto;
import Vistas.Main;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aaron
 */
public class IfrmMovimientos extends javax.swing.JInternalFrame {

    DefaultTableModel tablaMovimientos;
    SimpleDateFormat sdf;
    ArrayList<Inventario> inventarioFiltrado;

    public IfrmMovimientos() {
        initComponents();

        iniciarTabla();
        cargarMovimientos();
    }

    private void limpiar() {
        txtBuscar.setText("");
        cbxFiltrar.setSelectedIndex(0);
    }

    private void iniciarTabla() {
        tablaMovimientos = new DefaultTableModel();
        tablaMovimientos.addColumn("ID");
        tablaMovimientos.addColumn("Tipo de Movimiento");
        tablaMovimientos.addColumn("Producto");
        tablaMovimientos.addColumn("Categoria");
        tablaMovimientos.addColumn("Cantidad");
        tablaMovimientos.addColumn("Almacén");
        tablaMovimientos.addColumn("Fecha de Movimiento");
        tablaMovimientos.addColumn("Usuario Registra");

        tblMovimientos.setModel(tablaMovimientos);
    }

    private void cargarMovimientosFiltrados() {
        String textoBuscar = txtBuscar.getText().trim().toLowerCase();
        String campoBuscar = String.valueOf(cbxFiltrar.getSelectedItem());

        switch (campoBuscar) {
            case "ID" ->
                inventarioFiltrado = (ArrayList<Inventario>) Main.listaInventario.stream()
                        .filter(movimiento -> String.valueOf(movimiento.getId()).equals(textoBuscar))
                        .collect(Collectors.toList());

            case "Tipo de Movimiento" ->
                inventarioFiltrado = (ArrayList<Inventario>) Main.listaInventario.stream()
                        .filter(movimiento
                                -> movimiento.getTipoInventario() == 'I' ? "ingreso".matches(".*" + textoBuscar + ".*") : "salida".matches(".*" + textoBuscar + ".*"))
                        .collect(Collectors.toList());

            case "Producto" ->
                inventarioFiltrado = (ArrayList<Inventario>) Main.listaInventario.stream()
                        .filter(movimiento
                                -> Main.listaProductos.get(movimiento.getIdProducto() - 1).getNombre().toLowerCase().matches(".*" + textoBuscar + ".*")
                        )
                        .collect(Collectors.toList());

            case "Categoria" ->
                inventarioFiltrado = (ArrayList<Inventario>) Main.listaInventario.stream()
                        .filter(movimiento
                                -> Main.listaCategorias.get(Main.listaProductos.get(movimiento.getIdProducto()-1).getIdCategoria()-1).getNombreCategoria()
                                        .toLowerCase().matches(".*" + textoBuscar + ".*")
                        )
                        .collect(Collectors.toList());

            case "Cantidad" ->
                inventarioFiltrado = (ArrayList<Inventario>) Main.listaInventario.stream()
                        .filter(movimiento -> String.valueOf(movimiento.getCantidad()).equals(textoBuscar))
                        .collect(Collectors.toList());

            case "Almacen" ->
                inventarioFiltrado = (ArrayList<Inventario>) Main.listaInventario.stream()
                        .filter(movimiento
                                -> Main.listaAlmacenes.get(movimiento.getIdAlmacen() - 1).getUbicacion().toLowerCase().matches(".*" + textoBuscar + ".*")
                        )
                        .collect(Collectors.toList());

            case "Usuario Registra" ->
                inventarioFiltrado = (ArrayList<Inventario>) Main.listaInventario.stream()
                        .filter(movimiento
                                -> movimiento.getUsuarioRegistra().toLowerCase().matches(".*" + textoBuscar + ".*")
                        )
                        .collect(Collectors.toList());
        }

        cargarDatos();
    }

    private void cargarMovimientos() {
        inventarioFiltrado = Main.listaInventario;
        cargarDatos();
    }

    private void cargarDatos() {
        iniciarTabla();
        for (Inventario movimientos : inventarioFiltrado) {
            sdf = new SimpleDateFormat("dd/MM/yyyy HH:MM");
            String fechaRegistro = sdf.format(movimientos.getFechaRegistro());

            Producto producto = Main.listaProductos.get(movimientos.getIdProducto() - 1);
            Categoria categoria = Main.listaCategorias.get(producto.getIdCategoria() - 1);
            Almacen almacen = Main.listaAlmacenes.get(movimientos.getIdAlmacen() - 1);

            Object[] fila = {
                movimientos.getId(),
                movimientos.getTipoInventario() == 'I' ? "Ingreso" : "Salida",
                producto.getNombre(),
                categoria.getNombreCategoria(),
                movimientos.getCantidad(),
                almacen.getUbicacion(),
                fechaRegistro,
                movimientos.getUsuarioRegistra()
            };

            tablaMovimientos.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFiltrar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cbxFiltrar = new javax.swing.JComboBox<>();
        scpMovimientos = new javax.swing.JScrollPane();
        tblMovimientos = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        btnRestablecer = new javax.swing.JButton();

        setClosable(true);
        setTitle("Movimientos de Inventario");

        lblFiltrar.setText("Filtrar Por");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Tipo de Movimiento", "Producto", "Categoria", "Cantidad", "Almacen", "Usuario Registra" }));

        tblMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scpMovimientos.setViewportView(tblMovimientos);

        btnRestablecer.setText("Restablecer");
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpMovimientos)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(btnRestablecer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(lblFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestablecer))
                .addGap(18, 18, 18)
                .addComponent(scpMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        limpiar();
        cargarMovimientos();
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cargarMovimientosFiltrados();
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JComboBox<String> cbxFiltrar;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JScrollPane scpMovimientos;
    private javax.swing.JTable tblMovimientos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}

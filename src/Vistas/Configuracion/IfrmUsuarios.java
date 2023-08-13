package Vistas.Configuracion;

import Modelo.Rol;
import Modelo.Usuario;
import Vistas.Main;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aaron
 */
public class IfrmUsuarios extends javax.swing.JInternalFrame {

    DefaultTableModel tablaUsuarios;
    
    public IfrmUsuarios() {
        initComponents();
        
        iniciarTabla();
        cargarUsuarios();
        cargarRoles();
    }

    private void limpiar(){
        txtNombre.setText("");
        txtApellidos.setText("");
        txtUsuario.setText("");
        pwdContrasegna.setText("");
        
    }
    
    private void iniciarTabla(){
        tablaUsuarios = new DefaultTableModel();
        tablaUsuarios.addColumn("Usuario");
        tablaUsuarios.addColumn("Nombre completo");
        tablaUsuarios.addColumn("Rol");
        tblUsuarios.setModel(tablaUsuarios);
    }
    
    private void cargarUsuarios(){
        for(Usuario usuario : Main.listaUsuarios){
            if(!usuario.isEstado()) continue;
            Object[] fila = {usuario.getUsuario(), usuario.getNombreCompleto(), Main.listaRoles.get(usuario.getIdRol()-1).getNombreRol()};
            tablaUsuarios.addRow(fila);
        }
    }
    
    private void cargarRoles(){
        DefaultComboBoxModel comboRoles = new DefaultComboBoxModel();
        for(Rol roles : Main.listaRoles){
            comboRoles.addElement(roles.getNombreRol());
        }
        
        cbxRol.setModel(comboRoles);
    }
    
    private void crearUsuario(){
        String usuario = txtUsuario.getText();
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String contrasegna = new String(pwdContrasegna.getPassword());
        int rol = cbxRol.getSelectedIndex() + 1;
        
        Usuario nuevoUsuario = new Usuario(usuario, nombre, apellidos, contrasegna, rol);
        
        Main.listaUsuarios.add(nuevoUsuario);
        
        JOptionPane.showMessageDialog(null, "¡Usuario creado!");
    }
    
    private void editarUsuario(){
        int fila = tblUsuarios.getSelectedRow();
        String usuario = (String) tablaUsuarios.getValueAt(fila, 0);
        String contrasegna = new String(pwdContrasegna.getPassword());
        
        if(txtNombre.equals("") && fila == -1){
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
            return;
        }
        
        for(int i = 0; i < Main.listaUsuarios.size(); i++){
            if(Main.listaUsuarios.get(i).getUsuario().equals(usuario)){
                Usuario obtenerUsuario = Main.listaUsuarios.get(i);
                
                obtenerUsuario.setUsuario(txtUsuario.getText());
                obtenerUsuario.setNombre(txtNombre.getText());
                obtenerUsuario.setApellidos(txtApellidos.getText());
                obtenerUsuario.setIdRol(cbxRol.getSelectedIndex()+1);
                
                if(!contrasegna.equals("")){
                    obtenerUsuario.setContrasegna(contrasegna);
                }
                
                JOptionPane.showMessageDialog(null, "¡Usuario actualizado!");
            }
        }
    }
    
    private void eliminarUsuario(){
        int fila = tblUsuarios.getSelectedRow();
        String usuario = (String) tablaUsuarios.getValueAt(fila, 0);
        
        for(int i = 0; i < Main.listaUsuarios.size(); i++){
            if(Main.listaUsuarios.get(i).getUsuario().equals(usuario)){
                Usuario obtenerUsuario = Main.listaUsuarios.get(i);
                
                obtenerUsuario.setEstado(false);
                
                JOptionPane.showMessageDialog(null, "¡Usuario eliminado!");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblContrasegna = new javax.swing.JLabel();
        pwdContrasegna = new javax.swing.JPasswordField();
        lblRol = new javax.swing.JLabel();
        cbxRol = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        scpUsuarios = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };

        setClosable(true);
        setTitle("Usuarios");

        lblUsuario.setText("Usuario:");

        lblNombre.setText("Nombre:");

        lblApellidos.setText("Apellidos:");

        lblContrasegna.setText("Contraseña:");

        lblRol.setText("Rol:");

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

        btnBorrar.setText("Inhabilitar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        scpUsuarios.setViewportView(tblUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblContrasegna)
                                .addComponent(lblApellidos)
                                .addComponent(lblNombre)
                                .addComponent(lblUsuario)
                                .addComponent(lblRol))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUsuario)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                .addComponent(pwdContrasegna)
                                .addComponent(cbxRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(84, 84, 84)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scpUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasegna)
                    .addComponent(pwdContrasegna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRol)
                    .addComponent(cbxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnBorrar)
                    .addComponent(btnEditar))
                .addGap(20, 20, 20)
                .addComponent(scpUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        crearUsuario();
        iniciarTabla();
        cargarUsuarios();
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarUsuario();
        iniciarTabla();
        cargarUsuarios();
        limpiar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminarUsuario();
        iniciarTabla();
        cargarUsuarios();
        limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        if(evt.getClickCount() != 2) return;
        limpiar();
        
        int fila = tblUsuarios.getSelectedRow();
        String usuario = (String) tablaUsuarios.getValueAt(fila, 0);
        
        for(int i = 0; i < Main.listaUsuarios.size(); i++){
            if(Main.listaUsuarios.get(i).getUsuario().equals(usuario)){
                Usuario obtenerUsuario = Main.listaUsuarios.get(i);
                
                txtUsuario.setText(obtenerUsuario.getUsuario());
                txtNombre.setText(obtenerUsuario.getNombre());
                txtApellidos.setText(obtenerUsuario.getApellidos());
                cbxRol.setSelectedIndex(obtenerUsuario.getIdRol()-1);
            }
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cbxRol;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblContrasegna;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pwdContrasegna;
    private javax.swing.JScrollPane scpUsuarios;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

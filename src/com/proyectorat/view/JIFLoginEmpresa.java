package com.proyectorat.view;

import com.proyectorat.manager.Preferences;
import com.proyectorat.manager.Temporal;
import com.proyectorat.manager.EmpresaManagerImpl;
import com.proyectorat.model.Empresa;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
/**
 *
 * @author mateo
 */
public class JIFLoginEmpresa extends javax.swing.JInternalFrame {

    EmpresaManagerImpl ne = new EmpresaManagerImpl();
    Empresa empresaVO = new Empresa();
    Temporal tmp;
    Preferences pref = new Preferences();
    
    public JIFLoginEmpresa() {
        try {
            this.tmp = new Temporal();
            tmp.tempFile.deleteOnExit();
        } catch (IOException ex) {
        }
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        btnIngreso = new javax.swing.JButton();
        ckbRemember = new javax.swing.JCheckBox();
        lblREmpresa = new javax.swing.JLabel();
        lblWebFeed = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1087, 643));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setBorder(null);
        txtID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtID.setOpaque(false);
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 210, 20));

        btnIngreso.setText("Ingresar");
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 100, 30));

        ckbRemember.setText("Iniciar automáticamente");
        ckbRemember.setBorder(null);
        ckbRemember.setOpaque(false);
        getContentPane().add(ckbRemember, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, -1, -1));

        lblREmpresa.setText("Registra una empresa");
        lblREmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblREmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblREmpresaMouseClicked(evt);
            }
        });
        getContentPane().add(lblREmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, -1, -1));

        lblWebFeed.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblWebFeed.setForeground(new java.awt.Color(255, 255, 255));
        lblWebFeed.setText("Visita nuestro sitio");
        lblWebFeed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(lblWebFeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/img/frmEmpresa.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1087, 643));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed

        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el ID de la empresa", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Integer idEmpresa = Integer.parseInt(txtID.getText());
            try {
                empresaVO = ne.getEmpresa(idEmpresa);
                if (empresaVO.getEstado().equals("Activo")) {

                    if (ckbRemember.isSelected()) {
                        pref.saveProp("Recordar empresa", "true");
                    } else {
                        pref.saveProp("Recordar empresa", "false");
                    }
                    try {
                        pref.saveProp("ID Empresa", empresaVO.getId_empresa());
                        tmp.saveTemp("ID Empresa", empresaVO.getId_empresa());
                        tmp.saveTemp("Nombre empresa", empresaVO.getNombre());
                    } catch (IOException ex) {
                    }
                    System.out.println("Inicia con la empresa "+ empresaVO.getId_empresa());
                    JIFLoginUsuario loginUsuario = new JIFLoginUsuario(empresaVO);
                    Main.jDesktopPane1.add(loginUsuario);
                    loginUsuario.toFront();
                    loginUsuario.setVisible(true);
                    dispose();
                } else if (empresaVO.getEstado().equals("Inactivo")) {
                    JOptionPane.showMessageDialog(null, "La empresa no ha sido verificada", "¡Verifique la empresa!", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "La empresa no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnIngresoActionPerformed

    private void lblREmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblREmpresaMouseClicked
        JIFRegistroEmpresa registroEmpresa = new JIFRegistroEmpresa();
        Main.jDesktopPane1.add(registroEmpresa);
        registroEmpresa.toFront();
        registroEmpresa.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblREmpresaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngreso;
    private javax.swing.JCheckBox ckbRemember;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblREmpresa;
    private javax.swing.JLabel lblWebFeed;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}

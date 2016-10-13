package com.proyectorat.gui;

import com.proyectorat.manager.Temporal;
import com.proyectorat.manager.Preferences;
import com.proyectorat.manager.EmpresaManagerImpl;
import com.proyectorat.manager.MD5;
import com.proyectorat.manager.UsuarioManagerImpl;
import com.proyectorat.model.Empresa;
import com.proyectorat.model.Usuario;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mateo
 */
public class FrmIngreso extends javax.swing.JFrame {
    
    UsuarioManagerImpl nu = new UsuarioManagerImpl();
    static EmpresaManagerImpl ne = new EmpresaManagerImpl();
    Usuario usuarioVO = new Usuario();
    static Empresa empresaVO = new Empresa();
    Preferences pref = new Preferences();
    Temporal tmp;

    public FrmIngreso(Empresa u) {
        try {
            this.tmp = new Temporal();
        } catch (IOException ex) {
            Logger.getLogger(FrmIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        if(empresaVO.getLogo()!=null) {
            lblLogo.setIcon(new ImageIcon(empresaVO.getLogo()));
        } else {
            lblLogo.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/RAT.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();
        lblUsu = new javax.swing.JLabel();
        txtUsu = new javax.swing.JTextField();
        lblCon = new javax.swing.JLabel();
        txtCon = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesión - "+ empresaVO.getNombre() +"    |    Proyecto RAT");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl1.setBackground(new java.awt.Color(189, 195, 199));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(44, 62, 80));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Iniciar sesión");

        lblChange.setText("Cambiar de empresa");
        lblChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChangeMouseClicked(evt);
            }
        });

        lblUsu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsu.setForeground(new java.awt.Color(44, 62, 80));
        lblUsu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsu.setText("Nombre de usuario");

        txtUsu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblCon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCon.setForeground(new java.awt.Color(44, 62, 80));
        lblCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCon.setText("Contraseña");

        txtCon.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnLogin.setText("Iniciar sesión");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblCon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblChange))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(txtUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addComponent(txtCon, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addGap(135, 135, 135))))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblUsu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lblChange)
                .addContainerGap())
        );

        getContentPane().add(pnl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 370, 280));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 320));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/img/home.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1087, 643));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangeMouseClicked
        pref.saveProp("Recordar empresa", "false");
        new FrmEmpresa().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_lblChangeMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        if("".equals(txtUsu.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de usuario", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        } if ("".equals(txtCon.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese la contraseña", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String usu = txtUsu.getText();
        String con = txtCon.getText();
        String conEncripted = MD5.encriptMD5(con);
        try {
            usuarioVO = nu.getUsuario(usu, Integer.parseInt(empresaVO.getId_empresa()));
            if(conEncripted.equals(usuarioVO.getClave())) {
                
            } else {
                JOptionPane.showMessageDialog(null, "Nombre de usuario y/o contraseña incorrecta.", "Error de credenciales", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException | HeadlessException e) {
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        
        empresaVO = ne.getEmpresa(1000);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmIngreso(empresaVO).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblCon;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsu;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPasswordField txtCon;
    private javax.swing.JTextField txtUsu;
    // End of variables declaration//GEN-END:variables
}

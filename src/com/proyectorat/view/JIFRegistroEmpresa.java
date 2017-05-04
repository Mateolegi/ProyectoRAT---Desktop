/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectorat.view;

import com.proyectorat.manager.EmpresaManagerImpl;
import com.proyectorat.manager.MD5;
import com.proyectorat.manager.UsuarioManagerImpl;
import com.proyectorat.model.Empresa;
import com.proyectorat.model.Usuario;
import java.awt.Image;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author mateo
 */
public class JIFRegistroEmpresa extends javax.swing.JInternalFrame {

    EmpresaManagerImpl ne = new EmpresaManagerImpl();
    UsuarioManagerImpl nu = new UsuarioManagerImpl();
    Empresa empresaVO = new Empresa();
    Usuario usuarioVO = new Usuario();

    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PNG", "png");
    private Image logo = null;

    public JIFRegistroEmpresa() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    public boolean validarEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fchLogo = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNomE = new javax.swing.JTextField();
        lblNomE = new javax.swing.JLabel();
        txtLogE = new javax.swing.JTextField();
        lblLogE = new javax.swing.JLabel();
        lblSub1 = new javax.swing.JLabel();
        lblSub2 = new javax.swing.JLabel();
        lblUsuU = new javax.swing.JLabel();
        txtUsuU = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblNomU = new javax.swing.JLabel();
        txtNomU = new javax.swing.JTextField();
        lblConU = new javax.swing.JLabel();
        txtCarU = new javax.swing.JTextField();
        lblCarU = new javax.swing.JLabel();
        txtCorU = new javax.swing.JTextField();
        lblCorU = new javax.swing.JLabel();
        btnLogE = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblMen1 = new javax.swing.JLabel();
        lblMen2 = new javax.swing.JLabel();
        lblLogEVP = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtConU = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        fchLogo.setFileFilter(filter);

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(189, 195, 199));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(44, 62, 80));
        lblTitulo.setText("REGISTRA UNA EMPRESA");

        jSeparator1.setForeground(new java.awt.Color(127, 140, 141));

        lblNomE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomE.setForeground(new java.awt.Color(44, 62, 80));
        lblNomE.setText("Nombre de la empresa *");

        txtLogE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLogEFocusLost(evt);
            }
        });

        lblLogE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLogE.setForeground(new java.awt.Color(44, 62, 80));
        lblLogE.setText("Logo de la empresa");

        lblSub1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSub1.setForeground(new java.awt.Color(44, 62, 80));
        lblSub1.setText("DATOS DE LA EMPRESA");

        lblSub2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSub2.setForeground(new java.awt.Color(44, 62, 80));
        lblSub2.setText("DATOS DEL ADMINISTRADOR");

        lblUsuU.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuU.setForeground(new java.awt.Color(44, 62, 80));
        lblUsuU.setText("Nombre de usuario *");

        jSeparator2.setForeground(new java.awt.Color(127, 140, 141));

        lblNomU.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomU.setForeground(new java.awt.Color(44, 62, 80));
        lblNomU.setText("Nombre y apellido   *");

        lblConU.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblConU.setForeground(new java.awt.Color(44, 62, 80));
        lblConU.setText("Contraseña             *");

        txtCarU.setEditable(false);
        txtCarU.setText("Administrador");

        lblCarU.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCarU.setForeground(new java.awt.Color(44, 62, 80));
        lblCarU.setText("Perfil                      *");

        lblCorU.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCorU.setForeground(new java.awt.Color(44, 62, 80));
        lblCorU.setText("Correo electrónico *");

        btnLogE.setText("Buscar");
        btnLogE.setBorder(null);
        btnLogE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogEActionPerformed(evt);
            }
        });

        btnClean.setText("Limpiar campos");
        btnClean.setBorder(null);
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnCreate.setText("Registrar");
        btnCreate.setBorder(null);
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnBack.setText("Atrás");
        btnBack.setBorder(null);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblMen1.setText("El código de la empresa le será dado cuando sea registrada.");

        lblMen2.setText("Los campos marcados con * son obligatorios.");

        lblLogEVP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Vista previa del logo");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 605, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(lblTitulo))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(328, 328, 328)
                            .addComponent(lblSub2)
                            .addGap(289, 289, 289))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblNomU)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNomU, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblUsuU)
                                    .addGap(59, 59, 59)
                                    .addComponent(txtUsuU, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblConU)
                                    .addGap(59, 59, 59)
                                    .addComponent(txtConU, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(68, 68, 68)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblCarU)
                                    .addGap(59, 59, 59)
                                    .addComponent(txtCarU, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblCorU)
                                    .addGap(59, 59, 59)
                                    .addComponent(txtCorU, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMen2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(406, 406, 406)
                                    .addComponent(lblSub1)
                                    .addGap(56, 56, 56))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNomE)
                                        .addComponent(lblLogE))
                                    .addGap(38, 38, 38)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNomE, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtLogE, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnLogE, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblMen1)
                                .addGap(357, 357, 357)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblLogEVP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSub1)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomE)
                            .addComponent(txtNomE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLogE)
                            .addComponent(txtLogE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogE, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(lblMen1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblLogEVP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSub2)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuU)
                    .addComponent(txtUsuU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarU)
                    .addComponent(txtCarU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomU)
                    .addComponent(txtNomU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorU)
                    .addComponent(txtCorU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConU)
                    .addComponent(txtConU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMen2)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 1010, 620));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/img/home.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1087, 643));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogEActionPerformed
        int seleccion = fchLogo.showOpenDialog(jPanel1);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File file = fchLogo.getSelectedFile();
            String path = file.getAbsolutePath();
            txtLogE.setText(path);
            ImageIcon icon = new ImageIcon(path);
            logo = icon.getImage();
            Image newimg = logo.getScaledInstance(300, 150, java.awt.Image.SCALE_AREA_AVERAGING);
            ImageIcon newImgIcon = new ImageIcon(newimg);
            lblLogEVP.setIcon(newImgIcon);

        }
    }//GEN-LAST:event_btnLogEActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        txtNomE.setText("");
        txtLogE.setText("");
        txtUsuU.setText("");
        txtNomU.setText("");
        txtConU.setText("");
        txtCorU.setText("");
        lblLogEVP.setIcon(null);
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        //Empresa
        String nomE = txtNomE.getText();
        String logE = txtLogE.getText();
        //Usuario
        String usuU = txtUsuU.getText();
        String nomU = txtNomU.getText();
        String conU = txtConU.getText();
        String corU = txtCorU.getText();
        if (!validarEmail(corU)) {
            JOptionPane.showMessageDialog(null, "Correo electrónico inválido", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        String conUEncripted = MD5.encriptMD5(conU);

        try {
            String id = ne.getCons();
            empresaVO.setId_empresa(id);
            empresaVO.setNombre(nomE);
            empresaVO.setLogo(logo);
            empresaVO.setEstado("Activo");

            ne.getGuardarEmpresa(empresaVO);

            usuarioVO.setUsuario(usuU);
            usuarioVO.setNombre(nomU);
            usuarioVO.setClave(conUEncripted);
            usuarioVO.setPerfil("Administrador");
            usuarioVO.setEmail(corU);
            usuarioVO.setEstado("Activo");
            usuarioVO.setEmpresa(empresaVO.getId_empresa());
            nu.getGuardarUsuario(usuarioVO);

            JOptionPane.showMessageDialog(null, "El código de su empresa es " + id + ".\nGuárdelo en un lugar donde lo recuerde.", "Código de la empresa", JOptionPane.INFORMATION_MESSAGE);

            JIFLoginEmpresa loginEmpresa = new JIFLoginEmpresa();
            Main.jDesktopPane1.add(loginEmpresa);
            loginEmpresa.toFront();
            loginEmpresa.setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e + "\n" + empresaVO.getId_empresa() + "\n" + ne.getCons(), "Error", JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        JIFLoginEmpresa loginEmpresa = new JIFLoginEmpresa();
        Main.jDesktopPane1.add(loginEmpresa);
        loginEmpresa.toFront();
        loginEmpresa.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtLogEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLogEFocusLost
        String path = txtLogE.getText();
        ImageIcon icon = new ImageIcon(path);
        logo = icon.getImage();
        Image newimg = logo.getScaledInstance(300, 150, java.awt.Image.SCALE_AREA_AVERAGING);
        ImageIcon newImgIcon = new ImageIcon(newimg);
        lblLogEVP.setIcon(newImgIcon);
    }//GEN-LAST:event_txtLogEFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnLogE;
    private javax.swing.JFileChooser fchLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCarU;
    private javax.swing.JLabel lblConU;
    private javax.swing.JLabel lblCorU;
    private javax.swing.JLabel lblLogE;
    private javax.swing.JLabel lblLogEVP;
    private javax.swing.JLabel lblMen1;
    private javax.swing.JLabel lblMen2;
    private javax.swing.JLabel lblNomE;
    private javax.swing.JLabel lblNomU;
    private javax.swing.JLabel lblSub1;
    private javax.swing.JLabel lblSub2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuU;
    private javax.swing.JTextField txtCarU;
    private javax.swing.JPasswordField txtConU;
    private javax.swing.JTextField txtCorU;
    private javax.swing.JTextField txtLogE;
    private javax.swing.JTextField txtNomE;
    private javax.swing.JTextField txtNomU;
    private javax.swing.JTextField txtUsuU;
    // End of variables declaration//GEN-END:variables
}

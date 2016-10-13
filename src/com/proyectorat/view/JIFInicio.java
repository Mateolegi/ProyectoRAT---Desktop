/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectorat.view;

import com.proyectorat.manager.EmpresaManagerImpl;
import com.proyectorat.manager.Preferences;
import com.proyectorat.manager.UsuarioManagerImpl;
import com.proyectorat.model.Empresa;
import com.proyectorat.model.Usuario;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author mateo
 */
public class JIFInicio extends javax.swing.JInternalFrame {

    UsuarioManagerImpl nu = new UsuarioManagerImpl();
    EmpresaManagerImpl ne = new EmpresaManagerImpl();
    Usuario usuarioVO = new Usuario();
    Empresa empresaVO = new Empresa();
    Preferences pref = new Preferences();

    ImageIcon IIRAT = new ImageIcon(getClass().getResource("/com/resources/img/favicon.png"));
    Image IRAT = IIRAT.getImage();
    Image IScaledRAT = IRAT.getScaledInstance(55, 55, java.awt.Image.SCALE_AREA_AVERAGING);
    ImageIcon IIScaledRAT = new ImageIcon(IScaledRAT);

    Image IScaledLogoE;
    ImageIcon IIScaledLogoE;
    JIFInicioAdmin inicioAdmin = new JIFInicioAdmin(empresaVO, usuarioVO);

    public JIFInicio(Empresa empresaVO, Usuario usuarioVO) {

        this.empresaVO.setId_empresa(empresaVO.getId_empresa());
        this.empresaVO.setNombre(empresaVO.getNombre());
        this.empresaVO.setLogo(empresaVO.getLogo());
        this.empresaVO.setEstado(empresaVO.getEstado());

        this.usuarioVO.setUsuario(usuarioVO.getUsuario());
        this.usuarioVO.setNombre(usuarioVO.getNombre());
        this.usuarioVO.setClave(usuarioVO.getClave());
        this.usuarioVO.setEmail(usuarioVO.getEmail());
        this.usuarioVO.setPerfil(usuarioVO.getPerfil());
        this.usuarioVO.setEmpresa(usuarioVO.getEmpresa());
        this.usuarioVO.setEstado(usuarioVO.getEstado());

        IScaledLogoE = empresaVO.getLogo().getScaledInstance(180, 110, java.awt.Image.SCALE_AREA_AVERAGING);
        IIScaledLogoE = new ImageIcon(IScaledLogoE);
        
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
        pnlMenu.setBackground(colorPanel());
    }

    private Color colorPanel() {
        String color = pref.getProp("Color panel");
        Color colorR = new Color(41, 128, 185);
        if (color != null) {
            switch (color) {
                case "Belize Hole":
                    colorR = new Color(41, 128, 185);
                    break;
                case "Green Sea":
                    colorR = new Color(22, 160, 133);
                    break;
                case "Nephritis":
                    colorR = new Color(39, 174, 96);
                    break;
                case "Wisteria":
                    colorR = new Color(142, 68, 173);
                    break;
                case "Orange":
                    colorR = new Color(243, 156, 18);
                    break;
                case "Pumpkin":
                    colorR = new Color(211, 84, 0);
                    break;
                case "Pomegranate":
                    colorR = new Color(192, 57, 43);
                    break;
                default:
                    colorR = new Color(41, 128, 185);
                    break;
            }
        }
        return colorR;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        lblLogoE = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblHome = new javax.swing.JLabel();
        lblSettings = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        btnEyS = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        lblUser = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        btnAsignacion = new javax.swing.JButton();
        pnlSuperior = new javax.swing.JPanel();
        lblRAT = new javax.swing.JLabel();
        JDP2 = new javax.swing.JDesktopPane();

        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(41, 128, 185));

        jSeparator1.setBackground(new java.awt.Color(52, 73, 94));
        jSeparator1.setForeground(new java.awt.Color(44, 62, 80));

        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/img/buttons/home.png"))); // NOI18N
        lblHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });

        lblSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/img/buttons/settings.png"))); // NOI18N
        lblSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSettingsMouseClicked(evt);
            }
        });

        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/img/buttons/logout.png"))); // NOI18N
        lblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        btnEyS.setText("Entradas y salidas");
        btnEyS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEySActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(52, 73, 94));
        jSeparator3.setForeground(new java.awt.Color(44, 62, 80));

        jSeparator4.setBackground(new java.awt.Color(52, 73, 94));
        jSeparator4.setForeground(new java.awt.Color(44, 62, 80));

        lblUser.setForeground(new java.awt.Color(44, 62, 80));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText(usuarioVO.getNombre());

        lblPerfil.setForeground(new java.awt.Color(44, 62, 80));
        lblPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerfil.setText(usuarioVO.getPerfil());

        btnAsignacion.setText("Asignación de actividades");
        btnAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogoE, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEyS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(btnAsignacion, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(lblLogoE, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEyS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307))
        );

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 643));

        pnlSuperior.setBackground(new java.awt.Color(127, 140, 141));

        lblRAT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRAT.setIcon(IIScaledRAT);

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSuperiorLayout.createSequentialGroup()
                .addGap(0, 847, Short.MAX_VALUE)
                .addComponent(lblRAT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRAT, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        getContentPane().add(pnlSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 907, 60));

        javax.swing.GroupLayout JDP2Layout = new javax.swing.GroupLayout(JDP2);
        JDP2.setLayout(JDP2Layout);
        JDP2Layout.setHorizontalGroup(
            JDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
        );
        JDP2Layout.setVerticalGroup(
            JDP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        getContentPane().add(JDP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 907, 583));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        JIFHomeAdmin home = new JIFHomeAdmin();
        JDP2.removeAll();
        JDP2.add(home);
        home.toFront();
        home.setVisible(true);
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSettingsMouseClicked
        JIFPropiedades settings = new JIFPropiedades();
        JDP2.removeAll();
        JDP2.add(settings);
        settings.toFront();
        settings.setVisible(true);
    }//GEN-LAST:event_lblSettingsMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        JIFLoginUsuario loginUsuario = new JIFLoginUsuario(empresaVO);
        JDP2.removeAll();
        loginUsuario.toFront();
        loginUsuario.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void btnEySActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEySActionPerformed
        JIFRegistroEntrada registroEntrada = new JIFRegistroEntrada();
        JDP2.removeAll();
        JDP2.add(registroEntrada);
        registroEntrada.toFront();
        registroEntrada.setVisible(true);
    }//GEN-LAST:event_btnEySActionPerformed

    private void btnAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignacionActionPerformed
        JIFRegistroActividad registroActividad = new JIFRegistroActividad();
        JDP2.removeAll();
        JDP2.add(registroActividad);
        registroActividad.toFront();
        registroActividad.setVisible(true);
    }//GEN-LAST:event_btnAsignacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDP2;
    private javax.swing.JButton btnAsignacion;
    private javax.swing.JButton btnEyS;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblLogoE;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblRAT;
    private javax.swing.JLabel lblSettings;
    private javax.swing.JLabel lblUser;
    public static javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlSuperior;
    // End of variables declaration//GEN-END:variables
}

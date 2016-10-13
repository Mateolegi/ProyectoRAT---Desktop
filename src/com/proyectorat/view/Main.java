package com.proyectorat.view;

import com.proyectorat.manager.Preferences;
import com.proyectorat.manager.EmpresaManagerImpl;
import com.proyectorat.model.Empresa;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Main extends javax.swing.JFrame {

    Preferences pref = new Preferences();
    JIFLoginEmpresa loginEmpresa = new JIFLoginEmpresa();
    EmpresaManagerImpl ne = new EmpresaManagerImpl();
    Empresa empresaVO;

    public Main() {
        initComponents();
        loginEmpresa.show();
        jDesktopPane1.add(loginEmpresa);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/resources/img/favicon.png"));
        Image logo = icon.getImage();
        Image newimg = logo.getScaledInstance(48, 48, java.awt.Image.SCALE_AREA_AVERAGING);
        ImageIcon newImgIcon = new ImageIcon(newimg);
        setIconImage(newimg);
        setLocationRelativeTo(null);

        if ("true".equals(pref.getProp("Recordar empresa"))) {
            try {
                empresaVO = ne.getEmpresa(Integer.parseInt(pref.getProp("ID Empresa")));
                JIFLoginUsuario loginUsuario = new JIFLoginUsuario(empresaVO);
                jDesktopPane1.add(loginUsuario);
                loginUsuario.toFront();
                loginUsuario.setVisible(true);
                loginEmpresa.dispose();
            } catch (Exception e) {
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1087, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane1;
    // End of variables declaration//GEN-END:variables
}

package com.proyectorat.view;

import com.proyectorat.manager.Preferences;
import javax.swing.plaf.basic.BasicInternalFrameUI;
/**
 *
 * @author mateo
 */
public class JIFHomeAdmin extends javax.swing.JInternalFrame {

    Preferences pref = new Preferences();
    
    public JIFHomeAdmin() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(907, 583));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
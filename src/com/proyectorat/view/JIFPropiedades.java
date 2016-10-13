package com.proyectorat.view;

import com.proyectorat.manager.Preferences;
import java.awt.Color;
import javax.swing.plaf.basic.BasicInternalFrameUI;
/**
 *
 * @author mateo
 */
public class JIFPropiedades extends javax.swing.JInternalFrame {

    Preferences pref = new Preferences();
    
    public JIFPropiedades() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        pnlColor1 = new javax.swing.JPanel();
        pnlColor2 = new javax.swing.JPanel();
        pnlColor3 = new javax.swing.JPanel();
        pnlColor4 = new javax.swing.JPanel();
        pnlColor5 = new javax.swing.JPanel();
        pnlColor6 = new javax.swing.JPanel();
        pnlColor7 = new javax.swing.JPanel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(907, 583));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Color del panel");

        pnlColor1.setBackground(new java.awt.Color(41, 128, 185));
        pnlColor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlColor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlColor1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlColor1Layout = new javax.swing.GroupLayout(pnlColor1);
        pnlColor1.setLayout(pnlColor1Layout);
        pnlColor1Layout.setHorizontalGroup(
            pnlColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlColor1Layout.setVerticalGroup(
            pnlColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlColor2.setBackground(new java.awt.Color(22, 160, 133));
        pnlColor2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlColor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlColor2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlColor2Layout = new javax.swing.GroupLayout(pnlColor2);
        pnlColor2.setLayout(pnlColor2Layout);
        pnlColor2Layout.setHorizontalGroup(
            pnlColor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlColor2Layout.setVerticalGroup(
            pnlColor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlColor3.setBackground(new java.awt.Color(39, 174, 96));
        pnlColor3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlColor3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlColor3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlColor3Layout = new javax.swing.GroupLayout(pnlColor3);
        pnlColor3.setLayout(pnlColor3Layout);
        pnlColor3Layout.setHorizontalGroup(
            pnlColor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlColor3Layout.setVerticalGroup(
            pnlColor3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlColor4.setBackground(new java.awt.Color(142, 68, 173));
        pnlColor4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlColor4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlColor4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlColor4Layout = new javax.swing.GroupLayout(pnlColor4);
        pnlColor4.setLayout(pnlColor4Layout);
        pnlColor4Layout.setHorizontalGroup(
            pnlColor4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlColor4Layout.setVerticalGroup(
            pnlColor4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlColor5.setBackground(new java.awt.Color(243, 156, 18));
        pnlColor5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlColor5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlColor5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlColor5Layout = new javax.swing.GroupLayout(pnlColor5);
        pnlColor5.setLayout(pnlColor5Layout);
        pnlColor5Layout.setHorizontalGroup(
            pnlColor5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlColor5Layout.setVerticalGroup(
            pnlColor5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlColor6.setBackground(new java.awt.Color(211, 84, 0));
        pnlColor6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlColor6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlColor6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlColor6Layout = new javax.swing.GroupLayout(pnlColor6);
        pnlColor6.setLayout(pnlColor6Layout);
        pnlColor6Layout.setHorizontalGroup(
            pnlColor6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlColor6Layout.setVerticalGroup(
            pnlColor6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlColor7.setBackground(new java.awt.Color(192, 57, 43));
        pnlColor7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlColor7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlColor7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlColor7Layout = new javax.swing.GroupLayout(pnlColor7);
        pnlColor7.setLayout(pnlColor7Layout);
        pnlColor7Layout.setHorizontalGroup(
            pnlColor7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlColor7Layout.setVerticalGroup(
            pnlColor7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addComponent(pnlColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlColor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlColor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlColor4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlColor5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlColor6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlColor7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlColor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlColor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlColor4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlColor6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlColor5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlColor7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlColor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlColor1MouseClicked
        
        pref.saveProp("Color panel", "Belize Hole");
        JIFInicioAdmin.pnlMenu.setBackground(new Color(41, 128, 185));
    }//GEN-LAST:event_pnlColor1MouseClicked

    private void pnlColor2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlColor2MouseClicked
        pref.saveProp("Color panel", "Green Sea");
        JIFInicioAdmin.pnlMenu.setBackground(new Color(22, 160, 133));
    }//GEN-LAST:event_pnlColor2MouseClicked

    private void pnlColor3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlColor3MouseClicked
        pref.saveProp("Color panel", "Nephritis");
        JIFInicioAdmin.pnlMenu.setBackground(new Color(39, 174, 96));
    }//GEN-LAST:event_pnlColor3MouseClicked

    private void pnlColor4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlColor4MouseClicked
        pref.saveProp("Color panel", "Wisteria");
        JIFInicioAdmin.pnlMenu.setBackground(new Color(142, 68, 173));
    }//GEN-LAST:event_pnlColor4MouseClicked

    private void pnlColor5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlColor5MouseClicked
        pref.saveProp("Color panel", "Orange");
        JIFInicioAdmin.pnlMenu.setBackground(new Color(243, 156, 18));
    }//GEN-LAST:event_pnlColor5MouseClicked

    private void pnlColor6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlColor6MouseClicked
        pref.saveProp("Color panel", "Pumpkin");
        JIFInicioAdmin.pnlMenu.setBackground(new Color(211, 84, 0));
    }//GEN-LAST:event_pnlColor6MouseClicked

    private void pnlColor7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlColor7MouseClicked
        pref.saveProp("Color panel", "Pomegranate");
        JIFInicioAdmin.pnlMenu.setBackground(new Color(192, 57, 43));
    }//GEN-LAST:event_pnlColor7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlColor1;
    private javax.swing.JPanel pnlColor2;
    private javax.swing.JPanel pnlColor3;
    private javax.swing.JPanel pnlColor4;
    private javax.swing.JPanel pnlColor5;
    private javax.swing.JPanel pnlColor6;
    private javax.swing.JPanel pnlColor7;
    // End of variables declaration//GEN-END:variables
}

package com.proyectorat.view;

import com.proyectorat.manager.Preferences;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author mateo
 */
public class JIFRegistroHorario extends javax.swing.JInternalFrame {

    Preferences pref = new Preferences();

    public JIFRegistroHorario() {
        initComponents();
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        lblNumeroHoras.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        lblFin = new javax.swing.JLabel();
        rdbFijo = new javax.swing.JRadioButton();
        rdbVariable = new javax.swing.JRadioButton();
        lblTipoHorario = new javax.swing.JLabel();
        tglDomingo = new javax.swing.JToggleButton();
        tglLunes = new javax.swing.JToggleButton();
        tglMartes = new javax.swing.JToggleButton();
        tglMiercoles = new javax.swing.JToggleButton();
        tglJueves = new javax.swing.JToggleButton();
        tglViernes = new javax.swing.JToggleButton();
        tglSabado = new javax.swing.JToggleButton();
        lblHorario = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        tmpInicioDomingo = new com.github.lgooddatepicker.components.TimePicker();
        tmpInicioLunes = new com.github.lgooddatepicker.components.TimePicker();
        tmpInicioMartes = new com.github.lgooddatepicker.components.TimePicker();
        tmpInicioMiercoles = new com.github.lgooddatepicker.components.TimePicker();
        tmpInicioJueves = new com.github.lgooddatepicker.components.TimePicker();
        tmpInicioViernes = new com.github.lgooddatepicker.components.TimePicker();
        tmpInicioSabado = new com.github.lgooddatepicker.components.TimePicker();
        tmpFinLunes = new com.github.lgooddatepicker.components.TimePicker();
        tmpFinMartes = new com.github.lgooddatepicker.components.TimePicker();
        tmpFinMiercoles = new com.github.lgooddatepicker.components.TimePicker();
        tmpFinJueves = new com.github.lgooddatepicker.components.TimePicker();
        tmpFinViernes = new com.github.lgooddatepicker.components.TimePicker();
        tmpFinSabado = new com.github.lgooddatepicker.components.TimePicker();
        tmpFinDomingo = new com.github.lgooddatepicker.components.TimePicker();
        lblNumeroHoras = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 240, 241));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(907, 583));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFin.setText("Fin");
        lblFin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        buttonGroup.add(rdbFijo);
        rdbFijo.setSelected(true);
        rdbFijo.setText("Fijo: el empleado debe cumplir con un horario de entrada y salida.");
        rdbFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFijoActionPerformed(evt);
            }
        });
        getContentPane().add(rdbFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        buttonGroup.add(rdbVariable);
        rdbVariable.setText("Variable: el empleado debe cumplir con un determinado número de horas diarias.");
        rdbVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbVariableActionPerformed(evt);
            }
        });
        getContentPane().add(rdbVariable, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        lblTipoHorario.setText("Tipo de horario");
        lblTipoHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblTipoHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        tglDomingo.setText("Domingo");
        getContentPane().add(tglDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 100, 30));

        tglLunes.setSelected(true);
        tglLunes.setText("Lunes");
        getContentPane().add(tglLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 100, 30));

        tglMartes.setSelected(true);
        tglMartes.setText("Martes");
        getContentPane().add(tglMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 100, 30));

        tglMiercoles.setSelected(true);
        tglMiercoles.setText("Miércoles");
        getContentPane().add(tglMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 100, 30));

        tglJueves.setSelected(true);
        tglJueves.setText("Jueves");
        getContentPane().add(tglJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 100, 30));

        tglViernes.setSelected(true);
        tglViernes.setText("Viernes");
        getContentPane().add(tglViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 100, 30));

        tglSabado.setText("Sábado");
        getContentPane().add(tglSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 100, 30));

        lblHorario.setText("Horario");
        lblHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        lblInicio.setText("Inicio");
        lblInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        tmpInicioDomingo.setEnabled(false);
        getContentPane().add(tmpInicioDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 100, 30));
        getContentPane().add(tmpInicioLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 100, 30));
        getContentPane().add(tmpInicioMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 100, 30));
        getContentPane().add(tmpInicioMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 100, 30));
        getContentPane().add(tmpInicioJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 100, 30));
        getContentPane().add(tmpInicioViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 100, 30));

        tmpInicioSabado.setEnabled(false);
        getContentPane().add(tmpInicioSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 100, 30));
        getContentPane().add(tmpFinLunes, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 100, 30));
        getContentPane().add(tmpFinMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 100, 30));
        getContentPane().add(tmpFinMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 100, 30));
        getContentPane().add(tmpFinJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 100, 30));
        getContentPane().add(tmpFinViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 100, 30));

        tmpFinSabado.setEnabled(false);
        getContentPane().add(tmpFinSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 100, 30));

        tmpFinDomingo.setEnabled(false);
        getContentPane().add(tmpFinDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 100, 30));

        lblNumeroHoras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNumeroHoras.setText("Número de horas");
        getContentPane().add(lblNumeroHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbVariableActionPerformed
        lblInicio.setVisible(false);
        lblNumeroHoras.setVisible(true);
        lblFin.setVisible(false);
        tmpFinLunes.setVisible(false);
        tmpFinMartes.setVisible(false);
        tmpFinMiercoles.setVisible(false);
        tmpFinJueves.setVisible(false);
        tmpFinViernes.setVisible(false);
        tmpFinSabado.setVisible(false);
        tmpFinDomingo.setVisible(false);
    }//GEN-LAST:event_rdbVariableActionPerformed

    private void rdbFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFijoActionPerformed
        lblNumeroHoras.setVisible(false);
        lblInicio.setVisible(true);
        lblFin.setVisible(true);
        tmpFinLunes.setVisible(true);
        tmpFinMartes.setVisible(true);
        tmpFinMiercoles.setVisible(true);
        tmpFinJueves.setVisible(true);
        tmpFinViernes.setVisible(true);
        tmpFinSabado.setVisible(true);
        tmpFinDomingo.setVisible(true);
    }//GEN-LAST:event_rdbFijoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblNumeroHoras;
    private javax.swing.JLabel lblTipoHorario;
    private javax.swing.JRadioButton rdbFijo;
    private javax.swing.JRadioButton rdbVariable;
    private javax.swing.JToggleButton tglDomingo;
    private javax.swing.JToggleButton tglJueves;
    private javax.swing.JToggleButton tglLunes;
    private javax.swing.JToggleButton tglMartes;
    private javax.swing.JToggleButton tglMiercoles;
    private javax.swing.JToggleButton tglSabado;
    private javax.swing.JToggleButton tglViernes;
    private com.github.lgooddatepicker.components.TimePicker tmpFinDomingo;
    private com.github.lgooddatepicker.components.TimePicker tmpFinJueves;
    private com.github.lgooddatepicker.components.TimePicker tmpFinLunes;
    private com.github.lgooddatepicker.components.TimePicker tmpFinMartes;
    private com.github.lgooddatepicker.components.TimePicker tmpFinMiercoles;
    private com.github.lgooddatepicker.components.TimePicker tmpFinSabado;
    private com.github.lgooddatepicker.components.TimePicker tmpFinViernes;
    private com.github.lgooddatepicker.components.TimePicker tmpInicioDomingo;
    private com.github.lgooddatepicker.components.TimePicker tmpInicioJueves;
    private com.github.lgooddatepicker.components.TimePicker tmpInicioLunes;
    private com.github.lgooddatepicker.components.TimePicker tmpInicioMartes;
    private com.github.lgooddatepicker.components.TimePicker tmpInicioMiercoles;
    private com.github.lgooddatepicker.components.TimePicker tmpInicioSabado;
    private com.github.lgooddatepicker.components.TimePicker tmpInicioViernes;
    // End of variables declaration//GEN-END:variables
}

package com.proyectorat.gui;

//Importación de paquetes
import com.proyectorat.model.Tipo;
import com.proyectorat.business.TipoManagerImpl;
import javax.swing.*;
import java.awt.event.*;

public class FrmTipo extends Frm {

    TipoManagerImpl nt = new TipoManagerImpl();
    Tipo entTipo = new Tipo();

    //Declaración de variables
    JLabel lblActividad, lblDescripcion, lblEstado, lblLogo;
    JTextField txtActividad, txtDescripcion;
    JComboBox cmbEstado;
    JSeparator Separator;
    String oE[] = {"Seleccionar estado", "Activo", "Inactivo"};
    Integer pos;

    public FrmTipo() {

        setTitle("Tipos de actividades");
        lblVentana.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/frm_tipo.png")));

        lblActividad = new JLabel("* ID de la actividad");
        lblDescripcion = new JLabel("* Descripción");
        lblEstado = new JLabel("* Estado");

        txtActividad = new JTextField(4);
        txtDescripcion = new JTextField(100);

        cmbEstado = new JComboBox(oE);

        lblLogo = new JLabel();

        lblActividad.setBounds(20, 85, 200, 30);
        lblDescripcion.setBounds(20, 120, 200, 30);
        lblEstado.setBounds(20, 155, 100, 30);

        txtActividad.setBounds(170, 85, 100, 30);
        txtDescripcion.setBounds(170, 120, 200, 30);
        cmbEstado.setBounds(170, 155, 200, 30);

        btnUpdate.setVisible(false);

        pnlFondo.add(lblActividad);
        pnlFondo.add(lblEstado);
        pnlFondo.add(lblDescripcion);
        pnlFondo.add(txtActividad);
        pnlFondo.add(txtDescripcion);
        pnlFondo.add(cmbEstado);

        setVisible(true);
        this.repaint();

    }

    public boolean validaciones() {
        if (txtActividad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el ID de la actividad.");
            return true;
        } else if(!isNumber(txtActividad.getText())){
            JOptionPane.showMessageDialog(null, "El ID de la actividad debe ser solo cuatro números.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (txtDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese la descripción de la actividad.");
            return true;
        }
        if (cmbEstado.getSelectedItem() == oE[0]) {
            JOptionPane.showMessageDialog(null, "Se seleccionará \"Activo\" como estado por defecto.");
            cmbEstado.setSelectedItem(oE[1]);
        }

        return false;

    }

    @Override
    public void actionPerformed(ActionEvent accion) {

        //-------------GUARDAR-------------
        if (accion.getSource() == btnCreate) {
            if (validaciones()) {
                return;
            }

            String emp = txtActividad.getText();
            String nom = txtDescripcion.getText();
            String est = cmbEstado.getSelectedItem().toString();

            try {
                entTipo.setId_actividad(emp);
                entTipo.setDescripcion(nom);
                entTipo.setEstado(est);
                nt.getGuardarTipo(entTipo);

                txtActividad.setText("");
                txtDescripcion.setText("");
                cmbEstado.setSelectedItem(oE[0]);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar.\nError " + e.getCause(), "Error", ERROR);
            }

        }
        //----------LIMPIAR-------------

        if (accion.getSource() == btnClean) {
            txtActividad.setText("");
            txtDescripcion.setText("");
            cmbEstado.setSelectedItem(oE[0]);

            btnUpdate.setVisible(false);
            btnCreate.setVisible(true);
            btnDelete.setEnabled(false);
        }
        //--------ACTUALIZAR---------

        if (accion.getSource() == btnUpdate) {

            if (validaciones()) {
                return;
            }

            String nom = txtDescripcion.getText();
            String est = cmbEstado.getSelectedItem().toString();

            try {
                entTipo.setDescripcion(nom);
                entTipo.setEstado(est);
                nt.getEditarTipo(entTipo);

                txtActividad.setText("");
                txtDescripcion.setText("");
                cmbEstado.setSelectedItem(oE[0]);
                btnUpdate.setVisible(false);
                btnCreate.setVisible(true);
                btnDelete.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al editar.\nError " + e.getCause(), "Error", ERROR);
            }

        }
        //--------BUSCAR-------------

        if (accion.getSource() == btnSearch) {
            if (txtActividad.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Ingrese el ID de la actividad");

            } else {

                String tipo = txtActividad.getText();
                entTipo = nt.getTipo(tipo);
                if (!"*".equals(entTipo.getId_actividad())) {
                    txtDescripcion.setText(entTipo.getDescripcion());
                    cmbEstado.setSelectedItem(entTipo.getEstado());

                    btnUpdate.setVisible(true);
                    btnCreate.setVisible(false);
                    btnDelete.setEnabled(true);

                    if (txtDescripcion.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, tipo + " no existe");
                        txtActividad.setText("");
                        txtDescripcion.setText("");
                        cmbEstado.setSelectedItem(oE[0]);

                        btnUpdate.setVisible(false);
                        btnCreate.setVisible(true);
                        btnDelete.setEnabled(false);
                    }
                }
            }
        }
        //----------ELIMINAR-------------

        if (accion.getSource() == btnDelete) {
            if (txtActividad.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el id de la actividad", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String id = txtActividad.getText();

                int conf = JOptionPane.showConfirmDialog(null, "Seguro quieres eliminar el registro " + id);
                if (conf == JOptionPane.YES_OPTION) {
                    nt.getEliminarTipo(id);
                    btnUpdate.setVisible(false);
                    btnCreate.setVisible(true);
                    btnDelete.setEnabled(false);
                } else if (conf == JOptionPane.NO_OPTION) {
                    btnUpdate.setVisible(false);
                    btnCreate.setVisible(true);
                    btnDelete.setEnabled(false);
                }

            }
        }
        //---------MENÚ--------------------

        if (accion.getSource() == btnUsuario) {
            setVisible(false);
            FrmUsuario ventana = new FrmUsuario();
            ventana.setVisible(true);
        }
        if (accion.getSource() == btnEmpleado) {
            setVisible(false);
            FrmEmpleado ventana = new FrmEmpleado();
            ventana.setVisible(true);
        }
        if (accion.getSource() == btnEntrada) {
            setVisible(false);
            FrmEntrada ventana = new FrmEntrada();
            ventana.setVisible(true);
        }
        if (accion.getSource() == btnCargo) {
            setVisible(false);
            FrmCargo ventana = new FrmCargo();
            ventana.setVisible(true);
        }
        if (accion.getSource() == btnRegistro) {
            setVisible(false);
            FrmRegistro ventana = new FrmRegistro();
            ventana.setVisible(true);
        }
        if (accion.getSource() == btnTipo) {

        }
        if (accion.getSource() == btnSesion) {
            setVisible(false);
            FrmIngreso ventana = new FrmIngreso();
            ventana.setVisible(true);
        }
    }

    public static void main(String[] args) {

        FrmTipo p = new FrmTipo();
        p.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
    }
}

package com.proyectorat.gui;

//Importación de paquetes
import com.toedter.calendar.JDateChooser;
import com.proyectorat.model.Registro;
import com.proyectorat.manager.RegistroManagerImpl;
import static com.proyectorat.gui.FrmIngreso.leerTexto;
import javax.swing.*;
import java.awt.event.*;

public class FrmRegistro extends Frm {

    RegistroManagerImpl nr = new RegistroManagerImpl();
    Registro entRegistro = new Registro();

    //Declaración de variables
    JLabel lblEmpleado, lblCons, lblIDActividad, lblUsuarioCreador, lblFechaA, lblEstado, lblLogo;
    JTextField txtEmpleado, txtCons, txtIDActividad, txtUsuarioCreador;
    JDateChooser dteFecha;
    JComboBox cmbEstado;
    JSeparator Separator;
    String oE[] = {"Seleccionar estado", "Activo", "Inactivo"};
    Integer pos;

    public FrmRegistro() {

        setTitle("Asignación de actividades");
        lblVentana.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/frm_registro.png")));

        lblEmpleado = new JLabel("* ID del empleado");
        //lblCons = new JLabel("* Cons");
        lblIDActividad = new JLabel("* ID de la actividad");
        lblUsuarioCreador = new JLabel("* Usuario creador");
        lblFechaA = new JLabel("* Fecha de la actividad");
        lblEstado = new JLabel("* Estado");

        txtEmpleado = new JTextField(4);
        //txtCons = new JTextField(100);
        txtIDActividad = new JTextField(100);
        dteFecha = new JDateChooser();
        txtUsuarioCreador = new JTextField(13);

        cmbEstado = new JComboBox(oE);

        lblLogo = new JLabel();

        //lblCons.setBounds(100, 100, 130, 30);
        lblEmpleado.setBounds(20, 85, 200, 30);
        lblIDActividad.setBounds(20, 120, 200, 30);
        lblUsuarioCreador.setBounds(20, 155, 200, 30);
        lblFechaA.setBounds(20, 190, 200, 30);
        lblEstado.setBounds(20, 225, 150, 30);

        //txtCons.setBounds(270, 100, 100, 30);
        txtEmpleado.setBounds(180, 85, 200, 30);
        txtIDActividad.setBounds(180, 120, 200, 30);
        txtUsuarioCreador.setBounds(180, 155, 200, 30);
        dteFecha.setBounds(180, 190, 200, 30);
        cmbEstado.setBounds(180, 225, 200, 30);

        btnUpdate.setVisible(false);

        pnlFondo.add(lblEmpleado);
        pnlFondo.add(lblIDActividad);
        //pnlFondo.add(lblCons);
        pnlFondo.add(lblUsuarioCreador);
        pnlFondo.add(lblFechaA);
        pnlFondo.add(lblEstado);

        pnlFondo.add(txtEmpleado);
        //pnlFondo.add(txtCons);
        pnlFondo.add(txtIDActividad);
        pnlFondo.add(dteFecha);
        pnlFondo.add(txtUsuarioCreador);
        pnlFondo.add(cmbEstado);

        txtUsuarioCreador.setEnabled(false);
        try {
            txtUsuarioCreador.setText(leerTexto("Register"));
        } catch (Exception e) {
        }

        setVisible(true);
        this.repaint();

    }

    public boolean validaciones() {
        if (txtEmpleado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el ID del empleado.");
            return true;
        } else if (!isNumber(txtEmpleado.getText())) {
            JOptionPane.showMessageDialog(null, "El ID del empleado debe ser solo cuatro números.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (txtIDActividad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el ID de la actividad.");
            return true;
        } else if (!isNumber(txtIDActividad.getText())) {
            JOptionPane.showMessageDialog(null, "El ID de la actividad debe ser solo cuatro números.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (dteFecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione la fecha de la actividad.");
            return true;
        }
        if (txtUsuarioCreador.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el usuario creador.");
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

            java.util.Date uDate;

            String emp = txtEmpleado.getText();
            String con = txtCons.getText();
            String ida = txtIDActividad.getText();
            uDate = dteFecha.getDate();
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            String usu = txtUsuarioCreador.getText();
            String est = cmbEstado.getSelectedItem().toString();
            try {
                entRegistro.setId_empleado(emp);
                //entRegistro.setCons(con);
                entRegistro.setId_actividad(ida);
                entRegistro.setFecha(sDate);
                entRegistro.setUsuario_creador(usu);
                entRegistro.setEstado(est);
                nr.getGuardarRegistro(entRegistro);

                txtEmpleado.setText("");
                //txtCons.setText("");
                txtIDActividad.setText("");
                dteFecha.setDate(null);
                txtUsuarioCreador.setText("");
                cmbEstado.setSelectedItem(oE[0]);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar.\nError " + e, "Error", ERROR);
            }

        }
        //----------LIMPIAR-------------

        if (accion.getSource() == btnClean) {
            txtEmpleado.setText("");
            //txtCons.setText("");
            txtIDActividad.setText("");
            dteFecha.setDate(null);
            try {
                txtUsuarioCreador.setText(leerTexto("Register"));
            } catch (Exception e) {
            }
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

            java.util.Date uDate;

            //String con = txtCons.getText();
            String ida = txtIDActividad.getText();
            uDate = dteFecha.getDate();
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            String usu = txtUsuarioCreador.getText();
            String est = cmbEstado.getSelectedItem().toString();

            try {
                entRegistro.setId_actividad(ida);
                entRegistro.setFecha(sDate);
                entRegistro.setUsuario_creador(usu);
                entRegistro.setEstado(est);
                nr.getEditarRegistro(entRegistro);

                txtEmpleado.setText("");
                //txtCons.setText("");
                txtIDActividad.setText("");
                dteFecha.setDate(null);
                txtUsuarioCreador.setText("");
                cmbEstado.setSelectedItem(oE[0]);
                btnUpdate.setVisible(false);
                btnCreate.setVisible(true);
                btnDelete.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al editar.\nError " + e, "Error", ERROR);
            }

        }
        //--------BUSCAR-------------

        if (accion.getSource() == btnSearch) {
            if (txtEmpleado.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Ingrese el ID del empleado");

            } else {

                String regi = txtEmpleado.getText();
                entRegistro = nr.getRegistro(regi);
                if (!"*".equals(entRegistro.getId_empleado())) {
                    //txtCons.setText(entRegistro.getCons());
                    txtIDActividad.setText(entRegistro.getId_actividad());
                    dteFecha.setDate(entRegistro.getFecha());
                    txtUsuarioCreador.setText(entRegistro.getUsuario_creador());
                    cmbEstado.setSelectedItem(entRegistro.getEstado());

                    btnUpdate.setVisible(true);
                    btnCreate.setVisible(false);
                    btnDelete.setEnabled(true);

                    if (txtIDActividad.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, regi + " no existe");
                        txtEmpleado.setText("");
                        //txtCons.setText("");
                        txtIDActividad.setText("");
                        dteFecha.setDate(null);
                        txtUsuarioCreador.setText("");
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
            if (txtEmpleado.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el id del empleado", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String id = txtEmpleado.getText();

                int conf = JOptionPane.showConfirmDialog(null, "Seguro quieres eliminar el registro " + id);
                if (conf == JOptionPane.YES_OPTION) {
                    nr.getEliminarRegistro(id);
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

        }
        if (accion.getSource() == btnTipo) {
            setVisible(false);
            FrmTipo ventana = new FrmTipo();
            ventana.setVisible(true);
        }
        if (accion.getSource() == btnSesion) {
            setVisible(false);
            FrmIngreso ventana = new FrmIngreso();
            ventana.setVisible(true);
        }
    }

    public static void main(String[] args) {

        FrmRegistro p = new FrmRegistro();
        p.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
    }
}

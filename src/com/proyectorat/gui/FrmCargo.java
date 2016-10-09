package com.proyectorat.gui;

//Importación de paquetes
import com.proyectorat.model.Cargo;
import com.proyectorat.business.CargoManagerImpl;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;

public class FrmCargo extends Frm {

    CargoManagerImpl nc = new CargoManagerImpl();
    Cargo entCargo = new Cargo();

    //Declaración de variables
    JLabel lblIDCargo, lblNombre, lblSalario, lblEstado, lblLogo;
    JTextField txtIDCargo, txtNombre, txtSalario;
    JComboBox cmbEstado;
    JSeparator Separator;
    String oE[] = {"Seleccionar estado", "Activo", "Inactivo"};
    Integer pos;

    public FrmCargo() {

        setTitle("Registro de cargos");
        lblVentana.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/frm_cargo.png")));

        lblIDCargo = new JLabel("* ID del cargo");
        lblNombre = new JLabel("* Nombre");
        lblSalario = new JLabel("* Salario");
        lblEstado = new JLabel("* Estado");

        txtIDCargo = new JTextField(2);
        txtNombre = new JTextField(100);
        txtSalario = new JTextField(100);

        cmbEstado = new JComboBox(oE);

        lblLogo = new JLabel();

        lblIDCargo.setBounds(20, 50, 130, 30);
        lblNombre.setBounds(20, 85, 70, 30);
        lblSalario.setBounds(20, 120, 100, 30);
        lblEstado.setBounds(20, 155, 70, 30);
        txtIDCargo.setBounds(170, 50, 100, 30);
        txtNombre.setBounds(170, 85, 200, 30);
        txtSalario.setBounds(170, 120, 200, 30);
        cmbEstado.setBounds(170, 155, 200, 30);

        btnUpdate.setVisible(false);

        pnlFondo.add(lblIDCargo);
        pnlFondo.add(lblSalario);
        pnlFondo.add(lblNombre);
        pnlFondo.add(lblEstado);

        pnlFondo.add(txtIDCargo);
        pnlFondo.add(txtNombre);
        pnlFondo.add(txtSalario);
        pnlFondo.add(cmbEstado);

        setVisible(true);
        this.repaint();

    }

    public boolean validarEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public boolean validaciones() {
        if (txtIDCargo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el ID del cargo.");
            return true;
        } else if(!isNumber(txtIDCargo.getText())){
            JOptionPane.showMessageDialog(null, "El ID del cargo debe ser solo dos números.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre.");
            return true;
        }
        if (txtSalario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el salario.");
            return true;
        } else if(!isNumber(txtSalario.getText())){
            JOptionPane.showMessageDialog(null, "El salario debe ser solo números.", "Error", JOptionPane.ERROR_MESSAGE);
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

            String car = txtIDCargo.getText();
            String nom = txtNombre.getText();
            String sal = txtSalario.getText();
            String est = cmbEstado.getSelectedItem().toString();

            try {
                entCargo.setId_cargo(car);
                entCargo.setNombre(nom);
                entCargo.setSalario(sal);
                entCargo.setEstado(est);
                nc.getGuardarCargo(entCargo);

                txtIDCargo.setText("");
                txtNombre.setText("");
                txtSalario.setText("");
                cmbEstado.setSelectedItem(oE[0]);
            } catch (Exception e) {
            }

        }
        //----------LIMPIAR-------------

        if (accion.getSource() == btnClean) {
            txtIDCargo.setText("");
            txtNombre.setText("");
            txtSalario.setText("");
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

            String nom = txtNombre.getText();
            String sal = txtSalario.getText();
            String est = cmbEstado.getSelectedItem().toString();

            try {
                entCargo.setNombre(nom);
                entCargo.setSalario(sal);
                entCargo.setEstado(est);
                nc.getEditarCargo(entCargo);

                txtIDCargo.setText("");
                txtNombre.setText("");
                txtSalario.setText("");
                cmbEstado.setSelectedItem(oE[0]);
                btnUpdate.setVisible(false);
                btnCreate.setVisible(true);
                btnDelete.setEnabled(false);
            } catch (Exception e) {
            }

        }
        //--------BUSCAR-------------

        if (accion.getSource() == btnSearch) {
            if (txtIDCargo.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Ingrese el ID del cargo");

            } else {

                String carg = txtIDCargo.getText();
                entCargo = nc.getCargo(carg);
                if (!"*".equals(entCargo.getId_cargo())) {
                    txtNombre.setText(entCargo.getNombre());
                    txtSalario.setText(entCargo.getSalario());
                    cmbEstado.setSelectedItem(entCargo.getEstado());

                    btnCreate.setVisible(false);
                    btnUpdate.setVisible(true);
                    btnDelete.setEnabled(true);

                    if (txtNombre.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, carg + " no existe");
                        txtIDCargo.setText("");
                        txtNombre.setText("");
                        txtSalario.setText("");
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
            if (txtIDCargo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el id del cargo", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String id = txtIDCargo.getText();

                int conf = JOptionPane.showConfirmDialog(null, "Seguro quieres eliminar el registro " + id);
                if (conf == JOptionPane.YES_OPTION) {
                    nc.getEliminarCargo(id);
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

        FrmCargo p = new FrmCargo();
        p.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

    }
}

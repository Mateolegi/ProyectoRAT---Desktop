package com.proyectorat.gui;

//Importación de paquetes
import com.proyectorat.model.Usuario;
import com.proyectorat.business.UsuarioManagerImpl;
import com.proyectorat.persistence.SQL_Helpers;
import com.proyectorat.util.Conexion;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.*;

public class FrmUsuario extends Frm {

    UsuarioManagerImpl nu = new UsuarioManagerImpl();
    Usuario entUsuario = new Usuario();

    //Declaración de variables
    JLabel lblContrasena, lblNombre, lblEstado, lblPerfil, lblCorreo, lblFondo, lblUsuario;
    JTextField txtUsuario, txtNombre, txtCorreo;
    JComboBox cmbEstado, cmbPerfil;
    JPasswordField txtContrasena;
    JSeparator Separator;
    int largo = 5;
    String oP[] = new String[largo];
    String oE[] = {"Seleccionar estado", "Activo", "Inactivo"};
    Integer pos;

    public FrmUsuario() {

        setTitle("Registro de usuarios");
        lblVentana.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/frm_usuario.png")));

        lblUsuario = new JLabel("* Usuario");
        lblNombre = new JLabel("* Nombre");
        lblContrasena = new JLabel("* Contraseña");
        lblEstado = new JLabel("  Estado");
        lblPerfil = new JLabel("* Perfil");
        lblCorreo = new JLabel("* Correo electrónico");

        txtUsuario = new JTextField(100);
        txtNombre = new JTextField(100);
        txtCorreo = new JTextField(100);
        txtContrasena = new JPasswordField();

        comboBox();

        cmbEstado = new JComboBox(oE);
        cmbPerfil = new JComboBox(oP);

        lblUsuario.setBounds(20, 50, 200, 30);
        lblContrasena.setBounds(20, 120, 200, 30);
        lblNombre.setBounds(20, 85, 200, 30);
        lblEstado.setBounds(20, 155, 200, 30);
        lblPerfil.setBounds(20, 190, 200, 30);
        lblCorreo.setBounds(20, 225, 200, 30);

        txtUsuario.setBounds(170, 50, 200, 30);
        txtContrasena.setBounds(170, 120, 200, 30);
        txtNombre.setBounds(170, 85, 200, 30);
        cmbEstado.setBounds(170, 155, 200, 30);
        cmbPerfil.setBounds(170, 190, 200, 30);
        txtCorreo.setBounds(170, 225, 200, 30);

        btnUpdate.setVisible(false);

        pnlFondo.add(lblUsuario);
        pnlFondo.add(lblContrasena);
        pnlFondo.add(lblNombre);
        pnlFondo.add(lblEstado);
        pnlFondo.add(lblPerfil);
        pnlFondo.add(lblCorreo);

        pnlFondo.add(txtUsuario);
        pnlFondo.add(txtContrasena);
        pnlFondo.add(txtNombre);
        pnlFondo.add(cmbPerfil);
        pnlFondo.add(cmbEstado);
        pnlFondo.add(txtCorreo);

        setVisible(true);
        this.repaint();

    }

    private void comboBox() {
        Conexion c = new Conexion();
        try {
            ResultSet r = c.getCon().prepareStatement(SQL_Helpers.getCargo()).executeQuery();
            oP[0] = "Seleccionar perfil";
            int i = 1;
            while (r.next()) {
                oP[i] = r.getString(2);
                i++;
            }
            largo = i;

        } catch (SQLException e) {
        }
    }

    public boolean validarEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private void limpiar() {
        txtUsuario.setText("");
        txtContrasena.setText("");
        txtNombre.setText("");
        cmbPerfil.setSelectedItem(oP[0]);
        cmbEstado.setSelectedItem(oE[0]);
        txtCorreo.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent accion) {

        //-------------GUARDAR-------------
        if (accion.getSource() == btnCreate) {

            String mensaje = "";

            if (txtUsuario.getText().equals("")) {
                mensaje += "Por favor ingrese el usuario.\n";
            }
            if (txtNombre.getText().equals("")) {
                mensaje += "Por favor ingrese el nombre.\n";
            }
            if (txtContrasena.getText().equals("")) {
                mensaje += "Por favor ingrese la contraseña.\n";
            }
            if (cmbEstado.getSelectedItem() == oE[0]) {
                mensaje += "Se seleccionará \"Activo\" como estado por defecto.\n";
                cmbEstado.setSelectedItem(oE[1]);
            }
            if (cmbPerfil.getSelectedItem() == oP[0]) {
                mensaje += "Seleccione perfil.\n";
            }
            if (txtCorreo.getText().equals("")) {
                mensaje += "Por favor ingrese el correo electrónico.\n";
            } else if (!validarEmail(txtCorreo.getText())) {
                mensaje += "Correo inválido.";
            }

            //Excepciones
            if (!"".equals(mensaje)) {
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String usu = txtUsuario.getText();
            String nom = txtNombre.getText();
            String cla = txtContrasena.getText();
            String per = cmbPerfil.getSelectedItem().toString();
            String est = cmbEstado.getSelectedItem().toString();
            String cor = txtCorreo.getText();

            try {
                entUsuario.setUsuario(usu);
                entUsuario.setNombre(nom);
                entUsuario.setClave(cla);
                entUsuario.setEstado(est);
                entUsuario.setPerfil(per);
                entUsuario.setEmail(cor);
                nu.getGuardarUsuario(entUsuario);

                limpiar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar.\nError " + e.getCause(), "Error", ERROR);
            }

        }

        //----------LIMPIAR-------------
        if (accion.getSource() == btnClean) {
            limpiar();
            btnUpdate.setVisible(false);
            btnCreate.setVisible(true);
            btnDelete.setEnabled(false);
        }
        //--------ACTUALIZAR---------

        if (accion.getSource() == btnUpdate) {

            String mensaje = "";

            if (txtUsuario.getText().equals("")) {
                mensaje += "Por favor ingrese el usuario.\n";
            }
            if (txtNombre.getText().equals("")) {
                mensaje += "Por favor ingrese el nombre.\n";
            }
            if (txtContrasena.getText().equals("")) {
                mensaje += "Por favor ingrese la contraseña.\n";
            }
            if (cmbEstado.getSelectedItem() == oE[0]) {
                mensaje += "Se seleccionará \"Activo\" como estado por defecto.\n";
                cmbEstado.setSelectedItem(oE[1]);
            }
            if (cmbPerfil.getSelectedItem() == oP[0]) {
                mensaje += "Seleccione perfil.\n";
            }
            if (txtCorreo.getText().equals("")) {
                mensaje += "Por favor ingrese el correo electrónico.\n";
            } else if (!validarEmail(txtCorreo.getText())) {
                mensaje += "Correo inválido.";
            }

            //Excepciones
            if (!"".equals(mensaje)) {
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String usu = txtUsuario.getText();
            String nom = txtNombre.getText();
            String cla = txtContrasena.getText();
            String per = cmbPerfil.getSelectedItem().toString();
            String est = cmbEstado.getSelectedItem().toString();
            String cor = txtCorreo.getText();

            try {

                entUsuario.setNombre(nom);
                entUsuario.setClave(cla);
                entUsuario.setPerfil(per);
                entUsuario.setEstado(est);
                entUsuario.setEmail(cor);
                nu.getEditarUsuario(entUsuario);

                limpiar();

                btnUpdate.setVisible(false);
                btnCreate.setVisible(true);
                btnDelete.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar.\nError " + e.getCause());
            }

        }
        //--------BUSCAR-------------

        if (accion.getSource() == btnSearch) {
            if (txtUsuario.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Ingrese usuario");

            } else {

                String user = txtUsuario.getText();
                entUsuario = nu.getUsuario(user);
                if (!"*".equals(entUsuario.getUsuario())) {
                    txtCorreo.setText(entUsuario.getEmail());
                    txtNombre.setText(entUsuario.getNombre());
                    txtContrasena.setText(entUsuario.getClave());
                    txtUsuario.setText(entUsuario.getUsuario());
                    cmbPerfil.setSelectedItem(entUsuario.getPerfil());
                    cmbEstado.setSelectedItem(entUsuario.getEstado());

                    btnUpdate.setVisible(true);
                    btnCreate.setVisible(false);
                    btnDelete.setEnabled(true);

                    if (txtCorreo.getText().equals("")) {
                        limpiar();
                        btnUpdate.setVisible(false);
                        btnCreate.setVisible(true);
                        btnDelete.setEnabled(false);
                    }
                }
            }
        }
        //----------ELIMINAR-------------

        if (accion.getSource() == btnDelete) {
            if (txtUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre de usuario", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String id = txtUsuario.getText();

                int conf = JOptionPane.showConfirmDialog(null, "Seguro quieres eliminar el usuario " + id);
                if (conf == JOptionPane.YES_OPTION) {
                    nu.getEliminarUsuario(id);
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

    public static void main(String g[]) {

        new FrmUsuario().setVisible(true);
    }
}

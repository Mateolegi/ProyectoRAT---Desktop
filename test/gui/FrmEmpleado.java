package gui;

//Importación de paquetes
import com.toedter.calendar.JDateChooser;
import com.proyectorat.model.Empleado;
import com.proyectorat.manager.EmpleadoManagerImpl;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;

public class FrmEmpleado extends Frm {

    EmpleadoManagerImpl ne = new EmpleadoManagerImpl();
    Empleado entEmpleado = new Empleado();

    //Declaración de variables
    JLabel lblEmpleado, lblNombre, lblApellido, lblFecha, lblTelefono, lblDireccion, lblEmail, lblEstado, lblCargo;
    JTextField txtEmpleado, txtNombre, txtApellido, txtTelefono, txtDireccion, txtEmail, txtEstado, txtCargo;
    JDateChooser dteFecha;
    JComboBox cmbEstado;
    String oE[] = {"Seleccionar estado", "Activo", "Inactivo"};
    Integer pos;

    public FrmEmpleado() {

        //Interfaz
        setTitle("Registro de empleados");
        lblVentana.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/frm_empleado.png")));
        //Fin interfaz

        lblEmpleado = new JLabel("* ID del empleado");
        lblNombre = new JLabel("* Nombre");
        lblApellido = new JLabel("* Apellido");
        lblFecha = new JLabel("* Fecha de nacimiento");
        lblTelefono = new JLabel("* Teléfono");
        lblDireccion = new JLabel("* Dirección");
        lblEmail = new JLabel("* Correo electrónico");
        lblEstado = new JLabel("* Estado");
        lblCargo = new JLabel("* ID del cargo");

        txtEmpleado = new JTextField(4);
        txtNombre = new JTextField(100);
        txtApellido = new JTextField(100);
        dteFecha = new JDateChooser();
        txtTelefono = new JTextField(13);
        txtDireccion = new JTextField(100);
        txtEmail = new JTextField(100);
        txtCargo = new JTextField(2);

        cmbEstado = new JComboBox(oE);

        lblEmpleado.setBounds(20, 50, 200, 30);
        lblNombre.setBounds(20, 85, 200, 30);
        lblApellido.setBounds(20, 120, 200, 30);
        lblFecha.setBounds(20, 155, 200, 30);
        lblTelefono.setBounds(20, 190, 200, 30);
        lblDireccion.setBounds(20, 225, 200, 30);
        lblEmail.setBounds(20, 260, 200, 30);
        lblEstado.setBounds(20, 295, 200, 30);
        lblCargo.setBounds(20, 330, 200, 30);

        txtEmpleado.setBounds(180, 50, 100, 30);
        txtNombre.setBounds(180, 85, 200, 30);
        txtApellido.setBounds(180, 120, 200, 30);
        dteFecha.setBounds(180, 155, 200, 30);
        txtTelefono.setBounds(180, 190, 200, 30);
        txtDireccion.setBounds(180, 225, 200, 30);
        txtEmail.setBounds(180, 260, 200, 30);
        cmbEstado.setBounds(180, 295, 200, 30);
        txtCargo.setBounds(180, 330, 100, 30);

        btnUpdate.setVisible(false);

        pnlFondo.add(lblEmpleado);
        pnlFondo.add(lblApellido);
        pnlFondo.add(lblNombre);
        pnlFondo.add(lblFecha);
        pnlFondo.add(lblTelefono);
        pnlFondo.add(lblDireccion);
        pnlFondo.add(lblEmail);
        pnlFondo.add(lblEstado);
        pnlFondo.add(lblCargo);

        pnlFondo.add(txtEmpleado);
        pnlFondo.add(txtNombre);
        pnlFondo.add(txtApellido);
        pnlFondo.add(dteFecha);
        pnlFondo.add(txtTelefono);
        pnlFondo.add(txtDireccion);
        pnlFondo.add(txtEmail);
        pnlFondo.add(cmbEstado);
        pnlFondo.add(txtCargo);

        setVisible(true);
        this.repaint();

    }

    public boolean validarEmail(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public boolean validaciones() {
        if (txtEmpleado.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el ID del empleado.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        } else if(!isNumber(txtEmpleado.getText())){
            JOptionPane.showMessageDialog(null, "El ID del empleado debe ser solo cuatro números.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }

        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (txtApellido.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el apellido.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (dteFecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione la fecha de nacimiento.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (txtTelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el teléfono.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        } else if(!isNumber(txtTelefono.getText())){
            JOptionPane.showMessageDialog(null, "El teléfono debe ser solo números.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        if (txtDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese la dirección.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el correo electrónico.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        } else if (validarEmail(txtDireccion.getText())) {
            JOptionPane.showMessageDialog(null, "Correo inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (cmbEstado.getSelectedItem() == oE[0]) {
            JOptionPane.showMessageDialog(null, "Se seleccionará \"Activo\" como estado por defecto.");
            cmbEstado.setSelectedItem(oE[1]);
        }
        if (txtCargo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el ID del cargo.", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
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
            String nom = txtNombre.getText();
            String ape = txtApellido.getText();
            uDate = dteFecha.getDate();
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            String tel = txtTelefono.getText();
            String dir = txtDireccion.getText();
            String cor = txtEmail.getText();
            String est = cmbEstado.getSelectedItem().toString();
            String car = txtCargo.getText();

            try {
                entEmpleado.setId_empleado(emp);
                entEmpleado.setNombre(nom);
                entEmpleado.setApellidos(ape);
                entEmpleado.setFecha_n(sDate);
                entEmpleado.setTelefono(tel);
                entEmpleado.setDireccion(dir);
                entEmpleado.setEmail(cor);
                entEmpleado.setEstado(est);
                entEmpleado.setId_cargo(car);
                ne.getGuardarEmpleado(entEmpleado);

                txtEmpleado.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                dteFecha.setDate(null);
                txtTelefono.setText("");
                txtDireccion.setText("");
                txtEmail.setText("");
                cmbEstado.setSelectedItem(oE[0]);
                txtCargo.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar.\nError " + e, "Error", ERROR);
            }

        }
        //----------LIMPIAR-------------

        if (accion.getSource() == btnClean) {
            txtEmpleado.setText("");
            txtNombre.setText("");
            txtApellido.setText("");
            dteFecha.setDate(null);
            txtTelefono.setText("");
            txtDireccion.setText("");
            txtEmail.setText("");
            cmbEstado.setSelectedItem(oE[0]);
            txtCargo.setText("");

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

            String nom = txtNombre.getText();
            String ape = txtApellido.getText();
            uDate = dteFecha.getDate();
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            String tel = txtTelefono.getText();
            String dir = txtDireccion.getText();
            String cor = txtEmail.getText();
            String est = cmbEstado.getSelectedItem().toString();
            String car = txtCargo.getText();

            try {
                entEmpleado.setNombre(nom);
                entEmpleado.setApellidos(ape);
                entEmpleado.setFecha_n(sDate);
                entEmpleado.setTelefono(tel);
                entEmpleado.setDireccion(dir);
                entEmpleado.setEmail(cor);
                entEmpleado.setEstado(est);
                entEmpleado.setId_cargo(car);
                ne.getEditarEmpleado(entEmpleado);

                txtEmpleado.setText("");
                txtNombre.setText("");
                txtApellido.setText("");
                dteFecha.setDate(null);
                txtTelefono.setText("");
                txtDireccion.setText("");
                txtEmail.setText("");
                cmbEstado.setSelectedItem(oE[0]);
                txtCargo.setText("");

                btnUpdate.setVisible(false);
                btnCreate.setVisible(true);
                btnDelete.setEnabled(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar.\nError " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        //--------BUSCAR-------------

        if (accion.getSource() == btnSearch) {
            if (txtEmpleado.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Ingrese el ID del empleado");

            } else {

                String empl = txtEmpleado.getText();
                entEmpleado = ne.getEmpleado(empl);
                if (!"*".equals(entEmpleado.getId_empleado())) {
                    txtNombre.setText(entEmpleado.getNombre());
                    txtApellido.setText(entEmpleado.getApellidos());
                    dteFecha.setDate(entEmpleado.getFecha_n());
                    txtTelefono.setText(entEmpleado.getTelefono());
                    txtDireccion.setText(entEmpleado.getDireccion());
                    txtEmail.setText(entEmpleado.getEmail());
                    cmbEstado.setSelectedItem(entEmpleado.getEstado());
                    txtCargo.setText(entEmpleado.getId_cargo());

                    btnUpdate.setVisible(true);
                    btnCreate.setVisible(false);
                    btnDelete.setEnabled(true);

                    if (txtNombre.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, empl + " no existe");
                        txtEmpleado.setText("");
                        txtNombre.setText("");
                        txtApellido.setText("");
                        dteFecha.setDate(null);
                        txtTelefono.setText("");
                        txtDireccion.setText("");
                        txtEmail.setText("");
                        cmbEstado.setSelectedItem(oE[0]);
                        txtCargo.setText("");

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
                JOptionPane.showMessageDialog(null, "Ingrese el id del empleado", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            } else {
                String id = txtEmpleado.getText();

                int conf = JOptionPane.showConfirmDialog(null, "Seguro quieres eliminar el empleado " + id);
                if (conf == JOptionPane.YES_OPTION) {
                    ne.getEliminarEmpleado(id);
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

    public static void main(String g[]) {

        FrmEmpleado p = new FrmEmpleado();
        p.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
    }
}

package com.proyectorat.gui;

//Importación de paquetes
import com.toedter.calendar.JDateChooser;
import com.proyectorat.model.Entrada;
import com.proyectorat.manager.EntradaManagerImpl;
import com.proyectorat.persistence.SQL_Helpers;
import com.proyectorat.util.Conexion;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.*;
import javax.swing.table.DefaultTableModel;

public final class FrmEntrada extends Frm {

    EntradaManagerImpl ne = new EntradaManagerImpl();
    Entrada entEntrada = new Entrada();

    //Declaración de variables
    JLabel lblEmpleado, lblCons, lblHoraE, lblHoraS, lblFecha, lblLogo;
    JTextField txtEmpleado, txtCons, tmeHoraE, tmeHoraS;
    JDateChooser dteFecha;
    JButton btnSearch2;
    JSeparator Separator;
    Integer pos;
    JTable TablaDatos;
    DefaultTableModel dtm;
    JScrollPane tablapanel;
    Object[][] datos = new Object[0][4];
    Object[] Columnas = {"Consecutivo", "ID del empleado", "Hora de entrada", "Hora de salida", "Fecha"};
    JPanel controles;

    public FrmEntrada() {

        setTitle("Registo de entrada y salida");
        lblVentana.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/frm_entrada.png")));

        dtm = new DefaultTableModel(datos, Columnas) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        TablaDatos = new JTable(dtm);
        TablaDatos.setModel(dtm);
        tablapanel = new JScrollPane(TablaDatos);
        tablapanel.setBounds(25, 300, 857, 200);
        tablapanel.setVisible(true);

        lblEmpleado = new JLabel("* ID del empleado");
        lblCons = new JLabel("* Consecutivo");
        lblHoraE = new JLabel("* Hora de entrada");
        lblHoraS = new JLabel("  Hora de salida");
        lblFecha = new JLabel("* Fecha");

        txtEmpleado = new JTextField(4);
        txtCons = new JTextField(100);
        tmeHoraE = new JTextField(7);
        tmeHoraS = new JTextField(7);
        dteFecha = new JDateChooser();

        btnSearch2 = new JButton("Buscar");
        btnSearch2.setBackground(new Color(182, 182, 182));

        lblLogo = new JLabel();

        lblCons.setBounds(20, 50, 130, 30);
        lblEmpleado.setBounds(20, 85, 200, 30);
        lblFecha.setBounds(20, 120, 200, 30);
        lblHoraE.setBounds(410, 50, 200, 30);
        lblHoraS.setBounds(410, 85, 200, 30);

        txtCons.setBounds(180, 50, 100, 30);
        txtEmpleado.setBounds(180, 85, 200, 30);
        dteFecha.setBounds(180, 120, 200, 30);
        tmeHoraE.setBounds(550, 50, 100, 30);
        tmeHoraS.setBounds(550, 85, 100, 30);

        btnSearch2.setBounds(360, 410, 110, 30);

        pnlFondo.add(tablapanel);

        pnlFondo.add(lblEmpleado);
        pnlFondo.add(lblHoraE);
        pnlFondo.add(lblCons);
        pnlFondo.add(lblHoraS);
        pnlFondo.add(lblFecha);

        pnlFondo.add(txtEmpleado);
        pnlFondo.add(txtCons);
        pnlFondo.add(tmeHoraE);
        pnlFondo.add(dteFecha);
        pnlFondo.add(tmeHoraS);

        pnlFondo.add(btnSearch2);

        btnUpdate.setVisible(false);

        btnSearch2.addActionListener(this);

        rellenarTabla();

        txtCons.setEnabled(false);
        lblCons.setEnabled(false);
        btnSearch2.setVisible(false);

        setVisible(true);
        this.repaint();

    }

    boolean validarEmail(String email) {
        String mensaje;
        Pattern p = Pattern.compile("^[a-zA-Z0-9_\\-\\.~]{2,}@[a-zA-Z0-9_\\-\\.~]{2,}\\.[a-zA-Z]{2,4}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private void rellenarTabla() {
        Conexion c = new Conexion();
        try {
            ResultSet r = c.getCon().prepareStatement(SQL_Helpers.getEntrada()).executeQuery();
            while (r.next()) {
                Object[] fila = new Object[5];
                fila[1] = r.getString(1);
                fila[0] = r.getString(2);
                fila[2] = r.getString(3);
                fila[3] = r.getString(4);
                fila[4] = r.getString(5);
                dtm.addRow(fila);
                TablaDatos = new JTable(dtm);
            }

            TablaDatos.updateUI();

        } catch (SQLException e) {
        }
    }

    void rellenarTablaBusqueda(String id_empleado) {
        Conexion c = new Conexion();
        try {
            ResultSet r = c.getCon().prepareStatement(SQL_Helpers.getEntrada(id_empleado)).executeQuery();
            while (r.next()) {
                Object[] fila = new Object[5];
                fila[1] = r.getString(1);
                fila[0] = r.getString(2);
                fila[2] = r.getString(3);
                fila[3] = r.getString(4);
                fila[4] = r.getString(5);
                dtm.addRow(fila);
                TablaDatos = new JTable(dtm);

            }

            if (dtm.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados");
                setVisible(false);
                new FrmEntrada().setVisible(true);
            }

            TablaDatos.updateUI();

        } catch (SQLException e) {

        }
    }

    void vaciarTabla() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent accion) {

        //-------------GUARDAR-------------
        if (accion.getSource() == btnCreate) {

            String mensaje = "";

            //Campos obligatorios
            if ("".equals(txtEmpleado.getText())) {
                mensaje += "Ingrese el id del empleado";
            } else if (!isNumber(txtEmpleado.getText())) {
                mensaje += "El ID del empleado debe ser solo cuatro números.";
            }
            //Campos no obligatorios

            if (null == dteFecha.getDate()) {
                mensaje += "\nIngrese fecha";
            }

            if ("".equals(tmeHoraE.getText())) {
                mensaje += "\nIngrese hora de entrada";
            }

            if ("".equals(tmeHoraS.getText())) {
                mensaje += "\nIngrese hora de salida";
            }

            //Excepciones
            if (!"".equals(mensaje)) {
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            java.util.Date uDate;

            String emp = txtEmpleado.getText();
            String con = txtCons.getText();
            String hoe = tmeHoraE.getText();
            uDate = dteFecha.getDate();
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            String hos = tmeHoraS.getText();

            txtEmpleado.setText("");
            txtCons.setText("");
            tmeHoraE.setText("");
            dteFecha.setDate(null);
            tmeHoraS.setText("");

            try {
                entEntrada.setId_empleado(emp);
                entEntrada.setCons(ne.getCons());
                entEntrada.setHora_entrada(hoe);
                entEntrada.setFecha(sDate);
                entEntrada.setHora_salida(hos);
                ne.getGuardarEntrada(entEntrada);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No guardado");
            }

            setVisible(false);
            new FrmEntrada().setVisible(true);

        }
        //----------LIMPIAR-------------

        if (accion.getSource() == btnClean) {
            setVisible(false);
            new FrmEntrada().setVisible(true);

            txtCons.setEnabled(false);
            lblCons.setEnabled(false);
            btnUpdate.setVisible(false);
            btnCreate.setVisible(true);
        }
        //--------ACTUALIZAR---------

        if (accion.getSource() == btnUpdate) {

            String mensaje = "";

            //Campos obligatorios
            if ("".equals(txtEmpleado.getText())) {
                mensaje += "Ingrese el id del empleado";
            } else if (!isNumber(txtEmpleado.getText())) {
                mensaje += "El ID del empleado debe ser solo cuatro números.";
            }
            //Campos no obligatorios

            if (null == dteFecha.getDate()) {
                mensaje += "\nIngrese fecha";
            }

            if ("".equals(tmeHoraE.getText())) {
                mensaje += "\nIngrese hora de entrada";
            }

            if ("".equals(tmeHoraS.getText())) {
                mensaje += "\nIngrese hora de salida";
            }

            //Excepciones
            if (!"".equals(mensaje)) {
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            java.util.Date uDate;

            String hoe = tmeHoraE.getText();
            uDate = dteFecha.getDate();
            java.sql.Date sDate = new java.sql.Date(uDate.getTime());
            String hos = tmeHoraS.getText();

            vaciarTabla();
            TablaDatos.updateUI();
            rellenarTabla();

            txtEmpleado.setText("");
            txtCons.setText(ne.getCons());
            tmeHoraE.setText("");
            dteFecha.setDate(null);
            tmeHoraS.setText("");

            try {
                entEntrada.setHora_entrada(hoe);
                entEntrada.setFecha(sDate);
                entEntrada.setHora_salida(hos);
                ne.getEditarEntrada(entEntrada);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No guardado");
            }

            setVisible(false);
            new FrmEntrada().setVisible(true);

        }
        //--------BUSCAR-------------

        if (accion.getSource() == btnSearch) {

            if (txtEmpleado.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Ingrese el ID del empleado");

            } else {

                String entr = txtEmpleado.getText();
                entEntrada = ne.getEntrada(entr);
                if (!"*".equals(entEntrada.getId_empleado())) {
                    vaciarTabla();
                    rellenarTablaBusqueda(entr);

                    txtCons.setText("");

                    txtCons.setEnabled(true);
                    lblCons.setEnabled(true);

                    btnSearch.setVisible(false);
                    btnSearch2.setVisible(true);
                    txtEmpleado.setEnabled(false);

                } else {
                    JOptionPane.showMessageDialog(null, entr + " no existe");
                }
            }
        }

        if (accion.getSource() == btnSearch2) {

            if (txtCons.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "Ingrese el consecutivo", "Error", ERROR);

            } else {

                String entr = txtEmpleado.getText();
                String entr2 = txtCons.getText();
                entEntrada = ne.getEntrada_Cons(entr2, entr);
                if (!"*".equals(entEntrada.getCons())) {
                    tmeHoraE.setText(entEntrada.getHora_entrada());
                    tmeHoraS.setText(entEntrada.getHora_salida());
                    dteFecha.setDate(entEntrada.getFecha());

                    btnDelete.setEnabled(true);
                    btnCreate.setVisible(false);
                    btnUpdate.setVisible(true);

                    if (tmeHoraE.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, entr2 + " no existe");
                        txtCons.setText("");
                    }
                }
            }
        }
        //----------ELIMINAR-------------

        if (accion.getSource() == btnDelete) {
            if (txtCons.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el consecutivo", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String entr = txtCons.getText();
                String entr2 = txtEmpleado.getText();

                int conf = JOptionPane.showConfirmDialog(null, "Seguro quieres eliminar el registro " + entr);
                if (conf == JOptionPane.YES_OPTION) {
                    ne.getEliminarEntrada(entr, entr2);
                    setVisible(false);
                    new FrmEntrada().setVisible(true);
                    txtCons.setEnabled(false);
                    lblCons.setEnabled(false);
                    btnUpdate.setVisible(false);
                    btnCreate.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Eliminado");
                } else if (conf == JOptionPane.NO_OPTION) {
                    setVisible(false);
                    new FrmEntrada().setVisible(true);
                    txtCons.setEnabled(false);
                    lblCons.setEnabled(false);
                    btnUpdate.setVisible(false);
                    btnCreate.setVisible(true);
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

        FrmEntrada p = new FrmEntrada();
        p.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

    }
}

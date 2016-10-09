


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.*;

public class Plantilla_Frm extends JFrame implements ActionListener {

    JPanel pnlSuperior, pnlMenu, pnlFondo;
    JButton btnCargo, btnEmpleado, btnEntrada, btnRegistro, btnTipo, btnUsuario, btnSesion;
    JLabel lblVentana;
    JSeparator jSeparator1, jSeparator2, jSeparator3;

    public Plantilla_Frm() {

        //Interfaz
        setTitle("Titulo");
        setSize(910, 540);
        setLocationRelativeTo(this);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlSuperior = new JPanel();
        pnlMenu = new JPanel();
        btnUsuario = new JButton("Usuarios");
        btnEmpleado = new JButton("Empleados");
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        btnEntrada = new JButton("Entrada y salida");
        btnCargo = new JButton("Cargos");
        jSeparator3 = new JSeparator();
        btnRegistro = new JButton("Asignación");
        btnTipo = new JButton("Tipos de actividades");
        btnSesion = new javax.swing.JButton();
        lblVentana = new javax.swing.JLabel();
        pnlFondo = new JPanel();

        pnlFondo.setBackground(new Color(254, 254, 254));
        pnlFondo.setLayout(null);
        getContentPane().add(pnlFondo);
        pnlFondo.setBounds(0, 0, 910, 540);

        pnlSuperior.setBackground(new Color(182, 182, 182));
        pnlSuperior.setLayout(null);
        pnlFondo.add(pnlSuperior);
        pnlSuperior.setBounds(180, 0, 730, 50);

        pnlMenu.setBackground(new Color(73, 137, 201));
        pnlMenu.setLayout(null);
        pnlFondo.add(pnlMenu);
        pnlMenu.setBounds(0, 0, 180, 540);

        btnUsuario.setBounds(12, 119, 156, 28);
        pnlMenu.add(btnUsuario);

        pnlMenu.add(btnEmpleado);
        btnEmpleado.setBounds(12, 159, 156, 28);

        pnlMenu.add(jSeparator1);
        jSeparator1.setBounds(0, 205, 180, 10);

        pnlMenu.add(jSeparator2);
        jSeparator2.setBounds(0, 103, 180, 10);

        pnlMenu.add(btnEntrada);
        btnEntrada.setBounds(12, 221, 156, 28);

        pnlMenu.add(btnCargo);
        btnCargo.setBounds(12, 283, 156, 28);

        pnlMenu.add(jSeparator3);
        jSeparator3.setBounds(0, 267, 180, 10);

        pnlMenu.add(btnRegistro);
        btnRegistro.setBounds(12, 323, 156, 28);

        pnlMenu.add(btnTipo);
        btnTipo.setBounds(12, 363, 156, 28);

        btnSesion.setText("Cerrar sesión");
        pnlMenu.add(btnSesion);
        btnSesion.setBounds(55, 500, 115, 28);

        lblVentana.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/frm_empleado.png")));
        pnlMenu.add(lblVentana);
        lblVentana.setBounds(60, 30, 60, 60);

        URL iconURL = getClass().getResource("/com/resources/img/favicon_48x48.png");
        ImageIcon icon = new ImageIcon(iconURL);
        setIconImage(icon.getImage());

        btnUsuario.addActionListener(this);
        btnEmpleado.addActionListener(this);
        btnEntrada.addActionListener(this);
        btnCargo.addActionListener(this);
        btnRegistro.addActionListener(this);
        btnTipo.addActionListener(this);
        btnSesion.addActionListener(this);

        //Fin interfaz
        setVisible(true);
        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent accion) {
        /*---------MENÚ--------------------

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
            setVisible(false);
            FrmTipo ventana = new FrmTipo();
            ventana.setVisible(true);
        }
        if (accion.getSource() == btnSesion) {
            setVisible(false);
            FrmIngreso ventana = new FrmIngreso();
            ventana.setVisible(true);
        }*/
    }

    public static void main(String[] args) {

        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

        new Plantilla_Frm().setVisible(true);
    }
}

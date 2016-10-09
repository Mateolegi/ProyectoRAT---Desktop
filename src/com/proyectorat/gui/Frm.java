package com.proyectorat.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class Frm extends JFrame implements ActionListener {

    JPanel pnlSuperior, pnlMenu, pnlFondo;
    JButton btnCargo, btnEmpleado, btnEntrada, btnRegistro, btnTipo, btnUsuario, btnSesion;
    JLabel lblVentana, lblLogo;
    JSeparator jSeparator1, jSeparator2, jSeparator3;
    JButton btnCreate, btnClean, btnUpdate, btnSearch, btnDelete;

    public Frm() {
        
        lookAndFeel();

        //Interfaz
        setTitle("Registro de actividades y tiempo");
        setSize(1087, 643);
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
        btnSesion = new JButton();
        lblVentana = new JLabel();
        pnlFondo = new JPanel();
        lblLogo = new JLabel();

        pnlFondo.setBackground(new Color(236, 240, 241));
        pnlFondo.setLayout(null);
        getContentPane().add(pnlFondo);
        pnlFondo.setBounds(180, 50, 907, 593);
        
        pnlSuperior.setBackground(new Color(127, 140, 141));
        pnlSuperior.setLayout(null);
        getContentPane().add(pnlSuperior);
        pnlSuperior.setBounds(180, 0, 907, 50);

        pnlMenu.setBackground(new Color(41, 128, 185));
        pnlMenu.setLayout(null);
        getContentPane().add(pnlMenu);
        pnlMenu.setBounds(0, 0, 180, 643);
        
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/logo_mini.png")));
        pnlSuperior.add(lblLogo);
        lblLogo.setBounds(514, 0, 196, 50);

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
        btnSesion.setBounds(55, 460, 115, 28);

        pnlMenu.add(lblVentana);
        lblVentana.setBounds(60, 30, 60, 60);

        URL iconURL = getClass().getResource("/com/resources/img/favicon48.png");
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
        
        btnCreate = new JButton("Crear");
        btnClean = new JButton("Limpiar");
        btnUpdate = new JButton("Actualizar");
        btnSearch = new JButton("Buscar");
        btnDelete = new JButton("Eliminar");
        
        btnCreate.setBackground(new Color(182, 182, 182));
        btnClean.setBackground(new Color(182, 182, 182));
        btnUpdate.setBackground(new Color(182, 182, 182));
        btnSearch.setBackground(new Color(182, 182, 182));
        btnDelete.setBackground(new Color(182, 182, 182));
        
        btnCreate.setBounds(120, 410, 110, 30);
        btnClean.setBounds(240, 410, 110, 30);
        btnUpdate.setBounds(120, 410, 110, 30);
        btnSearch.setBounds(360, 410, 110, 30);
        btnDelete.setBounds(480, 410, 110, 30);
        
        pnlFondo.add(btnCreate);
        pnlFondo.add(btnClean);
        pnlFondo.add(btnUpdate);
        pnlFondo.add(btnSearch);
        pnlFondo.add(btnDelete);
        
        btnDelete.setEnabled(false);
        
        btnCreate.addActionListener(this);
        btnClean.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnSearch.addActionListener(this);
        btnDelete.addActionListener(this);
        
        setVisible(true);
        this.repaint();

    }
    
    public static boolean isNumber(String n){
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void lookAndFeel(){
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
    }

    public static void main(String[] args) {

        String OS = System.getProperty("os.name");

        if (null != OS) switch (OS) {
            case "Windows":
                try {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                }   break;
            case "Linux":
                try {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                }       break;
            default:
                try {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                }   break;
        }

        new Frm().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

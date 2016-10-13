
package com.proyectorat.gui;

import java.awt.Color;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class FrmInicio extends JFrame implements ActionListener {
    
    private final JButton btnCargo, btnEmpleado, btnEntrada, btnRegistro, btnTipo, btnUsuario;
    private final JLabel lblCargo,lblEmpleado, lblEntrada, lblLogo, lblRegistro, lblTipo, lblUsuario;
    private final JPanel pnlFondo, pnlSuperior;
    
    public FrmInicio(){
        
        pnlSuperior = new JPanel();
        pnlFondo = new JPanel();
        btnTipo = new JButton();
        btnUsuario = new JButton();
        btnEmpleado = new JButton();
        btnEntrada = new JButton();
        btnCargo = new JButton();
        btnRegistro = new JButton();
        lblLogo = new JLabel();
        lblTipo = new JLabel();
        lblUsuario = new JLabel();
        lblEmpleado = new JLabel();
        lblEntrada = new JLabel();
        lblCargo = new JLabel();
        lblRegistro = new JLabel();
        
        setTitle("Registro de actividades y tiempos - Pinvalidda");
        setSize(910, 560);
        setLocationRelativeTo(this);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlSuperior.setBackground(new Color(127, 140, 141));
        pnlSuperior.setLayout(null);
        getContentPane().add(pnlSuperior);
        pnlSuperior.setBounds(0, 0, 910, 50);

        pnlFondo.setBackground(new Color(236, 240, 241));
        pnlFondo.setLayout(null);

        btnTipo.setBorderPainted(false);
        btnTipo.setBackground(new Color(236, 240, 241));
        btnTipo.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/menu_tipo.png")));
        pnlFondo.add(btnTipo);
        btnTipo.setBounds(560, 360, 140, 140);

        btnUsuario.setBorderPainted(false);
        btnUsuario.setBackground(new Color(236, 240, 241));
        btnUsuario.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/menu_usuario.png")));
        pnlFondo.add(btnUsuario);
        btnUsuario.setBounds(200, 180, 140, 140);

        btnEmpleado.setBorderPainted(false);
        btnEmpleado.setBackground(new Color(236, 240, 241));
        btnEmpleado.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/menu_empleado.png")));
        pnlFondo.add(btnEmpleado);
        btnEmpleado.setBounds(380, 180, 140, 140);

        btnEntrada.setBorderPainted(false);
        btnEntrada.setBackground(new Color(236, 240, 241));
        btnEntrada.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/menu_entrada.png")));
        pnlFondo.add(btnEntrada);
        btnEntrada.setBounds(560, 180, 140, 140);

        btnCargo.setBorderPainted(false);
        btnCargo.setBackground(new Color(236, 240, 241));
        btnCargo.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/menu_cargo.png")));
        pnlFondo.add(btnCargo);
        btnCargo.setBounds(200, 360, 140, 140);

        btnRegistro.setBorderPainted(false);
        btnRegistro.setBackground(new Color(236, 240, 241));
        btnRegistro.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/menu_registro.png")));
        pnlFondo.add(btnRegistro);
        btnRegistro.setBounds(380, 360, 140, 140);

        lblLogo.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/logo.png")));
        pnlFondo.add(lblLogo);
        lblLogo.setBounds(250, 60, 400, 100);

        lblTipo.setText("Registro de actividades");
        pnlFondo.add(lblTipo);
        lblTipo.setBounds(550, 500, 170, 18);

        lblUsuario.setText("Registro de usuarios");
        pnlFondo.add(lblUsuario);
        lblUsuario.setBounds(200, 320, 150, 18);

        lblEmpleado.setText("Registro de empleados");
        pnlFondo.add(lblEmpleado);
        lblEmpleado.setBounds(370, 320, 170, 18);

        lblEntrada.setText("Entradas y salidas");
        pnlFondo.add(lblEntrada);
        lblEntrada.setBounds(570, 320, 140, 18);

        lblCargo.setText("Registro de cargos");
        pnlFondo.add(lblCargo);
        lblCargo.setBounds(210, 500, 140, 18);

        lblRegistro.setText("Asignación de actividades");
        pnlFondo.add(lblRegistro);
        lblRegistro.setBounds(360, 500, 190, 18);

        getContentPane().add(pnlFondo);
        pnlFondo.setBounds(0, 0, 910, 560);
        
        btnUsuario.addActionListener(this);
        btnEmpleado.addActionListener(this);
        btnEntrada.addActionListener(this);
        btnCargo.addActionListener(this);
        btnRegistro.addActionListener(this);
        btnTipo.addActionListener(this);
        
        URL iconURL = getClass().getResource("/com/resources/img/favicon48.png");
        ImageIcon icon = new ImageIcon(iconURL);
        setIconImage(icon.getImage());

        setVisible(true);
        this.repaint();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnCargo){
            FrmCargo cargo = new FrmCargo();
            cargo.setVisible(true);
            setVisible(false);
        }
        
        if(e.getSource()==btnUsuario){
            FrmUsuario usuario = new FrmUsuario();
            usuario.setVisible(true);
            setVisible(false);
        }
        if(e.getSource()==btnEntrada){
            FrmEntrada entrada = new FrmEntrada();
            entrada.setVisible(true);
            setVisible(false);
        }
        
        if(e.getSource()==btnEmpleado){
            FrmEmpleado empleado = new FrmEmpleado();
            empleado.setVisible(true);
            setVisible(false);
        }
        
        if(e.getSource()==btnRegistro){
            FrmRegistro registro = new FrmRegistro();
            registro.setVisible(true);
            setVisible(false);
        }
        
        if(e.getSource()==btnTipo){
            FrmTipo tipo = new FrmTipo();
            tipo.setVisible(true);
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args) {

       new FrmInicio().setVisible(true);
       
    }
    
}

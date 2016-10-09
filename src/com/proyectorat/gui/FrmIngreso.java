package com.proyectorat.gui;

import com.proyectorat.util.Conexion;
import com.proyectorat.persistence.Dao_Usuario;
import com.proyectorat.persistence.SQL_Helpers;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmIngreso extends JFrame implements ActionListener {

    JButton btnForgot, btnSesion;
    JCheckBox ckbRemember;
    JLabel lblAna1, lblAna2, lblLogo, lblUser, lblPass;
    JPanel pnlCuadro, pnlFondo, pnlSuperior;
    JTextField txtPass, txtUser;
    Connection c;
    Dao_Usuario dao;

    Conexion conexion = new Conexion();
    
    public FrmIngreso() {

        setTitle("Inicio de sesión");
        setSize(910, 550);
        setLocationRelativeTo(this);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlSuperior = new JPanel();
        pnlFondo = new JPanel();
        lblLogo = new JLabel();
        pnlCuadro = new JPanel();
        txtUser = new JTextField();
        ckbRemember = new JCheckBox("Recordar nombre de usuario", false);
        btnSesion = new JButton();
        btnForgot = new JButton();
        txtPass = new JPasswordField();
        lblPass = new JLabel();
        lblUser = new JLabel();
        lblAna2 = new JLabel();
        lblAna1 = new JLabel();

        pnlSuperior.setBackground(new Color(182, 182, 182));
        pnlSuperior.setLayout(null);
        //getContentPane().add(pnlSuperior);
        pnlSuperior.setBounds(0, 0, 910, 50);

        pnlFondo.setBackground(new Color(9, 41, 56));
        pnlFondo.setSize(910, 550);
        pnlFondo.setLayout(null);

        lblLogo.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/logo.png")));
        pnlFondo.add(lblLogo);
        lblLogo.setBounds(250, 60, 400, 100);

        pnlCuadro.setBackground(new Color(189, 195, 199));
        pnlCuadro.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        pnlCuadro.setLayout(null);

        pnlCuadro.add(txtUser);
        try {
            txtUser.setText(leerTexto("UserSaved"));
        } catch (Exception e) {
        }
        txtUser.setBounds(200, 30, 220, 40);

        pnlCuadro.add(ckbRemember);
        ckbRemember.setBackground(new Color(189, 195, 199));
        ckbRemember.setBounds(120, 120, 240, 22);

        btnSesion.setText("Iniciar sesión");
        pnlCuadro.add(btnSesion);
        btnSesion.setBounds(320, 178, 140, 30);

        btnForgot.setText("Recuperar contraseña");
        btnForgot.setBorderPainted(false);
        pnlCuadro.add(btnForgot);
        btnForgot.setBorder(null);
        btnForgot.setBackground(new Color(189, 195, 199));
        btnForgot.setBounds(10, 180, 200, 28);
        
        pnlCuadro.add(txtPass);
        txtPass.setBounds(200, 70, 220, 40);

        lblPass.setText("Contraseña");
        pnlCuadro.add(lblPass);
        lblPass.setBounds(90, 70, 90, 40);

        lblUser.setText("Nombre de usuario");
        pnlCuadro.add(lblUser);
        lblUser.setBounds(39, 30, 160, 40);

        pnlFondo.add(pnlCuadro);
        pnlCuadro.setBounds(200, 200, 470, 220);

        lblAna2.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/cce.png")));
        pnlFondo.add(lblAna2);
        lblAna2.setBounds(710, 460, 130, 56);

        lblAna1.setIcon(new ImageIcon(getClass().getResource("/com/resources/img/logo_Norton_131x50.png")));
        pnlFondo.add(lblAna1);
        lblAna1.setBounds(550, 460, 131, 50);

        getContentPane().add(pnlFondo);
        pnlFondo.setBounds(0, 0, 910, 550);
        
        URL iconURL = getClass().getResource("/com/resources/img/favicon48.png");
        ImageIcon icon = new ImageIcon(iconURL);
        setIconImage(icon.getImage());

        conexion.ConexionBd();
        if (conexion.verificarBD() == false) {
            JOptionPane.showMessageDialog(null, "Parece que la conexión al sistema está caída.\nRevice la conexión e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        btnSesion.addActionListener(this);
        btnForgot.addActionListener(this);
        

    }

    public static String leerTexto(String txt) throws FileNotFoundException, IOException{
        String user;
        FileReader f = new FileReader(txt);
        try (BufferedReader b = new BufferedReader(f)) {
            user = b.readLine();
        }
        return user;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnSesion) {

            try {
                if (txtUser.getText().length() > 0 && txtPass.getText().length() > 0) {

                    if (validarUsuario(txtUser.getText(), txtPass.getText())) {

                        File fr = new File("Register");
                            try {
                                FileWriter w = new FileWriter(fr);
                                BufferedWriter bw = new BufferedWriter(w);
                                try (PrintWriter wr = new PrintWriter(bw)) {
                                    wr.write(txtUser.getText());
                                }
                            } catch (IOException eio) {
                            }
                        
                        setVisible(false);
                        FrmInicio inicio = new FrmInicio();
                        inicio.setVisible(true);
                        
                        if (ckbRemember.isSelected()) {
                            File f = new File("UserSaved");
                            try {
                                FileWriter w = new FileWriter(f);
                                BufferedWriter bw = new BufferedWriter(w);
                                try (PrintWriter wr = new PrintWriter(bw)) {
                                    wr.write(txtUser.getText());
                                }
                            } catch (IOException eio) {
                            }
                        } else if (!ckbRemember.isSelected()) {
                            File f = new File("UserSaved");
                            f.delete();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El nombre de usuario y/o contraseña no son válidos.");
                        txtUser.setText("");
                        txtPass.setText("");

                        txtUser.requestFocusInWindow();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debe escribir nombre de usuario y contraseña.\n"
                            + "No puede dejar ningún campo vacío");
                }

            } catch (IOException | HeadlessException ex) {
            }
        }
    }

    boolean validarUsuario(String usua, String pass) throws IOException {

        String usu = txtUser.getText();
        String con = txtPass.getText();

        try {

            Conexion co = new Conexion();
            ResultSet r = co.getCon().prepareStatement(SQL_Helpers.getValidarIngreso(usua, pass)).executeQuery();

            return r.first();
        } catch (SQLException e) {
            return false;
        }

    }

    public static void main(String g[]) {
        new FrmIngreso().setVisible(true);
    }

}

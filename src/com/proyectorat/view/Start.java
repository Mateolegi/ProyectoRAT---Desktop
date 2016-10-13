package com.proyectorat.view;

import com.proyectorat.manager.Temporal;
import com.proyectorat.util.Conexion;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Start {
    
    public static void main(String[] args) {

        String VOS = System.getProperty("os.name");
        String OS[] = VOS.split(" ");
        System.out.println(OS[0] + " detected");

        try {
            Temporal tmp = new Temporal();
            tmp.tempFile.deleteOnExit();
        } catch (IOException ex) {
        }
        
        if (null != OS[0]) {
            switch (OS[0]) {
                case "Windows":
                    try {
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    }
                    break;
                case "Linux":
                    try {
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    }
                    break;
                default:
                    try {
                        JFrame.setDefaultLookAndFeelDecorated(true);
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    }
                    break;
            }
        }
        Conexion conexion = new Conexion();
        conexion.ConexionBd();
        if (conexion.verificarBD() == false) {
            JOptionPane.showMessageDialog(null, "Parece que la conexión al sistema está caída.\nRevice la conexión e inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            System.out.println("Conexión establecida");
            new Main().setVisible(true);
        }
    }
}
package com.proyectorat.manager;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author mateo
 */
public class AbrirWeb {
    public void abrirSitio(String link) {
        try {
            Process P = Runtime.getRuntime().exec("cmd /c start " + link);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
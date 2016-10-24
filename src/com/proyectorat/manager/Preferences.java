package com.proyectorat.manager;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author mateo
 */
public class Preferences {
    
    public static Properties prop = new Properties();
    
    public void saveProp(String title, String value) {
        try {
            prop.setProperty(title, value);
            prop.store(new FileOutputStream("configuration.properties"), null);
        } catch (IOException e) {
        }
    }
    
    public String getProp(String title) {
        String value = "";
        try {
            prop.load(new FileInputStream("configuration.properties"));
            value = prop.getProperty(title);
        } catch (IOException ex) {
        }
        return value;
    }
    
    public Color colorEnfasis() {
        String color = getProp("Color panel");
        Color colorR = new Color(41, 128, 185);
        if (color != null) {
            switch (color) {
                case "Belize Hole":
                    colorR = new Color(41, 128, 185);
                    break;
                case "Green Sea":
                    colorR = new Color(22, 160, 133);
                    break;
                case "Nephritis":
                    colorR = new Color(39, 174, 96);
                    break;
                case "Wisteria":
                    colorR = new Color(142, 68, 173);
                    break;
                case "Orange":
                    colorR = new Color(243, 156, 18);
                    break;
                case "Pumpkin":
                    colorR = new Color(211, 84, 0);
                    break;
                case "Pomegranate":
                    colorR = new Color(192, 57, 43);
                    break;
                default:
                    colorR = new Color(41, 128, 185);
                    break;
            }
        }
        return colorR;
    }
}

package com.proyectorat.manager;

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
}

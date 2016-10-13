package com.proyectorat.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author mateo
 */
public class Temporal {

    public File tempFile = File.createTempFile("RAT", "Temp");
    BufferedReader in = new BufferedReader(new FileReader(tempFile));
    BufferedWriter out = new BufferedWriter(new FileWriter(tempFile));
    
    public Temporal() throws IOException {
    }

    public void saveTemp(String title, String value) throws IOException {
        out.write(title + "=" + value);
        out.newLine();
        out.flush();
    }

    public String getTemp(String title) throws IOException {
        String value = "";
        String linea = in.readLine();
        while (linea != null) {
            String parametros[] = linea.split("=");
            if (parametros[0].equals(title)) {
                return parametros[1];
            }
            linea = in.readLine();
        }
        return value;
    }

//    public static void main(String[] args) throws IOException {
//        Temporal temp = new Temporal();
//        temp.saveTemp("Color", "azul");
//        temp.saveTemp("tipo", "madera");
//        temp.saveTemp("materia", "matematicas");
//        System.out.println(temp.getTemp("tipo"));
//        Scanner  sc = new Scanner (System.in);
//        String strnig = sc.nextLine();
//    }
}

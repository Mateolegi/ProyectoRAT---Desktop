package com.proyectorat.manager;

import com.proyectorat.model.Entrada;
import com.proyectorat.persistence.Dao_Entrada;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Mateo Leal
 */
public class EntradaManagerImpl {

    Connection c;
    Dao_Entrada dao;

    public EntradaManagerImpl() {
        dao = new Dao_Entrada();
    }

    public Entrada getEntrada(Integer idEmpleado, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEntrada(c, idEmpleado, idEmpresa);
    }
    
    public Entrada getEntrada_Cons(Integer cons, Integer emp, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEntrada_Cons(c, cons, emp, idEmpresa);
    }
    
    public String getCons() {

        c = new Conexion().getCon();
        return dao.getCons(c, "tblentrada_salida", "cons", 4);
    }

    public ArrayList<Entrada> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoEntradas(c);
    }

    public void getGuardarEntrada(Entrada u) throws Exception {
        Integer emp, con, idEmpresa;
        String mensaje;
        Date hoe, hos, fec;
        emp = Integer.parseInt(u.getId_empleado());
        con = Integer.parseInt(u.getCons());
        hoe = Date.valueOf(u.getHora_entrada());
        fec = u.getFecha();
        hos = Date.valueOf(u.getHora_salida());
        idEmpresa = Integer.parseInt(u.getEmpresa());
        mensaje = "";

        //Campos obligatorios
        if (null == emp) {
            mensaje += "Ingrese el ID del empleado";
        }
        //Campos no obligatorios
        
        if (null == fec) {
            mensaje += "\nIngrese fecha";
        }
        
        if (null == hoe) {
            mensaje += "\nIngrese hora de entrada";
        }
        
        if (null == hos) {
            mensaje += "\nIngrese hora de salida";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getGuardarEntrada(c, emp, con, hoe, hos, fec, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public void getEditarEntrada(Entrada u) throws Exception {
        Integer emp, con, idEmpresa;
        String mensaje;
        Date hoe, hos, fec;
        emp = Integer.parseInt(u.getId_empleado());
        con = Integer.parseInt(u.getCons());
        hoe = Date.valueOf(u.getHora_entrada());
        fec = u.getFecha();
        hos = Date.valueOf(u.getHora_salida());
        idEmpresa = Integer.parseInt(u.getEmpresa());
        mensaje = "";

        //Campos obligatorios
        if (null == emp) {
            mensaje += "Ingrese el ID del empleado";
        }
        //Campos no obligatorios
        
        if (null == fec) {
            mensaje += "\nIngrese fecha";
        }
        
        if (null == hoe) {
            mensaje += "\nIngrese hora de entrada";
        }
        
        if (null == hos) {
            mensaje += "\nIngrese hora de salida";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getEditarEntrada(c, emp, con, hoe, hos, fec, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public Entrada getEliminarEntrada(Integer cons, Integer idEmpleado, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEliminarEntrada(c, cons, idEmpleado, idEmpresa);
    }
}

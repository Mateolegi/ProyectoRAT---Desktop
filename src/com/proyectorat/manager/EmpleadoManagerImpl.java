package com.proyectorat.manager;

import com.proyectorat.model.Empleado;
import com.proyectorat.persistence.Dao_Empleado;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Mateo Leal
 */
public class EmpleadoManagerImpl {

    Connection c;
    Dao_Empleado dao;

    public EmpleadoManagerImpl() {
        dao = new Dao_Empleado();
    }

    public Empleado getEmpleado(Integer idEmpleado, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEmpleado(c, idEmpleado, idEmpresa);
    }

    public String getCons() {

        c = new Conexion().getCon();
        return dao.getCons(c, "tblempleado", "id_empleado", 4);
    }

    public ArrayList<Empleado> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoEmpleados(c);
    }

    public void getGuardarEmpleado(Empleado u) throws Exception {
        Integer emp, tel, car, idEmpresa;
        String mensaje, nom, ape, dir, cor, est;
        Date fec;
        emp = Integer.parseInt(u.getId_empleado());
        nom = u.getNombre();
        ape = u.getApellidos();
        fec = u.getFecha_n();
        tel = Integer.parseInt(u.getTelefono());
        dir = u.getDireccion();
        cor = u.getEmail();
        est = u.getEstado();
        car = Integer.parseInt(u.getId_cargo());
        idEmpresa = Integer.parseInt(u.getEmpresa());
        
        mensaje = "";
        
        //Campos obligatorios
        if (null == emp) {
            mensaje += "Ingrese ID del empleado";
        }

        //Campos no obligatorios
        if ("".equals(dir) || null == dir) {
            dir = "Ingrese dirección";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(ape) || null == ape) {
            mensaje += "Ingrese los apellidos";
        }
        
        if ("".equals(cor) || null == cor) {
            mensaje += "Ingrese el correo electrónico";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Activo";
        }
        
        if (null == tel) {
            mensaje += "Ingrese el teléfono";
        }
        
        if (null == car) {
            mensaje += "Ingrese ID del cargo";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getGuardarEmpleado(c, emp, nom, ape, fec, tel, dir, cor, est, car, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public void getEditarEmpleado(Empleado u) throws Exception {
        Integer emp, tel, car, idEmpresa;
        String mensaje, nom, ape, dir, cor, est;
        Date fec;
        emp = Integer.parseInt(u.getId_empleado());
        nom = u.getNombre();
        ape = u.getApellidos();
        fec = u.getFecha_n();
        tel = Integer.parseInt(u.getTelefono());
        dir = u.getDireccion();
        cor = u.getEmail();
        est = u.getEstado();
        car = Integer.parseInt(u.getId_cargo());
        idEmpresa = Integer.parseInt(u.getEmpresa());
        
        mensaje = "";
        
        //Campos obligatorios
        if (null == emp) {
            mensaje += "Ingrese ID del empleado";
        }

        //Campos no obligatorios
        if ("".equals(dir) || null == dir) {
            dir = "Ingrese dirección";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(ape) || null == ape) {
            mensaje += "Ingrese los apellidos";
        }
        
        if ("".equals(cor) || null == cor) {
            mensaje += "Ingrese el correo electrónico";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Activo";
        }
        
        if (null == tel) {
            mensaje += "Ingrese el teléfono";
        }
        
        if (null == car) {
            mensaje += "Ingrese ID del cargo";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getEditarEmpleado(c, emp, nom, ape, fec, tel, dir, cor, est, car, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public Empleado getEliminarEmpleado(Integer idEmpleado, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEliminarEmpleado(c, idEmpleado, idEmpresa);
    }
}

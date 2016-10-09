package com.proyectorat.manager;

import com.proyectorat.model.Cargo;
import com.proyectorat.persistence.Dao_Cargo;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Mateo Leal
 */
public class CargoManagerImpl {

    Connection c;
    Dao_Cargo dao;

    public CargoManagerImpl() {
        dao = new Dao_Cargo();
    }

    public Cargo getCargo(Integer idCargo, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getCargo(c, idCargo, idEmpresa);
    }

    public ArrayList<Cargo> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoCargos(c);
    }

    public void getGuardarCargo(Cargo u) throws Exception {
        String mensaje, nom, sal, est;
        Integer car, idEmpresa;
        car = Integer.parseInt(u.getId_cargo());
        nom = u.getNombre();
        sal = u.getSalario();
        est = u.getEstado();
        idEmpresa = Integer.parseInt(u.getEmpresa());
        
        mensaje = "";

        //Campos obligatorios
        if (null == car) {
            mensaje += "Ingrese ID de cargo";
        }

        //Campos no obligatorios
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(sal) || null == sal) {
            mensaje += "Ingrese salario";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Ingrese estado";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getGuardarCargo(c, car, nom, sal, est, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public void getEditarCargo(Cargo u) throws Exception {
        String mensaje, nom, sal, est;
        Integer car, idEmpresa;
        car = Integer.parseInt(u.getId_cargo());
        nom = u.getNombre();
        sal = u.getSalario();
        est = u.getEstado();
        idEmpresa = Integer.parseInt(u.getEmpresa());
        
        mensaje = "";

        //Campos obligatorios
        if (null == car) {
            mensaje += "Ingrese ID de cargo";
        }

        //Campos no obligatorios
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(sal) || null == sal) {
            mensaje += "Ingrese salario";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Ingrese estado";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getEditarCargo(c, car, nom, sal, est, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public Cargo getEliminarCargo(Integer idCargo, Integer idEmpleado) {

        c = new Conexion().getCon();
        return dao.getEliminarCargo(c, idCargo, idEmpleado);
    }
}

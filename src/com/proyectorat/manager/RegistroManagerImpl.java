package com.proyectorat.manager;

import com.proyectorat.model.Registro;
import com.proyectorat.persistence.Dao_Registro;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Mateo Leal
 */
public class RegistroManagerImpl {

    Connection c;
    Dao_Registro dao;

    public RegistroManagerImpl() {
        dao = new Dao_Registro();
    }

    public Registro getRegistro(Integer idEmpleado, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getRegistro(c, idEmpleado, idEmpresa);
    }

    public String getCons() {

        c = new Conexion().getCon();
        return dao.getCons(c, "tblregistro_actividades", "cons", 4);
    }

    public ArrayList<Registro> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoRegistros(c);
    }

    public void getGuardarRegistro(Registro u) throws Exception {
        Integer emp, con, act, idEmpresa;
        String mensaje, usu, est;
        Date fec;
        emp = Integer.parseInt(u.getId_empleado());
        con = Integer.parseInt(u.getCons());
        act = Integer.parseInt(u.getId_actividad());
        fec = u.getFecha();
        usu = u.getUsuario_creador();
        est = u.getEstado();
        idEmpresa = Integer.parseInt(u.getEmpresa());        
        mensaje = "";

        //Campos obligatorios
        if (null == emp) {
            mensaje += "Ingrese el ID del empleado";
        }

        //Campos no obligatorios
        if (null == usu || "".equals(usu)) {
            mensaje += "Ingrese el usuario";
        }
        
        if (null == act) {
            mensaje += "Ingrese el ID de la actividad";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Activo";
        }
        
        if(fec == null){
            mensaje += "Ingrese fecha";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getGuardarRegistro(c, emp, con, act, usu, fec, est, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public void getEditarRegistro(Registro u) throws Exception {
        Integer emp, con, act, idEmpresa;
        String mensaje, usu, est;
        Date fec;
        emp = Integer.parseInt(u.getId_empleado());
        con = Integer.parseInt(u.getCons());
        act = Integer.parseInt(u.getId_actividad());
        fec = u.getFecha();
        usu = u.getUsuario_creador();
        est = u.getEstado();
        idEmpresa = Integer.parseInt(u.getEmpresa());        
        mensaje = "";

        //Campos obligatorios
        if (null == emp) {
            mensaje += "Ingrese el ID del empleado";
        }

        //Campos no obligatorios
        if (null == usu || "".equals(usu)) {
            mensaje += "Ingrese el usuario";
        }
        
        if (null == act) {
            mensaje += "Ingrese el ID de la actividad";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Activo";
        }
        
        if(fec == null){
            mensaje += "Ingrese fecha";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getEditarRegistro(c, emp, con, act, usu, fec, est, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public Registro getEliminarRegistro(Integer idEmpleado, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEliminarRegistro(c, idEmpleado, idEmpresa);
    }
}

package com.proyectorat.manager;

import com.proyectorat.model.Tipo;
import com.proyectorat.persistence.Dao_Tipo;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Mateo Leal
 */
public class TipoManagerImpl {

    Connection c;
    Dao_Tipo dao;

    public TipoManagerImpl() {
        dao = new Dao_Tipo();
    }

    public Tipo getTipo(Integer idActividad, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getTipoA(c, idActividad, idEmpresa);
    }

    public ArrayList<Tipo> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoTipos(c);
    }

    public void getGuardarTipo(Tipo u) throws Exception {
        Integer idAct, idEmpresa;
        String mensaje, act, des, est;
        idAct = Integer.parseInt(u.getId_actividad());
        act = u.getActividad();
        des = u.getDescripcion();
        est = u.getEstado();
        idEmpresa = Integer.parseInt(u.getEmpresa());
        mensaje = "";

        //Campos obligatorios
        if (null == idAct) {
            mensaje += "Ingrese el ID de la actividad";
        }

        //Campos no obligatorios
        
        if ("".equals(act) || null == act) {
            mensaje += "Ingrese el nombre de la actividad";
        }
        
        if ("".equals(des) || null == des) {
            mensaje += "Ingrese la descripción de la actividad";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Ingrese clave";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getGuardarTipo(c, idAct, act, des, est, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public void getEditarTipo(Tipo u) throws Exception {
        Integer idAct, idEmpresa;
        String mensaje, act, des, est;
        idAct = Integer.parseInt(u.getId_actividad());
        act = u.getActividad();
        des = u.getDescripcion();
        est = u.getEstado();
        idEmpresa = Integer.parseInt(u.getEmpresa());
        mensaje = "";

        //Campos obligatorios
        if (null == idAct) {
            mensaje += "Ingrese el ID de la actividad";
        }

        //Campos no obligatorios
        
        if ("".equals(act) || null == act) {
            mensaje += "Ingrese el nombre de la actividad";
        }
        
        if ("".equals(des) || null == des) {
            mensaje += "Ingrese la descripción de la actividad";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Ingrese clave";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getEditarTipo(c, idAct, act, des, est, idEmpresa);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public Tipo getEliminarTipo(Integer idActividad, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEliminarTipo(c, idActividad, idEmpresa);
    }
}

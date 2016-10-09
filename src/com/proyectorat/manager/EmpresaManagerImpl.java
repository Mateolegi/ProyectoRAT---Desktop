package com.proyectorat.manager;

import com.proyectorat.model.Empresa;
import com.proyectorat.persistence.Dao_Empresa;
import com.proyectorat.util.Conexion;
import java.sql.Blob;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class EmpresaManagerImpl {
    
    Connection c;
    Dao_Empresa dao;

    public EmpresaManagerImpl() {
        dao = new Dao_Empresa();
    }

    public Empresa getEmpresa(Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEmpresa(c, idEmpresa);
    }

    public ArrayList<Empresa> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoEmpresas(c);
    }

    public void getGuardarEmpresa(Empresa u) throws Exception {
        String mensaje, nom, est;
        Integer idEmpresa;
        Blob logo;
        idEmpresa = Integer.parseInt(u.getId_empresa());
        nom = u.getNombre();
        logo = u.getLogo();
        est = u.getEstado();
        
        mensaje = "";

        if (null == idEmpresa) {
            mensaje += "Ingrese el ID de la empresa";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Ingrese estado";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getGuardarEmpresa(c, idEmpresa, nom, logo, est);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public void getEditarEmpresa(Empresa u) throws Exception {
        String mensaje, nom, est;
        Integer idEmpresa;
        Blob logo;
        idEmpresa = Integer.parseInt(u.getId_empresa());
        nom = u.getNombre();
        logo = u.getLogo();
        est = u.getEstado();
        
        mensaje = "";

        if (null == idEmpresa) {
            mensaje += "Ingrese el ID de la empresa";
        }
        
        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }
        
        if ("".equals(est) || null == est) {
            mensaje += "Ingrese estado";
        }
        
        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getEditarEmpresa(c, idEmpresa, nom, logo, est);

        if (!"".equals(mensaje)) {
            throw new Exception(mensaje);
        }
    }
    
    public Empresa getEliminarEmpresa(Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEliminarEmpresa(c, idEmpresa);
    }
}

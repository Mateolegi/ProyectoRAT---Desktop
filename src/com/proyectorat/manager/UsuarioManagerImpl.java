package com.proyectorat.manager;

import com.proyectorat.model.Usuario;
import com.proyectorat.persistence.Dao_Usuario;
import com.proyectorat.util.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo Leal
 */
public class UsuarioManagerImpl {

    Connection c;
    Dao_Usuario dao;

    public UsuarioManagerImpl() {
        dao = new Dao_Usuario();
    }

    public Usuario getUsuario(String idUsuario, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getUsuario(c, idUsuario, idEmpresa);
    }

    public ArrayList<Usuario> getListado() {

        c = new Conexion().getCon();
        return dao.getListadoUsuarios(c);
    }

    public void getGuardarUsuario(Usuario u) throws Exception {
        Integer idEmpresa;
        String mensaje, usu, nom, cla, per, est, cor;
        usu = u.getUsuario();
        nom = u.getNombre();
        cla = u.getClave();
        per = u.getPerfil();
        est = u.getEstado();
        cor = u.getEmail();
        idEmpresa = Integer.parseInt(u.getEmpresa());
        mensaje = "";

        //Campos obligatorios
        if ("".equals(usu) || null == usu) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        if ("".equals(est) || null == est) {
            est = "Activo";
        }

        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }

        if ("".equals(cla) || null == cla) {
            mensaje += "Ingrese clave";
        }

        if ("".equals(per) || null == per) {
            mensaje += "Ingrese perfil";
        }
        
        if ("".equals(cor) || null == cor) {
            mensaje += "Ingrese el correo";
        }

        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getGuardarUsuario(c, usu, nom, cla, est, per, cor, idEmpresa);

        if (!"".equals(mensaje)) {
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void getEditarUsuario(Usuario u) throws Exception {
        Integer idEmpresa;
        String mensaje, usu, nom, cla, per, est, cor;
        usu = u.getUsuario();
        nom = u.getNombre();
        cla = u.getClave();
        per = u.getPerfil();
        est = u.getEstado();
        cor = u.getEmail();
        idEmpresa = Integer.parseInt(u.getEmpresa());
        mensaje = "";

        //Campos obligatorios
        if ("".equals(usu) || null == usu) {
            mensaje += "Ingrese usuario";
        }

        //Campos no obligatorios
        if ("".equals(est) || null == est) {
            est = "Activo";
        }

        if ("".equals(nom) || null == nom) {
            mensaje += "Ingrese nombre";
        }

        if ("".equals(cla) || null == cla) {
            mensaje += "Ingrese clave";
        }

        if ("".equals(per) || null == per) {
            mensaje += "Ingrese perfil";
        }

        if (!"".equals(mensaje)) {
            throw new Exception("Los campos(*):\n " + mensaje + "\nSon obligatorios");
        }
        c = new Conexion().getCon();
        mensaje = dao.getEditarUsuario(c, usu, nom, cla, est, per, cor, idEmpresa);

        if (!"".equals(mensaje)) {
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Usuario getEliminarUsuario(String usuario, Integer idEmpresa) {

        c = new Conexion().getCon();
        return dao.getEliminarUsuario(c, usuario, idEmpresa);
    }
}

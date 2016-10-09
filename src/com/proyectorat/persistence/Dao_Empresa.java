
package com.proyectorat.persistence;

import com.proyectorat.model.Empresa;
import java.awt.HeadlessException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class Dao_Empresa {
    
    public Empresa getEmpresa(Connection c, Integer idEmpresa) {
        Empresa u = new Empresa();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEmpresa(idEmpresa));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_empresa(r.getString(1));
                u.setNombre(r.getString(2));
                u.setLogo(r.getBlob(3));
                u.setEstado(r.getString(4));
                
            }
        } catch (Exception e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return u;
    }

    public String getGuardarEmpresa(Connection c, int emp, String nom, Blob log, String est) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarEmpresa());
            stm.setInt(1, emp);
            stm.setString(2, nom);
            stm.setBlob(3, log);
            stm.setString(4, est);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                res = "Empresa " + nom + " añadida";
            } else {
                res = "Empresa " + nom + " no añadida";
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                res = "La empresa " + emp + " ya existe.";
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarEmpresa(Connection c, int emp, String nom, Blob log, String est) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarEmpresa());
            stm.setInt(4, emp);
            stm.setString(1, nom);
            stm.setBlob(2, log);
            stm.setString(3, est);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                res = "Empresa " + nom + " actualizada";
            } else {
                res = "Empresa " + nom + " no actualizada";
            }
        } catch (SQLException | HeadlessException e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
                res = "" + e.getCause();
            }
        }
        return res;
    }

    public ArrayList<Empresa> getListadoEmpresas(Connection c) {
        ArrayList<Empresa> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getEmpresa());
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Empresa u = new Empresa();
                u.setId_empresa(r.getString(1));
                u.setNombre(r.getString(2));
                u.setLogo(r.getBlob(3));
                u.setEstado(r.getString(4));

                Listado.add(u);

            }
        } catch (Exception e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return Listado;
    }

    public ArrayList<Empresa> getListadoEmpresas(Connection c, String campo, String valor) {
        ArrayList<Empresa> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getEmpresa(campo, valor));
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Empresa u = new Empresa();
                u.setId_empresa(r.getString(1));
                u.setNombre(r.getString(2));
                u.setLogo(r.getBlob(3));
                u.setEstado(r.getString(4));

                Listado.add(u);

            }
        } catch (Exception e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return Listado;
    }
    
    public Empresa getEliminarEmpresa(Connection c, Integer idEmpresa) {
        Empresa u = new Empresa();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEliminarEmpresa(idEmpresa));
            smt.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return u;
    }
}

package com.proyectorat.persistence;

import com.proyectorat.model.Tipo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RAT
 * @serial v1.0
 * @since 11-07-2016
 *
 */
public class Dao_Tipo {

    public Tipo getTipoA(Connection c, Integer idActividad, Integer idEmpresa) {
        Tipo u = new Tipo();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getTipoA(idActividad, idEmpresa));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_actividad(r.getString(1));
                u.setActividad(r.getString(2));
                u.setDescripcion(r.getString(3));
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

    public String getCons (Connection c, String tabla, String campo, int Longitud) {
        String u = "1000";
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getConsectivo(tabla, campo, Longitud));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u=r.getString(1);
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
    
    public String getGuardarTipo(Connection c, Integer ida, String act, String des, String est, Integer idEmpresa) {
        
        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarTipoA());
            stm.setInt(1, ida);
            stm.setString(2, act);
            stm.setString(3, des);
            stm.setString(4, est);
            stm.setInt(5, idEmpresa);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                res = "Tipo de actividad " + des + " añadido";
            } else {
                res = "Error, tipo de actividad " + des + " no añadido";
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                res = "El tipo de actividad " + act + " ya existe.";
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarTipo(Connection c, Integer ida, String act, String des, String est, Integer idEmpresa) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarTA());
            stm.setInt(4, ida);
            stm.setString(1, act);
            stm.setString(2, des);
            stm.setString(3, est);
            stm.setInt(5, idEmpresa);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                res = "Tipo de actividad " + des + " actualizado";
            } else {
                res = "Error, tipo de actividad " + des + " no actualizado";
            }
        } catch (SQLException | HeadlessException e) {
            res = "" + e.getCause();
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public ArrayList<Tipo> getListadoTipos(Connection c) {
        ArrayList<Tipo> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getTipoA());
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Tipo u = new Tipo();
                u.setId_actividad(r.getString(1));
                u.setActividad(r.getString(2));
                u.setDescripcion(r.getString(3));
                u.setEstado(r.getString(4));
                u.setEmpresa(r.getString(5));
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

    public ArrayList<Tipo> getListadoTipos(Connection c, String campo, String valor) {
        ArrayList<Tipo> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getTipoA(campo, valor));
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Tipo u = new Tipo();
                u.setId_actividad(r.getString(1));
                u.setActividad(r.getString(2));
                u.setDescripcion(r.getString(3));
                u.setEstado(r.getString(4));
                u.setEmpresa(r.getString(5));
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
    
    public Tipo getEliminarTipo(Connection c, Integer idActividad, Integer idEmpresa) {
        Tipo u = new Tipo();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEliminarTipoA(idActividad, idEmpresa));
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

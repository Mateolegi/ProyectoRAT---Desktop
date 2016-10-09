package com.proyectorat.persistence;

import com.proyectorat.model.Entrada;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RAT
 * @serial v2.0
 * @since 22-07-2016
 *
 */
public class Dao_Entrada {

    public Entrada getEntrada(Connection c, Integer idEmpleado, Integer idEmpresa) {
        Entrada u = new Entrada();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEntrada(idEmpleado, idEmpresa));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_empleado(r.getString(1));
                u.setCons(r.getString(2));
                u.setHora_entrada(r.getString(3));
                u.setHora_salida(r.getString(4));
                u.setFecha(r.getDate(5));
                
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
    
    public Entrada getEntrada_Cons(Connection c, Integer cons, Integer emp, Integer idEmpresa) {
        Entrada u = new Entrada();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEntrada_Cons(cons, emp, idEmpresa));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_empleado(r.getString(1));
                u.setCons(r.getString(2));
                u.setHora_entrada(r.getString(3));
                u.setHora_salida(r.getString(4));
                u.setFecha(r.getDate(5));
                
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
    
    public String getGuardarEntrada(Connection c, Integer emp, Integer con, Date hoe, Date hos, Date fec, Integer idEmpresa) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarEntrada());
            stm.setInt(1, emp);
            stm.setInt(2, con);
            stm.setDate(3, hoe);
            stm.setDate(4, hos);
            stm.setDate(5, fec);
            stm.setInt(6, idEmpresa);
            stm.execute();
            if (stm.getUpdateCount() > 0) {
                res = "Registro " + con + " añadido";
            } else {
                res = "Registro " + con + " no añadido";
            }
        } catch (SQLException | HeadlessException e) {
            
            res = "" + e.getCause();
            res= res.replace("#","");
            if (res.equals("23000")) {
                res = "El registro " + con + " ya existe.";
            }
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarEntrada(Connection c, Integer emp, Integer con, Date hoe, Date hos, Date fec, Integer idEmpresa) {

        String res = "";
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarES());
            stm.setInt(4, emp);
            stm.setInt(5, con);
            stm.setDate(1, hoe);
            stm.setDate(2, hos);
            stm.setDate(3, fec);
            stm.setInt(6, idEmpresa);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                res = "Registro " + con + " actualizado";
            } else {
                res = "Registro " + con + " no actualizado";
            }
        } catch (SQLException | HeadlessException e) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
                res =  "" + e.getCause();
            }
        }
        return res;
    }

    public ArrayList<Entrada> getListadoEntradas(Connection c) {
        ArrayList<Entrada> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getEntrada());
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Entrada u = new Entrada();
                u.setId_empleado(r.getString(1));
                u.setNombre(r.getString(2));
                u.setCons(r.getString(3));
                u.setHora_entrada(r.getString(4));
                u.setHora_salida(r.getString(5));
                u.setFecha(r.getDate(6));
                u.setEmpresa(r.getString(7));
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

    public ArrayList<Entrada> getListadoEntradas(Connection c, String campo, String valor) {
        ArrayList<Entrada> Listado = new ArrayList<>();
        try {
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getEntrada(campo, valor));
            ResultSet r = stm.executeQuery();
            while (r.next()) {
                Entrada u = new Entrada();
                u.setId_empleado(r.getString(1));
                u.setCons(r.getString(2));
                u.setHora_entrada(r.getString(3));
                u.setHora_salida(r.getString(4));
                u.setFecha(r.getDate(5));
                u.setEmpresa(r.getString(6));
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
    
    public Entrada getEliminarEntrada(Connection c, Integer cons, Integer idEmpleado, Integer idEmpresa) {
        Entrada u = new Entrada();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEliminarEntrada(cons, idEmpleado, idEmpresa));
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

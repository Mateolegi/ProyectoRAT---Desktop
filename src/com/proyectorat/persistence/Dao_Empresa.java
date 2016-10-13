
package com.proyectorat.persistence;

import com.proyectorat.manager.ImageBlob;
import com.proyectorat.model.Empresa;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateo
 */
public class Dao_Empresa {
    
    ImageBlob imb = new ImageBlob();
    
    public Empresa getEmpresa(Connection c, Integer idEmpresa) {
        Empresa u = new Empresa();
        try {
            PreparedStatement smt = c.prepareStatement(SQL_Helpers.getEmpresa(idEmpresa));
            ResultSet r = smt.executeQuery();
            while (r.next()) {
                u.setId_empresa(r.getString(1));
                u.setNombre(r.getString(2));
                
                Blob logo = r.getBlob(3);
                int blobLength = (int) logo.length();
                byte[] blobAsBytes = logo.getBytes(1, blobLength);
                final BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
                u.setLogo(imagen);
                
                u.setEstado(r.getString(4));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
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
        if(u==null) {
            return "1000";
        }
        return u;
    }

    public String getGuardarEmpresa(Connection c, int emp, String nom, Image log, String est) {

        String res = "";
        try {
            ByteArrayInputStream logo = imb.imageToBinary(log);
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getInsertarEmpresa());
            stm.setInt(1, emp);
            stm.setString(2, nom);
            stm.setBinaryStream(3, logo);
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
        } catch (IOException ex) {
        } finally {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
        return res;
    }

    public String getEditarEmpresa(Connection c, int emp, String nom, Image log, String est) {

        String res = "";
        try {
            ByteArrayInputStream logo = imb.imageToBinary(log);
            PreparedStatement stm = c.prepareStatement(SQL_Helpers.getActualizarEmpresa());
            stm.setInt(1, emp);
            stm.setString(2, nom);
            stm.setBinaryStream(3, logo);
            stm.setString(4, est);
            stm.executeUpdate();
            if (stm.getUpdateCount() > 0) {
                res = "Empresa " + nom + " actualizada";
            } else {
                res = "Empresa " + nom + " no actualizada";
            }
        } catch (SQLException | HeadlessException e) {
        } catch (IOException ex) {
            Logger.getLogger(Dao_Empresa.class.getName()).log(Level.SEVERE, null, ex);
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
                
                Blob logo = r.getBlob(3);
                int blobLength = (int) logo.length();
                byte[] blobAsBytes = logo.getBytes(1, blobLength);
                final BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
                u.setLogo(imagen);
                
                u.setEstado(r.getString(4));

                Listado.add(u);

            }
        } catch (SQLException | IOException e) {
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
                
                Blob logo = r.getBlob(3);
                int blobLength = (int) logo.length();
                byte[] blobAsBytes = logo.getBytes(1, blobLength);
                final BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
                u.setLogo(imagen);
                
                u.setEstado(r.getString(4));

                Listado.add(u);

            }
        } catch (SQLException | IOException e) {
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

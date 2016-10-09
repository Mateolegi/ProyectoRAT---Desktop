package com.proyectorat.persistence;

import java.sql.Blob;
import java.sql.Date;

public class SQL_Helpers {

    //USUARIO
    public static String getUsuario() {
        return "SELECT us.usuario, us.nombre, us.clave, us.estado, pe.cargo, us.correo, em.nombre FROM tblusuario us INNER JOIN tblcargo pe ON us.perfil = pe.id_cargo INNER JOIN tblempresa em ON us.id_empresa = em.id_empresa GROUP BY us.usuario, pe.cargo, em.nombre";
    }

    public static String getUsuario(String empresa) {
        return "SELECT usuario, nombre, clave, estado, perfil, correo FROM tblusuario WHERE id_empresa = '" + empresa + "' ";
    }
    
    public static String getUsuario(String id, Integer empresa) {
        return "SELECT usuario, nombre, clave, estado, perfil, correo FROM tblusuario WHERE usuario = '" + id + "' AND id_empresa = '" + empresa + "' ";
    }

    public static String getUsuario(String campo, String valor) {
        return "SELECT usuario, nombre, clave, estado, perfil, correo FROM tblusuario WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizar() {
        return "UPDATE tblusuario SET nombre=?, clave=?, estado=?, perfil=?, correo=? WHERE usuario=? AND id_empresa=?";
    }

    public static String getInsertarUsuario(String usuario, String nombre, String clave, String estado, String perfil, String correo, Integer idEmpresa) {
        return "INSERT INTO tblusuario( usuario, nombre, clave, estado, perfil, correo, id_empresa) values (" + usuario + "," + nombre + "," + clave + "," + estado + "," + perfil + "," + correo + ", " + idEmpresa + ")";
    }

    public static String getInsertarUsuario() {
        return "INSERT INTO tblusuario( usuario, nombre, clave, estado, perfil, correo, id_empresa) values (?,?,?,?,?,?,?)";
    }

    public static String getValidarIngreso(String usr, String pass) {
        return "SELECT usuario, nombre, clave, estado, perfil, correo \n"
                + " FROM tblusuario "
                + " WHERE usuario='"+ usr +"' AND clave='"+ pass +"'"
                + "AND estado='Activo'";
    }
    
    public static String getEliminarUsuario(String id, Integer idEmpresa){
        return "DELETE FROM tblusuario WHERE usuario='"+ id +"' AND id_empresa='" + idEmpresa + "' ";
    }

    
    //CARGO
    public static String getCargo() {
        return "SELECT ca.id_cargo, ca.cargo, ca.salario, ca.estado, em.nombre FROM tblcargo ca INNER JOIN tblempresa em ON ca.id_empresa = em.id_empresa GROUP BY ca.id_cargo, em.nombre";
    }

    public static String getCargo(Integer id, Integer idEmpresa) {
        return "SELECT id_cargo, nombre, salario, estado FROM tblcargo WHERE id_cargo = '" + id + "' AND id_empresa = '" + idEmpresa + "' ";
    }

    public static String getCargo(String campo, String valor) {
        return "SELECT id_cargo, nombre, salario, estado, id_empresa FROM tblcargo WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizarC() {
        return "UPDATE tblcargo SET nombre=?, salario=?, estado=? WHERE id_cargo=? AND id_empresa=?";
    }

    public static String getInsertarCargo(Integer id_cargo, String nombre, String salario, String estado, Integer idEmpresa) {
        return "INSERT INTO tblcargo( id_cargo, nombre, salario, estado) values (" + id_cargo + "," + nombre + "," + salario + "," + estado + "," + idEmpresa + ")";
    }

    public static String getInsertarCargo() {
        return "INSERT INTO tblcargo( id_cargo, nombre, salario, estado, id_empresa) values (?,?,?,?,?)";
    }
    
    public static String getEliminarCargo(Integer id, Integer idEmpresa){
        return "DELETE FROM tblcargo WHERE id_cargo='"+ id +"' AND id_empresa='" + idEmpresa + "' ";
    }

    //EMPLEADO
    public static String getEmpleado() {
        return "SELECT em.id_empleado, em.nombre, em.apellidos, em.fecha_n, em.telefono, em.direccion, em.email, em.estado, pe.cargo, ep.nombre FROM tblempleado em INNER JOIN tblcargo pe ON em.id_cargo = pe.id_cargo INNER JOIN tblempresa ep ON em.id_empresa = ep.id_empresa GROUP BY em.id_empleado, pe.id_cargo, ep.nombre";
    }

    public static String getEmpleado(Integer id, Integer idEmpresa) {
        return "SELECT id_empleado, nombre, apellidos, fecha_n, telefono, direccion, email, estado, id_cargo, id_empresa FROM tblempleado WHERE id_empleado = '" + id + "' AND id_empresa = '" + idEmpresa + "' ";
    }

    public static String getEmpleado(String campo, String valor) {
        return "SELECT id_empleado, nombre, apellidos, fecha_n, telefono, direccion, email, estado, id_cargo, id_empresa FROM tblempleado WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizarE() {
        return "UPDATE tblempleado SET nombre=?, apellidos=?, fecha_n=?, telefono=?, direccion=?, email=?, estado=?, id_cargo=? WHERE id_empleado=? AND id_empresa=?";
    }

    public static String getInsertarEmpleado(Integer id_empleado, String nombre, String apellidos, Date fecha_n, Integer telefono, String direccion, String email, String estado, Integer idCargo, Integer idEmpresa) {
        return "INSERT INTO tblempleado( id_empleado, nombre, apellidos, fecha_n, telefono, direccion, email, estado, id_cargo, id_empresa) values (" + id_empleado + "," + nombre + "," + apellidos + "," + fecha_n + "," + telefono + "," + direccion + "," + email + "," + estado + "," + idCargo + "," + idEmpresa+ ")";
    }

    public static String getInsertarEmpleado() {
        return "INSERT INTO tblempleado( id_empleado, nombre, apellidos, fecha_n, telefono, direccion, email, estado, id_cargo, id_empresa) values (?,?,?,?,?,?,?,?,?,?)";
    }
    
    public static String getEliminarEmpleado(Integer id, Integer idEmpresa){
        return "DELETE FROM tblempleado WHERE id_empleado='"+ id +"' AND id_empresa='" + idEmpresa + "' ";
    }
    
    //EMPRESA
    public static String getEmpresa() {
        return "SELECT id_empresa, nombre, logo, estado FROM tblempresa";
    }

    public static String getEmpresa(Integer id) {
        return "SELECT id_empresa, nombre, logo, estado FROM tblempresa WHERE id_empresa = '" + id + "' ";
    }

    public static String getEmpresa(String campo, String valor) {
        return "SELECT id_empresa, nombre, logo, estado FROM tblempresa WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizarEmpresa() {
        return "UPDATE tblempresa SET nombre=?, logo=?, estado=? WHERE id_empresa=?";
    }

    public static String getInsertarEmpresa(Integer id_empresa, String nombre, Blob logo, String estado) {
        return "INSERT INTO tblempresa( id_empresa, nombre, logo, estado) values (" + id_empresa + "," + nombre + "," + logo + "," + estado + ")";
    }

    public static String getInsertarEmpresa() {
        return "INSERT INTO tblempresa( id_empresa, nombre, logo, estado) values (?,?,?,?)";
    }
    
    public static String getEliminarEmpresa(Integer id){
        return "DELETE FROM tblempresa WHERE id_empresa='" + id + "' ";
    }
    
    //ENTRADAS
    public static String getEntrada() {
        return "SELECT es.id_empleado, CONCAT(em.nombre, ' ', em.apellidos) nombre, es.cons, TIME_FORMAT(es.hora_entrada,'%r') hora_entrada, TIME_FORMAT(es.hora_salida,'%r') hora_salida, es.fecha, ep.nombre FROM tblentrada_salida es INNER JOIN tblempleado em ON es.id_empleado = em.id_empleado INNER JOIN tblempresa ep ON es.id_empresa = ep.id_empresa GROUP BY em.nombre, es.cons, ep.nombre";
    }

    public static String getEntrada(Integer id, Integer idEmpresa) {
        return "SELECT id_empleado, cons, hora_entrada, hora_salida, fecha FROM tblentrada_salida WHERE id_empleado = '" + id + "' AND id_empresa='" + idEmpresa + "' ";
    }
    
    public static String getEntrada_Cons(Integer id, Integer emp, Integer idEmpresa) {
        return "SELECT id_empleado, cons, hora_entrada, hora_salida, fecha FROM tblentrada_salida WHERE cons = '" + id + "' AND id_empleado='"+ emp +"' AND id_empresa='" + idEmpresa + "' ";
    }

    public static String getEntrada(String campo, String valor) {
        return "SELECT id_empleado, cons, hora_entrada, hora_salida, fecha, id_empresa FROM tblentrada_salida WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizarES() {
        return "UPDATE tblentrada_salida SET hora_entrada=?, hora_salida=?, fecha=? WHERE id_empleado=? AND cons=? AND id_empresa=?";
    }

    public static String getInsertarEntrada(Integer id_empleado, Integer cons, Date hora_entrada, Date hora_salida, Date fecha, Integer idEmpresa) {
        return "INSERT INTO tblentrada_salida( id_empleado, cons, hora_entrada, hora_salida, fecha, id_empresa) values (" + id_empleado + "," + cons + "," + hora_entrada + "," + hora_salida + "," + fecha + "," + idEmpresa + ")";
    }

    public static String getInsertarEntrada() {
        return "INSERT INTO tblentrada_salida( id_empleado, cons, hora_entrada, hora_salida, fecha, id_empresa) values (?,?,?,?,?,?)";
    }
    
    public static String getEliminarEntrada(Integer id, Integer emp, Integer idEmpresa){
        return "DELETE FROM tblentrada_salida WHERE cons='"+ id +"' AND id_empleado='"+ emp +"' AND id_empresa='" + idEmpresa + "'";
    }
    
    
    //REGISTROA
    public static String getRegistroA() {
        return "SELECT ac.cons, CONCAT(em.nombre, ' ', em.apellidos) nombre, ti.actividad, us.usuario, ac.fecha_actividad, ac.estado, ep.nombre FROM tblregistro_actividades ac INNER JOIN tblempleado em ON ac.id_empleado = em.id_empleado INNER JOIN tbltipo_actividad ti ON ac.id_actividad = ti.id_actividad INNER JOIN tblusuario us ON us.usuario = ac.usuario_creador INNER JOIN tblempresa ep ON ac.id_empresa = ep.id_empresa GROUP BY em.nombre, ti.descripcion, us.usuario, ac.fecha_actividad, ep.nombre";
    }

    public static String getRegistroA_E(Integer id, Integer idEmpresa) {
        return "SELECT id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado FROM tblregistro_actividades WHERE id_empleado = '" + id + "' AND id_empresa = '" + idEmpresa + "' ";
    }

    public static String getRegistroA_A(Integer id, Integer idEmpresa) {
        return "SELECT id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado FROM tblregistro_actividades WHERE id_actividad = '" + id + "' AND id_empresa = '" + idEmpresa + "' ";
    }

    public static String getRegistroA(String campo, String valor) {
        return "SELECT id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado, id_empresa FROM tblregistro_actividades WHERE " + campo + " = '" + valor + "' ";
    }

    public static String getActualizarRA() {
        return "UPDATE tblregistro_actividades SET cons=?, id_actividad=?, usuario_creador=?, fecha_actividad=?, estado=? WHERE id_empleado=?  AND id_empresa=?";
    }

    public static String getInsertarRegistroA(Integer id_empleado, Integer cons, Integer id_actividad, String usuario_creador, Date fecha_actividad, String estado, Integer idEmpresa) {
        return "INSERT INTO tblregistro_actividades( id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado, id_empresa) values (" + id_empleado + "," + cons + "," + id_actividad + "," + usuario_creador + "," + fecha_actividad + "," + estado + "," + idEmpresa + " )";
    }

    public static String getInsertarRegistroA() {
        return "INSERT INTO tblregistro_actividades( id_empleado, cons, id_actividad, usuario_creador, fecha_actividad, estado, id_empresa) values (?,?,?,?,?,?,?)";
    }
    
    public static String getEliminarRegistroA(Integer id, Integer idEmpresa){
        return "DELETE FROM tblregistro_actividades WHERE id_empleado='"+ id +"' AND id_empresa = '" + idEmpresa + "' ";
    }
    

    //TIPOA
    public static String getTipoA() {
        return "SELECT tp.id_actividad, tp.actividad, tp.descripcion, tp.estado, ep.nombre FROM tbltipo_actividad tp INNER JOIN tblempresa ep ON tp.id_empresa = ep.id_empresa GROUP BY tp.id_actividad, ep.nombre";
    }

    public static String getTipoA(Integer id, Integer idEmpresa) {
        return "SELECT id_actividad, actividad, descripcion, estado FROM tbltipo_actividad WHERE id_actividad = '" + id + "' AND id_empresa = '" + idEmpresa + "'";
    }
    
    public static String getTipoA(String campo, String valor) {
        return "SELECT id_actividad, actividad, descripcion, estado, id_empresa FROM tbltipo_actividad WHERE " + campo + " = '" + valor + "' ";
    }
    
    public static String getActualizarTA() {
        return "UPDATE tbltipo_actividad SET actividad=?, descripcion=?, estado=? WHERE id_actividad=? AND id_empresa=?";
    }

    public static String getInsertarTipoA(Integer idActividad, String actividad, String descripcion, String estado, Integer idEmpresa) {
        return "INSERT INTO tbltipo_actividad( id_actividad, actividad, descripcion, estado, id_empresa) values (" + idActividad + "," + actividad + "," + descripcion + "," + estado + "," + idEmpresa + ")";
    }

    public static String getInsertarTipoA() {
        return "INSERT INTO tbltipo_actividad( id_actividad, actividad, descripcion, estado, id_empresa) values (?,?,?,?,?)";
    }
    
    public static String getEliminarTipoA(Integer id, Integer idEmpresa){
        return "DELETE FROM tbltipo_actividad WHERE id_actividad='"+ id +"' AND id_empresa = '" + idEmpresa + "' ";
    }
    
    
    //GENERACION DE CONSECUTIVO
    
    public static String getConsectivo(String tabla, String campo, int Longitud){
        return "SELECT Lpad( max( cast( "+campo+" AS signed ) ) +1, "+Longitud+", '0' )  FROM "+tabla +"";
    }
}

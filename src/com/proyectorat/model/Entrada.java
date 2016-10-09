package com.proyectorat.model;

import java.sql.Date;

public class Entrada {

    private String id_empleado, cons, hora_entrada, hora_salida;
    private Date fecha;

    public Entrada() {

    }
    
    public Entrada(String id_empleado, String cons, String hora_entrada, String hora_salida, Date fecha) {
        this.id_empleado = id_empleado;
        this.cons = cons;
        this.hora_entrada = hora_entrada;
        this.fecha = fecha;
        this.hora_salida = hora_salida;
    }
    
    public String getId_empleado() {
        return id_empleado;
    }
    
    public String getCons() {
        return cons;
    }
    
    public String getHora_entrada() {
        return hora_entrada;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public String getHora_salida() {
        return hora_salida;
    }
    

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }
}

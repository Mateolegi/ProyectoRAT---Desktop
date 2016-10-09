package com.proyectorat.model;

public class Tipo {

    private String id_actividad, actividad, descripcion, estado, empresa;

    public Tipo() {

    }

    public Tipo(String id_actividad, String actividad, String descripcion, String estado, String empresa) {
        this.id_actividad = id_actividad;
        this.actividad = actividad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.empresa = empresa;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }
    

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
}

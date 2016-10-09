package com.proyectorat.model;

public class Tipo {

    private String id_actividad, descripcion, estado;

    public Tipo() {

    }

    public Tipo(String id_actividad, String descripcion, String estado) {
        this.id_actividad = id_actividad;
        this.descripcion = descripcion;
        this.estado = estado;
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
}

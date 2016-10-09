package com.proyectorat.model;

public class Cargo {

    private String id_cargo, nombre, salario, estado, empresa;

    public Cargo(String id_cargo, String nombre, String salario, String estado, String empresa) {
        this.id_cargo = id_cargo;
        this.nombre = nombre;
        this.salario = salario;
        this.estado = estado;
        this.empresa = empresa;
    }

    public Cargo() {
        
    }

    public String getId_cargo() {
        return id_cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSalario() {
        return salario;
    }

    public String getEstado() {
        return estado;
    }

    public void setId_cargo(String id_cargo) {
        this.id_cargo = id_cargo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(String salario) {
        this.salario = salario;
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
}

package com.telecom.administracionservice.rol.data.dto;

public class RolDTO {
    private String nombre;
    private String descripcion;

    public RolDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


package com.portfolio.rbl.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoPersona {
    @NotBlank
    private String nombre;
     @NotBlank
    private String descripcion;
      @NotBlank
    private String apellido;
       @NotBlank
  private String img;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String descripcion, String apellido, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.apellido = apellido;
        this.img = img;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
       
       
}

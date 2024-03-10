package org.ecos.logic.thelastandroidexam2;

import java.io.Serializable;

public class Personaje implements Serializable {
    int id;
    String nombre, nombreLargo;
    int edad;
    String genero, nacionalidad, desc;
    int imagen;


    public Personaje(int id, String nombre, String nombreLargo, int edad, String genero, String nacionalidad, String desc, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.nombreLargo = nombreLargo;
        this.edad = edad;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.desc = desc;
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

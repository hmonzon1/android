package com.hmonzon.myappbdsqlite.complementos;

public class MascostasVO {
    private int codigo;
    private String nombre;
    private String raza;
    private String color;
    private int edad;

    public MascostasVO() {
    }

    public MascostasVO(int codigo, String nombre, String raza, String color, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}



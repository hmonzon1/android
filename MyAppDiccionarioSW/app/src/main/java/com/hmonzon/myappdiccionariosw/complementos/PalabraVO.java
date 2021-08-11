package com.hmonzon.myappdiccionariosw.complementos;

public class PalabraVO {

    private int codigo;
    private String nombre;
    private String definicion;

    public PalabraVO() {
    }

    public PalabraVO(int codigo, String nombre, String definicion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.definicion = definicion;
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

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }
}

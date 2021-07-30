package com.hmonzon.myappextrasrecyclerfragment;

public class DatosVO {

    private int imagen;
    private String texto;

    private int detalle;
    private int especificaiones;

    public DatosVO() {

    }


    public DatosVO(int detalle, int especificaiones) {
        this.detalle = detalle;
        this.especificaiones = especificaiones;
    }

    public int getDetalle() {
        return detalle;
    }

    public void setDetalle(int detalle) {
        this.detalle = detalle;
    }

    public int getEspecificaiones() {
        return especificaiones;
    }

    public void setEspecificaiones(int especificaiones) {
        this.especificaiones = especificaiones;
    }

    public DatosVO(int imagen, String texto) {
        this.imagen = imagen;
        this.texto = texto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

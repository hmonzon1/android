package com.hmonzon.myappcrudswproductos.complementos;

public class ProductoVO {

    private int codigo;
    private String nombre;
    private String marca;
    private int costo;
    private int precio;

    public ProductoVO() {
    }

    public ProductoVO(int codigo, String nombre, String marca, int costo, int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.precio = precio;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

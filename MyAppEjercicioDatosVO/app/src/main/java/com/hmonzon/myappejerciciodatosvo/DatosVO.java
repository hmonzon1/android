package com.hmonzon.myappejerciciodatosvo;

public class DatosVO {

    private String NombreC;
    private String TelefonoC;
    private  int imagenC;

    public DatosVO() {
    }

    public DatosVO(String nombreC, String telefonoC, int imagenC) {
        NombreC = nombreC;
        TelefonoC = telefonoC;
        this.imagenC = imagenC;
    }

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String nombreC) {
        NombreC = nombreC;
    }

    public String getTelefonoC() {
        return TelefonoC;
    }

    public void setTelefonoC(String telefonoC) {
        TelefonoC = telefonoC;
    }

    public int getImagenC() {
        return imagenC;
    }

    public void setImagenC(int imagenC) {
        this.imagenC = imagenC;
    }
}

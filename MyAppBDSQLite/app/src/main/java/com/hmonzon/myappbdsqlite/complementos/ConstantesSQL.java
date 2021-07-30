package com.hmonzon.myappbdsqlite.complementos;

public class ConstantesSQL {

    //Cosntantes para la utilizacion de cada una de las consultas principales DDL

    //Base de datos

    public static final String BD_MASCOTAS = "bd_mascotas";

    //tablas

    public static final String TABLA_MASCOTAS = "tbl_mascotas";

    //Campos de la tabla

    public static final String CAMPO_ID = "id_mascota";
    public static final String CAMPO_NOMBRE = "nombre_mascota";
    public static final String CAMPO_RAZA = "raza_mascota";
    public static final String CAMPO_COLOR = "color_mascota";
    public static final String CAMPO_EDAD = "edad_mascota";

    //consultas oncreate

    public static final String CREAR_TABLA_MASCOTAS = "CREATE TABLE "+TABLA_MASCOTAS+
            " ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +CAMPO_NOMBRE + " TEXT NOT NULL,"
            +CAMPO_RAZA + " TEXT NOT NULL,"
            +CAMPO_COLOR+" TEXT NOT NULL,"
            +CAMPO_EDAD+" INTEGER NOT NULL);";

    //Consultas cON drop

    public static final String BORRAR_TABLA = "DROP TABLE IF EXISTS"+TABLA_MASCOTAS;

    //Version

    public static final int VERSION = 1;



}



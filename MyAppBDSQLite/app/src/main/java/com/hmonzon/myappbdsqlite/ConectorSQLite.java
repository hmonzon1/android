package com.hmonzon.myappbdsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.hmonzon.myappbdsqlite.complementos.ConstantesSQL;

public class ConectorSQLite extends SQLiteOpenHelper {

    public ConectorSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //crear la tabla por medio de las constantes
        db.execSQL(ConstantesSQL.CREAR_TABLA_MASCOTAS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Borrar la tabla si ya existe
        db.execSQL(ConstantesSQL.BORRAR_TABLA);
        onCreate(db);

    }
}

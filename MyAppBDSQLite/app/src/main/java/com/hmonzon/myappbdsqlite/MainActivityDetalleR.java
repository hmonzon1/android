package com.hmonzon.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivityDetalleR extends AppCompatActivity {

    private Fragment fragment;
    private String id, nombre, raza, color, edad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle_r);

        fragment = new DetalleFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorID,fragment).commit();
        this.Obtenerdatos();
        this.TrasladoFragment();

    }

    private void Obtenerdatos(){

        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        nombre = bundle.getString("nombre");
        raza = bundle.getString("raza");
        color = bundle.getString("color");
        edad = bundle.getString("edad");

    }

    private void TrasladoFragment(){
        Bundle bundle = getIntent().getExtras();
        bundle.putString("id",id);
        bundle.putString("nombre",nombre);
        bundle.putString("raza",raza);
        bundle.putString("color",color);
        bundle.putString("edad",edad);
        fragment.setArguments(bundle);

    }
}
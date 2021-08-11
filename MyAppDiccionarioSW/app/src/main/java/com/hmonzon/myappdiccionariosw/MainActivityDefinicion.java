package com.hmonzon.myappdiccionariosw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivityDefinicion extends AppCompatActivity {

    private Fragment fragment;
    private String nombre, definicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_definicion);

        fragment = new DefinicionFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.idFragment, fragment).commit();
        this.Obtenerdatos();
        this.TrasladarDatos();




    }

private void Obtenerdatos(){
Bundle bundle = getIntent().getExtras();
nombre = bundle.getString("nombre");
definicion = bundle.getString("definicion");
}

private void TrasladarDatos(){

        Bundle bundle = getIntent().getExtras();
        bundle.putString("nombre",nombre);
        bundle.putString("definicion",definicion);
        fragment.setArguments(bundle);

}
}
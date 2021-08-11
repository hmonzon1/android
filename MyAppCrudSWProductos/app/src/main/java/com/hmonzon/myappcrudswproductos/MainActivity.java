package com.hmonzon.myappcrudswproductos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()){
            case R.id.btnMenuGuardar:
                intent = new Intent(getApplicationContext(), MainActivityInsertarSW.class);
                startActivity(intent);

                break;

            case R.id.btnMenuBuscar:
                intent = new Intent(getApplicationContext(), MainActivityBuscarSW.class);
                startActivity(intent);
                break;

            case R.id.btnMenuMostrar:
                intent = new Intent(getApplicationContext(), MainActivityMostrarSW.class);
                startActivity(intent);
                break;
            case R.id.btnMenuEliminar:
                intent = new Intent(getApplicationContext(), MainActivityEliminarSW.class);
                startActivity(intent);
                break;
            case R.id.btnMenuActualizar:
                intent = new Intent(getApplicationContext(), MainActivityActualizarSW.class);
                startActivity(intent);
                break;
        }
    }
}
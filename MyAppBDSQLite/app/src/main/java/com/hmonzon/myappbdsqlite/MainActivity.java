    package com.hmonzon.myappbdsqlite;

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
        switch (view.getId()){
            case R.id.btnMenuInsertar:
               intent = new Intent(getApplicationContext(), MainActivityInsertar.class);
               startActivity(intent);
                break;
            case R.id.btnMenuConsultar:
                intent = new Intent(getApplicationContext(), MainActivityConsultar.class);
                startActivity(intent);
                break;
            case R.id.btnMenuMostrar:
                intent = new Intent(getApplicationContext(), MainActivityMostrar.class);
                startActivity(intent);
                break;
            case R.id.btnMenuActualizar:
                intent = new Intent(getApplicationContext(), MainActivityActualizar.class);
                startActivity(intent);
                break;
            case R.id.btnMenuEliminar:
                intent = new Intent(getApplicationContext(), MainActivityEliminar.class);
                startActivity(intent);
                break;

        }
        }
    }
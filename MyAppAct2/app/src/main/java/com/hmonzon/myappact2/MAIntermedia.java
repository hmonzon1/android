package com.hmonzon.myappact2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MAIntermedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintermedia);
    }

    public void pulsar(View view) {
        Intent intent = null;
        if (view.getId() == R.id.btnRegresar){

            //Objeto intent permite iniciar diferentes actividades
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        }
        if(view.getId() == R.id.btnAvanzar){
            intent = new Intent(this, MAFinal.class);
            startActivity(intent);


        }
    }
}
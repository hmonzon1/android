package com.hmonzon.myappaniob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     private EditText campoAnio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoAnio = findViewById(R.id.txtAnio);
    }

 private void anio(){
        String anio = campoAnio.getText().toString();

        if(!anio.isEmpty()){
            Intent intent = new Intent(this, MArecepcion.class);
            intent.putExtra("Año",anio);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Año no ingresado", Toast.LENGTH_SHORT).show();
        }

 }

    public void onClick(View view) {
        this.anio();
    }
}
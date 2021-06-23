package com.hmonzon.myapp_nombre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText edad;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.txtNombre);
        edad = findViewById(R.id.txtEdad);
        resultado = findViewById(R.id.txtResultado);
    }

    public void mostrarDatos(){
        String CNombre;
        String CEdad;
        CNombre = nombre.getText().toString();
        CEdad = edad.getText().toString();
        if (!CNombre.isEmpty()&&!CEdad.isEmpty()) {
            int anio;
            anio = 2021 - Integer.parseInt(CEdad);
            resultado.setText("Su nombre es: " + CNombre +"\n"+"Su año de nacimiento es: " + anio);
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }


    public void pulsar(View view) {
        switch(view.getId()){
            case R.id.btnMostrar:
                this.mostrarDatos();
        }

    }
}
package com.hmonzon.myappenvio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, apellido, direccion, telefono, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        direccion = findViewById(R.id.txtDireccion);
        telefono = findViewById(R.id.txtTelefono);
        edad = findViewById(R.id.txtEdad);
    }

    private void datos(){
        String n = nombre.getText().toString();
        String a = apellido.getText().toString();
        String d = direccion.getText().toString();
        String t = telefono.getText().toString();
        String e = edad.getText().toString();

        if(!n.isEmpty()&&!a.isEmpty()&&!d.isEmpty()&&!t.isEmpty()&&!e.isEmpty()){

            Intent intent = new Intent(this, MAreceptor.class);
           intent.putExtra("nombres",n);
            intent.putExtra("apellidos",a);
            intent.putExtra("Direccion",d);
            intent.putExtra("Telefono",t);
            intent.putExtra("Edad",e);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClick(View view) {
        this.datos();
    }
}
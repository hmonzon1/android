package com.hmonzon.myapptiendaarte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MaReceptor extends AppCompatActivity {

    private TextView reciben, recibep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_receptor);

        reciben = findViewById(R.id.txtNombreR);
        recibep = findViewById(R.id.txtPrecioR);



        this.recibeDatos();

    }

    private void recibeDatos(){
               Bundle bundle = getIntent().getExtras();

               String nombre1 = bundle.getString("nombre");
               String precio1 = bundle.getString("precio");

                reciben.setText(String.valueOf("Nombre"+nombre1));
                recibep.setText(String.valueOf("Precio: "+precio1));


                   Toast.makeText(this, "Datos no recibidos", Toast.LENGTH_SHORT).show();
               }

    }

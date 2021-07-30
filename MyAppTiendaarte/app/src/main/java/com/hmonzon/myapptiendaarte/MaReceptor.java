package com.hmonzon.myapptiendaarte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MaReceptor extends AppCompatActivity {

    private TextView reciben, recibep;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_receptor);

        reciben = findViewById(R.id.txtNombreR);
        recibep = findViewById(R.id.txtPrecioR);
        imageView = findViewById(R.id.Receptorimg);



        this.recibeDatos();

    }

    private void recibeDatos(){
               Bundle bundle = getIntent().getExtras();

               String nombre = bundle.getString("nombre");
               String precio = bundle.getString("precio");
               int imagen = bundle.getInt("pintura");

                reciben.setText(String.valueOf("Nombre"+nombre));
                recibep.setText(String.valueOf("Precio: "+precio));
                imageView.setImageResource(imagen);



                   //Toast.makeText(this, "Datos no recibidos", Toast.LENGTH_SHORT).show();
               }

    }

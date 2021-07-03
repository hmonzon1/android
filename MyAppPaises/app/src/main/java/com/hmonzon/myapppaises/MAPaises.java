package com.hmonzon.myapppaises;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MAPaises extends AppCompatActivity {

    private TextView paisA;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapaises);

        paisA = findViewById(R.id.txtPais);
        img = findViewById(R.id.imgPais);
        this.recibeDatos();

    }

    public void recibeDatos(){

        Bundle bundle = getIntent().getExtras();
        int informacion = bundle.getInt("pais");
        int imagen = bundle.getInt("imagen");
        paisA.setText(informacion);
        img.setImageResource(imagen);





    }
}
package com.hmonzon.myappmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

public class Mameses extends AppCompatActivity {


    private TextView datos, titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mameses);

        datos = findViewById(R.id.txtInfo);
        titulo = findViewById(R.id.txtMes);
        this.recibedatos();
    }

    private void recibedatos(){

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombremes");
        int contenido = bundle.getInt("contenido");
        titulo.setText(String.valueOf(nombre));
        datos.setText(contenido);

}
}
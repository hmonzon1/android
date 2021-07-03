package com.hmonzon.myapplistado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MAVocales extends AppCompatActivity {

    private ImageView img;
    private TextView texto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mavocales);

        img = findViewById(R.id.imgvocal);
        texto1= findViewById(R.id.texto1);
        this.recibirimg();



    }
    public void recibirimg(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagen");
        int texto = bundle.getInt("texto");
        img.setImageResource(imagen);
        texto1.setText(texto);

    }

}
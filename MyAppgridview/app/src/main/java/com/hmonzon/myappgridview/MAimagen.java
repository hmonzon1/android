package com.hmonzon.myappgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MAimagen extends AppCompatActivity {

    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maimagen);

        img = findViewById(R.id.imgGrande);
        this.dato();

    }

    private void dato(){
        Bundle bundle = getIntent().getExtras();
        int imagen = bundle.getInt("imagen");

        this.img.setImageResource(imagen);



    }
}
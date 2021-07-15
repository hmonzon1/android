package com.hmonzon.myappcolores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    ArrayList<String> ncolores = new ArrayList<>();
   // ArrayList<Integer> llenadoColor = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.dGradView);

        ncolores.add("Celeste");
        ncolores.add("Morado");
        ncolores.add("Azul");
        ncolores.add("Beige");
        ncolores.add("Rosado");
        ncolores.add("Gris");
        ncolores.add("Verde");



        AdaptadorGrid adaptadorGrid = new AdaptadorGrid(this,R.layout.colores_personalizados, ncolores);
        gridView.setAdapter(adaptadorGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Pulsando valores"+ncolores.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MaReceptorColor.class);
                intent.putExtra("colores", ncolores.get(position));
                startActivity(intent);

            }
        });


    }
}
package com.hmonzon.myappgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    ArrayList<String> nombre = new ArrayList<>();
    ArrayList<Integer> imagenes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.griedview);
        nombre.add("Perro");
        nombre.add("Gato");
        nombre.add("Hamster");
        nombre.add("Tortuga");
        nombre.add("Loro");
        nombre.add("Huron");

        imagenes.add(R.drawable.ic_perro);
        imagenes.add(R.drawable.ic_gato);
        imagenes.add(R.drawable.ic_camster);
        imagenes.add(R.drawable.ic_tortuga);
        imagenes.add(R.drawable.ic_loro);
        imagenes.add(R.drawable.ic_huron);

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nombre);
        //gridView.setAdapter(adapter);

        AdaptadorGrid adaptadorGrid = new AdaptadorGrid(this, R.layout.grid_personalizado,nombre,imagenes);
        gridView.setAdapter(adaptadorGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "A pulsado: "+nombre.get(position), Toast.LENGTH_SHORT).show();
                Intent intent =  new Intent(getApplicationContext(),MAimagen.class);
                intent.putExtra("imagen",imagenes.get(position));
                startActivity(intent);
            }
        });


    }
}
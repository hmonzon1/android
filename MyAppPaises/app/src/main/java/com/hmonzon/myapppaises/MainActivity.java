package com.hmonzon.myapppaises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaP;
    ArrayList <String> paises = new ArrayList<>();
    ArrayList <Integer> imagenes = new ArrayList<>();
    ArrayList <Integer> informacion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaP = findViewById(R.id.listaPaises);

        paises.add("GUATEMALA");
        paises.add("EL SALVADOR");
        paises.add("HONDURAS");
        paises.add("NICARAGUA");
        paises.add("COSTA RICA");
        paises.add("PANAMA");
        paises.add("MEXICO");
        paises.add("ESTADOS UNIDOS");
        paises.add("CANADA");
        paises.add("COLOMBIA");

        imagenes.add(R.drawable.ic_guate);
        imagenes.add(R.drawable.ic_salvador);
        imagenes.add(R.drawable.ic_honduras);
        imagenes.add(R.drawable.ic_nicaragua);
        imagenes.add(R.drawable.ic_costarica);
        imagenes.add(R.drawable.ic_panama);
        imagenes.add(R.drawable.ic_mexico);
        imagenes.add(R.drawable.id_estadosunidos);
        imagenes.add(R.drawable.id_canada);
        imagenes.add(R.drawable.ic_colombia);

        informacion.add(R.string.Guatemala);
        informacion.add(R.string.Salvador);
        informacion.add(R.string.Honduras);
        informacion.add(R.string.Nicaragua);
        informacion.add(R.string.CostaRica);
        informacion.add(R.string.Panama);
        informacion.add(R.string.Mexico);
        informacion.add(R.string.EstadosUnidos);
        informacion.add(R.string.Canada);
        informacion.add(R.string.Colombia);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, paises);
        listaP.setAdapter(adapter);

        listaP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),MAPaises.class);
                intent.putExtra("pais", informacion.get(position));
                intent.putExtra("imagen", imagenes.get(position));
                startActivity(intent);

            }
        });


    }
}
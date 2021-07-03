package com.hmonzon.myapptiendaarte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView CategoriaPintura;

    ArrayList<String> nombreCategorias = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CategoriaPintura = findViewById(R.id.CategoriaPinturas);

        nombreCategorias.add("REALISMO");
        nombreCategorias.add("HIPERREALISMO");
        nombreCategorias.add("SURREALISMO");
        nombreCategorias.add("IMPRESIONISMO");
        nombreCategorias.add("EXPRESIONISMO");
        nombreCategorias.add("ARTE ABSTRACTO");
        nombreCategorias.add("ARTE POP");

        CategoriaPintura.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        AdaptadorLista adaptadorLista = new AdaptadorLista(this, R.layout.lista_personalizada, nombreCategorias);
        CategoriaPintura.setAdapter(adaptadorLista);
    }


    }

package com.hmonzon.myappmeses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaM;
    ArrayList <String> meses = new ArrayList<>();
    ArrayList <Integer> informacion = new ArrayList<>();
    ArrayList<Integer> numero = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaM = findViewById(R.id.listaMeses);

        meses.add("ENERO");
        meses.add("FEBRERO");
        meses.add("MARZO");
        meses.add("ABRIL");
        meses.add("MAYO");
        meses.add("JUNIO");
        meses.add("JULIO");
        meses.add("AGOSTO");
        meses.add("SEPTIEMBRE");
        meses.add("OCTUBRE");
        meses.add("NOVIEMBRE");
        meses.add("DICIEMBRE");

        informacion.add(R.string.enero);
        informacion.add(R.string.febrero);
        informacion.add(R.string.marzo);
        informacion.add(R.string.abril);
        informacion.add(R.string.mayo);
        informacion.add(R.string.junio);
        informacion.add(R.string.julio);
        informacion.add(R.string.agosto);
        informacion.add(R.string.septiembre);
        informacion.add(R.string.octubre);
        informacion.add(R.string.noviembre);
        informacion.add(R.string.diciembre);

        numero.add(1);
        numero.add(2);
        numero.add(3);
        numero.add(4);
        numero.add(5);
        numero.add(6);
        numero.add(7);
        numero.add(8);
        numero.add(9);
        numero.add(10);
        numero.add(11);
        numero.add(12);



        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, meses);
        //listaM.setAdapter(adapter);

        listaM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Mameses.class);

                intent.putExtra("nombremes", meses.get(position));
                intent.putExtra("contenido", informacion.get(position));
                startActivity(intent);

            }
        });

        AdaptadorLista adaptadorLista = new AdaptadorLista(this,R.layout.lista_personalizada,meses,numero);
        listaM.setAdapter(adaptadorLista);
    }
}
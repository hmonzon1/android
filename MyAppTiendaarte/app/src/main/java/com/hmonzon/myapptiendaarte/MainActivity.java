package com.hmonzon.myapptiendaarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        nombreCategorias.add("ARTE ABASTRACTO");
        nombreCategorias.add("ARTE POP");
  ;

        CategoriaPintura.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 0:
                         intent = new Intent(getApplicationContext(), MARealismo.class);
                        startActivity(intent);
                        break;

                    case 1:
                        intent  = new Intent(getApplicationContext(),MAarteabstracto.class);
                        startActivity(intent);
                        break;

                    case 2:
                        intent = new Intent(getApplicationContext(),MAartepop.class);
                        startActivity(intent);
                        break;


                }

            }
        });

        AdaptadorLista adaptadorLista = new AdaptadorLista(this, R.layout.lista_personalizada, nombreCategorias);
        CategoriaPintura.setAdapter(adaptadorLista);
    }


    }

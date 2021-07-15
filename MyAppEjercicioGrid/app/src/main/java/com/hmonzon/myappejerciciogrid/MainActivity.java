package com.hmonzon.myappejerciciogrid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    ArrayList<String>marcas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        marcas.add("Toyota");
        marcas.add("Chevrolet");
        marcas.add("Suzuki");
        marcas.add("Ford");
        marcas.add("Volkwagen");
        marcas.add("BMW");
        marcas.add("Hyundai");
        marcas.add("Honda");
        marcas.add("Mazda");
        marcas.add("Fiat");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,marcas);
        gridView.setAdapter(adapter);


        
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "A pulsado la marca "+marcas.get(position), Toast.LENGTH_SHORT).show();
            }
        });



    }
}
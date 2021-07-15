package com.hmonzon.myappreciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> lista = new ArrayList<>();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyckerId);
        //definimos el diseño de un recycleView, por defecto es lista
        //
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));

        for(int i = 0; i <= 10; i++){
            lista.add("Item No."+i);
        }

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(lista);
        recyclerView.setAdapter(adaptadorRecycler);
    }
}
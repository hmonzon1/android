package com.hmonzon.myapprecycler_datosvo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DatosVO> listaVO = new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        insertarDatos();

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(listaVO);
        recyclerView.setAdapter(adaptadorRecycler);
    }

    public void insertarDatos(){
    listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_donut));
        listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_hamburguesa));
        listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_papas));
        listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_pizza));
        listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_taco));
        listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_taco));
        listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_taco));
        listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_taco));
        listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_taco));
        listaVO.add(new DatosVO("Dona","Calientes",R.drawable.ic_taco));


    }
}
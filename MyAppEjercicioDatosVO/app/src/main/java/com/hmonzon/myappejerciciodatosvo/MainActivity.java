package com.hmonzon.myappejerciciodatosvo;

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

        InsertarDatos();

        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(listaVO);
        recyclerView.setAdapter(adaptadorRecycler);

    }

    public void InsertarDatos(){
        listaVO.add(new DatosVO("Abuelita","4512-7845",R.drawable.ic_abuelita));
        listaVO.add(new DatosVO("Brother","4578-6952",R.drawable.ic_bro));
        listaVO.add(new DatosVO("Papa","5418-7845",R.drawable.ic_dad));
        listaVO.add(new DatosVO("Mama","45845-3625",R.drawable.ic_mother));
        listaVO.add(new DatosVO("Sister","9865-3654",R.drawable.ic_girl));
        listaVO.add(new DatosVO("Hijo","2587-4578",R.drawable.ic_song));
        listaVO.add(new DatosVO("Tio","2589-6985",R.drawable.ic_uncle));
        listaVO.add(new DatosVO("Jefe","1245-7845",R.drawable.ic_manager));
        listaVO.add(new DatosVO("Teacher","4512-4578",R.drawable.ic_teacher));
        listaVO.add(new DatosVO("Ingeniero","4571-0152",R.drawable.ic_engineers));

    }
}
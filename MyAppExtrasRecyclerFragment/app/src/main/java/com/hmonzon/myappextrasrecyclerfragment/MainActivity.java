package com.hmonzon.myappextrasrecyclerfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DatosVO> listaG = new ArrayList<>();
    private ArrayList<DatosVO> listaVO2 = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerID);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        this.insertarDatos();
        this.insertarInformacion();
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(listaG);
        adaptadorRecycler.setOnItemClickListener(new AdaptadorRecycler.ClickListener() {
            @Override
            public void OnItemClick(int position, View vista) {

                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(getApplicationContext(),MainActivity2.class);
                        intent.putExtra("detalle",listaVO2.get(position).getDetalle());
                        intent.putExtra("especificaciones",listaVO2.get(position).getEspecificaiones());
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(getApplicationContext(),MainActivity2.class);
                        intent.putExtra("detalle",listaVO2.get(position).getDetalle());
                        intent.putExtra("especificaciones",listaVO2.get(position).getEspecificaiones());
                        startActivity(intent);


                        break;

                    case 2:
                        intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("detalle",listaVO2.get(position).getDetalle());
                        intent.putExtra("especificaciones",listaVO2.get(position).getEspecificaiones());
                        startActivity(intent);


                        break;

                    case 3:
                        intent = new Intent(getApplicationContext(),MainActivity2.class);
                        intent.putExtra("detalle",listaVO2.get(position).getDetalle());
                        intent.putExtra("especificaciones",listaVO2.get(position).getEspecificaiones());
                        startActivity(intent);


                        break;

                    case 4:
                        intent = new Intent(getApplicationContext(),MainActivity2.class);
                        intent.putExtra("detalle",listaVO2.get(position).getDetalle());
                        intent.putExtra("especificaciones",listaVO2.get(position).getEspecificaiones());
                        startActivity(intent);


                        break;
                }
            }
        });

        recyclerView.setAdapter(adaptadorRecycler);


    }
    public void insertarDatos(){
        listaG.add(new DatosVO(R.drawable.ic_circuito,"Computadora"));
        listaG.add(new DatosVO(R.drawable.ic_circuito,"Computadora"));
        listaG.add(new DatosVO(R.drawable.ic_circuito,"Computadora"));
        listaG.add(new DatosVO(R.drawable.ic_circuito,"Computadora"));
    }

    public void insertarInformacion(){
        listaVO2.add(new DatosVO(R.string.detalleString1,R.string.especificacionesString1));
        listaVO2.add(new DatosVO(R.string.detalleString2, R.string.especificacionesString2));
        listaVO2.add(new DatosVO(R.string.detalleString3, R.string.especificacionesString3));
        listaVO2.add(new DatosVO(R.string.detalleString4, R.string.especificacionesString4));
    }
}
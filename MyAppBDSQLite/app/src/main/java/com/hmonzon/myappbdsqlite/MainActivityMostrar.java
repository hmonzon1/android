package com.hmonzon.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hmonzon.myappbdsqlite.complementos.ConstantesSQL;
import com.hmonzon.myappbdsqlite.complementos.MascostasVO;

import java.util.ArrayList;

public class MainActivityMostrar extends AppCompatActivity {

     private ListView listView;
     //Arreglos
     //el primero es para llenar la lista
     private ArrayList<String> listaDatos;
     //el segundo para obtener los datos de la base de datos
      private ArrayList<MascostasVO> listaMascota;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar);

        listView = findViewById(R.id.idlist);
        this.mostrarMascota();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trasladoInformacion(position);

            }
        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaDatos);
        listView.setAdapter(arrayAdapter);


    }

    private void mostrarMascota(){
        ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS,null,ConstantesSQL.VERSION);

        SQLiteDatabase db = conectorSQLite.getReadableDatabase();
        try {

            MascostasVO mascostasVO;
            listaMascota = new ArrayList<>();

            String Csql;
            Csql = "SELECT * FROM "+ConstantesSQL.TABLA_MASCOTAS+";";

            Cursor cursor = db.rawQuery(Csql,null);
            //llenado de variables VO y el arreglo tipo clase
            while(cursor.moveToNext()){
                mascostasVO = new MascostasVO();
                mascostasVO.setCodigo(cursor.getInt(0));
                mascostasVO.setNombre(cursor.getString(1));
                mascostasVO.setRaza(cursor.getString(2));
                mascostasVO.setColor(cursor.getString(3));
                mascostasVO.setEdad(cursor.getInt(4));

                listaMascota.add(mascostasVO);

            }
            listaDatos = new ArrayList<>();
            for(int i = 0; i< listaMascota.size();i++ ){
                listaDatos.add(listaMascota.get(i).getCodigo()+".  "+listaMascota.get(i).getNombre()+
                ". "+listaMascota.get(i).getRaza()+". "+listaMascota.get(i).getColor()+". "+listaMascota.get(i).getEdad());

            }

        }catch(Exception e){
            e.getMessage();

        }
    }

private void trasladoInformacion(int position){
         String CMascota, NMascota, RMascota, CoMascota, EMascota;
         CMascota = String.valueOf(listaMascota.get(position).getCodigo());
         NMascota = listaMascota.get(position).getNombre();
         RMascota = listaMascota.get(position).getRaza();
         CoMascota = listaMascota.get(position).getColor();
         EMascota = String.valueOf(listaMascota.get(position).getEdad());

    Intent intent = new Intent(getApplicationContext(), MainActivityDetalleR.class);
    intent.putExtra("id", CMascota);
    intent.putExtra("nombre", NMascota);
    intent.putExtra("raza", RMascota);
    intent.putExtra("color", CoMascota);
    intent.putExtra("edad",EMascota);

    startActivity(intent);






    }

}


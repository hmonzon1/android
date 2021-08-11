package com.hmonzon.myappdiccionariosw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.hmonzon.myappdiccionariosw.complementos.MetodosSW;
import com.hmonzon.myappdiccionariosw.complementos.PalabraVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    private ListView listView;
    ArrayList<String> listaPalabras = new ArrayList<>();
    ArrayList<PalabraVO> listaPalabrasVO = new ArrayList<>();
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.IDPalabrasList);
        metodosSW.ConsultarSW(this,this,this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TrasladoDatos(position);



            }
        });






    }


   private void ConsultaPalabras(JSONObject response){

       JSONArray jsonArray = response.optJSONArray("tbl_diccionario");
       listaPalabrasVO = new ArrayList<>();
       try{

           for (int i = 0; i< jsonArray.length(); i++){
               PalabraVO palabraVO = new PalabraVO();
               JSONObject jsonObject = jsonArray.getJSONObject(i);
               palabraVO.setCodigo(jsonObject.optInt("codigo_palabra"));
               palabraVO.setNombre(jsonObject.optString("nombre_palabra"));
               palabraVO.setDefinicion(jsonObject.optString("definicion_palabra"));
               listaPalabrasVO.add(palabraVO);

           }

           listaPalabras = new ArrayList<>();
           for(int i = 0; i< listaPalabrasVO.size(); i++){
               if (listaPalabrasVO.get(i).getCodigo()!= 0){

                  listaPalabras.add(listaPalabrasVO.get(i).getCodigo()+ " . "+ listaPalabrasVO.get(i).getNombre());

               }
               else {

                   Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

               }
           }

           ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaPalabras);
           listView.setAdapter(arrayAdapter);



       }catch (Exception e){
           Toast.makeText(this, "error referente a C", Toast.LENGTH_SHORT).show();
           System.err.println("B------"+e.getCause()+"B-------"+e.getMessage());


       }




   }



    @Override
    public void onResponse(JSONObject response) {

        this.ConsultaPalabras(response);


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a Consultar: "+error, Toast.LENGTH_SHORT).show();
        System.err.println("C*****"+error);

    }

    private void TrasladoDatos(int position){
        String nombreP, definicionP;
        nombreP = String.valueOf(listaPalabrasVO.get(position).getNombre());
        definicionP = String.valueOf(listaPalabrasVO.get(position).getDefinicion());
        Intent intent = new Intent(getApplicationContext(), MainActivityDefinicion.class);
        intent.putExtra("nombre",nombreP);
        intent.putExtra("definicion",definicionP);
        startActivity(intent);


    }
}

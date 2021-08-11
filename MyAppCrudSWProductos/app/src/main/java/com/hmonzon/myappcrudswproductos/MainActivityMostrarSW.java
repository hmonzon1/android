package com.hmonzon.myappcrudswproductos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.hmonzon.myappcrudswproductos.complementos.MetodosSW;
import com.hmonzon.myappcrudswproductos.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityMostrarSW extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    ListView listView;
    ArrayList<String>ListaProductos = new ArrayList<>();
    ArrayList<ProductoVO> listaproductoVO = new ArrayList<>();
    MetodosSW metodosSW = new MetodosSW();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mostrar_sw);

        listView = findViewById(R.id.lvListaProductos);
        metodosSW.ConsultarSW(this,this,this);
    }

    private void resultadoConsultaCompleta(JSONObject response){

        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        listaproductoVO = new ArrayList<>();
        try{
            for(int i = 0; i <jsonArray.length(); i++){
                ProductoVO productoVO = new ProductoVO();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                productoVO.setCodigo(jsonObject.optInt("id_producto"));
                productoVO.setNombre(jsonObject.optString("nombre_producto"));
                productoVO.setMarca(jsonObject.optString("marca_producto"));
                productoVO.setCosto(jsonObject.optInt("costo_producto"));
                productoVO.setPrecio(jsonObject.optInt("precio_producto"));
                listaproductoVO.add(productoVO);
            }

            ListaProductos = new ArrayList<>();
            for(int i = 0; i <listaproductoVO.size(); i++) {
                if (listaproductoVO.get(i).getCodigo() != 0) {

                    ListaProductos.add(listaproductoVO.get(i).getCodigo() + ". " + listaproductoVO.get(i).getNombre());

                } else {
                    Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                }
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ListaProductos);
            listView.setAdapter(arrayAdapter);




        }catch (Exception e){

            Toast.makeText(this, "error referente a C", Toast.LENGTH_SHORT).show();
            System.err.println("B------"+e.getCause()+"B-------"+e.getMessage());


        }


    }



    @Override
    public void onResponse(JSONObject response) {

        this.resultadoConsultaCompleta(response);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente a Consultar: "+error, Toast.LENGTH_SHORT).show();
        System.err.println("C*****"+error);



    }
}
package com.hmonzon.myappcrudswproductos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.hmonzon.myappcrudswproductos.complementos.MetodosSW;

import org.json.JSONObject;

public class MainActivityInsertarSW extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
    EditText editTextN, editTextM, editTextC, editTextP;
    MetodosSW metodosSW = new MetodosSW();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar_sw);

        editTextN =findViewById(R.id.edNombreProducto);
        editTextM = findViewById(R.id.edMarcaProducto);
        editTextC = findViewById(R.id.edCostoProducto);
        editTextP =findViewById(R.id.edPrecioProducto);
    }

    public void onClick(View view) {

        this.insertar();
    }

    private void insertar(){
        if (!editTextN.getText().toString().isEmpty()&&
        !editTextM.getText().toString().isEmpty()&&
        !editTextC.getText().toString().isEmpty()&&
        !editTextP.getText().toString().isEmpty()){

            //utilizamos el metodo
            metodosSW.insertarSW(this,editTextN.getText().toString(),
                    editTextM.getText().toString(),Integer.parseInt(editTextC.getText().toString()),
                            Integer.parseInt(editTextP.getText().toString()),this,this);

            editTextN.setText("");
            editTextM.setText("");
            editTextC.setText("");
            editTextP.setText("");

        }else{
            Toast.makeText(this, "Debe llenar el campo", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Datos Ingresados Correctamente", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Error referente: "+error, Toast.LENGTH_SHORT).show();
        System.err.println("I*****"+error);

    }
}
package com.hmonzon.myappcrudswproductos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.hmonzon.myappcrudswproductos.complementos.MetodosSW;
import com.hmonzon.myappcrudswproductos.complementos.ProductoVO;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivityBuscarSW extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    EditText editTextB;
    TextView textViewN, textViewM, textViewC, textViewP;
    MetodosSW  metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buscar_sw);

        editTextB = findViewById(R.id.EditBuscarID);
         textViewN = findViewById(R.id.txtNombreP);
        textViewM = findViewById(R.id.txtmarcaP);
        textViewC = findViewById(R.id.txtcostoP);
        textViewP = findViewById(R.id.txtprecioP);


    }

    public void onClick(View view) {
        this.BuscarID();

    }

    private void BuscarID(){
        if(!editTextB.getText().toString().isEmpty()){
            metodosSW.BuscarID(this,Integer.parseInt(editTextB.getText().toString()), this, this);

        }else{
            Toast.makeText(this, "Debe llenar el campo", Toast.LENGTH_SHORT).show();
        }
    }

    private void resultadoConsulta(JSONObject response){
        ProductoVO productoVO = new ProductoVO();
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        try{

            JSONObject jsonObject = null;
            jsonObject = jsonArray.getJSONObject(0);
            productoVO.setNombre(jsonObject.optString("nombre_producto"));
            productoVO.setMarca(jsonObject.optString("marca_producto"));
            productoVO.setCosto(jsonObject.optInt("costo_producto"));
            productoVO.setPrecio(jsonObject.optInt("precio_producto"));

            String dato = productoVO.getNombre();
            if (!dato.equals("...")) {

                textViewN.setText(productoVO.getNombre());
                textViewM.setText(productoVO.getMarca());
                textViewC.setText(String.valueOf(productoVO.getCosto()));
                textViewP.setText(String.valueOf(productoVO.getPrecio()));
            }else{
                editTextB.setText("...");
                textViewN.setText("...");
                textViewM.setText("...");
                textViewC.setText("...");
                textViewP.setText("...");
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "error referente a B", Toast.LENGTH_SHORT).show();
            System.err.println("B------"+e.getCause()+"B-------"+e.getMessage());
        }

    }

    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsulta(response);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        textViewN.setText("");
        textViewM.setText("");
        textViewC.setText("");
        textViewP.setText("");

    }
}
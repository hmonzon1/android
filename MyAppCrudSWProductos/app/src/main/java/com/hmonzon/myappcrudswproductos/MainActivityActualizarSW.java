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

public class MainActivityActualizarSW extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    EditText editTextB, editTextN, editTextM, editTextC, editTextP;

    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar_sw);

        editTextB = findViewById(R.id.EditBuscarID);
        editTextN = findViewById(R.id.editNombreActualizar);
        editTextM = findViewById(R.id.editMarcaActualizar);
        editTextC = findViewById(R.id.editCostoActualizar);
        editTextP = findViewById(R.id.editPrecioActualizar);


    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscar:
                this.BuscarID();

                break;

            case R.id.btnActualizar:

                this.actualizar();


                break;
        }
    }

    private void actualizar(){
        if (!editTextB.getText().toString().isEmpty()&&!editTextN.getText().toString().isEmpty()&&
        !editTextM.getText().toString().isEmpty()&&!editTextC.getText().toString().isEmpty()&&
                !editTextP.getText().toString().isEmpty()){

            metodosSW.Actualizar(this,Integer.parseInt(editTextB.getText().toString()),
                    editTextN.getText().toString(), editTextM.getText().toString(),
                    Integer.parseInt(editTextC.getText().toString()),
                    Integer.parseInt(editTextP.getText().toString()),this,this);
            editTextB.setText("");
            editTextN.setText("...");
            editTextM.setText("...");
            editTextC.setText("...");
            editTextP.setText("...");
            Toast.makeText(this, "Datos Actualizados", Toast.LENGTH_SHORT).show();

        }

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

                editTextN.setText(productoVO.getNombre());
                editTextM.setText(productoVO.getMarca());
                editTextC.setText(String.valueOf(productoVO.getCosto()));
                editTextP.setText(String.valueOf(productoVO.getPrecio()));
            }else{
                editTextN.setText("...");
                editTextM.setText("...");
                editTextC.setText("...");
                editTextP.setText("...");
                Toast.makeText(this, "Datos no modificados", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "error referente a A", Toast.LENGTH_SHORT).show();
            System.err.println("A------"+e.getCause()+"A-------"+e.getMessage());
        }

    }


    @Override
    public void onResponse(JSONObject response) {
        this.resultadoConsulta(response);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "error referente a A", Toast.LENGTH_SHORT).show();
        System.err.println("A-----"+error);

    }
}
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
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivityEliminarSW extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
    EditText editTextE;
    TextView textViewN, textViewM, textViewC, textViewP;
    MetodosSW metodosSW = new MetodosSW();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eliminar_sw);

        editTextE = findViewById(R.id.EditBuscarID);
        textViewN = findViewById(R.id.txtNombreE);
        textViewM = findViewById(R.id.txtmarcaE);
        textViewC = findViewById(R.id.txtcostoE);
        textViewP = findViewById(R.id.txtprecioE);


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEliminar1:
                this.BuscarIDEliminar();

                break;

            case R.id.btnEliminar2:
                this.eliminar();

                break;
        }
    }

    private void eliminar() {
        if (!editTextE.getText().toString().isEmpty()) {

            metodosSW.eliminarSW(this, Integer.parseInt(editTextE.getText().toString()), this, this);
            editTextE.setText("");
            textViewN.setText("");
            textViewM.setText("");
            textViewC.setText("");
            textViewP.setText("");
            Toast.makeText(this, "Datos eliminados correctamente", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Debe llenar el campo", Toast.LENGTH_SHORT).show();



        }


    }

    private void BuscarIDEliminar() {
        if (!editTextE.getText().toString().isEmpty()) {
            metodosSW.BuscarID(this, Integer.parseInt(editTextE.getText().toString()), this, this);

        } else {
            Toast.makeText(this, "Debe llenar el campo", Toast.LENGTH_SHORT).show();

        }

    }

    private void Resultado(JSONObject response) {
        ProductoVO productoVO = new ProductoVO();
        JSONArray jsonArray = response.optJSONArray("tbl_producto");
        try {

            JSONObject jsonObject = null;
            jsonObject = jsonArray.getJSONObject(0);
            productoVO.setNombre(jsonObject.optString("nombre_producto"));
            productoVO.setMarca(jsonObject.optString("marca_producto"));
            productoVO.setCosto(jsonObject.optInt("costo_producto"));
            productoVO.setPrecio(jsonObject.optInt("precio_producto"));

            String dato = productoVO.getNombre();
            if (!dato.equals("")) {
                textViewN.setText(productoVO.getNombre());
                textViewM.setText(productoVO.getMarca());
                textViewC.setText(String.valueOf(productoVO.getCosto()));
                textViewP.setText(String.valueOf(productoVO.getPrecio()));
            } else{

                editTextE.setText("");
                textViewN.setText("");
                textViewM.setText("");
                textViewC.setText("");
                textViewP.setText("");
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();


                }

        } catch (Exception e) {
            Toast.makeText(this, "error referente a E", Toast.LENGTH_SHORT).show();
            System.err.println("E------" + e.getCause() + "E-------" + e.getMessage());

        }


    }

    @Override
    public void onResponse(JSONObject response) {
        this.Resultado(response);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(this, "error referente a E", Toast.LENGTH_SHORT).show();
        System.err.println("E-----"+error);


    }
}
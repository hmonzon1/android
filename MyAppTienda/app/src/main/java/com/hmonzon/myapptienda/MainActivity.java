package com.hmonzon.myapptienda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campo1, campo2, campo3;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo1 = findViewById(R.id.txtProducto);
        campo2 = findViewById(R.id.txtValor);
        campo3 = findViewById(R.id.txtCantidad);
        resultado = findViewById(R.id.txtResultado);
    }

    public void mostrarDatos(){
        String c1, c2, c3;
        c1 = campo1.getText().toString();
        c2 = campo2.getText().toString();
        c3 = campo3.getText().toString();
        if (!c1.isEmpty()&&!c2.isEmpty()&&!c3.isEmpty()){
            int valor, cantidad;
            valor = Integer.parseInt(c2);
            cantidad = Integer.parseInt(c3);
            int ivav = valor * 12 / 100;
            int valorI = valor + ivav;
            int total = valorI * cantidad;
            resultado.setText(("Producto : "+c1 +" \n "+valorI+ "\n "+ total));

        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }

    }

    public void pulsar(View view) {
        switch(view.getId()){
            case R.id.btnMostrar:
                this.mostrarDatos();
                break;

        }
    }
}
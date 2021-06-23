package com.hmonzon.myapp_suma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campo1, campo2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo1 = findViewById(R.id.txtNumero1);
        campo2 = findViewById(R.id.txtNumero2);
        resultado = findViewById(R.id.txtResultado);

    }

    public void sumar(){
        String campoN1, campoN2, CampoResultado;
        campoN1 = campo1.getText().toString();
        campoN2 = campo2.getText().toString();
        if (!campoN1.isEmpty()&&!campoN2.isEmpty()){
            int dato1 = Integer.parseInt(campoN1);
            int dato2 = Integer.parseInt(campoN2);
            int suma = dato1 + dato2;
            resultado.setText(String.valueOf(suma));

        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void pulsar(View view) {
        switch (view.getId()){
            case R.id.btnSumar:
                this.sumar();
                break;
        }
    }
}
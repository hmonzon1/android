package com.hmonzon.myappact3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MAMayor extends AppCompatActivity {

    private TextView campoNumero1, campoNumero2, campoCalificacion;
    private EditText campoResultado;
    private int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mamayor);

        campoNumero1 = findViewById(R.id.txtNumero1);
        campoNumero2 = findViewById(R.id.txtNumero2);
        campoResultado = findViewById(R.id.txtResultado);
        campoCalificacion = findViewById(R.id.txtCalificacion);

        num1 = (int) (Math.random()*5);
        num2 = (int) (Math.random()*5);
        campoNumero1.setText(String.valueOf("Numero:"+num1));
        campoNumero2.setText(String.valueOf("Numero: "+num2));


    }

    private void multiplicacion(){

        String result = campoResultado.getText().toString();
        int resultado = Integer.parseInt(result);

        int multiplicacion = num1 * num2;

        if (resultado == multiplicacion ){

            campoCalificacion.setText("Excelente eres todo un adulto");
        }else{
            Toast.makeText(this, "Incorrecto intentalo de nuevo", Toast.LENGTH_SHORT).show();
        }

    }

    public void pulsar(View view) {

        this.multiplicacion();
    }
}
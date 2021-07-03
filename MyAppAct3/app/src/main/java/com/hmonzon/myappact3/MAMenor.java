package com.hmonzon.myappact3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MAMenor extends AppCompatActivity {

    private TextView campoNum1, campoNum2, campoCalificacion;
    private EditText campoResultado;
    private int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mamenor);

        campoNum1 = findViewById(R.id.txtNumero1);
        campoNum2 = findViewById(R.id.txtNumero2);
        campoCalificacion = findViewById(R.id.txtCalificacion);
        campoResultado = findViewById(R.id.txtResultado);



         num1 = (int) (Math.random()*5);
         num2 = (int) (Math.random()*5);
        campoNum1.setText(String.valueOf("Numero: "+num1));
        campoNum2.setText(String.valueOf("Numero: "+num2));

    }

    private void sumaaleatoria(){

        String result = campoResultado.getText().toString();
        int resultado = Integer.parseInt(result);


        int suma = num1 + num2;

        if (resultado == suma){

            campoCalificacion.setText("Es correcto  ya no eres tan bebe");


        }else{
            Toast.makeText(this, "Incorrecto ingresa otra respuesta", Toast.LENGTH_SHORT).show();
        }



    }

    public void onClick(View view) {
        this.sumaaleatoria();
    }
}
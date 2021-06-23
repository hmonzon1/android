package com.hmonzon.myappoperaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView resultado;
    private TextView resultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.txtNum1);
        num2 = findViewById(R.id.txtNum2);
        resultado = findViewById(R.id.txtResultado);
        resultado2 = findViewById(R.id.txtResultado2);
    }

    public void sumar(){
        String n1,n2;
        n1 = num1.getText().toString();
        n2 = num2.getText().toString();
        if (!n1.isEmpty()&&!n2.isEmpty()){
            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            int suma = num1 + num2;
            resultado.setText(String.valueOf(suma));

        }else{
            Toast.makeText(this, "Ingrese los numeros", Toast.LENGTH_SHORT).show();
        }




    }

    public void restar(){
        String n1,n2;
        n1 = num1.getText().toString();
        n2 = num2.getText().toString();
        if (!n1.isEmpty()&&!n2.isEmpty()){
            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            int resta = num1 - num2;
            resultado.setText(String.valueOf(resta));
        }else{
            Toast.makeText(this, "Ingrese los numeros", Toast.LENGTH_SHORT).show();
        }
    }

    public void produto(){
        String n1, n2;
        n1 = num1.getText().toString();
        n2 = num2.getText().toString();
        if (!n1.isEmpty()&&!n2.isEmpty()){
            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            int producto = num1 * num2;
            resultado.setText(String.valueOf(producto));
        }
    }

    public void dividir(){
        String n1, n2;
        n1 = num1.getText().toString();
        n2 = num2.getText().toString();
        if (!n1.isEmpty()&&!n2.isEmpty()){
            double num1 = Integer.parseInt(n1);
            double num2 = Integer.parseInt(n2);
            double dividir = num1 / num2;
            resultado.setText(String.valueOf(dividir));
        }else{
            Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
        }
    }

    public void numeromayor(){
        String n1,n2;
        n1 = num1.getText().toString();
        n2 = num2.getText().toString();
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        if (num1>num2){
            resultado2.setText(String.valueOf(num1));


        }else{
            resultado2.setText(String.valueOf(num2));
        }
    }




    public void pulsar(View view) {
        switch(view.getId()){
            case R.id.btnSumar:
                this.sumar();
                this.numeromayor();
                break;
            case R.id.btnRestar:
                this.restar();
                this.numeromayor();
                break;

            case R.id.btnProducto:
                this.produto();
                this.numeromayor();
                break;
            case R.id.btnDividir:
                this.dividir();
                this.numeromayor();
                break;

        }
    }
}
package com.hmonzon.myappenvio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MAreceptor extends AppCompatActivity {

    private TextView textoN, textoA, textoD, textoT, textoE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mareceptor);

        textoN = findViewById(R.id.txtN);
        textoA = findViewById(R.id.txtA);
        textoD = findViewById(R.id.txtD);
        textoT = findViewById(R.id.txtT);
        textoE = findViewById(R.id.txtE);

        this.obtener();

    }

    private void obtener(){

        //Se agrega el objeto Bundle este permite obtener los datos
        //trasladados de intent con su metodo putExtra y manipularlos

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String nombre = bundle.getString("nombres");
            String apellido = bundle.getString("apellidos");
            String direccion = bundle.getString("Direccion");
            String telefono = bundle.getString("Telefono");
            String edad = bundle.getString("Edad");

            textoN.setText("Nombre: "+nombre);
            textoA.setText("Apellidos: "+apellido);
            textoD.setText("Direcion: "+direccion);
            textoT.setText("Telefono: "+telefono);
            textoE.setText("Edad: "+edad);
        }else{
            Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
        }

    }
}
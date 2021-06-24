package com.hmonzon.myappaniob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class MArecepcion extends AppCompatActivity {

    private TextView textoA, textoB, textoS, textoM, textoD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marecepcion);

        textoA = findViewById(R.id.txtA);
        textoB = findViewById(R.id.txtBisiesto);
        textoS = findViewById(R.id.txtSemana);
        textoM = findViewById(R.id.txtMes);
        textoD = findViewById(R.id.txDia);
        this.obtener();
    }

     private void obtener(){
         GregorianCalendar calendar = new GregorianCalendar();
        Bundle bundle = getIntent().getExtras();


        if(bundle != null){
            Integer semana;
            Integer dia;
            String anio = bundle.getString("Año");
            textoA.setText("Año: "+anio);


            //Verificando el año
           // int an = Integer.parseInt(anio);
            //if ((an % 4 == 0) && ((an % 100 != 0) ||(an % 400 == 0))){
              // textoB.setText(String.valueOf("El año es bisiesto"));
            //}else{
             // textoB.setText(String.valueOf("El Año no es Bisiesto"));
           // }

            //Verificando el año
             int an = Integer.parseInt(anio);
             if (calendar.isLeapYear(an)){
                 textoB.setText(String.valueOf("El año es bisiesto"));
             }else{
                 textoB.setText(String.valueOf("El Año no es Bisiesto"));
             }

            //semanas meses y dias
            if(calendar.isLeapYear(an)) {
                Integer mes;
                mes = 366 / 30;
                textoM.setText(String.valueOf("Meses: " + mes));
            }else{
                Integer mes = 365/ 30;
                textoM.setText(String.valueOf("Meses: " +mes));
            }

            if (calendar.isLeapYear(an)){
                semana = 366 / 7;
                textoS.setText(String.valueOf("Semana :"+
                        semana));
            }else{
                semana = 365 / 7;
                textoS.setText(String.valueOf("Semana:"+semana));
            }

            if (calendar.isLeapYear(an)){

            }

            if (calendar.isLeapYear(an)){
                dia = 366 / 1;
                textoD.setText(String.valueOf("Dias del Año: "+dia));
            }else{
                dia = 365 / 1;
                textoD.setText(String.valueOf("Dias del Año: "+dia));
            }



        }else{
            Toast.makeText(this, "Año no ingresado", Toast.LENGTH_SHORT).show();
        }



    }
    private void calcular(){

    }
}
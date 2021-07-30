package com.hmonzon.myapptiendaarte;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MARealismo extends AppCompatActivity {
    private ArrayList<Integer> imagenes = new ArrayList<>();
    private TextView n1;
    private TextView p1;
    private TextView n2;
    private TextView p2;
    private TextView n3;
    private TextView p3;
    private ImageView i1, i2, i3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marealismo);

        n1 = findViewById(R.id.txtPintura1);
        n2 = findViewById(R.id.txtPintura2);
        n3 = findViewById(R.id.txtPintura3);
        p1 = findViewById(R.id.txtPrecio1);
        p2 = findViewById(R.id.txtPrecio2);
        p3 = findViewById(R.id.txtPrecio3);

        i1 = findViewById(R.id.img1);
        i2 = findViewById(R.id.img2);
        i3 = findViewById(R.id.img3);

        imagenes.add(R.drawable.ic_pastora);
        imagenes.add(R.drawable.ic_pensador);
        imagenes.add(R.drawable.ic_cesta);



    }

    private void enviarDatos1() {
         int img1 = imagenes.get(0);
         String pintura = n1.getText().toString();
         String precio = p1.getText().toString();

         if (!pintura.isEmpty()&&!precio.isEmpty()){

             Intent intent = new Intent(this,
                     MaReceptor.class);

             intent.putExtra("nombre", pintura);
             intent.putExtra("precio", precio);
             intent.putExtra("pintura", img1);
             startActivity(intent);

         }else{
             Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_SHORT).show();
         }












    }



    public void onClick(View view) {
          switch(view.getId()){
              case R.id.btnP1:
                  this.enviarDatos1();
                  break;

          }

    }
}
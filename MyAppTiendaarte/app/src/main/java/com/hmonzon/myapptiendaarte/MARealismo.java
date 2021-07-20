package com.hmonzon.myapptiendaarte;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MARealismo extends AppCompatActivity {

    private TextView n1;
    private TextView p1;
    private TextView n2;
    private TextView p2;
    private TextView n3;
    private TextView p3;
    private ImageView i1, i2, i3;
    String cuadro1;
    String preciop1;

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

         cuadro1 = n1.getText().toString();
         preciop1 = p1.getText().toString();
    }

    private void enviarDatos1() {





            Intent intent = new Intent(this,
                    MaReceptor.class);
            startActivity(intent);
            intent.putExtra("nombre", cuadro1);
            intent.putExtra("precio", preciop1);




           // Toast.makeText(this, "NO encontrado", Toast.LENGTH_SHORT).show();



    }



    public void onClick(View view) {
          switch(view.getId()){
              case R.id.btnP1:
                  this.enviarDatos1();
                  break;

          }

    }
}
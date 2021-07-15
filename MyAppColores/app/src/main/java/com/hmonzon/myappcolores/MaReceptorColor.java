package com.hmonzon.myappcolores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MaReceptorColor extends AppCompatActivity {

    private TextView campocolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_receptor_color);

        campocolor = findViewById(R.id.txtRecibeNColor);
    }

    private void dato() {


    Bundle bundle = getIntent().getExtras();
    String ncolor = bundle.getString("colores");

    campocolor.setText(ncolor);

}
}
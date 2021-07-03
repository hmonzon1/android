package com.hmonzon.myappact3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edad = findViewById(R.id.txtEdad);
    }

    public void test() {
        String edad1;
        edad1 = edad.getText().toString();
        Integer edades = Integer.parseInt(edad1);
        if (edades >= 18) {
            Intent intent = new Intent(this, MAMayor.class);
            startActivity(intent);
            


        } else {
            Intent intent = new Intent(this, MAMenor.class);
            startActivity(intent);
        }


    }




    public void pulsar(View view) {
        if (view.getId()==R.id.btnVerficar){
            this.test();
    }
}

    }

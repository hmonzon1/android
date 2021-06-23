package com.hmonzon.myappact3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsar(View view) {
        Intent intent = null;
        if (view.getId()== R.id.btnVerficar) {
            intent = new Intent(this, MAMayor.class);
            startActivity(intent);
            finish();
        }else if(view.getId() == R.id.btnVerficar2){
            intent = new Intent(this, MAMenor.class);
            startActivity(intent);
            finish();


        }

    }
}
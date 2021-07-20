package com.hmonzon.myappcuentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MaFragmentos extends AppCompatActivity {

     private Fragment fragmentA,fragmentB, fragmentC,fragmentD,fragmentE;
     private FragmentTransaction transaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_fragmentos);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();
        fragmentD = new FragmentD();
        fragmentE = new FragmentE();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragmentA).hide(fragmentA).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragmentB).hide(fragmentB).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragmentC).hide(fragmentC).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragmentD).hide(fragmentD).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorID,fragmentE).hide(fragmentE).commit();







    }

    public void onClick(View view) {
             transaction = getSupportFragmentManager().beginTransaction();

             switch (view.getId()){
                 case R.id.btnCto1:
                     if (fragmentA.isAdded()){
                           transaction.hide(fragmentB).hide(fragmentC).hide(fragmentD).hide(fragmentE).show(fragmentA);
                     }else{
                           transaction.hide(fragmentB).hide(fragmentC).hide(fragmentD).hide(fragmentE).add(R.id.contenedorID,fragmentA);
                           transaction.addToBackStack(null);

                     }

                     break;

                 case R.id.btnCto2:
                     if (fragmentB.isAdded()){
                         transaction.hide(fragmentA).hide(fragmentC).hide(fragmentD).hide(fragmentE).show(fragmentB);

                     }else{
                         transaction.hide(fragmentB).hide(fragmentC).hide(fragmentD).hide(fragmentE).add(R.id.contenedorID,fragmentB);
                         transaction.addToBackStack(null);
                     }


                     break;

                 case R.id.btnCto3:
                     if (fragmentC.isAdded()){
                         transaction.hide(fragmentA).hide(fragmentB).hide(fragmentD).hide(fragmentE).show(fragmentC);
                     }else{
                         transaction.hide(fragmentA).hide(fragmentB).hide(fragmentD).hide(fragmentE).add(R.id.contenedorID,fragmentC);
                         transaction.addToBackStack(null);
                     }

                     break;

                 case R.id.btnCto4:
                     if (fragmentD.isAdded()){
                         transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentE).show(fragmentD);
                     }else{
                         transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentE).add(R.id.contenedorID,fragmentD);
                         transaction.addToBackStack(null);
                     }

                     break;

                 case R.id.btnCto5:
                     if (fragmentE.isAdded()){
                         transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentD).show(fragmentE);
                     }else{
                         transaction.hide(fragmentA).hide(fragmentB).hide(fragmentC).hide(fragmentD).add(R.id.contenedorID,fragmentE);
                         transaction.addToBackStack(null);

                     }


                     break;


             }

             transaction.commit();
    }
}
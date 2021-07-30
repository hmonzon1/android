package com.hmonzon.myappextrasrecyclerfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    private Fragment fragment1, fragment2;
    private FragmentTransaction transaction;

    //encargadas de recibir datos y luego insertar esos datos a los
    //fragmentos
    private int detalle;
    private int especificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fragment1 = new DetalleFragment();
        fragment2 = new EspecificacionesFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorId,fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorId,fragment2).hide(fragment2).commit();

          //datos
        this.recibirDatos();
        this.trasladarFrag1();
        this.trasladarFrag2();

    }

    //obtener datos
    private void recibirDatos(){
        Bundle bundle = getIntent().getExtras();
        detalle = bundle.getInt("detalle");
        especificaciones = bundle.getInt("especificaciones");

    }

    //traslado de info
    private void trasladarFrag1(){
        Bundle bundle = new Bundle();
        bundle.putInt("det",detalle);
        fragment1.setArguments(bundle);


    }
    private void trasladarFrag2(){
        Bundle bundle = new Bundle();
        bundle.putInt("esp",especificaciones);
        fragment2.setArguments(bundle);

    }
    private void trasladarFrag3(){

    }
    private void llenarFrag4(){

    }


    public void onClick(View view){
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btnDetalles:
                if (fragment1.isAdded()){
                    transaction.hide(fragment2).show(fragment1);

        }else{
                    transaction.hide(fragment2).add(R.id.contenedorId, fragment1);
                    transaction.addToBackStack(null);
                }
                break;
            case R.id.btnEspecificaciones:
            if (fragment2.isAdded()){
                transaction.hide(fragment1).show(fragment2);

            }else{
                transaction.hide(fragment1).add(R.id.contenedorId, fragment1);
                transaction.addToBackStack(null);
            }
            break;

        }
        transaction.commit();

    }


}
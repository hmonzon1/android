package com.hmonzon.myappdiccionariosw;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class DefinicionFragment extends Fragment {

    private String nombre, definicion;

    public DefinicionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       if (getArguments() != null){
           nombre =getArguments().getString("nombre");
           definicion = getArguments().getString("definicion");

       }

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista  = inflater.inflate(R.layout.fragment_definicion, container, false);
        TextView textViewNombre, textViewDefinicion;
        textViewNombre = vista.findViewById(R.id.nombrepalabra);
        textViewDefinicion = vista.findViewById(R.id.definicionpalabra);

        textViewNombre.setText(nombre);
        textViewDefinicion.setText(definicion);

        return vista;
    }
}
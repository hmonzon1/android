package com.hmonzon.myappfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentB extends Fragment {


    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista =  inflater.inflate(R.layout.fragment_b, container, false);

         Button button;
         button = vista.findViewById(R.id.btnEnviar);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String dato;
                 dato = "Guatemala";
                 TextView textView;
                 textView = getActivity().findViewById(R.id.txtMostrar);
                 textView.setText(dato);
             }
         });



        return vista;
    }
}
package com.hmonzon.myappextrasrecyclerfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetalleFragment extends Fragment {
    //siempres tiene que ser una variable global
    private int detalleF1;




    public DetalleFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            detalleF1 = getArguments().getInt("det");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_detalle, container, false);

        TextView textView;
        textView = vista.findViewById(R.id.txtDetalle);
        textView.setText(String.valueOf(detalleF1));
        return  vista;
    }
}
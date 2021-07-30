package com.hmonzon.myappextrasrecyclerfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EspecificacionesFragment extends Fragment {

  private int especificaciones;

    public EspecificacionesFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            especificaciones = getArguments().getInt("esp");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_especificaciones, container, false);
        TextView textView;
        textView = vista.findViewById(R.id.txtEspecificaciones);
        textView.setText((especificaciones));
        return vista;
    }
}
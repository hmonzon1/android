package com.hmonzon.myappgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorGrid extends BaseAdapter {

    private Context context;
    private int listareferencia;
    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<Integer> imagenes = new ArrayList<>();

    public AdaptadorGrid(Context context, int listareferencia, ArrayList<String> nombres, ArrayList<Integer> imagenes) {
        this.context = context;
        this.listareferencia = listareferencia;
        this.nombres = nombres;
        this.imagenes = imagenes;
    }

    public AdaptadorGrid(MainActivity mainActivity, int grid_personalizado, ArrayList<String> nombre) {
    }

    @Override
    public int getCount() {
        return this.nombres.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        vista = layoutInflater.inflate(R.layout.grid_personalizado, null);

        String nombre;
        nombre = this.nombres.get(position);
        int img;
        img = this.imagenes.get(position);

        TextView campoNombre;
        ImageView CampoImagen;

        campoNombre = vista.findViewById(R.id.txtGrid);
        CampoImagen = vista.findViewById(R.id.imgGrid);

        campoNombre.setText(String.valueOf(nombre));
        CampoImagen.setImageResource(img);


        return vista;
    }
}

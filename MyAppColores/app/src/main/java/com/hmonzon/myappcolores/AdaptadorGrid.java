package com.hmonzon.myappcolores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorGrid extends BaseAdapter {

    private Context context;
    private int listareferencia;
    private ArrayList<String> nombrecolor = new ArrayList<>();
   // private ArrayList<Integer> color = new ArrayList<>();


    public AdaptadorGrid(Context context, int listareferencia, ArrayList<String> nombrecolor) {
        this.context = context;
        this.listareferencia = listareferencia;
        this.nombrecolor = nombrecolor;
        //this.color = color;
    }

    @Override
    public int getCount() {
        return this.nombrecolor.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        vista = layoutInflater.inflate(R.layout.colores_personalizados, null);

       String nColor = this.nombrecolor.get(position);
       //int llenadoC = this.color.get(position);

       TextView campoColor;
       RelativeLayout campollenado;


       campoColor = vista.findViewById(R.id.txtRecibeNColor);
       //campollenado = vista.findViewById(R.layout.activity_ma_receptor_color);

       campoColor.setText(nColor);
       //campollenado.setBackgroundColor(llenadoC);

        return vista;
    }
}

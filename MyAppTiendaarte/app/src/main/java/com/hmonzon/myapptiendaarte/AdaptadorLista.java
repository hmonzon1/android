package com.hmonzon.myapptiendaarte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {

    private Context context;
    private int listapersonalizada;
    private ArrayList<String> catpinturas = new ArrayList<>();

    public AdaptadorLista(Context context, int listapersonalizada, ArrayList<String> catpinturas) {
        this.context = context;
        this.listapersonalizada = listapersonalizada;
        this.catpinturas = catpinturas;
    }

    @Override
    public int getCount() {
        return this.catpinturas.size();
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
        vista = layoutInflater.inflate(R.layout.lista_personalizada, null);

        String catpintura;
        catpintura = this.catpinturas.get(position);

        TextView categoriaPintura;

        categoriaPintura = vista.findViewById(R.id.txtListaPersonalizada);

        categoriaPintura.setText(String.valueOf(catpintura));




        return vista;
    }
}

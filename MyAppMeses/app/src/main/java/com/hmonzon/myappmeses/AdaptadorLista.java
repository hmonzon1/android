package com.hmonzon.myappmeses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


//Extends de la clase Base para tener los metodo necesarios  y crear nuestro adaptador
public class AdaptadorLista extends BaseAdapter {

    private Context context;
    private int referenciaLista;
    private ArrayList<String> dato = new ArrayList<>();
    private ArrayList<Integer> num = new ArrayList<>();


    //creacion del constructor para las referencias del parametro
    public AdaptadorLista(Context context, int referenciaLista, ArrayList<String> dato, ArrayList<Integer> num) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.dato = dato;
        this.num = num;
    }

    @Override
    public int getCount() {
        return this.dato.size();
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

        //variable tipo vista, que sera el retorno
        View v = convertView;
        //Reconoce el contexto donde se va mostrar la lista personalizada
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        //crea la referencia para el retorno de la nueva lista personalizada
        v = layoutInflater.inflate(R.layout.lista_personalizada, null);

        //Recibir la informacion del arrayList
        String mes;
        int numM;
        mes = this.dato.get(position);
        numM = this.num.get(position);

        //Setteo de datos a los componentes
        TextView mesC;
        TextView numC;
        mesC = v.findViewById(R.id.txtMenu);
        numC = v.findViewById(R.id.txtNum);

        mesC.setText(String.valueOf(mes));
        numC.setText(String.valueOf(numM));



        return v;
    }
}

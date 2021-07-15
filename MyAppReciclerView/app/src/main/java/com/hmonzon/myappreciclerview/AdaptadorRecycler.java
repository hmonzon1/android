package com.hmonzon.myappreciclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//extendemos a RecyclerView Adapter
//implementar metodos abstractos
//crear la clase viewHolder
//extender en la clase ViewHolder,crear RecyclerView.ViewHolder
//crear el constructor de la clase
//si se muestra el Not null hay que eliminarlo
//falta capturar la estructura de Adaptador

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    //capturamos los datos

    private ArrayList<String> lista = new ArrayList<>();

    //creamos nuestro constructor de la clase y solo hay un parametro en este caso
    public AdaptadorRecycler(ArrayList<String> lista) {
        this.lista = lista;
    }




    @Override
    public AdaptadorRecycler.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        //Los inflater toman un componenete existente y crean uno personalizado

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null, false);
        ViewHolder viewHolder = new ViewHolder(vista);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycler.ViewHolder holder, int position) {
    //metodo del final
   //llamamos los valores a la vista con el holder
        holder.asignarDatos(lista.get(position));


    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //campos dinamicos

        TextView textView;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txtTexto);
        }

        public void asignarDatos(String datos){
            textView.setText(datos);


        }
    }
}

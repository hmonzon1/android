package com.hmonzon.myappejerciciorecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

        //capturamos los datos por medio del arreglo
        ArrayList <Integer> imagenes = new ArrayList<>();
        //creamos nuestro constructor
        public AdaptadorRecycler(ArrayList<Integer> imagenes) {
        this.imagenes = imagenes;
    }


    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
            //creamos nuestro inflater toma un componente existente y crea uno personalizado

            View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null,false);
            ViewHolder viewHolder = new ViewHolder(vista);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  AdaptadorRecycler.ViewHolder holder, int position) {

            //llamamos los valore a la vista con el Holder
            holder.asignarImagen(imagenes.get(position));

    }

    @Override
    public int getItemCount() {
        return this.imagenes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
          imageView = itemView.findViewById(R.id.img);
        }

        public void asignarImagen(Integer img){
           imageView.setImageResource(img);

        }
    }
}

package com.hmonzon.myapprecycler_datosvo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    private ArrayList<DatosVO> listaDatos = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<DatosVO> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,null, false);
        ViewHolder viewHolder = new ViewHolder(vista);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignarDatos(listaDatos.get(position).getNombreR(),
                listaDatos.get(position).getCalidadR(),
                listaDatos.get(position).getImagenR());


    }

    @Override
    public int getItemCount() {
        return this.listaDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewN , textViewC;
        ImageView imageViewR;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            textViewN = itemView.findViewById(R.id.txtNombreR);
            textViewC = itemView.findViewById(R.id.txtCalidadR);
            imageViewR = itemView.findViewById(R.id.imgR);


        }

        public  void asignarDatos(String nom, String calidad, int img){
            textViewN.setText(nom);
            textViewC.setText(calidad);
            imageViewR.setImageResource(img);

        }
    }
}

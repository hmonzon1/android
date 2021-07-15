package com.hmonzon.myappejerciciodatosvo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {

    private ArrayList<DatosVO> listaContactos = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<DatosVO> listaContactos) {
        this.listaContactos = listaContactos;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,null,false);
        ViewHolder viewHolder = new ViewHolder(vista);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignarDatos(listaContactos.get(position).getNombreC(),
                listaContactos.get(position).getTelefonoC(),
                listaContactos.get(position).getImagenC());

    }

    @Override
    public int getItemCount() {
        return this.listaContactos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewC, textViewT;
        ImageView imageView;


        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            textViewC = itemView.findViewById(R.id.txtNombreC);
            textViewT = itemView.findViewById(R.id.txtNumeroT);
            imageView = itemView.findViewById(R.id.imgR);

        }

        public void asignarDatos(String contacto, String telefono, int img){
            textViewC.setText(contacto);
            textViewT.setText(telefono);
            imageView.setImageResource(img);


        }
    }
}

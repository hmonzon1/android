package com.hmonzon.myappextrasrecyclerfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {
    //variable tipo click paso 1
    private static ClickListener clickListener;


    private ArrayList<DatosVO> lista = new ArrayList<>();

    public AdaptadorRecycler(ArrayList<DatosVO> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,null,false);
        ViewHolder viewHolder = new ViewHolder(vista);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  AdaptadorRecycler.ViewHolder holder, int position) {
        holder.asignardatos(lista.get(position).getImagen(),lista.get(position).getTexto());

    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }
 // implementamos oncliclistener paso 2
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;




        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
             //paso 6 definir el clic
            itemView.setOnClickListener(this);

            imageView = itemView.findViewById(R.id.imgR);
            textView = itemView.findViewById(R.id.txtTexto);

        }
        public void asignardatos(int img, String texto){
            imageView.setImageResource(img);
            textView.setText(texto);

        }

         //paso 5
        @Override
        public void onClick(View vista) {
            clickListener.OnItemClick(getAdapterPosition(),vista);

        }
    }

     //metodo para hacer clic dentro de el recycler view,
    public void setOnItemClickListener(ClickListener clickListener){
        AdaptadorRecycler.clickListener = clickListener;

    }

    public interface ClickListener{
        public void OnItemClick(int position, View vista);

    }
}

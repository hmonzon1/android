package com.hmonzon.myappejerciciorecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {

   private ArrayList<Integer> imagenes = new ArrayList<>();
   RecyclerView recyclerView;
   private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarId);

        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.RecyclerId);

        imagenes.add(R.drawable.ic_cero);
        imagenes.add(R.drawable.ic_uno);
        imagenes.add(R.drawable.ic_two);
        imagenes.add(R.drawable.ic_three);
        imagenes.add(R.drawable.ic_four);
        imagenes.add(R.drawable.ic_five);
        imagenes.add(R.drawable.ic_six);
        imagenes.add(R.drawable.is_seven);
        imagenes.add(R.drawable.ic_eigth);
        imagenes.add(R.drawable.ic_nine);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(imagenes);
        recyclerView.setAdapter(adaptadorRecycler);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemlista:
                recyclerView.setLayoutManager(new GridLayoutManager(this,2));

                break;
            case R.id.itemlista1:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}


package com.hmonzon.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hmonzon.myappbdsqlite.complementos.ConstantesSQL;

public class MainActivityConsultar extends AppCompatActivity {

    private EditText editTextId;
    private TextView textViewNombre, textViewRaza, textViewColor, textViewEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_consultar);

        editTextId = findViewById(R.id.editIdMascota);
        textViewNombre = findViewById(R.id.txtNombreC);
        textViewRaza = findViewById(R.id.txtRazaC);
        textViewColor = findViewById(R.id.txtColorC);
        textViewEdad = findViewById(R.id.txtEdadC);


    }

    public void onClick(View view) {

        this.ConsultarMascota();
    }

    private void ConsultarMascota(){
        ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS,null,ConstantesSQL.VERSION);
        SQLiteDatabase db = conectorSQLite.getReadableDatabase();
        //parametro con posicion variable
        String[] parametro = {editTextId.getText().toString()};
        if (!editTextId.getText().toString().isEmpty()){
          try {
              //Consulta por id

              String Csql;
              Csql = "SELECT " + ConstantesSQL.CAMPO_NOMBRE + "," + ConstantesSQL.CAMPO_RAZA + "," +
                      ConstantesSQL.CAMPO_COLOR + "," + ConstantesSQL.CAMPO_EDAD + " FROM " +
                      ConstantesSQL.TABLA_MASCOTAS + " WHERE " + ConstantesSQL.CAMPO_ID + " = ?;";

              //cursor.
              //objeto que permite obtener datos de una consulta de datos
              Cursor cursor = db.rawQuery(Csql, parametro);
              cursor.moveToFirst();
              textViewNombre.setText(cursor.getString(0));
              textViewRaza.setText(cursor.getString(1));
              textViewColor.setText(cursor.getString(2));
              textViewEdad.setText(cursor.getString(3));


              cursor.close();
          }
          catch (Exception e){
              e.getMessage();

          }

        }else{
            Toast.makeText(this, "Debe llenar el campo", Toast.LENGTH_SHORT).show();

            textViewNombre.setText("");
            textViewRaza.setText("");
            textViewColor.setText("");
            textViewEdad.setText("");
        }





    }
}
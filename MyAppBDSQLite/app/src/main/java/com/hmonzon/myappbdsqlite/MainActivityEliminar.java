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

public class MainActivityEliminar extends AppCompatActivity {

    private TextView textViewN, textViewR, textViewC, textViewE;
    private EditText editTextidE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eliminar);

        editTextidE = findViewById(R.id.eliminarIdMascota);
        textViewN = findViewById(R.id.txtNombreE);
        textViewR = findViewById(R.id.txtRazaE);
        textViewC = findViewById(R.id.txtColorE);
        textViewE = findViewById(R.id.txtEdadE);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEliminarMascota:
                this.ConsultarID();


                break;

            case R.id.btnEliminar:
                this.Eliminar();


                break;
        }

    }

    private void ConsultarID(){
        if (!editTextidE.getText().toString().isEmpty()){

            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS, null, ConstantesSQL.VERSION);
            SQLiteDatabase db = conectorSQLite.getReadableDatabase();

            String [] Vbuscado = {editTextidE.getText().toString()};

            try {

                String Csql;
                        Csql = "SELECT "+ConstantesSQL.CAMPO_NOMBRE+", "
                        +ConstantesSQL.CAMPO_RAZA+", "
                        +ConstantesSQL.CAMPO_COLOR+", "
                        +ConstantesSQL.CAMPO_EDAD+" FROM "
                        +ConstantesSQL.TABLA_MASCOTAS+" WHERE "+ConstantesSQL.CAMPO_ID+" = ?;";

                Cursor cursor = db.rawQuery(Csql, Vbuscado);
                cursor.moveToFirst();

                textViewN.setText(cursor.getString(0));
                textViewR.setText(cursor.getString(1));
                textViewC.setText(cursor.getString(2));
                textViewE.setText(cursor.getString(3));

                cursor.close();



            }catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Debe ingresar un ID", Toast.LENGTH_SHORT).show();
            textViewN.setText("");
            textViewR.setText("");
            textViewC.setText("");
            textViewE.setText("");

        }

    }

    private void Eliminar(){
        if (!editTextidE.getText().toString().isEmpty()){

            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS,null,ConstantesSQL.VERSION);
            SQLiteDatabase db = conectorSQLite.getWritableDatabase();

            try {

                String Csql;
                Csql = "DELETE FROM "+ConstantesSQL.TABLA_MASCOTAS+
                       " WHERE "+ConstantesSQL.CAMPO_ID+" ="+editTextidE.getText().toString()+";";

                db.execSQL(Csql);
                db.close();



                editTextidE.setText("");
                textViewN.setText("");
                textViewR.setText("");
                textViewC.setText("");
                textViewE.setText("");

                Toast.makeText(this, "Dato Eliminado", Toast.LENGTH_SHORT).show();

            }catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "No se ha podido eliminar", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "NO se encontro dato a eliminar", Toast.LENGTH_SHORT).show();
        }

    }
}
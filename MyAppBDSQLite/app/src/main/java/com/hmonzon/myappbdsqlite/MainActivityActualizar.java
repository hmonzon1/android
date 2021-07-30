package com.hmonzon.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hmonzon.myappbdsqlite.complementos.ConstantesSQL;

import java.lang.reflect.Array;

public class MainActivityActualizar extends AppCompatActivity {

    private EditText editTextB, editTextN, editTextR, editTextC, editTextE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actualizar);

        editTextB = findViewById(R.id.editMascotaB);
        editTextN =  findViewById(R.id.editNombre);
        editTextR = findViewById(R.id.editRaza);
        editTextC = findViewById(R.id.editColor);
        editTextE = findViewById(R.id.editEdad);
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnBuscarA:
                this.ConsultarID();
                break;

            case R.id.btnActualizar:
                this.Actualizar();

                break;
        }
    }

    private void ConsultarID(){
        if (!editTextB.getText().toString().isEmpty()){

            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS, null,ConstantesSQL.VERSION);
            SQLiteDatabase db = conectorSQLite.getReadableDatabase();

            String[] parametro ={editTextB.getText().toString()};
            try{
                String  Csql;
                        Csql = "SELECT "+ConstantesSQL.CAMPO_NOMBRE+","
                                +ConstantesSQL.CAMPO_RAZA+", "
                                +ConstantesSQL.CAMPO_COLOR+", "
                                +ConstantesSQL.CAMPO_EDAD+" FROM "+ConstantesSQL.TABLA_MASCOTAS+
                                " WHERE "+ConstantesSQL.CAMPO_ID+"= ?;";

                Cursor cursor = db.rawQuery(Csql, parametro);
                cursor.moveToFirst();

                editTextN.setText(cursor.getString(0));
                editTextR.setText(cursor.getString(1));
                editTextC.setText(cursor.getString(2));
                editTextE.setText(cursor.getString(3));

                cursor.close();



            }catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no encontrados", Toast.LENGTH_SHORT).show();
            }
            
        }else{
            Toast.makeText(this, "Debe Ingresar Un ID", Toast.LENGTH_SHORT).show();
           ;
        }

    }

    private void Actualizar(){
        if(!editTextB.getText().toString().isEmpty()&&
        !editTextN.getText().toString().isEmpty()&&
        !editTextR.getText().toString().isEmpty()&&
        !editTextC.getText().toString().isEmpty()&&
        !editTextE.getText().toString().isEmpty()){

            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS, null, ConstantesSQL.VERSION);
            SQLiteDatabase db = conectorSQLite.getWritableDatabase();

            try {
                String Csql;
                Csql = "UPDATE "+ConstantesSQL.TABLA_MASCOTAS+" SET "+
                        ConstantesSQL.CAMPO_NOMBRE+"= '"+editTextN.getText().toString()+
                        "',"+ConstantesSQL.CAMPO_RAZA+" = '"+editTextR.getText().toString()+
                        "',"+ConstantesSQL.CAMPO_COLOR+"= '"+editTextC.getText().toString()+
                        "', "+ConstantesSQL.CAMPO_EDAD+" ="+editTextE.getText().toString()+" WHERE "
                        +ConstantesSQL.CAMPO_ID+"= "+editTextB.getText().toString()+";";
                //metodo cuando inserto execSQL metodo cuando consulto rawQuery
                db.execSQL(Csql);
                db.close();

                editTextB.setText("");
                editTextN.setText("");
                editTextR.setText("");
                editTextC.setText("");
                editTextE.setText("");

                Toast.makeText(this, "Datos Actualizados Correctamente", Toast.LENGTH_SHORT).show();



            }catch (Exception e){
                e.getMessage();
                Toast.makeText(this, "Datos no Modificados", Toast.LENGTH_SHORT).show();

            }

        }else{
            Toast.makeText(this, "Debe llenar todos los datos", Toast.LENGTH_SHORT).show();
        }


    }

}

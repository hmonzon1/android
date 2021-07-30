package com.hmonzon.myappbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hmonzon.myappbdsqlite.complementos.ConstantesSQL;

public class MainActivityInsertar extends AppCompatActivity {

    private EditText editTextNombre, editTextRaza, editTextColor, editTextEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insertar);

        editTextNombre = findViewById(R.id.editNombreMascota);
        editTextRaza = findViewById(R.id.editRaza);
        editTextColor = findViewById(R.id.editColor);
        editTextEdad = findViewById(R.id.editEdad);
    }

    public void onClick(View view) {
        this.InsertarMascota();
    }

    private void InsertarMascota(){
        if (!editTextNombre.getText().toString().isEmpty()&&
            !editTextRaza.getText().toString().isEmpty()&&
            !editTextColor.getText().toString().isEmpty()&&
            !editTextEdad.getText().toString().isEmpty()){

           //Realizar la conexion por medio del objeto conector
            ConectorSQLite conectorSQLite = new ConectorSQLite(this, ConstantesSQL.BD_MASCOTAS,null,ConstantesSQL.VERSION);

           //Instanciamos el objeto de base de datos para establecer lo que se va a realizar
            // a continuacion en la base de datos

            SQLiteDatabase db = conectorSQLite.getWritableDatabase();


            //creacion del query para la insercion de los datos
            try {
                String Csql;
                Csql = "INSERT INTO "+ConstantesSQL.TABLA_MASCOTAS+"("+ConstantesSQL.CAMPO_NOMBRE+","+
                        ConstantesSQL.CAMPO_RAZA+","+ConstantesSQL.CAMPO_COLOR+","+ConstantesSQL.CAMPO_EDAD+
                        ") VALUES ('"+editTextNombre.getText().toString()+"','"+editTextRaza.getText().toString()+
                        "','"+editTextColor.getText().toString()+"',"+editTextEdad.getText().toString()+");";

                //acccion de la consulta
                db.execSQL(Csql);

                editTextNombre.setText("");
                editTextRaza.setText("");
                editTextColor.setText("");
                editTextEdad.setText("");
                db.close();

                Toast.makeText(this, "Datos Ingresados Correctamente", Toast.LENGTH_SHORT).show();


            }
            catch (Exception e){
                e.getMessage();
            }


        }else{

            Toast.makeText(this, "Debe Ingresar valores en los campos", Toast.LENGTH_SHORT).show();

        }

    }
}
package com.hmonzon.myappcrudswproductos.complementos;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MetodosSW {

    //declarar una constante de la  ip del servidor local.

    public static final String IP_SERVER = "http://192.168.0.17/";


    //implementar variables para la conexion y obtencion de informacion

    Context context;

    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;





    public MetodosSW() {



    }


    //metodo insertar
    public void insertarSW(Context context, String nombre, String marca,
                           int costo, int precio,
                           Response.Listener listener, Response.ErrorListener errorListener){

        this.context = context;
        try{

            String url;
            url = IP_SERVER+"tienda_sw/insertar_sw.php?nombre_producto="+nombre+"&marca_producto="+marca+
                    "&costo_producto="+costo+"&precio_producto="+precio;

            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);



        }catch (Exception e){
            Toast.makeText(context, "ConflictoI"+e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println("I-----"+e.getCause()+"-----"+e.getMessage());

        }



    }

    public void BuscarID(Context context,int codigo, Response.Listener listener, Response.ErrorListener errorListener){
        this.context = context;

        try{
            String url;
            url = IP_SERVER+"tienda_sw/buscar_id.php?id_producto="+codigo;
            requestQueue =  Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, listener,errorListener);
            requestQueue.add(jsonObjectRequest);


        }catch(Exception e){
            Toast.makeText(context, "ConflictoI"+e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println("I-----"+e.getCause()+"-----"+e.getMessage());

        }



    }

    public void ConsultarSW(Context context, Response.Listener listener,
                            Response.ErrorListener errorListener){

        this.context = context;

        try{

            String url;
            url = IP_SERVER+"tienda_sw/mostrar_sw.php";
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);


        }catch (Exception e){

            Toast.makeText(context, "ConflictoC"+e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println("C-----"+e.getCause()+"C-----"+e.getMessage());

        }

    }


    public void eliminarSW(Context context, int codigo, Response.Listener listener, Response.ErrorListener errorListener){
        this.context = context;
        try {

            String url;
            url = IP_SERVER+"tienda_sw/eliminar_sw.php?id_producto="+codigo;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);


        }catch (Exception e){
            Toast.makeText(context, "Conflicto_BD_E"+e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println("E-----"+e.getCause()+"E-----"+e.getMessage());

        }

    }

    public void Actualizar(Context context, int codigo, String nombre, String marca, int costo,
                           int precio, Response.Listener listener, Response.ErrorListener errorListener){
        this.context = context;
        try{

            String url;
            url = IP_SERVER+"tienda_sw/actualizar_sw.php?id_producto="+codigo+"&nombre_producto="+nombre+
                    "&marca_producto="+marca+"&costo_producto="+costo+"&precio_producto="+precio;
            requestQueue = Volley.newRequestQueue(context);
            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListener);
            requestQueue.add(jsonObjectRequest);

        }catch (Exception e){
            Toast.makeText(context, "Conflicto A"+e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println("A-----"+e.getCause()+"A-----"+e.getMessage());

        }
    }
}

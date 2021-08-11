package com.hmonzon.myappdiccionariosw.complementos;


import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MetodosSW {

         public static final  String IP_SERVER = "http://192.168.0.17/";
         Context context;
         RequestQueue requestQueue;
         JsonObjectRequest jsonObjectRequest;

    public MetodosSW() {
    }

    public void ConsultarSW(Context context, Response.Listener listener,
                            Response.ErrorListener errorListenerlistener){
        this.context = context;
        try{
        String url;
        url = IP_SERVER+"biblioteca_sw/consulta_sw.php";
        requestQueue = Volley.newRequestQueue(context);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,listener,errorListenerlistener);
        requestQueue.add(jsonObjectRequest);
        }catch (Exception e){
            Toast.makeText(context, "ConflictoC"+e.getMessage(), Toast.LENGTH_SHORT).show();
            System.err.println("C-----"+e.getCause()+"C-----"+e.getMessage());

        }

    }


}

package com.example.primerparciallaboratoriov;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HiloConexion extends Thread {

    public static final int TEXTO=2;

    Handler handler;

    public HiloConexion(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        ConexionHTTP conexionHTTP = new ConexionHTTP();

        byte[] productosJson = conexionHTTP.obtenerRespuesta("http://10.0.2.2:3000/productos");

        String s = new String(productosJson);

        Log.d("", s);

        Message msg = new Message();
        msg.arg1=TEXTO;
        msg.obj = this.parserJson(s);
        handler.sendMessage(msg);
    }

    public List<Producto> parserJson(String s) {

        List<Producto> productos = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(s);

            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Producto pdt = new Producto(Integer.parseInt(jsonObject.getString("id")), jsonObject.getString("nombre"), Integer.parseInt(jsonObject.getString("cantidad")), Float.parseFloat(jsonObject.getString("precio")));
                productos.add(pdt);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return productos;

    }

}

package com.example.primerparciallaboratoriov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnItemClick, Handler.Callback {

    List<Producto> productoList = new ArrayList<>();
    Integer posicionActual = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Primer Parcial");

        Handler handler = new Handler(this);
        HiloConexion hiloProductos = new HiloConexion(handler);
        hiloProductos.start();

        this.crearRecyclerView();

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, EditarActivity.class);

        intent.putExtra("producto", productoList.get(position));

        this.posicionActual = position;

        //startActivity(intent);
        startActivityForResult(intent,999);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 999 && resultCode == RESULT_OK) {
            Log.d("", "Entre en onActivityResult");
            Bundle extras = data.getExtras();
            Serializable producto = extras.getSerializable("productoEditado");
            Log.d("", ((Producto) producto).getNombre());

            this.actualizarProducto((Producto) producto);
        }

    }

    @Override
    public boolean handleMessage(@NonNull Message message) {

        if(message.arg1==HiloConexion.TEXTO) {

            List<Producto> productos = (List<Producto>) message.obj;
            Log.d("", productos.get(0).toString());

            for(Producto producto : productos)
            {
                productoList.add(producto);
            }

        }

        return false;
    }

    private void actualizarProducto(Producto producto) {

        this.productoList.set(this.posicionActual, producto);

        this.crearRecyclerView();

    }

    private void crearRecyclerView() {
        ProductoAdapter adapter = new ProductoAdapter(productoList, this);
        RecyclerView rv = super.findViewById(R.id.rvProductos);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
    }
}
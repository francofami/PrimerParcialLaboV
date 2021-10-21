package com.example.primerparciallaboratoriov;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditarView implements View.OnClickListener{

    private Activity activity;
    private Producto producto;

    TextView tvEditarNombre;
    TextView tvEditarCantidad;
    TextView tvEditarPrecio;


    private IOnEditClick listener;


    public EditarView(Activity activity, Producto producto, EditarController editarController, IOnEditClick listener) {
        this.activity = activity;
        this.producto = producto;

        this.tvEditarNombre = this.activity.findViewById(R.id.editarNombre);
        this.tvEditarCantidad = this.activity.findViewById(R.id.editarCantidad);
        this.tvEditarPrecio = this.activity.findViewById(R.id.editarPrecio);

        Button botonEditar = this.activity.findViewById(R.id.botonEditar);
        botonEditar.setOnClickListener(this);

        this.listener = listener;
    }

    public void guardarProducto() {
        Log.d("","Entre a guardarProducto");

        this.tvEditarNombre = this.activity.findViewById(R.id.editarNombre);
        this.tvEditarCantidad = this.activity.findViewById(R.id.editarCantidad);
        this.tvEditarPrecio = this.activity.findViewById(R.id.editarPrecio);

        this.producto.setNombre(this.tvEditarNombre.getText().toString());
        this.producto.setCantidad(Integer.parseInt(this.tvEditarCantidad.getText().toString()));
        this.producto.setPrecio(Float.parseFloat(this.tvEditarPrecio.getText().toString()));
    }

    public void mostrarProducto() {
        this.tvEditarNombre.setText(this.producto.getNombre());
        this.tvEditarCantidad.setText(this.producto.getCantidad().toString());
        this.tvEditarPrecio.setText(this.producto.getPrecio().toString());
    }

    @Override
    public void onClick(View view) {
        this.guardarProducto();
        listener.onEditClick(this.producto);
    }

}

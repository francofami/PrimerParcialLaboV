package com.example.primerparciallaboratoriov;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvNombre;
    TextView tvCantidad;
    TextView tvPrecio;
    private IOnItemClick listener;
    private int position;

    public ProductoViewHolder(View view, IOnItemClick listener) {
        super(view);
        this.tvNombre = view.findViewById(R.id.nombre);
        this.tvCantidad = view.findViewById(R.id.cantidad);
        this.tvPrecio = view.findViewById(R.id.precio);

        view.setOnClickListener(this);
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(position);
    }

    public void setPosition(int position) {
        this.position = position;
    }

}

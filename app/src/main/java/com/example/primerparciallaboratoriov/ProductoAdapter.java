package com.example.primerparciallaboratoriov;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoViewHolder> {

    private List<Producto> lista;
    private IOnItemClick listener;

    public ProductoAdapter(List<Producto> lista, IOnItemClick listener) {
        this.lista = lista;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ProductoViewHolder productoViewHolder = new ProductoViewHolder(view, listener);

        return productoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Producto producto = this.lista.get(position);

        holder.tvNombre.setText(producto.getNombre());
        holder.tvCantidad.setText(Integer.toString(producto.getCantidad()));
        holder.tvPrecio.setText(Float.toString(producto.getPrecio()));
        holder.setPosition(position);
    }
}

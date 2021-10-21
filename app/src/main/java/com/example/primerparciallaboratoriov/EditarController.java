package com.example.primerparciallaboratoriov;

public class EditarController {

    EditarView editarView;
    Producto producto;

    public EditarController(Producto producto) {
        this.producto = producto;
        recuperarProducto();
    }

    private void recuperarProducto() {
        this.producto.setNombre(this.producto.getNombre());
        this.producto.setCantidad(this.producto.getCantidad());
        this.producto.setPrecio(this.producto.getPrecio());
    }

    public void setEditarView(EditarView editarView) {
        this.editarView = editarView;
        this.editarView.mostrarProducto();
    }
}

package com.example.primerparciallaboratoriov;

import java.io.Serializable;

public class Producto implements Serializable {

    private Integer id;
    private String nombre;
    private Integer cantidad;
    private Float precio;

    public Producto(Integer id, String nombre, Integer cantidad, Float precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre='" + nombre + '\'' +
                ", Cantidad='" + cantidad.toString() + '\'' +
                ", Precio='" + precio.toString() + '\'' +
                '}';
    }
}

package com.example.demo.modelo;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CarritoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private Integer cantidad;

    // Constructor vacío
    public CarritoProducto() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    // Método para calcular el precio total de este producto (precio unitario * cantidad)
    public BigDecimal getPrecioTotal() {
        if (producto != null && cantidad != null) {
            return producto.getPrecio().multiply(new BigDecimal(cantidad)); // Convierte la cantidad (de tipo Integer) a BigDecimal para hacer la multiplicación de forma precisa.
        }
        return BigDecimal.ZERO;
    }
}

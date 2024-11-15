package com.example.demo.modelo;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    //BigDecimal me permite hacer calculos con mas precisión
    private BigDecimal precio;
    private String talle;
    private String imagenUrl;
    private String categorias; 

    public Producto() {}

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public BigDecimal getPrecio() {
        return precio;
    }

    public String getTalle() {
        return talle;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }
    public String getCategorias(){
        return categorias;
    }

    // Setters
    public void setId(Long id){
        this.id=id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
    public void setCategorias(String categorias){
        this.categorias=categorias;
    }
}

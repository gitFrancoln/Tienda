package com.example.demo.modelo;


import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
    private String imagenUrl;
    private String categorias; 
    private int stock;

    @ElementCollection
    @CollectionTable(name = "producto_talles", joinColumns = @JoinColumn(name = "producto_id"))
    private List<Talle> talles;
    

    

    @OneToOne
    @JoinColumn(name = "envio_id") // Nombre de la columna en la base de datos
    private Envio envio; // Propiedad añadida para establecer la relación bidireccional

  

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
    
    public List<Talle> getTalles() {
        return talles;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }
    public String getCategorias(){
        return categorias;
    }
    public Envio getEnvio(){
        return envio;
    }
   
    public int getStock(){
        return stock;
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

    public void setTalles(List<Talle> talles) {
        this.talles = talles;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
    public void setCategorias(String categorias){
        this.categorias=categorias;
    }
    public void setEnvio(Envio envio){
        this.envio=envio;
    }
 
    public void setStock(int stock){
        this.stock=stock;
    }
}

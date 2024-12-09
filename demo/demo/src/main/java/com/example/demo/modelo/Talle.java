package com.example.demo.modelo;

import jakarta.persistence.Embeddable;


@Embeddable
public class Talle {
  
    private String nombre;
    private int stock;

    // Getters and Setters

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock=stock;
    }

}

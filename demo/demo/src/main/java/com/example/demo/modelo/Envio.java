package com.example.demo.modelo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Envio {
    //atributos
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;
    @Email
    @NotNull
    private String mail;

    private String nombre;
    private String apellido;
    private String numero;
    private String piso;
    private String departamento;

    private String dni;

    private String telefono;

    private String direccion;

    private String provincia;

    @OneToOne(mappedBy = "envio")
    private Producto producto;
    
  public Envio(){}

    //getters
    public long getId(){
        return id;
    }
    public String getMail(){
        return mail;
    }
    public String getDni(){
        return dni;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getDireccion(){

        return direccion;
    }
    public String getProvincia(){
        return provincia;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getNumero(){
        return numero;
    }
    public String getPiso(){
        return piso;
    }
    public String getDepartamento(){
        return departamento;
    }

    //setters
    public void setId(long id){
        this.id=id;
    }
    public void setMail(String mail){
        this.mail=mail;
    }
    public void setDni(String dni){
        this.dni=dni;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public void setProvincia(String provincia){
        this.provincia=provincia;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public void setNumero(String numero){
        this.numero=numero;
    }
    public void setPiso(String piso){
        this.piso=piso;
    }
    public void setDepartamento(String departamento){
        this.departamento=departamento;
    }
}

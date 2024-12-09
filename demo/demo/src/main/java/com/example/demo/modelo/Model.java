package com.example.demo.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)//unique para q el user sea unico Y NULLABLE PARA QUE NO PUEDA ESTAR VACIO
    private String user; //instancia 
    @Column(nullable = false)  
    private String password;

    private String role;

    public Model(){}
    public Model(String user, String password, String role){
       this.user=user;
       this.password=password;
       this.role=role;
    }
    //setters y getters
    public Long getId(){
        return id;
    }
    public String getUser(){
        return user;
    }
public String getPassword(){
    return password;
}
public String getRole(){
    return role;
}

public void setId(Long id){
    this.id=id;
}
public void setUser(String user){
    this.user=user;
}
public void setPassword(String password){
    this.password=password;
}
public void setRole(String role){
    this.role=role;
 
}
@Override
public String toString() {
    return "Model{" +
            "id=" + id +
            ", user='" + user + '\'' +
            ", password='" + password + '\'' +
            '}';
}
}


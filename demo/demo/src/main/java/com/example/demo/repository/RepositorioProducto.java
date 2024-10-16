package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.modelo.Producto;

public interface RepositorioProducto extends JpaRepository<Producto, Long> {
    Producto findByNombre(String nombre); //busco por nombre 
}

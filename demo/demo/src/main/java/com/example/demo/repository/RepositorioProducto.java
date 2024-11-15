package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;
@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
    Producto findByNombre(String nombre); //busco por nombre

    List<Producto> findByNombreContaining(String nombre);
    List<Producto> findByCategorias(String categorias);
}

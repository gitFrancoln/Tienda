package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Carrito;

@Repository
public interface CarritoRepositorio extends JpaRepository<Carrito, Long >{
    Optional<Carrito> findTopByOrderByIdDesc();
}

package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CarritoProducto;

@Repository
public interface CarritoPrRepositorio extends JpaRepository<CarritoProducto, Long>{
    
}

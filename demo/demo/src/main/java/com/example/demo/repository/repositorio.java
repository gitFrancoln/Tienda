package com.example.demo.repository;
import com.example.demo.modelo.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositorio extends JpaRepository<Model, Long> {
    // Método personalizado para buscar por el campo 'user'
    Model findByUser(String user);
}

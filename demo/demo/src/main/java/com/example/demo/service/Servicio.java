package com.example.demo.service;
import com.example.demo.modelo.Model;
import com.example.demo.repository.repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Servicio {

    @Autowired
    private repositorio userRepository;

    public Model registerUser(Model user) {
        if (userRepository.findByUser(user.getUser()) != null) {
            throw new IllegalArgumentException("El nombre de usuario ya está registrado");
        }
        return userRepository.save(user);
    }

    public Model loginUser(String user, String password) {
        Model foundUser = userRepository.findByUser(user);
        if (foundUser != null && foundUser.getPassword().equals(password)) {
            return foundUser; // Retorna el usuario si las credenciales son válidas
        }
        return null;
}}

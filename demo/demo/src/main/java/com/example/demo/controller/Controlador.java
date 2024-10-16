package com.example.demo.controller;

import com.example.demo.modelo.Model;
import com.example.demo.service.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/users")
public class Controlador {
    @Autowired
    private Servicio userService;

    // Método para mostrar el formulario de registro
    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup"; // Retorna el nombre del archivo HTML sin extensión
    }

    // Método para manejar el registro
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@ModelAttribute Model user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Método para mostrar el formulario de inicio de sesión
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Retorna el nombre del archivo HTML sin extensión
    }

    // Método para manejar el inicio de sesión
    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String user, @RequestParam String password) {
        Model loggedInUser = userService.loginUser(user, password);
        ModelAndView modelAndView = new ModelAndView();

        if (loggedInUser != null) {
            modelAndView.setViewName("/crear-producto"); // Redirigir a la página de inicio
            modelAndView.addObject("message", "Inicio de sesión exitoso");
        } else {
            modelAndView.setViewName("login"); // Regresar al formulario de inicio de sesión
            modelAndView.addObject("error", "Usuario o contraseña incorrectos");
        }

        return modelAndView;
    }
}

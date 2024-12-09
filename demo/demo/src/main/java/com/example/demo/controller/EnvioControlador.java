package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.example.demo.modelo.Envio;

import com.example.demo.service.SEnvio;

    
@Controller
@RequestMapping("/envio")
public class EnvioControlador {
    
@Autowired
private SEnvio sEnvio;


@GetMapping("/formulario")
public String mostrarFormulario(Model model) {
    model.addAttribute("envio", new Envio());
    
    return "form-envio";  
}

@PostMapping("/guardar")
public String guardarEnvio(@ModelAttribute com.example.demo.modelo.Envio envio, Model model) {
    try {
        // Guardamos el envío en la base de datos
        sEnvio.guardarEnvio(envio);
        return "index";
    } catch (IllegalStateException e) {
        model.addAttribute("error", e.getMessage());
        return "error";
    }
}
}
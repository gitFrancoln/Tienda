package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    /*Pagina principal (localhost8080 redirije a el return ) */
    @RequestMapping("/")
    public String inicio() {
        return "redirect:/pr/productos";
    }
}

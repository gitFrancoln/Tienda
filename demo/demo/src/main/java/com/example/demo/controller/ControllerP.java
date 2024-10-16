package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.example.demo.service.ServicioProducto;
import com.example.demo.modelo.Producto;

@Controller
@RequestMapping("/pr") // Base path for all routes in this controller
public class ControllerP {

    @Autowired
    private ServicioProducto servicioProducto;

    @GetMapping("/productos")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "crear-producto"; // Asegúrate de tener una vista correspondiente para esto
    }

    @PostMapping("/productos") // Este es el método que maneja el envío del formulario
    public String crearProducto(Producto producto) {
        servicioProducto.guardarProducto(producto);
        return "redirect:/pr/listar-productos"; // Redirige después de guardar
    }

    @GetMapping("/listar-productos") // Ruta para listar productos
    public String listarProductos(Model model) {
        model.addAttribute("productos", servicioProducto.listarProductos());
        return "listar-productos"; // Vista para listar productos
    }
}



package com.example.demo.controller;

import com.example.demo.service.ServicioProducto;
import com.example.demo.modelo.Producto;
import com.example.demo.service.ServicioCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pr") 
public class ControllerP {

    @Autowired
    private ServicioProducto servicioProducto;

    @Autowired
    private ServicioCarrito servicioCarrito;

    @GetMapping("/productos") //formulario para agregar productos
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Producto());
        return "crear-producto"; 
    }

    @PostMapping("/productos") // maneja el envío del formulario
    public String crearProducto(Producto producto) {
        servicioProducto.guardarProducto(producto);
        return "redirect:/pr/listar-productos"; 
    }

    @GetMapping("/listar-productos") // listar productos
    public String listarProductos(Model model) {
        Long carritoId = servicioCarrito.obtenerOCrearCarritoId(); // Obtener o crear el carrito
        model.addAttribute("carritoId", carritoId); // Agregar el ID del carrito al modelo
        model.addAttribute("productos", servicioProducto.listarProductos()); // Listar todos los productos
        return "listar-productos"; 
    }

    @GetMapping("/buscar") //buscador
    public String buscar(@RequestParam("query") String query, Model model) {
        Long carritoId = servicioCarrito.obtenerOCrearCarritoId(); // Obtener o crear el carrito
        model.addAttribute("carritoId", carritoId); // Agregar el ID del carrito al modelo
        List<Producto> resultados = servicioProducto.buscarProductos(query);
        model.addAttribute("productos", resultados);
        return "listar-productos";
    }

    @GetMapping("/categorias/{nombre}") // buscar por categorias
    public String filtrarPorCategoria(@PathVariable("nombre") String nombre, Model model) {
        Long carritoId = servicioCarrito.obtenerOCrearCarritoId(); // Obtener o crear el carrito
        List<Producto> productosPorCategoria = servicioProducto.buscarPorCategoria(nombre);
        
        model.addAttribute("carritoId", carritoId); // Agregar el ID del carrito al modelo
        model.addAttribute("productos", productosPorCategoria);
        model.addAttribute("categoria", nombre); 

        return "listar-productos"; 
    }

    @GetMapping("/producto/{id}")
    public String verProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = servicioProducto.obtenerProductoPorId(id);
        model.addAttribute("producto", producto);
        return "detalle-producto"; // Nombre de la vista del producto individual
    }
}

package com.example.demo.controller;
import com.example.demo.service.ServicioCarrito;
import com.example.demo.modelo.Carrito;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/carrito")

public class CCarrito {

     @Autowired
   private ServicioCarrito servicioCarrito;

   @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody Carrito carrito) {
        // Llama al servicio para procesar el carrito
        servicioCarrito.procesarCarrito(carrito);

        return ResponseEntity.ok("Compra realizada con éxito");
    }


    //eliminar
    @PostMapping("/eliminar")
public String eliminarProducto(@RequestParam Long carritoId, @RequestParam Long productoId) {
    Carrito carrito = servicioCarrito.obtenerCarritoId(carritoId)
                      .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));
    
    servicioCarrito.removerProducto(carrito, productoId);
    return "redirect:/carrito/ver/" + carrito.getId(); // Redirige a la vista del carrito
}

//total
@GetMapping("/total")
public String verTotalCarrito(@RequestParam Long carritoId, Model model) {
    Carrito carrito = servicioCarrito.obtenerCarritoId(carritoId)
                      .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));
    
    BigDecimal total = servicioCarrito.obtenerTotalCarrito(carrito);
    // Comprobar si el total es null y asignar un valor por defecto
    if (total == null || total.compareTo(BigDecimal.ZERO) <= 0) {
        model.addAttribute("total", ""); 
    } else {
    model.addAttribute("total", total.toString());
    }
    return "ver-total"; // Nombre de la vista donde se muestra el total
}

//ver
@GetMapping("/ver/{carritoId}") // Método para ver el carrito
public String verCarrito(@PathVariable Long carritoId, Model model) {  // Usa @PathVariable en lugar de @RequestParam
    Carrito carrito = servicioCarrito.obtenerCarritoId(carritoId)
            .orElseThrow(() -> new IllegalArgumentException("Carrito no encontrado"));

    model.addAttribute("carrito", carrito);
    return "ver-carrito"; // Nombre de la vista para mostrar el contenido del carrito
}

  // Método para cargar la página principal y obtener o crear un carrito
  @GetMapping("/listar-productos")
  public String cargarPaginaPrincipal(Model model) {
      Long carritoId = servicioCarrito.obtenerOCrearCarritoId();
      model.addAttribute("carritoId", carritoId);
      return "listar-productos"; // Nombre de la vista principal
}
}
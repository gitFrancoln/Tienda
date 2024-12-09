package com.example.demo.service;
import com.example.demo.repository.CarritoPrRepositorio;
import com.example.demo.repository.CarritoRepositorio;
import com.example.demo.modelo.Carrito;
import com.example.demo.modelo.CarritoProducto;


import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCarrito {
    
    @Autowired
    CarritoRepositorio carritoRS;
    @Autowired
    CarritoPrRepositorio carritoPrRS;

    // Implementación de métodos para agregar
    public void procesarCarrito(Carrito carrito) {
        // Itera sobre los productos en el carrito recibido y los guarda en la base de datos
        for (CarritoProducto carritoProducto : carrito.getProductos()) {
            carritoProducto.setCarrito(carrito);  // Asocia cada producto al carrito
            carritoPrRS.save(carritoProducto);     // Guarda el producto en el carrito
        }
        carritoRS.save(carrito); // Guarda el carrito completo con todos los productos
    }

    public void removerProducto(Carrito carrito, Long productoId){
        carrito.getProductos().removeIf(cp -> cp.getProducto().getId().equals(productoId));//remuevo
        carritoRS.save(carrito); //guardo el carrito actualizado
    }
    //obtener precio total del carrito
    public BigDecimal obtenerTotalCarrito(Carrito carrito){
        return carrito.getTotal(); //llamo a Total de carrito
    }
    //obtener carrito por id del cliente
    public Optional<Carrito> obtenerCarritoId(Long id){
        return carritoRS.findById(id);
    }
    public Long obtenerOCrearCarritoId() {
        // ajusta el criterio de obtención del carrito
        Optional<Carrito> carritoExistente = carritoRS.findTopByOrderByIdDesc();
        
        // Si hay un carrito existente, devolver su ID
        if (carritoExistente.isPresent()) {
            return carritoExistente.get().getId();
        } 
        
        // Si no hay carrito, crea uno nuevo
        Carrito nuevoCarrito = new Carrito();
        carritoRS.save(nuevoCarrito);
        return nuevoCarrito.getId();
    }
    
}

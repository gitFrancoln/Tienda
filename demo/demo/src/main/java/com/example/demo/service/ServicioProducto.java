package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.RepositorioProducto;

@Service
public class ServicioProducto {
    
    @Autowired
    private RepositorioProducto repositorioProducto;

    public void guardarProducto (Producto producto){
        repositorioProducto.save(producto);
    }
    public List<Producto> listarProductos() {
        return repositorioProducto.findAll();
    }
        public List<Producto> buscarProductos(String query) {
            return repositorioProducto.findByNombreContaining(query);
}
public List<Producto> buscarPorCategoria(String categorias){
    return repositorioProducto.findByCategorias(categorias); 
}
public Producto obtenerProductoPorId(Long id) {
    return repositorioProducto.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
}

}
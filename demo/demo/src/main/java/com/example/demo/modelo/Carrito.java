package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//lista productos
    @OneToMany(mappedBy ="carrito", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CarritoProducto> Lproductos= new ArrayList<>();

    private BigDecimal total=BigDecimal.ZERO;

    public Carrito(){}

    //getters and setters
    public Long getId(){
        return id;
    }    
    public List<CarritoProducto> getProductos(){
        return Lproductos;
    }
        public BigDecimal getTotal(){
            return total;
        }
        
        public void setId(Long id){
            this.id=id;
        }
//métodos
        public void agregarProductos(CarritoProducto producto){
         // se almacena producto en la lista productos 
            this.Lproductos.add(producto);
            //asocio carritoProducto con el carrito actual 
            producto.setCarrito(this);
            recalcularTotal(); 
        }
        public void removerProducto(CarritoProducto producto){
            this.Lproductos.remove(producto);
            producto.setCarrito(null);
            recalcularTotal();
        }
        //cálculo
        private void recalcularTotal() {
            total = Lproductos.stream()
                             .map(p -> p.getPrecioTotal())
                             .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
}

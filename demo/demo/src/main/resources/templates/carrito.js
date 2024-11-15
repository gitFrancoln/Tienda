// Inicializar el carrito en el navegador
let cart = JSON.parse(localStorage.getItem("cart")) || [];

// Función para agregar un producto al carrito
function addToCart(id, nombre, precio) {
    const index = cart.findIndex(item => item.id === id);
    if (index === -1) {
        cart.push({ id, nombre, precio, cantidad: 1 });
    } else {
        cart[index].cantidad += 1;
    }
    localStorage.setItem("cart", JSON.stringify(cart));
}

// Función para hacer el checkout y enviar el carrito al backend
// Función para hacer el checkout y enviar el carrito al backend
function checkout() {
    // Obtiene el carrito desde localStorage
    const cart = JSON.parse(localStorage.getItem("cart")) || [];

    // Envía el carrito al backend
    fetch('/carrito/checkout', {  // Asegúrate que la URL coincide con la ruta del controlador
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ productos: cart })  // Envía los productos en el JSON
    })
    .then(response => response.json())
    .then(data => {
        alert("Compra realizada con éxito");
        localStorage.removeItem("cart");  // Limpia el carrito en el navegador
    })
    .catch(error => console.error("Error:", error));
}


//Objetos

const nombreProducto = "Monitor 20 pulgadas";
const precio = 300;
const disponible = true;

const producto = {
    nombreProducto : "monitor 20 puldagas",
    precio: 300,
    disponible: true
}

console.log(producto);

//accediendo al obsjeto
console.log(producto.precio);
console.log(producto.nombreProducto);
console.log(producto['disponible']);

//agregando
producto.imagen = 'imagen.jpg'

console.log(producto);

//eliminar
delete producto.imagen;

console.log(producto);

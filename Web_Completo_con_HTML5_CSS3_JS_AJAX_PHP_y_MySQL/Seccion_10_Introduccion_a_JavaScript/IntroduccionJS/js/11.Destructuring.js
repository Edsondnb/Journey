//Objetos

const producto = {
    
    nombreProducto: "Monitor 20 pulgadas",
    precio: 300,
    disponible: true
}

// forma antigua:
// const precio= producto.precio;
// const nombreProducto = producto.nombreProducto;

//Destructuring ==> sacar de una estructura por ejemplo un OBJETO
const {precio} = producto;
const {nombreProducto, disponible } = producto;

console.log(precio);
console.log(nombreProducto);
console.log(disponible);

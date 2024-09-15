//POO
/* object literal*/

const producto = {
    nombre: 'Tablet',
    precio: 500

}


//Object Constructor
function Prodcuto (nombre, precio, stock){
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
}

//PROTOTYPE ==> CREA FUNCIONES QUE SOLO SE UTILIZAN EN UN OBJETO EN ESPECIFICO
Prodcuto.prototype.formatearProducto = function(){
    return `El producto ${this.nombre} tiene un precio de: ${this.precio} y tienen un stock de ${this.stock} unidades`
}

//objeto vacio que crea un nuevo producto
const producto2 = new Prodcuto('monitor curvo 49p',800, 90);
const producto3 = new Prodcuto('Laptop',1800, 95);
const producto4 = new Prodcuto('tv 32"', 950, 40);


function formatearProducto(producto){
    return `El producto ${producto.nombre} tiene un precio de: ${producto.precio} y tienen un stock de ${producto.stock} unidades`
}


console.log(producto2.formatearProducto());
console.log(producto3.formatearProducto());
console.log(producto4.formatearProducto());



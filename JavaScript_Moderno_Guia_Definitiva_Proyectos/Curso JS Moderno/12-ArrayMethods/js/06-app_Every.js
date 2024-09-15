// todos los elementos de un arreglo deben de cumplir esa condicion para devolver un true 

const carrito = [
    {nombre: 'monitor 20 pulgadas', precio: 800},
    {nombre: 'Televisor', precio: 700},
    {nombre: 'Tablet', precio: 300},
    {nombre: 'Audifonos', precio: 200},
    {nombre: 'Teclado', precio: 500},
    {nombre: 'Celular', precio: 500},
    {nombre: 'Bocinas', precio: 300},
    {nombre: 'Laptop', precio: 800},

]

                                            // todos los elelmentos deben cumplir esa condicion       
const resultado = carrito.every ( producto => producto.precio < 500);
console.log(resultado);


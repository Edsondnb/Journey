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
 
//FOREACH --> solo arreglos, para enviar a consoloa, mostar en pantalla
carrito.forEach( producto => console.log(`Una vez por cada elemento: ${producto.nombre}`));


//map ---> solo arreglo, crear un nuevo arreglo dede cero

const arreglo2 = carrito.map( producto => `${producto.nombre} -- ${producto.precio}`);
console.log(arreglo2);
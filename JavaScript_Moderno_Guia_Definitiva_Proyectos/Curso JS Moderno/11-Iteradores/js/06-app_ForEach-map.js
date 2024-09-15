

//foreach

const pendiente = ['Tarea','Dormir','Comer','Proyecto','Estudiar'];

pendiente.forEach( (pendiente, indice) => {
    console.log(`${indice}: ${pendiente}`);
})


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


 const nuevoArreglo = carrito.forEach( producto => producto.precio);
 //no traera nada
 console.log(nuevoArreglo);
 
 //map crea un arreglo nuevo areglo
const nuevoArreglo2 = carrito.map( producto => producto.precio);
console.log(nuevoArreglo2);

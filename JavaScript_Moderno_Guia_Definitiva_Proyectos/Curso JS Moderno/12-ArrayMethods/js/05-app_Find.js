const meses = ['enero','febreo' ,'Marzo' ,'Abril'];  //arreglo

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


//con forEach

let resultado = '';
carrito.forEach( (producto , index ) => {
    if(producto.nombre === 'Tablet'){
        resultado = carrito[index]
    }
});

console.log(resultado);

// con .find = solo traerá el primer elemento que coincida primero

const resultado2 = carrito.find (producto => producto.nombre === 'Tablet');
console.log(resultado2);
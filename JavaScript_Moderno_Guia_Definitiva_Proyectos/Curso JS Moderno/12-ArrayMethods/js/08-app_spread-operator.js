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

//progrmacion funcional = no modificar ni agregar nada al arreglo
console.log(meses);

//sp con arrglo de indices
const meses2 = [...meses, 'Julio'];
console.log(meses2);

//agreando con sp
const producto = {nombre: 'Disco HDD', precio: 300};
const carrito2 = [producto, ...carrito];
console.log(carrito2);
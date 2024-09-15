
//FOR = MAS FACIL PARA ITERAR
const pendientes = ['Tarea','Dormir','Comer','Proyecto','Estudiar'];

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



for (let pendiente of pendientes ){
   console.log(pendiente);
}


for( let producto of carrito){
    console.log(producto.nombre);
}
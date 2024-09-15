//Array methods

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

//ForEach

meses.forEach(function(mes){
    if (mes == 'Marzo'){
        console.log('Marzo si existe');
    }
})

// Includes en vez de ForEach *** solo con objetos planos NO OBJETOS, para saber si exite en el arreglo
let resultado = meses.includes('Diciembre');
console.log(resultado);


//para buscar en un AREGLO DE OBJETOS (some)
resultado2 = carrito.some(function(producto){
    return producto.nombre === 'Celular'
});

console.log(resultado2);


//Reduce ==> funcion reductora, toma una gran cantidad de datos unirlos y entregar un resultado
 resultado = carrito.reduce(function(total, producto){
     return total + producto.precio
 },0);

    //--suma todos los valores
    console.log(resultado);
                                                                        //se puede agregar a la suma
resultado2 = carrito.reduce( (total, producto ) => total + producto.precio, 20);
console.log(resultado2);


//Filter ==> obtener elememtos, mayor que, menor que , iguales que, etc
resultado = carrito.filter(function(producto){
     return producto.precio > 400;
})

//trayendo todo menos el teclado
resultado = carrito.filter(function(producto){
    return producto.nombre !== 'Teclado';
})

console.log(resultado);



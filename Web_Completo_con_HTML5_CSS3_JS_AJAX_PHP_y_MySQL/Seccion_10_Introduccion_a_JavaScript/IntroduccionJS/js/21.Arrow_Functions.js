//Funciones flecha


const sumar2 = (n1,n2) => {
    console.log(n1 + n2);
}

sumar2(5,10);

/* 
    manera de simplificar una funcion con arrow functions
*/

const aprendiendo = (tecnologia) =>{
    console.log(`aprendiendo ${tecnologia}`);
}
aprendiendo('JavaScript');

//solo cuando se tiene una linea en el return
const aprendiendo2 = (tec) => `aprendiendo ${tec}`;
console.log(aprendiendo2('Java y Spring Boot con angular')); 



//----------------------------------

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


         //funcion(mes)
meses.forEach( mes => {
    if (mes == 'Marzo'){
        console.log('Marzo si existe');
    }
})


///para AREGLO DE OBJETOS (some)
resultado = carrito.some (producto => producto.nombre === 'Celular');

console.log(resultado);


//Reduce ==> entrega un resultado
 resultado = carrito.reduce((total, producto) => total + producto.precio, 0);

 console.log(resultado);

 //Filter ==> obtener elememtos, mayor que, menor que , iguales que, etc
 resultado = carrito.filter(producto => producto.precio > 400);

 console.log(resultado);

 resultado = carrito.filter(producto => producto.nombre == 'Laptop')

 console.log(resultado);

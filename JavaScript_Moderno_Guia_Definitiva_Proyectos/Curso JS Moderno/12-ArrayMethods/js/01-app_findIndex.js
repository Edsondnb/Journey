// En que indice de nuestro arreglo se encuentra un elemento

const meses = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio'];

const carrito = [
    { nombre: 'Monitor 27 Pulgadas', precio: 500 },
    { nombre: 'Televisión', precio: 100 },
    { nombre: 'Tablet', precio: 200 },
    { nombre: 'Audifonos', precio: 300 },
    { nombre: 'Teclado', precio: 400 },
    { nombre: 'Celular', precio: 700 },
]
                    //por default se define el index => i
meses.forEach( (mes, i ) => {
    if( mes === 'Abril'){
        console.log(`Encontrado en el indice ${i}`);
    };
})


//encontrado el indice  con FINDINDEX, retorna un -1 si no lo encuentra o se ingresa un valor inexistente

const indice = meses.findIndex( mes => mes === 'Abril');
console.log(indice);

//Encontrar un indice en un arreglo de objetos

const indice2 = carrito.findIndex( producto => producto.nombre == 'Celular');
console.log(indice2);
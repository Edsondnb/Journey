//crear un for loop que cuando llegue la 5 detenga su ejecucion

for (let i = 1; i <= 10; i++) {
    if( i == 5){
        console.log('Este es un 5');
        break; //detiene el bucle
    }

    console.log(`Numero: ${i}`);

}

//el 5 en TEXTO 
for (let i = 1; i <= 10; i++) {
    if( i == 5){
        console.log('CINCO');
        continue; //Rompe el ciclo pero continua ejecutando el resto del bucle
    }

    console.log(`Numero: ${i}`);

}


//ejm. CONTINUE


const carrito = [
    {nombre: 'monitor 20 pulgadas', precio: 800},
    {nombre: 'Televisor', precio: 700},
    {nombre: 'Tablet', precio: 300},
    {nombre: 'Audifonos', precio: 200, descuento: true},
    {nombre: 'Teclado', precio: 500},
    {nombre: 'Celular', precio: 500},
    {nombre: 'Bocinas', precio: 300},
    {nombre: 'Laptop', precio: 800},

]

for (let i = 0; i < carrito.length ; i++) {
    if(carrito[i].descuento){
        console.log(`el aritulo carrito[i].nombre tiene descuento`);
        continue;
    }

    console.log(carrito[i].nombre);
    
}
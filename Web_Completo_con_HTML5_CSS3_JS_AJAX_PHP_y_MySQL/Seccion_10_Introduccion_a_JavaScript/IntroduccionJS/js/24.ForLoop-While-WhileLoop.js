//FOR LOOP
for (let i = 1; i <= 10; i++) {
    if( i % 2 === 0){
        console.log(i);
    }else{
        console.log(i);
    }

}

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


for (let i = 0; i < carrito.length ; i++) {
    //solo iterar nombre
    console.log(carrito[i].nombre);
    
}


//WHILE LOOP ----> debe coincidir la condicion se cumpla para luego que pueda ejecutar

// let i = 0;//indice

// while (i <= 100) {//condicion
//     if (i % 2 === 0) {
//         console.log(`el numero ${i} es par`);
//     }else{
//         console.log(`el numero ${i} es impar`);
//     }
//     i++;//incremento
// }


// let e = 20;//indice

// while (e < 31) {//condicion
//     console.log('Desde el while loop');
//     e++;//incremento
// }

//DO WHILE ---> el codigo se ejecuta una vez y luego evalua

let i = 0;

do{
    console.log(i);
    i++;
}while(i<10);
"use strict"

const producto = {
    
    nombreProducto: "Monitor 20 pulgadas",
    precio: 300,
    disponible: true
}

// Object.freeze(producto); //impide que el objeto cambie las propiedades
Object.seal(producto); //solo permite modificar propiedades exitentes - sellar el objeto
producto.disponible = false; //modificando existente

// producto.imagen = "imagen.png";

//saber si el objeto esta congelado o no
console.log(Object.isFrozen(producto));
console.log(Object.isSealed(producto));

console.log(producto);
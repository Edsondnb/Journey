//Clases

class Producto {

    constructor(nombre, precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    formatearProducto(){
        return `El producto ${this.nombre} tiene un precio de: ${this.precio}`
    }

    // formatearPrecio(){
    //     return `el precio del producto es: ${this.precio}`
    // }
    
    obtenerPrecio(){
        console.log(this.precio);
    }

}

const producto2 = new Producto('monitor curvo 49p',800);
const producto3 = new Producto('Laptop',1800);

// console.log(producto2.formatearPrecio());
console.log(producto3);


//----------------- HERENCIA ==> extends ------------
class Libro extends Producto{
    constructor(nombre,precio,isbn){
        super(nombre,precio)
        this.isbn = isbn;
    }

    formatearProducto(){
        return `${super.formatearProducto() } y su ISBN es: ${this.isbn}`;
    }

    obtenerPrecio(){
        super.obtenerPrecio();
        console.log('Si hay precio');
    }
}

const libro = new Libro('JavaScript',150,'78748668484')

console.log(libro.formatearProducto());
console.log(libro.obtenerPrecio());
console.log(producto2.formatearProducto());
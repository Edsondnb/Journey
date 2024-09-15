//THIS

const reservacion = {
    nombre: 'Edson',
    apellido: 'Mendo',
    total: 5000,
    pagado: false,
    //arrow function 
    informacion: () => {
        console.log(`${this.nombre} ${this.total}`);
    }
}


const reservacion2 = {
    nombre: 'Edson',
    apellido: 'Mendo',
    total: 5000,
    pagado: false,
    // this == Propiedades del objeto sobre el cual se esta ejecutando esta funcion
    informacion2: function(){
        console.log(`El cliente ${reservacion2.nombre} reservo y su cantidad a pagar es: ${reservacion2.total}`);
    }
}

console.log(reservacion2.informacion2());

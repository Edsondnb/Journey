const producto = {
    nombre: 'Tablet',
    precio: 500,
    disponible: true
}


//.keys = se obtendra un arrgelo con las llaves del objeto
console.log(Object.keys( producto ));

//.values = se obtendras los valores
console.log(Object.values( producto ));

//.entried = se obtendras todos los datos del objeto en PARES
console.log(Object.entries( producto ));

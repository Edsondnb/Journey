//ASYNC /AWAIT => hasta que no este completado no se ejecuta la siguiente linea de codigo

//resolve => obligar que la funcion se cumpla

function descargarNuevosCliente(){
    return new Promise( resolve => {
        console.log('Descargando cliente....');

        setTimeout( () => {
            resolve('los clientes fueron descargados')
        }, 5000);
    });
}

function descargarUltimosPedidos(){
    return new Promise( resolve => {
        console.log('Descargando ultimos pedidos....');

        setTimeout( () => {
            resolve('los Pedidos fueron descargados')
        }, 3000);
    });
}


//optimizando una apliacicon, ganado performance
async function app(){
   try {
    //    const clientes = await descargarUltimosPedidos();
    //    const pedidos = await descargarNuevosCliente();
    //    console.log(clientes);
    //    console.log(pedidos);
        // ==> ejecutandose las dos funciones al mismo tiempo mediante arreglos
        const resultado = await Promise.all([ descargarNuevosCliente(), descargarUltimosPedidos() ])
        console.log(resultado[0]);
        console.log(resultado[1]);

    } catch (error) {
        console.log(error);
       
   }
}

app();
//Tiempo en ejecutar esa funcion
// setInterval(() => {
//     console.log('set timeout');
// }, 3000);
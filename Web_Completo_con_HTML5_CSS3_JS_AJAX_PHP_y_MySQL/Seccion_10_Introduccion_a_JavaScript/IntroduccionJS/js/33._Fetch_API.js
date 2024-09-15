//Fetch API => reemplazo a ajax (XMLHTTPrequest) ontiene informacion del servidos, proceso los datos en tiempo real sin recargar, Utilizadon JSON(Javascript Object Notation) lenguaje de transporte de datos, no importa el lunguiaje en de backend todo tiene la capacidad de exportar en json y ser leeido por javascript para ser visto en la web

//Ulizado con PROMISES, pero tambien con ASYNC, AWAIT

async function obtenerEmpleados(){
    const archivo = 'empleados.json'; 
    
    // fetch(archvio)
    //     .then( resultado => {
    //         return resultado.json(); //.text
    //     })
    //     .then( datos => {
    //         //console.log(datos.empleados);
    //         const {empleados} = datos;
    //         console.log(empleados);

    //         empleados.forEach(empleado => {
    //             //console.log(empleados);
    //             console.log(empleado.id);
    //             console.log(empleado.nombre);
    //             console.log(empleado.puesto);

    //         });
    //     })

    const resultado = await fetch(archivo);
    const datos = await resultado.json();
    console.log(datos);
}

obtenerEmpleados();
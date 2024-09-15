
const datos = {
    ingresarMonto : 0,
    retiroMonto: 0
}

const total = document.getElementById('total');

const lblIngreso = document.querySelector('#lblIngreso');
const btnAgregar = document.getElementById('btn-agregar');
const ingresarMonto = document.getElementById('ingresar-monto');

const lblRetiro = document.getElementById('lblRetiro');
const btnRetirar = document.getElementById('btn-retirar');
const retiroMonto = document.getElementById('retiro-monto');


const listaHistorial = document.querySelector('.form__historial--lista');
const listaHistoriaRetiro = document.querySelector('.form__historial--listaRetiro');

let categoria = document.getElementById('categoria')


// let monto = ingreso.innerHTML = 5500;

// total.innerHTML = monto;

/**
 * * Detectando datos ingresados en el INPUT*/

ingresarMonto.addEventListener('input', leerInput);
retiroMonto.addEventListener('input', leerInput);
console.log(retirarMonto.value);


/**
 * * Funciones del boton formulario
 **/
btnAgregar.addEventListener('click', function(e) {
    e.preventDefault();
    agregarMonto();
});

btnRetirar.addEventListener('click', function(e) {
    e.preventDefault();
    retirarMonto();
})

/**
 * * *********************FUNCIONES**************************
 **/

function agregarMonto(){
    let montoActual = parseFloat(total.textContent) || 0;
    let montoReciente = parseFloat(total.textContent) || 0;

    montoReciente = datos['ingresarMonto'];
    montoActual += datos['ingresarMonto'];
    //console.log(montoActual);

    lblIngreso.textContent = montoReciente.toFixed(2);
    total.textContent = montoActual.toFixed(2);

    agregarVineta(montoReciente.toFixed(2));

    ingresarMonto.value = '';
}

function retirarMonto(){
    let montoActual = parseFloat(total.textContent) || 0;
    let montoRetiro = parseFloat(total.textContent) || 0;
    //console.log(montoActual);
   

    montoRetiro = datos['retirarMonto'];
    montoActual -= datos['retirarMonto'];

    lblRetiro.textContent = montoRetiro.toFixed(2);
    total.textContent = montoActual.toFixed(2);

    agregarVinetaRetiro(montoRetiro.toFixed(2));
    //leerCombo();

    retiroMonto.value = '';
}


/**
 * * Leer cada caracter ingresado **/
function leerInput(e){
    datos['ingresarMonto'] = parseFloat(e.target.value) || 0;
    datos['retirarMonto'] = parseFloat(e.target.value) || 0;

    console.log(e.target.value);
}


/**
 * * Funcion para agregar vineta al historial **/
function agregarVineta(texto){
    const vineta = document.createElement('li');
    let fechaActual = new Date();

    
    vineta.classList.add('form__historial--vineta');
    //vineta.textContent = texto;
    vineta.textContent = `Ingresó: S/.${texto} - ${fechaActual.getDate() + '-' + fechaActual.toLocaleDateString('default', { month: 'short' }) + '-' + fechaActual.getFullYear()}`;
    listaHistorial.appendChild(vineta);
    
}

function agregarVinetaRetiro(montoRetiro){
    const vineta = document.createElement('li');
    let fechaActual = new Date();

    //const opcion = categoria.value;
    const opcionTexto = categoria.options[categoria.selectedIndex].text;


    vineta.classList.add('form__historial--vineta');
    vineta.textContent = `Retiró: S/. ${montoRetiro} / ${fechaActual.getDate() + '-' + fechaActual.toLocaleDateString('default', { month: 'short' }) + '-' + fechaActual.getFullYear()} / ${opcionTexto}`;

    listaHistoriaRetiro.appendChild(vineta);

}



/**
 * * **************************************************
 * * ***************************************************
 * 
 **/


// let categoria = document.getElementById('categoria');
// let i = categoria.selectedIndex;


// let opcion = categoria.options[i].text;

// console.log(opcion);

// let categoria = document.getElementById('categoria');
// let opcion = categoria.selectedIndex;
// console.log(categoria.options[opcion].text);

// let opciones = categoria.options;
// console.log(opciones);



// function anexarFecha(){
    
//     const fecha = new Date();
//     const anoActual = fecha.getFullYear();
//     const mesActual = fecha.toLocaleDateString('default', { month: 'short' });
//     const diaActual = fecha.getDate();

//     let fechaTransaccion = anoActual + ' ' + mesActual + ' ' + diaActual
//     //console.log(fechaTransaccion);

// }



// const fecha = new Date();

// const day = fecha.getDay();
// console.log(day);
// const anoActual = fecha.getFullYear();
// const mesActual = fecha.toLocaleDateString('default', { month: 'short' });
// const diaActual = fecha.getDate();

// const fechaTransaccion = anoActual + ' ' + mesActual + ' ' + diaActual
// console.log(fechaTransaccion);



// const date = new Date();  // 2009-11-10
// const month = date.toLocaleString('default', { month: 'long' });
// console.log(date); 
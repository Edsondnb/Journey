//Estructura de control

const puntaje = 1001;

if(puntaje == 1000){
    console.log('el puntaje es 1000');
}else{
    console.log('No es igual a 1000');
}


//-*-------------------------

const efectivo = 1000;
const carrito = 800;

if (efectivo > carrito) {
    console.log('El usuadio puede pagar');
}else{
    console.log('Fondos insuficientes');
}

///-----------------------------------

const rol = 'Administrador'

if (rol === 'Administrador') {
    console.log('Acceso al sistema');
} else if (rol === 'Editor'){
    console.log('Eres editor, medio acceso');
}else{
    console.log('No tienes acceso');
}

///-----------------------------------

const puntaje2 = 300;

function revisarpuntje() {
    if(puntaje2 > 450){
        console.log('Exclente!!');
        return;
    }
    if(puntaje2 => 300){
        console.log('buen puntaje.. felicidades');
        return;
    }
}

revisarpuntje();

///------------- OPERADOR TERNARIO ----------------------

const  autenticado4 = true;
const  puedePagar = false;

console.log(autenticado4 && puedePagar ? 'Si puede pagar' : 'No esta autenticado');


///------------- TERNARIO anidado ----------------------
console.log(autenticado4 ? puedePagar ? 'Si puede pagar' : 'Si autenticado, no puede pagar' : 'No esta autenticado');
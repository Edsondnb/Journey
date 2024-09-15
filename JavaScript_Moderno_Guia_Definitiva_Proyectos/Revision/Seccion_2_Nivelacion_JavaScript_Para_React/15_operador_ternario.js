
const cuenta = -10;
let mensaje;


if(cuenta < 0){
    mensaje = "No tienes saldo disponible";
}else{
    mensaje = "Tienes saldo disponible";
}

console.log(mensaje)


const edad = 8;
let alerta;

if(edad < 18){
    alerta = "No tienes permitido el ingreso: " + edad;
}else{
    alerta = "Puedes ingresar: " + edad;
}

console.log(alerta);

/***************************************************************/
/* Operador Ternario */

const nota = 10; 
const aprobado = nota >= 13 ? "Aprobado" : "Desaprobado";

console.log(aprobado);
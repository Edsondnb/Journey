//JAVASCRIPT SE EJECUTA EN 2 ETAPAS -- 1. BUSCA LAS VARIABLES Y REGISTRA LAS FUNCIONES, 2. EJECUCION DE CODIGO

//Funciones ==> serie de procedimientos que realizan una accion, permiten un codigo mas ordenado y reutilizables

//Declaracion de la funcion -----------------------------------------
sumar();

function sumar(){
    //cuerpo
    console.log(10 + 10);
}



//Expresion de la funcion ------------------------------------------------
const sumar2 = function(){
    console.log(3 + 3);
}

sumar2();//DEBIDO A LA DECLARACION QUE SE PUEDE TOMAR COMO UNA VARIABLE, ESTA MANDARÁ ERROR SI ESTA POR ENCIMA DE SU FUNCION DECLARADA
 
//IIFE ==> funciones que se invocan a ellas mismas, no para reutilizarce
(function() {
    console.log('esto es una funcion');
})(); 


                       //0 = DEFAULT
function sumar(numero1 = 0, numero2 = 0){ //num1, num2 son PARAMETROS
    //cuerpo
    console.log(numero1 + numero2);
}

sumar(10,10); //argumentos o valores reales
sumar(4); //argumentos o valores reales
sumar(7888,2); //argumentos o valores reales



//expresion de la funcion
const sumar2 = function(numero1, numero2){
    console.log(numero1 + numero2);
}

sumar2(96, 4); 
sumar2(1099, 1); 

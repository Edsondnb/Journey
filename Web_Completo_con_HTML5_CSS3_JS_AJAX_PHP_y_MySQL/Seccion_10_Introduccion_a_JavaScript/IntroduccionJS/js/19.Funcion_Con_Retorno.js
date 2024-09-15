                       
function sumar(n1, n2 ){ 
    //cuerpo
    return (n1 + n2);
}

//asignancose a otra variable
const resultado = sumar(10,10); 

console.log(resultado);


let total = 0;

function agregarCarrito(precio){
    return total += precio;
}

function calcularImpuesto(total){
    return 1.15*total;
}

total = agregarCarrito(200);
total = agregarCarrito(400);
total = agregarCarrito(600);

console.log(total);

const totalApagar = calcularImpuesto(total);

console.log(`total a pagar con impuesto es de : ${totalApagar}`);




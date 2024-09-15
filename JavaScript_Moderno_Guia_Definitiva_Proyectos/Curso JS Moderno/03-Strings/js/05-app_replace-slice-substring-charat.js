
const producto = 'Monitor 20 pulagadas';


console.log(producto);

//replace = reemplazando texto
console.log(producto.replace('pulagdas', '"'));

console.log(producto.replace('Monitor', 'Monitor Curvo'));

//slice = para cortar letras
                    //donde inicia a cortar, donde deja de                       cortar                         
console.log(producto.slice(0, 10) );

//substring = alternativa a slice
console.log(producto.substring(0, 10));
console.log(producto.substring(2, 1));


/*
    Diferecencia entre .slice y .subtring, es que si se pasa un numero mayor de incio
    y la extencion .slice no hara nada, por lo contrario .subtring lo modifica poniendo al mayor al inicio.

*/


const usuario = 'Edson';
console.log(usuario.substring(0,1));

//.charAt = corta la primera letra del texto
console.log(usuario.charAt(0));
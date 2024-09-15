//arrelos - arrays
                 //indicativo de arreglo []   
const numeros =  [10,20,30,40,50];

console.table(numeros);

const meses = ['enero','febreo' ,'Marzo' ,'Abril'];  //arreglo

console.table(meses);

const arreglo = ["Hola", 10, true, "si", null, {nombre: "Pepe", edad: 30}, [1,2,3]];

console.log(arreglo);

//accediento al arreglo del arreglo
console.log(arreglo[6][2]);

//como acceder valores de un arreglo
console.log(numeros[4]);

//conocer la extension de un arreglo
console.log(meses.length);


//iterador --> recorer arreglos
numeros.forEach(function (numeros){
    console.log(numeros);
})

//Modificar los arreglos
numeros.push(60,70,80) //agregar al final del arreglo

numeros.unshift(-10,-20,-30)  //agregar al inicio del arreglo

console.table(numeros);

//Eliminar
const dias = ['lunes','martes','Miercoles','jueves','viernes'];
console.log(dias);
dias.pop()  //ultimo
dias.shift() //primero

dias.splice(2,1); //orden --> cuantos elementos quieres eliminar

console.log(dias);


//Rest operator o Spread Operator ==> RECOMENDADO

const nuevoArreglo = [...dias, 'Nuevo dia']
console.log(nuevoArreglo);




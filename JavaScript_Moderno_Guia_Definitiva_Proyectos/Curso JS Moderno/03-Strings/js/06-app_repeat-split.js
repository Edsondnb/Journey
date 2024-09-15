const producto = 'Monitor 20 pulagadas';


//repeat = permite repetir una cadena de texto. Solo acepta numeros entereos, al    ingresar un un decimal lo redondea

const texto = 'En promocion'.repeat(3);

console.log(texto);
console.log(`${producto} ${texto}!!`);


//split = divide un string por cada una de las palabras(" ") o letras ("")

const actividad = 'Estoy repazando javascritp';
console.log(actividad.split(""));

const hobbies = 'Leer, caminar, estudiar, mezlcar';
console.log(hobbies.split(" "));

const tweet = 'Aprendiendo #javaScript';
console.log(tweet.split('#'));
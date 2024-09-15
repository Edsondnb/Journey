
const primerEnlace = document.querySelector('a');

//-- eliminado 
// primerEnlace.remove();
// console.log(primerEnlace);

//-- padre elimninado hijo

const navegacion = document.querySelector('.navegacion');
console.log(navegacion.children);

navegacion.removeChild( navegacion.children[2]);
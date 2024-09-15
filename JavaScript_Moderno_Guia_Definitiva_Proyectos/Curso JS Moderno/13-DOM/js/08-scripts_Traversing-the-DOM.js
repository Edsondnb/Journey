//significa recorriendo el HTML

const navegacion = document.querySelector('.navegacion');
console.log(navegacion);
console.log(navegacion.childNodes); //espacios en blanco son considerados elementos, ejm espaciado o tabulacion de etiquetas html

console.log(navegacion.firstElementChild);
console.log(navegacion.lastElementChild);

console.log(navegacion.children[0].nodeName); //verdadero codigo html- [0] = lista el primer elemento
console.log(navegacion.children[0].nodeType); //significa diferentes tipos de NODO


// const card2 = document.querySelector('.card');
// card2.children[1].children[1].textContent = 'Nuevo heading desde traversing de DOM'
//                               //trayendo el titulo
// console.log(card2.children[1].children[1].textContent);

// card2.children[0].src = 'img/hacer3.jpg';
// console.log(card2.children[0]);

//TRAVERSING DE HIJO AL PADRE -- parentElement
const card = document.querySelector('.card');
console.log(card.parentElement); //verifica por elemntos html validos , no espacios en blanco

console.log(card.parentElement.parentElement.parentElement); 

//seleccionar el elemnto hermano = nextElementSibling
console.log(card.nextElementSibling);
console.log(card.nextElementSibling.nextElementSibling);

//ir al elemento previo = previousElementSibling

const ultimoCard = document.querySelector('.card:nth-child(4)');
console.log(ultimoCard.previousElementSibling);

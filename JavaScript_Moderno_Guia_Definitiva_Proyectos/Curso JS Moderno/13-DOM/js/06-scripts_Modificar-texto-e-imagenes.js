

const encabezado = document.querySelector('.contenido-hero h1');
console.log(encabezado);

//accediendo al texto h1, 3 maneras

console.log(encabezado.innerText); //si en el css existe - visibility: hidden; no lo va a encontrar
console.log(encabezado.textContent); //si lo va a encontrar
console.log(encabezado.innerHTML); //se trae toda la etiqueda html

//reemplazando el titulo
document.querySelector('.contenido-hero h1').textContent = 'Nuevo Heading';

//reemplazando una imagen 
const imagen = document.querySelector('.card img');
imagen.src = 'img/hacer2.jpg';




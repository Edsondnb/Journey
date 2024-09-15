/* Metodos para seleccionar elementoas HTML, todos los elemntos html en javascript se conocen como nodos */

//querySelector ==> selecciona una o ningun elemento que concuerde con elemento utilizado. clase o id

const heading = document.querySelector('.header__texto h2')

//cambiando valores como objeto
heading.textContent = 'Nuevo heading';

console.log(heading);

//querySelectorAll ==> retorna todos los elementos o 0 si el elemento está mal

const enlaces = document.querySelectorAll('.navegacion a');
console.log(enlaces[1]);

enlaces[0].textContent  ='Nuevo texto';

//getelementById
const heading2 = document.getElementById('heading');
console.log(heading2);



//-------------------- Gnerenar un nuevo enlace -------------
const nuevoEnlace = document.createElement('A');

//agregar el href
nuevoEnlace.href = 'nuevo-enlace.html'

//agregar texto
nuevoEnlace.textContent = 'Un nuevo enlace'

//agregar la calse
nuevoEnlace.classList.add('navegacion__enlace');

//agregando al documento ==> permite agregar un elelmento e insertala en otro lugar
const navegacion = document.querySelector('.navegacion');
navegacion.appendChild(nuevoEnlace);

console.log(nuevoEnlace);

/***************** Eventos **********/
//window ==> objeto global del HTML y funciones
//addEventListener ==> evento asociado
//load ==> espera a que el js y los archivos que dependen del HTML (img, videos, css, etc) esten listo
//DOMContentLoaded ==> solo le importa que cargue el HTML, no espera img o css
console.log(1);

window.addEventListener('load', function() {
    console.log(2);
});

window.onload = function(){
    console.log(3);
};

document.addEventListener('DOMContentLoaded', function(){
    console.log(4);
});

window.onscroll = function(){
    console.log('scrolling...');
}

// SELECIONAR ELEMENTOS Y ASOCIARLES UN EVENTO
const btnEnviar = document.querySelector('.boton--primario')
btnEnviar.addEventListener('click', function(evento){
    console.log(evento);
    //para validar el formulario
    evento.preventDefault();
    console.log('enviando formulario');
});

//El evento de Submit
const formulario = document.querySelector('.formulario');
formulario.addEventListener('submit', function(evento){
    evento.preventDefault();

    console.log('enviando formulario');
})

/*********   Eventos de los Inputs y areas ************ */

const datos = {
    nombre: '',
    email: '',
    mensaje: ''
}

const nombre = document.querySelector('#nombre');
const email = document.querySelector('#email');
const mensaje = document.querySelector('#mensaje');

nombre.addEventListener('input', leerTexto);
email.addEventListener('input', leerTexto);
mensaje.addEventListener('input', leerTexto);

function leerTexto(e){

    //leyendo datos del formulario
    datos[e.target.id]  = e.target.value;
    console.log(datos);
}


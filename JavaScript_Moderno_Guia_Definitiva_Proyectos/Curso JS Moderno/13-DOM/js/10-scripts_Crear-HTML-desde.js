


const enlace = document.createElement('A')

//agrendo el texto
enlace.textContent = 'Nuevo enlace';

//añadiendo href
enlace.href = '/nuevo-enlace';

enlace.onclick = miFuncion;

//seleccionar la navegacion - mostradon en el DOM
const navegacion = document.querySelector('.navegacion');
        //siempre lo colocará al final
//navegacion.appendChild(enlace);
navegacion.insertBefore(enlace, navegacion.children[1]);


console.log(enlace);

function miFuncion (){
        alert('Diste click');
}

// CREAR UN CARD, conocido como DOM escripting

const parrafo1 = document.createElement('P');
parrafo1.textContent = 'Concierto';
parrafo1.classList.add('categoria', 'concierto');

const parrafo2 = document.createElement('P');
parrafo2.textContent = 'Concierto de Rock';
parrafo2.classList.add('titulo')


const parrafo3 = document.createElement('P');
parrafo2.textContent = '$800 por persona';
parrafo2.classList.add('precio')

//crear div con la clase de info
const info = document.createElement('div');
info.classList.add('info');

info.appendChild(parrafo1);
info.appendChild(parrafo2);
info.appendChild(parrafo3);


//crear la imagen
const imagen = document.createElement('img');
imagen.src = 'img/hacer2.jpg';

imagen.alt = "texto alternativo";

//crear el card

const card = document.createElement('div');
card.classList.add('card');

//asignar la imagen
card.appendChild(imagen);

//asignar info
card.appendChild(info);

console.log(parrafo1);


//INSERTAR EN EL HTML
const contendor = document.querySelector('.hacer .contenedor-cards');
contendor.appendChild(card);


const cardDiv = document.querySelector('.card');


cardDiv.addEventListener('click', evento => {

    if(evento.target.classList.contains('titulo')){
        console.log('Diste click en titulo');
    }
    if(evento.target.classList.contains('precio')){
        console.log('Diste click en precio');
    }
    if(evento.target.classList.contains('card')){
        console.log('Diste click en card');
    }
});
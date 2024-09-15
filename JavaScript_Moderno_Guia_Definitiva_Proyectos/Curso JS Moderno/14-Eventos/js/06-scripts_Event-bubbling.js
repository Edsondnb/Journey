// llamando a mas evento de más, se dispara más de un evento

const cardDiv = document.querySelector('.card');
const infoDiv = document.querySelector('.info');
const titulo = document.querySelector('.titulo');

cardDiv.addEventListener('click', eventp => {
          //detiene la propagacion de más eventos que no se este 
    eventp.stopPropagation()
    console.log('Click en card');
})

infoDiv.addEventListener('click', evento => {
    
    evento.stopPropagation()
    console.log('Click en infoDiv');
})

titulo.addEventListener('click', evento => {
    evento.stopPropagation()
    console.log('Click en titulo');
})
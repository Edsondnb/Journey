

const formuilario = document.querySelector('#formulario');

formuilario.addEventListener('submit', validaFormulario);


function validaFormulario(evento){
            //prevenir la accion que realizaria el elemento por default, ejm: <a> y llamar una API
    evento.preventDefault();
    
    console.log('Buscando...');

    console.log(evento.target.action);
    
}

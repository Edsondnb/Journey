//1. - cargando el html
document.addEventListener('DOMContentLoaded', function() {
    
    //objeto para los campos 
    const correo = {
        email: '',
        cc: '',
        asunto: '',
        mensaje: ''
    }

    //2. - selecionando elementos de la interfaz
    const inputEmail = document.querySelector("#email");
    const inputCC = document.querySelector("#cc");
    const inputAsunto = document.querySelector("#asunto");
    const inputMensaje = document.querySelector('#mensaje');

    const formulario = document.querySelector('#formulario');

    //console.log(inputMensaje);

    //3. - Asignando eventos
    inputEmail.addEventListener('blur', validar);

    inputCC.addEventListener('blur', validar);

    inputAsunto.addEventListener('blur', validar);

    inputMensaje.addEventListener('blur', validar);

    //4.- agregando funciones

    //validando el click afuea de los inputs
    function validar(evento){
        //referencia al atributo
        console.log(evento.target.parentElement.parentElement);

        if(evento.target.value.trim() === ''){
            mostrarAlerta(`el campo ${evento.target.id} es obligatorio`, evento.target.parentElement);
            return;
        }

        if(evento.target.id === 'email' && !validarEmail(evento.target.value)){
            mostrarAlerta('el email no es valido', evento.target.parentElement);
            return;
        }

        if(evento.target.id === 'cc' && !validarEmail(evento.target.value)){
            mostrarAlerta('el cc no es valido', evento.target.parentElement);
            return;
        }
        
        limpiarAlerta(evento.target.parentElement);
        console.log('despues del if');
    }

    function mostrarAlerta(mensaje, referencia){
        //comprobar si ya existe una alerta
        limpiarAlerta(referencia);
        
        const error = document.createElement('P');
        error.textContent = mensaje;
        error.classList.add('error');

        //inyectar el error al formulario
        
        //formulario.appendChild(error);
        referencia.appendChild(error);
    }

    function limpiarAlerta(referencia){
        const alerta = referencia.querySelector('.error');
        if(alerta){
            alerta.remove();
        };
    }

    function validarEmail (email){
        const regex = /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/ 
        const resultado = regex.test(email);
        console.log(resultado);


    }

});



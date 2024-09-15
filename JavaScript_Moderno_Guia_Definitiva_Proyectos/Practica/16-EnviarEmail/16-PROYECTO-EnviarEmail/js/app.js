

document.addEventListener('DOMContentLoaded', function(){

    //objeto para verificar si los campos estan llenos y habilitar el boton de enviar
    const email = {
        email: '',
        cc: '',
        asunto: '',
        mensaje: ''
    }


    //Seleccionar los elementos de la interfaz
    const inputEmail = document.querySelector('#email');
    const inputCC = document.querySelector('#cc');
    const inputAsunto = document.querySelector('#asunto');
    const inputMensaje = document.querySelector('#mensaje');
    const formulario = document.querySelector('#formulario');

    const spinner = document.querySelector('#spinner');

    const btnSubmit = document.querySelector('#formulario button[type="submit"');
    const btnReset = document.querySelector('#formulario button[type="reset"');

    //Asginando eventos        //cuando se presiona en algun lado del doom que no sea input
    inputEmail.addEventListener('input', validador);
    inputCC.addEventListener('input',  validador);
    inputAsunto.addEventListener('input',  validador);
    inputMensaje.addEventListener('input', validador);
    

    
    
    formulario.addEventListener('submit', enviarEmail);

    btnReset.addEventListener('click', function(e){
        e.preventDefault();

        resetFormulario();
    })

    function enviarEmail(e){
        e.preventDefault();

        spinner.classList.add('flex');
        spinner.classList.remove('hidden');

        setTimeout(() => {
            spinner.classList.remove('flex');
            spinner.classList.add('hidden');

            resetFormulario();

            //crear una alerta
            const alertExito = document.createElement('P');
            alertExito.classList.add('bg-green-500', 'text-white', 'p-2', 'text-center', 'rounded-lg', 'mt-10', 'font-bold', 'text-sm', 'uppercase');

            alertExito.textContent = 'Mensaje enviado correctamente';

            formulario.appendChild(alertExito);

            setTimeout(() => {
                alertExito.remove();
            }, 3000); 

        }, 3000);
    }



    function validador(evento){
        //console.log(evento.target.value);
                              //metodo de string, para evitar espacios en blanco
        if(evento.target.value.trim() === ''){
            
            mostrarAletra(`El campo ${evento.target.id} es obligatorio`, evento.target.parentElement);
            //console.log('Esta vacio');
            email[evento.target.name] = '';
            comprobarEmail();
            return;
        }
        
        if(evento.target.id === 'email' && !validarEmail(evento.target.value)) {
            mostrarAletra('El email no es valido', evento.target.parentElement);
            email[evento.target.name] = '';
            comprobarEmail();
            return;
        };

        // if(evento.target.id === 'cc' && !validarEmail(evento.target.value)) {
        //     mostrarAletra('El CC no es valido', evento.target.parentElement);
        //     cc[evento.target.name] = '';
        //     comprobarEmail();
        //     return;
        // };

        

       
        

        limpiarAlerta(evento.target.parentElement);
        
        
        // Asignar los valores para enviar el mensaje
        email[evento.target.name] = evento.target.value.trim().toLowerCase();
        
        //comprobar el objeto de email
        comprobarEmail();

    }


    function mostrarAletra(mensaje, referencia){
        //comprobar si ya existe una alerta
        limpiarAlerta(referencia);
        /**
            //comprobar si ya existe una alerta
            const alerta = referencia.querySelector('.bg-red-600')
                if( alerta ){
            alerta.remove();
        } 
        */


        //generar alerta en HTML
        const error = document.createElement('P');
        error.textContent = mensaje;
        error.classList.add('bg-red-600', 'text-white', 'p-2', 'text-center');

        //console.log(error);

        //inyectar el error al formulario
        referencia.appendChild(error);
    }

    function limpiarAlerta(referencia){
        const alerta = referencia.querySelector('.bg-red-600'); 
        if( alerta ){
            alerta.remove();
        }

    }

    function validarEmail(email){
        const regex =  /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/ ;

        const resultado = regex.test(email);
        //console.log(resultado);

        return resultado;
    }

    function comprobarEmail(){
                    //toma el objeto email y 
                    //lo canvierte en un arreglo
        if(Object.values(email).includes('')){
                                //alguno de los elemntos tiene un string vacio
             
            btnSubmit.classList.add('opacity-50');
            btnSubmit.disabled = true;
            return;
        }

        btnSubmit.classList.remove('opacity-50');
        btnSubmit.disabled = false;
        
                                           
    }

    function resetFormulario(){
        //reiniciar el objeto
        email.email = '';
        email.cc = '';
        email.asunto = '';
        email.mensaje = '';

        formulario.reset();
        comprobarEmail();
    }

});



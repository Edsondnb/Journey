const datos = {
    nombre: '',
    email: '',
    mensaje: ''
}

const nombre = document.querySelector('#nombre');
const email = document.querySelector('#email');
const mensaje = document.querySelector('#mensaje');
const formulario = document.querySelector('.formulario');

nombre.addEventListener('input', leerTexto);
email.addEventListener('input', leerTexto);
mensaje.addEventListener('input', leerTexto);


formulario.addEventListener('submit', function(evento){
    evento.preventDefault();

    //validar formulario
    const { nombre, email, mensaje } = datos;
    
    if(nombre === '' || email === '' || mensaje === ''){     
        mostrarAlerta('todos los campos son obligatorios' , true);
        return; //corta la ejecucion del codigo
    }

    //Crear alerta enviado
    mostrarAlerta('Formulario enviado correctamente');
    

    console.log('enviando formulario');
}) 


/*************  ALERTAS -*******/
//Refactory ==> codigo funcional al inicio y luego modificar el codigo para que se vea bien

function mostrarAlerta(mensaje, error = null){
    const alerta = document.createElement('P');
    alerta.textContent = mensaje;

    if(error){
        alerta.classList.add('error');
    }else{
        alerta.classList.add('correcto')
    }

    formulario.appendChild(alerta);

    //desaparecer despue sde 5s
    setTimeout(() => {
        alerta.remove();
    }, 3000);

}


function leerTexto(e){

    datos[e.target.id]  = e.target.value;
    console.log(datos);
}



const btnFlotante = document.querySelector('.btn-flotante');
const footer = document.querySelector('.footer');

//al dar click en un boton se llama evento

//registrando evento                  //funcion anonima
btnFlotante.addEventListener('click', mostrarOcutarFooter);

function mostrarOcutarFooter(){
                        //verifica si tiene o no una clase
    if(footer.classList.contains ('activo')){
        footer.classList.remove('activo');
        this.classList.remove('activo');
        this.textContent = 'Idioma y Moneda';

    }else{
        footer.classList.add('activo');
        this.classList.add('activo'); //.this = referencia a btnFlotante
        this.textContent = 'X cerrar';
    }

    console.log(footer.classList);
}
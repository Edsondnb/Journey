

const nav = document.querySelector('.navegacion');

//registrar eventos
                
nav.addEventListener('click', () => {
    console.log('CLick en nav');
})

nav.addEventListener('mouseout', () => {
    console.log('saliendo del  nav');

    nav.style.backgroundColor = 'transparent';
})

nav.addEventListener('mouseenter', () => {
    console.log('Entrando al  nav');
    nav.style.backgroundColor = 'white';
})
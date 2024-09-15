
//window => ventana global

window.addEventListener('scroll', () => {

    const premium = document.querySelector('.premium');
                  //a que distacia se encuentra un elemento. ejm ubicacion
    const ubicacion = premium.getBoundingClientRect();

    console.log(ubicacion);


    if(ubicacion.top < 100){
        console.log('El elemento ya es visible');
    }else{
        console.log('Aun no, sigue dando sroll');
    }
})









// const scrollPX = window.scrollY;

// console.log(scrollPX);
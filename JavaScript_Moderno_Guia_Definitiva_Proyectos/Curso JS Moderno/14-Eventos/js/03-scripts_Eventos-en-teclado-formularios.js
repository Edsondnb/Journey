

const busqueda = document.querySelector('.busqueda');

//                         //Escribir texto
// busqueda.addEventListener('keyup', () => {
//     console.log('Escribiendo...');
// })

//                         //pegar texto o cortar = cut
// busqueda.addEventListener('paste', () => {
//     console.log('Escribiendo...');
// })

                        //registra todo
// busqueda.addEventListener('input', () => {
//     console.log('Escribiendo...');
// })

busqueda.addEventListener('input', (e) => {
    if(e.target.value === ''){
        console.log('fallo la validacion');
    }

                 //sobre que elmento estamos trabajando
    console.log(e.target.value);
})


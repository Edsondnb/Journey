//DOMContentLoaded => siempre sera una funcion anonima, este evento espera a que todo el documento este listo

console.log(1);
                         
document.addEventListener('DOMContentLoaded', () =>{
    console.log(2);
})

console.log(3);


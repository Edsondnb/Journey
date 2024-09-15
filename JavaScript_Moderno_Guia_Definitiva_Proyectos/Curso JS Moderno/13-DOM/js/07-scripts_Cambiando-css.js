const emcabezado = document.querySelector('h1');

/*
    no recomendable, la apariencia debe estar a cargo del css, sin embargo, si se puede para AGREGAR o QUITAR clases 
*/
emcabezado.style.backgroundColor = 'orange';
emcabezado.style.fontFamily = 'Arial';
emcabezado.style.textTransform = 'uppercase';


//---Agregando clase

const card = document.querySelector('.card');
card.classList.add('nueva-clase', 'segunda-clase');
console.log(card.classList);

//--- eliminaod clase
const card2 = document.querySelector('.card');
card2.classList.remove('segunda-clase');
console.log(card.classList);
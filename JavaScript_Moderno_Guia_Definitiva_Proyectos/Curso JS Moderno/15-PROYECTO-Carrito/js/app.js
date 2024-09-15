
//VARIABLES
const carrito = document.querySelector('#carrito');
const contenedorCarrito = document.querySelector('#lista-carrito tbody');
const vaciarCarrito = document.querySelector('#vaciar-carrito');
const listaCursos = document.querySelector('#lista-cursos');

let articulosCarrito = [];

//CARGANDO EVENTLISTENER
cargarEventListeners();

function cargarEventListeners(){

    //cuando agregar un curso ´presionandop "agregar carrito
    listaCursos.addEventListener('click', agregarCurso);

    //elimina cursos del carrito
    carrito.addEventListener('click', eliminarCurso);

    //vaciar carrito
    vaciarCarrito.addEventListener('click', () => {
        articulosCarrito = []; //reseteando arreglo

        limpiarHTML(); //eliminaos todo el HTML

        console.log('vaciando carrito');
    })

}

//Funciones

function agregarCurso(evento){

    evento.preventDefault();

    if( evento.target.classList.contains('agregar-carrito')){
        const cursoSeleccionado = evento.target.parentElement.parentElement;
        leerDatosCurso(cursoSeleccionado);
    }
}

//Eliminar curso del carrito
function eliminarCurso(evento){
    console.log(evento.target.classList);

    if(evento.target.classList.contains('borrar-curso')){
        const cursoId = evento.target.getAttribute('data-id');

        //eliminar del arreglo de ArticulosCarrtio por el data id
        articulosCarrito = articulosCarrito.filter( curso => curso.id !== cursoId);

        //llamando funcion se inserthtml
        carritoHTML(); //se itera sobre el carrtio y se muestra el html
    };
}

//lee el contenido del HTML al que le dimos click y extre la informacion del curso
function leerDatosCurso(curso){
    //console.log(curso);

    //creando un objeto con el contenido del curso actual
    const infoCurso = {
        imagen: curso.querySelector('img').src,
        titulo: curso.querySelector('h4').textContent,
        precio: curso.querySelector('.precio span').textContent,
        id: curso.querySelector('a').getAttribute('data-id'),
        cantidad: 1
    }

    //Revisa si un elelmto ya existe en el carrito
    const existe = articulosCarrito.some ( curso => curso.id === infoCurso.id);
    if(existe){
        //actualizamos cantidad
        const cursos = articulosCarrito.map ( curso => {
            if(curso.id === infoCurso.id){
                curso.cantidad++;
                return curso; //retrorna el objeto actualizado 
            }else{
                return curso; //retorna objetos que no son duplicados
            }
        });
        articulosCarrito = [...cursos];
    }else{
        //agrega elementos al arreglo articulosCarrito 
        articulosCarrito =  [...articulosCarrito, infoCurso];
    }

    //console.log(infoCurso);

 
    

    console.log(articulosCarrito);

    carritoHTML();
}


//Muestra el carrito de comprar en el HT5ML

function carritoHTML(){

    //limpiarHTML
    limpiarHTML();

    //recorre el carrito y genera el HTML
    articulosCarrito.forEach( curso => {

        const { imagen, titulo, precio, cantidad, id} = curso;
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>
               <img src="${imagen}" width="100">
            </td>
           
            <td>
                ${titulo}
            </td>
            <td>
                ${precio}
            </td>
            <td>
                ${cantidad}
            </td>
            <td>
                <a href="#" class="borrar-curso" data-id="${id}">X</a>
            </td>
        `;

        //agrega el html del carrito en el tbody
        contenedorCarrito.appendChild(row);

    })
}

//ELIMINA LOS CURSO DEL TBODY
function limpiarHTML(){
    //forma lenta
    // contenedorCarrito.innerHTML = '';

    while (contenedorCarrito.firstChild){
        contenedorCarrito.removeChild(contenedorCarrito.firstChild)
    }

}
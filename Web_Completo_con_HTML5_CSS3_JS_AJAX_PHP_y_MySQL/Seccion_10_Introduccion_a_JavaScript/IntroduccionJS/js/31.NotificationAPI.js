//Notification API 

//docuemnt ==> referencia a todo el HTML
//querySelector ==> selecciona contenido HTML
//addEventListener ==> funcion que perimite registrar un evento a la variable del boton que tiene agregado el html de ID de boton

const boton = document.querySelector('#boton');
boton.addEventListener('click', function(){
    Notification.requestPermission()
        .then(resultado => console.log(`El resultado es ${resultado}`))
    
    //console.log('Diste click');
    //console.log(5 + 5);
});

if(Notification.permission == 'granted'){
    new Notification('Esta es una notificacion',{
        //forma de agregar el logotipo
        icon: 'img/android.ico',
        body: 'Aprendiendo para el futuro'
    })
}
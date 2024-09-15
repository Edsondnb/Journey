//Metodos de propiedad = funciones con sitaxis que la utilizarlas llegan a ser un metodo

const reproductor = {
    reproducir : function(id){
        console.log(`Reproduciendo cancion con el ID: ${id}`);
    },
    pausar : function(){
        console.log('Pausando...');
    },
    crearPlaylist: function(nombre){
        console.log(`Creandoi playlist: ${nombre}`);
    },
    reporducirPlaylist: function(nombre){
        console.log(`Reproduciendo playlist: ${nombre}`);
    }
}

reproductor.borrarCancion = function(id){
    console.log(`eliminado cancion: ${id}`);
}

reproductor.reproducir(5);
reproductor.pausar();
reproductor.borrarCancion(4);
reproductor.crearPlaylist('Hernanez')
reproductor.reporducirPlaylist('Hernanez')
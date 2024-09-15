package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasListar implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    //consturctor para inciializar
    public ServicioPeliculasListar(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("LISTADO DE PELICULAS....");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("SE AGREGO LA PELICULA: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //1. Regresa el indice de la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);
        if(indice == -1){
            System.out.println("No se encontró la pelicula: "+ pelicula);
        }else {
            System.out.println("Pelicula encontrada en el indice: " + indice);
        }
    }


    public static void main(String[] args) {
        //2. creando obj de tipo pelicula
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Rocket");

        //3. creando servicio (patron de diseño service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasListar();

        //4. agregando las peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);

        //5. llamando peliculas
        servicioPeliculas.listarPeliculas();

        //6. buscamos peliculas
        servicioPeliculas.buscarPelicula(new Pelicula("Batman"));
    }
}

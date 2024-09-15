package servicio;

import dominio.Pelicula;

public interface IServicioPeliculas {

    //no contiene la definicion de sus metodos
    public void listarPeliculas();

    public void agregarPelicula(Pelicula pelicula);

    public void buscarPelicula(Pelicula pelicula);



}

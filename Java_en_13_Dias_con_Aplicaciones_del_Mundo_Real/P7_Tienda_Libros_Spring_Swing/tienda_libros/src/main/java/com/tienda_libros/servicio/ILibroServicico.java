package com.tienda_libros.servicio;

import com.tienda_libros.modelo.Libro;

import java.util.List;

public interface ILibroServicico {

    public List<Libro> listarLibros();

    public Libro buscarLibroPorId(Integer idLibro);

    public void guardarLibro(Libro libro);
    public void eliminarLibro(Libro libro);

}

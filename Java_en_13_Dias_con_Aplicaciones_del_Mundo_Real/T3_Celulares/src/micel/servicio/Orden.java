package micel.servicio;

import micel.modelo.Celular;

import java.util.ArrayList;
import java.util.List;

public class Orden {

    private final int idOrden;
    private final List<Celular> celulares;
    private static int contadorOrdenes;

    public Orden(){
        celulares = new ArrayList<>();
        this.idOrden = ++contadorOrdenes;
    }

    //agregar celular
    public void agregarCeular(Celular celular){
        celulares.add(celular);
    }

    //mostrar ordenes
    public void mostrarOrden(){
        System.out.println("N° Orden: " + idOrden);
        System.out.println("Total de celulares: " + celulares.size());
        celulares.forEach(System.out::println);
    }



}

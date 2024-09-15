package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    //8. guardando en un archivo
    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //9. si ya existe el archivo no se vuelve a crear
            if(archivo.exists()){
                System.out.println("El archivo ya exite");
            }else {
                //10. si no existe, se crea
                var nuevoArhcivo = new PrintWriter(new FileWriter(archivo));
                nuevoArhcivo.close();
                System.out.println("Se ha creado el nuevo archivo");
            }

        }catch (Exception ex){
            System.out.println("Ocurrio un error al abrir el archivo: " +ex.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {

        //12. volvemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Lisado de peliculas");
            //13. abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //14. leemos linea a linea el archvio
            String linea;
            linea = entrada.readLine();
            //15. leemos todas las lineas disponibles
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //16. Antes de termina el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();

            }
            entrada.close();

        }catch (Exception ex){
            System.out.println("Ocurrio un error al leer el archivo:  " + ex.getMessage());
        }


    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);

        try {
            //18. revisamos si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            //19. agregamos la pelicula (toString)
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego al archivo: " + pelicula);
        }catch (Exception e){
            System.out.println("Ocurrio un error al AGREGAR pelicula:  "+ e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //20. abrimos el archivo para la lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();

            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();

            while (lineaTexto != null){
                //21. buscamos sin importar mayusculas/minusculas
                if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                //22. leemos la siguiente linea antes de la siguiente iteracion
                lineaTexto = entrada.readLine();
                indice++;
            }//fin del while
            //23. imprimimos los resultados de la busqueda
            if(encontrada){
                System.out.println("Pelicula: " + lineaTexto + " encontrada - linea " + indice);
            }else{
                System.out.println("No se encontro la pelicula: " + pelicula.getNombre());
            }
            entrada.close();

        }catch (Exception ex)
        {
            System.out.println("ocurrio un erro al buscar en el archivo " + ex.getMessage());
        }
    }
}

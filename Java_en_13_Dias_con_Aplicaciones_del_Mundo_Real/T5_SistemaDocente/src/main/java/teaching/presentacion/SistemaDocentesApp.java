package teaching.presentacion;


import teaching.dao.DocenteDAO;
import teaching.dominio.Docente;

import java.util.List;
import java.util.Scanner;

public class SistemaDocentesApp {
    public static void main(String[] args) {

        var salir = false;
        var consola = new Scanner(System.in);


        var docentesDao = new DocenteDAO();

        while (!salir){

            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, docentesDao);

            }catch (Exception ex){
                System.out.println("Ocurrio un error al ejecutar la operacion: " +ex.getMessage());

            }
            System.out.println();
        }


    }

    public static void mostrarMenu(){
        System.out.println("""
                ############# Elija una opcion ##############
                1. Listar Docentes
                2. Agregar Docentes
                3. Modificar Docentes
                4. Buscar Docentes
                5. Eliminar Docentes
                6. Salir
                
                """);
    }

    public static boolean ejecutarOpciones(Scanner consola, DocenteDAO docentesDao){
        var salir = false;
        var opcion = Integer.parseInt(consola.nextLine());

        switch (opcion){
            case 1 -> {
                System.out.println("Listado de Docentes: ");
                List<Docente> docentes = docentesDao.listarDocente();
                docentes.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Agregar estudiante: ");

                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("email: ");
                var email = consola.nextLine();

                var nuevoDocente = new Docente(nombre,apellido,telefono,email);
                var agregado = new DocenteDAO().agregarDocente(nuevoDocente);
                if(agregado)
                    System.out.println("Docente agregado: " + nuevoDocente);
                else
                    System.out.println("Error al agregar Docente");
            }
            case 3 -> {
                System.out.println("Modificar estudiante");
                System.out.println("Ingresar ID del estudiante: ");
                var idDocente = Integer.parseInt(consola.nextLine());

                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("email: ");
                var email = consola.nextLine();

                var modificarDocente = new Docente(idDocente, nombre, apellido, telefono, email);
                var modificado = docentesDao.modificarEstudiante(modificarDocente);
                if(modificado){
                    System.out.println("Docente modificado: " + modificarDocente);
                }else {
                    System.out.println("Docente no modificado");
                }

            }

            case 4 -> {
                System.out.println("Buscar doncete");
                var idDocente = Integer.parseInt(consola.nextLine());
                var buscarDocente = new Docente(idDocente);

                var encontrado = docentesDao.buscarDocenteId(buscarDocente);

                if(encontrado){
                    System.out.println("Docente encontrado: " + buscarDocente);
                }else{
                    System.out.println("Docente no encontrado");
                }

            }

            case 5 -> {
                System.out.println("Eliminar Docente: ");

                var idDocente = Integer.parseInt(consola.nextLine());
                var eliminarDocente = new Docente(idDocente);

                var eliminado = docentesDao.eliminarDocente(eliminarDocente);

                if(eliminado){
                    System.out.println("Docente Eliminado: " + eliminarDocente);
                }else {
                    System.out.println("Docente no ELIMINADO");
                }

            }
            case 6 -> {
                System.out.println("Hasta pronto....");
                salir = true;
            }

            default -> System.out.println("Opcion incorrecta");

        }
        return salir;
    }
}
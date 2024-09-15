package school.presentacion;


import school.dao.EstudianteDAO;
import school.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {

        var salir = false;
        var consola = new Scanner(System.in);

        //se crea una instancia clase servicio

        var estudianteDao = new EstudianteDAO();
        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            }catch (Exception ex){
                System.out.println("Ocurrio un error al ejecutar operacion: "+ ex.getMessage());
            }
            System.out.println();

        }//fin while


    }

    private static void mostrarMenu(){
        System.out.println("""
                --- Sistema de estudiantes ---
                1. Listar Estudiantres
                2. Buscar Estudiantes
                3. Agregar Estudiante
                4. Modificar Estudiantes
                5. Eliminar Estudiantes
                6. SALIR
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDao){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch (opcion){
            case 1 -> {
                System.out.println("Listado de estudiantes...");
                var estudiantes = estudianteDao.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDao.buscarEstudiantePorId(estudiante);
                if(encontrado){
                    System.out.println("Estudiante encontrado: " +estudiante);
                }else {
                    System.out.println("Estduainte no encontrado");
                }

            }case 3 -> {
                System.out.println("Agregar Estudiante: ");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();

                //creando objeto estudiante
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDao.agregarEstudiante(estudiante);
                if(agregado){
                    System.out.println("Estudiante agregado: " +estudiante);
                }else {
                    System.out.println("Estudiante no agregado: " + estudiante);
                }
            }

            case 4 -> {
                System.out.println("Modificar estudiante: ");
                System.out.println("Ingrese el ID del estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();

                //crewar el objeto estudiante a modificar
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDao.modificarEstudiante(estudiante);
                if(modificado)
                    System.out.println("Estudiante modificado: " + estudiante);
                else
                    System.out.println("Estudiante no moficiado");
            }

            case 5 -> {
                System.out.println("Eliminar Estudiante: ");
                System.out.println("Id estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDao.eliminarEstudiante(estudiante);
                if(eliminado){
                    System.out.println("Estudiante eliminado: " + eliminado);
                }else {
                    System.out.println("No eliminado");
                }
            }
            case 6 ->{
                System.out.println("Hasta ptronto");
                salir = true;
            }

            default -> System.out.println("Opcion incorrecta");

        }

        return salir;
    }
}
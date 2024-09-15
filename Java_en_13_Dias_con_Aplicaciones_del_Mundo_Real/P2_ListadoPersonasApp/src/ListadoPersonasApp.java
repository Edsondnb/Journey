import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {

    public static void main(String[] args) {


        Scanner consola = new Scanner(System.in);

        //1. Definimos la lista fuera del ciclo While
        List<Persona> personas = new ArrayList<>();

        //2. menu
        var salir = false;

        while(!salir){
            mostrarMenu();

            try {
                //4. ejecutando operacion
                salir = ejecutarOperacion(consola, personas);
            }catch (Exception ex){
                System.out.println("Ocurrio un error " + ex.getMessage());
            }


            System.out.println();
        }

    }

    private static void mostrarMenu(){
        //3. mostrando las opciones
        System.out.print("""
                ---- listado perosnas app ----
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Porporciona una opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        //5. verificamos la opcion proporcionada
        switch (opcion){
            case 1 -> {
                System.out.println("Porpociona el nombre: ");
                var nombre = consola.nextLine();

                System.out.println("Porpociona el telefono: ");
                var numero = consola.nextLine();

                System.out.println("Porpociona el email: ");
                var email = consola.nextLine();

                //6. crear el objeto persona
                var persona = new Persona(nombre, numero, email);

                //7. agregamos a la lista
                personas.add(persona);

                //8. cuantos elementos se han agreado a la lista
                System.out.println("La lista tiene : " + personas.size() + " personas");
            }//fin caso 1

            //9. lista las personas
            case 2 -> {
                System.out.println("Listado de personas");
                //10. mejora usando lambda y metodo de referencia
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }

            //11. Salir
            case 3 ->{
                System.out.println("Vuelve pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: " + opcion);
        }//fin switch

        return salir;
    }

}

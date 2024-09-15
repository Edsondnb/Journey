import java.util.Scanner;

public class MiProceso {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        while(true){

            try{

            System.out.println("**** Aplicacion Calculadora *****");
            mostrarMenu();

                int operacion = Integer.parseInt(sc1.nextLine());

                if (operacion >= 1 && operacion <= 4) {
                    ejecutarOperacion(operacion, sc1);

                } else if (operacion == 5) {
                    System.out.println("Vuelve pronto...");
                    break;

                } else {
                    System.out.println("Opcion erronea = " + operacion);
                }//fin del if

                System.out.println("-------------------------------------------------");
            }catch (Exception ex){
                System.out.println("Ocurrio un error: " + ex.getMessage());
            }

        }//fin del ciclo while
    }

    private static void mostrarMenu() {
        System.out.println("""
                    1. Suma
                    2. Resta
                    3. Multiplicacion
                    4. Division
                    5. Salir
                    """);
        System.out.println("Ingrese la operacion a realizar ↓↓↓↓↓↓↓");
    }

    private static void ejecutarOperacion(int operacion, Scanner sc1){

        System.out.println("Ingrese el primer numero");
        double numero1 = Double.parseDouble(sc1.nextLine());

        System.out.println("Ingrese el segundo numero");
        double numero2 = Double.parseDouble(sc1.nextLine());

        double numero3;

        switch (operacion) {
            case 1 -> {
                numero3 = numero1 + numero2;
                System.out.println("El resultado de la suma es: " + numero3);
            }

            case 2 -> {
                numero3 = numero1 - numero2;
                System.out.println("El resultado de la resta: " + numero3);
            }

            case 3 -> {
                numero3 = numero1 * numero2;
                System.out.println("el resultado de la multiplicacion es : " + numero3);
            }

            case 4 -> {
                numero3 = numero1 / numero2;
                System.out.println("el resultado de la division es: " + numero3);
            }

            default -> System.out.println("Opcion no es correcta: " + operacion);
        }
    }

}




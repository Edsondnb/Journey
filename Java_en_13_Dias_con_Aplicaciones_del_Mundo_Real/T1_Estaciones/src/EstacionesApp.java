import java.util.Scanner;

public class EstacionesApp {

    public static void main(String[] args) {

        while(true){
            System.out.println("#### Escoga la opcion con la que desea buscar: ####");
            System.out.println("""
                1. Por el numero del mes.
                2. Por el nombre de la estacion.
                3. salir
                """);

            try {
                Scanner sc = new Scanner(System.in);

                var opcionEstacion = Integer.parseInt(sc.next());

                if (opcionEstacion == 1) {

                    System.out.println("**** Ingrese el numero del mes: ****");
                    Scanner consola = new Scanner(System.in);
                    var numMesEstacion = Integer.parseInt(consola.next());
                    opcionNumMes(numMesEstacion);

                }
                else if (opcionEstacion == 2) {
                    System.out.println("**** Ingrese el nombre de de la estacion" +
                            "" +
                            ": ****");

                    Scanner consola = new Scanner(System.in);
                    var nombreMesEstacion = consola.nextLine().toLowerCase();

                    opcionNomMes(nombreMesEstacion);
                        
                }
                else if (opcionEstacion == 3) {
                        System.out.println("Vuelve pronto...");
                        break;
                }else {
                    System.out.println("Por favor, eija una opcion correcta ↓↓↓↓");
                }



                //fin try
            }catch (Exception ex){
                System.out.println("Ocurrio un error -> " + ex + " ......");
            }

        }//fin while

    }//fin main

    private static void opcionNumMes(int numMesEstacion){


        if (numMesEstacion >= 1 && numMesEstacion <= 3) {
            System.out.println("VERANO: inicia el 21 de diciembre y finaliza el 20 de marzo.");
        } else if (numMesEstacion >= 4 && numMesEstacion <= 6) {
            System.out.println("OTONO: inicia el 20 de marzo y finaliza el 21 de junio.");
        } else if (numMesEstacion >= 7 && numMesEstacion <= 9) {
            System.out.println("INVIERNO: inicia el 21 de junio y finaliza el 22 de septiembre.");
        } else if (numMesEstacion >= 10 && numMesEstacion <= 12) {
            System.out.println("PRIMAVERA: inicia el 22 de septiembre y finaliza el 21 de diciembre.");
        } else {
            System.out.println("No exite el mes:  " + numMesEstacion);
        }

        System.out.println();
    }

    public static void  opcionNomMes(String nombreMesEstacion){

        switch (nombreMesEstacion){
            case "verano" -> System.out.println("inicia el 21 de diciembre y finaliza el 20 de marzo");
            case "otono" -> System.out.println("inicia el 20 de marzo y finaliza el 21 de junio.");
            case "invierno" -> System.out.println("inicia el 21 de junio y finaliza el 22 de septiembre.");
            case "primavera" -> System.out.println("inicia el 22 de septiembre y finaliza el 21 de diciembre."+ "\n");
            default -> System.out.println("No existe el mes con nombre: " + nombreMesEstacion);
        }
    }
}

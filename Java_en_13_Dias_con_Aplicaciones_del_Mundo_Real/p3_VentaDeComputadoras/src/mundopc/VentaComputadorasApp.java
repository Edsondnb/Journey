package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadorasApp {


    public static void main(String[] args) {
        //creando objetos

        Raton ratonLenovo = new Raton("USB", "Lenovo");
        //System.out.println(ratonLenovo);
        Raton ratonDell = new Raton("USB", "Dell");
        Raton ratonMac = new Raton("Bluetooth", "Mac");

        Teclado tecladoLenovo = new Teclado("Bluetooth", "Lenovo");
        //System.out.println(tecladoLenovo);
        Teclado tecladoDell = new Teclado("Wifi", "tecladoDell");
        Teclado tecladoMac = new Teclado("Bluetooth", "tecladoMac");


        Monitor monitorLenovo = new Monitor("Lenovo", 24.5);
        //System.out.println(monitorLenovo);
        Monitor monitorDell = new Monitor("Dell",27);
        Monitor monitorMac = new Monitor("Mac",32);


        //creando objeto de tipo computadora
        Computadora computadoraLenovo = new Computadora("Comp. lenovo",monitorLenovo, tecladoLenovo, ratonLenovo);
        //System.out.println(computadoraLenovo);

        Computadora computadoraDell = new Computadora("Computadora Dell", monitorDell, tecladoDell, ratonDell);
        Computadora computadoraMac = new Computadora("Computadora Mac", monitorMac, tecladoMac, ratonMac);



        //creando una orden
        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.agregarComputadora(computadoraDell);
        orden1.mostarOrden();
        System.out.println("""
               ****************************************************
                """);
        Orden orden2 = new Orden();
        orden2.agregarComputadora(computadoraMac);
        orden2.agregarComputadora(computadoraDell);
        orden2.mostarOrden();


    }


}

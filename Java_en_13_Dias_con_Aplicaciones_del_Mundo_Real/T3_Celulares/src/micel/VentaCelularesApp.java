package micel;

import micel.modelo.Audifonos;
import micel.modelo.Celular;
import micel.modelo.Operador;
import micel.modelo.PowerBank;
import micel.servicio.Orden;

public class VentaCelularesApp {


    public static void main(String[] args) {

        /********************************************/
        /**************** OBJETOS ********************/

        Audifonos au1 = new Audifonos("Audifonos", "Samsung");
        Audifonos au2 = new Audifonos("Audifonos", "Ugreen");
        Audifonos au3 = new Audifonos("Audifonos", "Sony");

        PowerBank pb1 = new PowerBank("PowerBank", "Coolbox");
        PowerBank pb2 = new PowerBank("PowerBank", "Duracell");
        PowerBank pb3 = new PowerBank("PowerBank", "Xiaomi");

        Operador op1 = new Operador("Bitel", "Prepago");
        Operador op2 = new Operador("Claro", "Pospago");
        Operador op3 = new Operador("Entel", "Prepago");

        Celular cel1 = new Celular("Huawei", au2, pb3, op2);
        Celular cel2 = new Celular("Zenfone 10", au3, pb2, op3);
        Celular cel3 = new Celular("Oppo", au1, pb1, op3);

        Orden orden1 = new Orden();

        orden1.agregarCeular(cel1);
        orden1.agregarCeular(cel3);

        Orden orden2 = new Orden();
        orden2.agregarCeular(cel2);
        orden2.agregarCeular(cel1);


        orden1.mostrarOrden();
        System.out.println("""
                ------------------------------------------------------------------------
                """);
        orden2.mostrarOrden();




    }
}

package mundopc.modelo;

public class Raton extends DispositivoEntrada{


    private final int idRaton;

    private static int contyadorRatones;

    public Raton(String tipoDeEntrada, String marca) {
        super(tipoDeEntrada, marca);
        idRaton = ++contyadorRatones;
    }

    @Override
    public String toString() {
        return "Raton{" +
                "idRaton=" + idRaton +
                "} " + super.toString();
    }
}

package micel.modelo;

public class PowerBank extends AccesoriosExtra{

    private int idPower;
    private static int contadorPower;


    public PowerBank(String tipoAceesorio, String marcaAccesorio) {
        super(tipoAceesorio, marcaAccesorio);
        idPower = ++contadorPower;

    }

    @Override
    public String toString() {
        return "PowerBank{" +
                "idPower=" + idPower +
                //"contadorPower=" + contadorPower +
                "} " + super.toString();
    }


    public static void main(String[] args) {

        PowerBank pb1 = new PowerBank("PowerBank", "Coolbox");
        PowerBank pb2 = new PowerBank("PowerBank", "Xiaomi");

        System.out.println(pb1);
        System.out.println(pb2);
    }
}

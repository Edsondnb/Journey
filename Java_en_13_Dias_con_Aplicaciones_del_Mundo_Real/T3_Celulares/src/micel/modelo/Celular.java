package micel.modelo;

public class Celular {

    private final int idCelular;
    private String marcaCelular;
    private Audifonos audifonos;
    private PowerBank powerBank;
    private Operador operador;

    private static int contadorCelular;


    public Celular(){
        idCelular = ++contadorCelular;
    }

    public Celular(String marcaCelular, Audifonos audifonos, PowerBank powerBank, Operador operador){
        this();
        this.marcaCelular = marcaCelular;
        this.audifonos = audifonos;
        this.powerBank = powerBank;
        this.operador = operador;
    }


    @Override
    public String toString() {
        return "Celular{" +
                "idCelular=" + idCelular +
                ", marcaCelular='" + marcaCelular + '\'' +
                "\n-> audifonos=" + audifonos +
                "\n-> powerBank=" + powerBank +
                "\n-> operador=" + operador +
                '}' + "\n";
    }
}

package mundopc.modelo;

public class DispositivoEntrada {

    private String tipoDeEntrada;
    private String marca;


    //Constructor

    public DispositivoEntrada(String tipoDeEntrada, String marca){
        this.tipoDeEntrada = tipoDeEntrada;
        this.marca = marca;
    }

    @Override //-> siginifica que se está sobreescribiendo la clase object o clase padre
    public String toString() {
        return "DispositivoEntrada{" +
                "tipoDeEntrada='" + tipoDeEntrada + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}

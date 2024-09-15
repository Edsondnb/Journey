package micel.modelo;

public class Operador {

    private final int idOperador;
    private String nomOperador;
    private String plan;

    private static int contadorOperador;

    public Operador(){
        idOperador = ++contadorOperador;
    }

    public Operador(String nomOperador, String plan){
        this();
        this.nomOperador = nomOperador;
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "Operador{" +
                "idOperador=" + idOperador +
                ", nomOperador='" + nomOperador + '\'' +
                ", plan='" + plan + '\'' +
                '}';
    }
}

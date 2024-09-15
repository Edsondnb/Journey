package micel.modelo;

public class AccesoriosExtra {

    private String tipoAceesorio;

    private String marcaAccesorio;

    public AccesoriosExtra(String tipoAceesorio, String marcaAccesorio){
        this.tipoAceesorio = tipoAceesorio;
        this.marcaAccesorio = marcaAccesorio;
    }

    @Override
    public String toString() {
        return "AccesoriosExtra{" +
                "tipoAceesorio='" + tipoAceesorio + '\'' +
                ", marcaAccesorio='" + marcaAccesorio + '\'' +
                '}';
    }



}

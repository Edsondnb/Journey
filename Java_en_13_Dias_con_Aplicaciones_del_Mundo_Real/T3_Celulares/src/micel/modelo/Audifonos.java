package micel.modelo;

public class Audifonos extends AccesoriosExtra{

    private int idAudi;

    private static int contadorAudi;


    public Audifonos(String tipoAccesorio, String marca){
        super(tipoAccesorio, marca);
        idAudi = ++contadorAudi;
    }

    @Override
    public String toString() {
        return "Audifonos{" +
                "idAudi=" + idAudi +
                //"contadorAudi=" + contadorAudi +
                "} "+ super.toString();
    }




    public static void main(String[] args) {

        Audifonos audi = new Audifonos("Audifonos", "Ugreen");
        Audifonos audi2 = new Audifonos("Audifonos", "Sony");

        //AccesoriosExtra audiExtra1 = new AccesoriosExtra("audi","Ugreen");
        // audifonos2 = new AccesoriosExtra("Audifonos","Sony");
        System.out.println(audi);
        System.out.println(audi2);
        //System.out.println(audiExtra1);

    }
}

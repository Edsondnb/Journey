public class Persona {

    private int id;
    private String nombre;
    private String numero;
    private String email;

    //atributo realcionado con la clase
    private static int numeroPersonas = 0;

    //constructor vacio para contar personas
    public Persona() {
        this.id = ++Persona.numeroPersonas;

    }

    //consturctur con argumentos
    public Persona(String nombre, String numero, String email) {

        //lamando constructor vacio de manera explicita
        //lamando constructor vacio de manera explicita
        this();

        this.nombre = nombre;
        this.numero = numero;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{ " +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", email='" + email + '\'' +
                      //direccion de memeoria
                '}' + super.toString();
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona("Huaa kee", "555555","juaa@gmail.com");
        System.out.println(persona1);
    }

}

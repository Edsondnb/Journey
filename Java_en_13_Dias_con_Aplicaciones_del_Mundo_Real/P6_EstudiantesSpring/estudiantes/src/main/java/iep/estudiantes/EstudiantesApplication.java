package iep.estudiantes;

import iep.estudiantes.modelo.Estudiante;
import iep.estudiantes.servicio.EstudianteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {


	@Autowired
	private EstudianteServicio estudianteServicio;

	//salida por comandos
	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();


	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");
		//levanta la fabrica de spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada!");
	}

	//llamando a este metodo creado por la fabrica de spring para ejecutar aplicaciones en comando
	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecutando metodo run de spring..." + nl);

		var salida = false;
		var cs = new Scanner(System.in);

		while (!salida){

			mostrarMenu();
			salida = ejecutarOpciones(cs);
			logger.info(nl);

		}

	}

	public static void mostrarMenu(){
		logger.info("""
    			***************** Elija una opcion *******************
				1. Listar Estudiante
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Moficar Estudiante
				5. Eliminar Estudiante
				6. Salir
				""");
	}

	public boolean ejecutarOpciones(Scanner cs){

		logger.info(nl);
		var opcion = Integer.parseInt(cs.nextLine());
		var salir = false;

		switch (opcion){

			case 1 -> {
				logger.info(nl + "----------> Listado de Estudiantes <----------" +nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));
			}
			case 2 -> {
				logger.info("Buscar Estudiante por id: ");
				var idEstudiante = Integer.parseInt(cs.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudianteById(idEstudiante);

				if(estudiante != null){
					logger.info("Estudiante encontrado: " + estudiante + nl);
				}else {
					logger.info("Estudiante no encontrado");
				}
			}
			case 3 -> {
				logger.info("Agregar estudiante: " +nl);
				logger.info("Nombre: ");
				var nombre = cs.nextLine();
				logger.info("Apellido: ");
				var apellido = cs.nextLine();
				logger.info("Telefono: ");
				var telefono = cs.nextLine();
				logger.info("email: ");
				var email = cs.nextLine();

				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);

				logger.info("Estudiante agregado: " + estudiante + nl);

			}
			case 4 -> {
				logger.info("Modificar estudiante: " + nl);
				logger.info("ID Estudiante: ");
				var idEstudiante = Integer.parseInt(cs.nextLine());

				//Buscaamos estudiantes a modificar
				Estudiante estudiante = estudianteServicio.buscarEstudianteById(idEstudiante);

				if(estudiante != null){
					logger.info("Nombre: ");
					var nombre = cs.nextLine();
					logger.info("Apellido: ");
					var apellido = cs.nextLine();
					logger.info("Telefono: ");
					var telefono = cs.nextLine();
					logger.info("email: ");
					var email = cs.nextLine();

					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);

					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: " + estudiante + nl);

				}else {
					logger.info("Estudiante no encontrado");
				}

			}
			case 5 -> {
				logger.info("Eliminar estudiante: " + nl);
				logger.info("Ingrese el id: ");
				var idEstudiante = Integer.parseInt(cs.nextLine());

				//buscamos el valor
				var estudiante = estudianteServicio.buscarEstudianteById(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado " + estudiante + nl);
				}else {
					logger.info("Estudiante no encontrado con id: " + idEstudiante);
				}
			}
			case 6 ->{
				logger.info("Hasta pronto....");
				salir = true;
			}

			default -> logger.info("OPcion incorrecta");
		}
        return salir;
    }
}

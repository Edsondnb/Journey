package ch.empleados;

import ch.empleados.modelo.Empleado;
import ch.empleados.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EmpleadosApplication implements CommandLineRunner {

	@Autowired
	private EmpleadoServicio empleadoServicio;

	private static final Logger logger = LoggerFactory.getLogger(EmpleadosApplication.class);

	String nl = System.lineSeparator();


	public static void main(String[] args) {
		logger.info("Inciando la aplicacion.............");

		SpringApplication.run(EmpleadosApplication.class, args);

		logger.info("Finalizando aplicacion.!!!!!!!!!!!!!");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecuatando metodo RUN de Spring!!!!" +nl);

		var salir = false;
		var consola = new Scanner(System.in);

		while (!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}

	}

	public void mostrarMenu(){
		logger.info("""
    			***************** Elija una opcion *******************
				1. Listar Empleados
				2. Buscar Empleado
				3. Agregar Empleado
				4. Moficar Empleado
				5. Eliminar Empleado
				6. Salir
				""");
	}

	public boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;

		switch (opcion){
			case 1 -> {
				logger.info(nl + "Listado de empleados" + nl);
				List<Empleado> empleados = empleadoServicio.listarEmpleados();
				empleados.forEach((empleado -> logger.info(empleado.toString()+ nl)));
			}

			case 2 -> {
				logger.info("Empleado por ID: ");
				var idEmpleado = Integer.parseInt(consola.nextLine());
				Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);

				if(empleado != null){
					logger.info("Empleado encontrado: " + empleado + nl);
				}else {
					logger.info("Empleado no existe!!" + nl);
				}

			}

			case 3 -> {
				logger.info("Agregar empleado..." + nl);

				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("DNI: ");
				var dni = Integer.parseInt(consola.nextLine());
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("email: ");
				var email = consola.nextLine();

				var empleado = new Empleado();
				empleado.setNombre(nombre);
				empleado.setApellido(apellido);
				empleado.setDni(dni);
				empleado.setTelefono(telefono);
				empleado.setEmail(email);

				empleadoServicio.guardarEmpleado(empleado);
				logger.info("Empleado agregado: " + empleado);

			}

			case 4 -> {
				logger.info("Actualziar empleado ");
				logger.info("ID de empelado: ");
				var idEmpleado = Integer.parseInt(consola.nextLine());

				Empleado empleado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);

				if(empleado != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("DNI: ");
					var dni = Integer.parseInt(consola.nextLine());
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("email: ");
					var email = consola.nextLine();

					empleado.setNombre(nombre);
					empleado.setApellido(apellido);
					empleado.setDni(dni);
					empleado.setTelefono(telefono);
					empleado.setEmail(email);

					empleadoServicio.guardarEmpleado(empleado);
					logger.info("Empleado actulizado: " + empleado);
				}

			}
			case 5 -> {
				logger.info("Eliminar empleado: " + nl);
				logger.info("Ingrese el id: ");
				var idEmpleado = Integer.parseInt( consola.nextLine());

				var empelado = empleadoServicio.buscarEmpleadoPorId(idEmpleado);
				if(empelado != null){
					empleadoServicio.eliminarEmpleado(empelado);
					logger.info("Empleado eliminado: " + empelado + nl);
				}else {
					logger.info("Error al eliminar Empleado: " + empelado);
				}

			}case 6 -> {
				logger.info("Adiós!!!!!");
				salir = true;
			}
			default -> logger.info("Opcion incorrecta");


		}//fin switch
		return salir;
	}
}

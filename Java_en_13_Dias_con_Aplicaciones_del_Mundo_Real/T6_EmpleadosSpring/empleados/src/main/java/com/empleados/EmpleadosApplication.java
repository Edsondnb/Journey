package com.empleados;

import com.empleados.modelo.Empleado;
import com.empleados.servicio.EmpleadoServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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

	public static void main(String[] args) {
		logger.info("Iniciando la app....");
		SpringApplication.run(EmpleadosApplication.class, args);
		logger.info("App finalizada");
	}

	String nl = System.lineSeparator();


	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecutando metodo run de spring...." + nl);

		var salida = false;
		var cs = new Scanner(System.in);

		while (!salida){
			mostrarMenu();
			salida = ejecutarOperaciones(cs);
			logger.info(nl);
		}


	}

	void mostrarMenu(){
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

	public boolean ejecutarOperaciones(Scanner cs){
		logger.info(nl);

		var opciones = Integer.parseInt(cs.nextLine());
		var salir = false;

		switch (opciones){
			case 1 -> {
				logger.info(nl + "Listado de empleado...");
				List<Empleado> empleados = empleadoServicio.listarEmpleados();
				empleados.forEach((empleado -> logger.info(empleado.toString() + nl)));

			}
			case 2 -> {
				logger.info("Buscar empleado po id: ");
				var idEmpleado = Integer.parseInt(cs.nextLine());
				Empleado empleado1 = empleadoServicio.buscarEmpleadoPorId(idEmpleado);

				if(empleado1 != null){
					logger.info("Empleado encontrado: " + empleado1 + nl);
				}else{
					logger.info("Estudiante no encontrado");
				}

			}
		}

		return salir;
	}


}

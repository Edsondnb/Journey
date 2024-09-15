
use estudiantes_db;

CREATE TABLE `estudiantes_db`.`estudiante` (
  `id_estudiante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id_estudiante`));


select * from estudiante;

/******************************************/
/*****************CRUD*******************/

/*----CREATE-----*/
insert INTO estudiante (nombre, apellido, telefono, email) values ("Katte", "Geral", "9851562062", "geraldine@gmail.com");
insert INTO estudiante (nombre, apellido, telefono, email) values ("Sandra", "Dream", "8591562062", "sandra@gmail.com");


/*----UPDATE-----*/
Update estudiante set nombre = "Katherine",
					  apellido = "Munoz"
Where id_estudiante = 1;

/*----Delete-----*/
delete from estudiante where id_estudiante = 1;

select * from estudiante where id_estudiante = 2;





create database empleados_db;
use  empleados_db;


create table empleado(

	id_empleado int not null primary key auto_increment,
    nombre varchar(100) null,
    apellido varchar(100) null,
    dni int null,
    telefono varchar(100) null,
    email varchar(50) null
);


insert into empleado (nombre, apellido, dni, telefono, email) values ("Wilson","Hemet", 75919591,"985152050","em@gmail.com");
insert into empleado (nombre, apellido, dni, telefono, email) values ("Josue","Becerra", 20948357,"945718369","jb@gmail.com");
insert into empleado (nombre, apellido, dni, telefono, email) values ("Xiomara","Lazaro", 73581426,"984327156","xl@gmail.com");
insert into empleado (nombre, apellido, dni, telefono, email) values ("Gianella","Arellano", 16253980,"932654189","ga@gmail.com");
insert into empleado (nombre, apellido, dni, telefono, email) values ("Michael","Bocanegra", 94826715,"976582413","mb@gmail.com");
insert into empleado (nombre, apellido, dni, telefono, email) values ("Edica","Rojas", 57382046,"997641825","er@gmail.com");

select * from empleado;


drop database empleados_db;
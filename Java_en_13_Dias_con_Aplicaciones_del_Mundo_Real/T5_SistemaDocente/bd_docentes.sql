create database bd_docentes;
use bd_docentes;

create table docentes(
	id_docente int not null primary key auto_increment,
    nombre varchar(50) NULL,
    apellido varchar(50) null,
    telefono varchar(50) null,
    email varchar(50) null,
    estado bit default 1  null
);

drop table docentes;


insert into docentes (nombre, apellido, telefono, email) values ("Kumiko","Salzedo","956325632","ks@gmail.com");
insert into docentes (nombre, apellido, telefono, email) values ("Nora","Inga","9222222222","ni@gmail.com");
insert into docentes (nombre, apellido, telefono, email) values ("Midory","Rubina","9444444444","ni@gmail.com");
insert into docentes (nombre, apellido, telefono, email) values ("Ashely","Mendoza","9229865521","am@gmail.com");

insert into docentes (nombre, apellido, telefono, email) values ("Luz","Soto","9229865521","am@gmail.com");
insert into docentes (nombre, apellido, telefono, email) values ("Xiomara","Ballena","9229865521","am@gmail.com");
insert into docentes (nombre, apellido, telefono, email) values ("Jairo","Trujillo","9229865521","am@gmail.com");
insert into docentes (nombre, apellido, telefono, email) values ("Diego","Rojo","9229865521","am@gmail.com");

update docentes set estado = 1
	   where id_docente = 6;
       
update docentes set nombre="Nora", apellido="Inga", telefono="9222222220", email="ni@gmail.com"
		where id_docente = 2;

select * from docentes;

select * from docentes where estado = 1;

select * from docentes where estado = 0;

select * from docentes where id_docente = 6 and estado = 1;

drop procedure usp_estadoDocente;

delimiter $
 create procedure usp_estadoDocente(IN id int)
 begin
   update docentes set estado = 0
	   where id_docente = id;
 end $
 delimiter ;
 
CALL usp_estadoDocente(8);






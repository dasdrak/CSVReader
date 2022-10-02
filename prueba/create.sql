create table user (nombre varchar(255) not null, dni varchar(255), fecha_de_nacimiento varchar(255), email varchar(255), apellidos varchar(255), primary key (nombre)) engine=InnoDB;
alter table hibernate_sequence add column nombre varchar(255) not null;
alter table hibernate_sequence add column dni varchar(255);
alter table hibernate_sequence add column fecha_de_nacimiento varchar(255);
alter table hibernate_sequence add column email varchar(255);
alter table hibernate_sequence add column apellidos varchar(255);

create database projetopoo;
use projetopoo;

create table login(
	usuario varchar(30) primary key not null,
    senha varchar(16) not null
);

create table cadastro(
	idcadastro int not null auto_increment primary key,
    nome varchar(100),
    idade int not null,
    altura int not null,
    peso int not null
);

select * from cadastro;
select * from login;




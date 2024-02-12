/* Script desenvolvido Por Osvaldo Sandoli*/
/* Script banco de dados com criação de tabelas e inclusão de dados ficticios para o projeto integrador*/

USE DBCUSTOM;

/*INICIO DROPS DE TABELAS*/
DROP TABLE USUARIOS;
DROP TABLE clientes;
DROP TABLE tbos;
/*FIM DROPS DE TABELAS*/ 

/* INICIO CREATE TABLES*/
CREATE TABLE USUARIOS (
	id int  AUTO_INCREMENT PRIMARY KEY,
	usuario VARCHAR(50),
	senha VARCHAR(50),
	perfil VARCHAR(50)
);

/* Inserindo o primeiro usuario do sistema */
/* 
LOGIN: ADM
SENHA: 123
*/

insert into USUARIOS () VALUES(
1,
'ADM',
'123',
'202cb962ac59075b964b07152d234b70'
);

create table clientes(
    idcli int AUTO_INCREMENT PRIMARY KEY, 
    nome VARCHAR(50) NOT NULL, 
    fone VARCHAR(13) NOT NULL,
    uf VARCHAR(2) NOT NULL, 
    endereco VARCHAR(100), 
    numero INT NOT NULL, 
    cep VARCHAR(8) NOT NULL, 
    complemento VARCHAR(50), 
    bairro VARCHAR(50), 
    cidade VARCHAR(50), 
    fone2 VARCHAR(50)
);

create table tbos(
os int AUTO_INCREMENT PRIMARY KEY,
tipo varchar(50) NOT NULL,
osstatus varchar(50) NOT NULL,
modelo varchar(50) NOT NULL,
marca varchar(50) NOT NULL,
servico varchar(50) NOT NULL,
tecnico varchar(50) NOT NULL,
valor numeric NOT NULL,
dataret date NOT NULL,
idcli int NOT NULL,
FOREIGN KEY (idcli) REFERENCES clientes(idcli),
datainc TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);

/* FIM CREATE TABLES */

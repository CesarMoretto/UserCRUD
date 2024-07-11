--DROP DATABASE CadastroUsuarioDB

CREATE DATABASE CadastroUsuarioDB;

USE CadastroUsuarioDB;

CREATE TABLE usuarios (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nome NVARCHAR(100) NOT NULL,
    email NVARCHAR(100) NOT NULL,
    senha NVARCHAR(100) NOT NULL
);

SELECT * FROM usuarios;


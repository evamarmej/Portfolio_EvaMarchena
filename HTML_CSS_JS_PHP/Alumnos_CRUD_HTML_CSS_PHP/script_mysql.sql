CREATE DATABASE puntuable4ldm;

CREATE TABLE alumnos (
    codigo INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    foto LONGBLOB NOT NULL
);
DROP DATABASE IF EXISTS restaurante;

CREATE DATABASE Restaurante;

USE Restaurante;

DROP TABLE IF EXISTS articulo;
DROP TABLE IF EXISTS servicio;
DROP TABLE IF EXISTS oid;

CREATE TABLE servicio (
  oid INT NOT NULL,
  id INT NOT NULL,
  mozoUsuario varchar(20),
  PRIMARY KEY (id)
);

INSERT INTO servicio(oid, id, mozoUsuario) VALUES(1, 10000, 'vincentes'), (2, 10001, ''), (3, 10002, ''), (4, 10004, '');

CREATE TABLE articulo (
oid INT NOT NULL,
codigo INT NOT NULL,
producto INT NOT NULL,
cantidad INT NOT NULL,
descripcion VARCHAR(200) NOT NULL,
servicio INT NOT NULL,
PRIMARY KEY(codigo)
);

INSERT INTO articulo(oid, codigo, producto, cantidad, descripcion, servicio) 
VALUES(1, 20000, -1, 30, "Todo bien", 10000), (2, 20001, -1, 20, "Quiere papas", 10000),
(3, 20002, -1, 10, "Sin pepino", 10000),

(4, 20003, -1, 10, "", 10001);

CREATE TABLE oid (
valor INT NOT NULL,
PRIMARY KEY (valor)
);

INSERT INTO oid(valor) VALUES(23);


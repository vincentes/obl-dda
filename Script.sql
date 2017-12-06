CREATE DATABASE Restaurante;

USE Restaurante;

CREATE TABLE TipoCliente(tipo VARCHAR(20) UNIQUE);

CREATE TABLE Cliente(cliente_id INT NOT NULL AUTO_INCREMENT, 
cliente_nombre VARCHAR(40), 
cliente_email VARCHAR(70), 
cliente_tipo VARCHAR(20) NOT NULL, 
PRIMARY KEY (cliente_id), 
FOREIGN KEY (cliente_tipo) REFERENCES TipoCliente(tipo));

CREATE TABLE Servicio(servicio_id INT NOT NULL AUTO_INCREMENT, PRIMARY KEY (servicio_id));

CREATE TABLE Producto(codigo INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(40),
precio INT NOT NULL,
stock INT NOT NULL,
PRIMARY KEY (codigo)); 

CREATE TABLE Articulo(articulo_codigo INT NOT NULL AUTO_INCREMENT,
articulo_producto INT,
articulo_cantidad INT,
articulo_desc VARCHAR(200),
articulo_servicio INT,
FOREIGN KEY (articulo_servicio) REFERENCES Servicio(servicio_id),
PRIMARY KEY (articulo_codigo),
FOREIGN KEY (articulo_producto) REFERENCES Producto(codigo));


CREATE TABLE ServicioArticulo(servicio_id INT NOT NULL, articulo_codigo INT NOT NULL, FOREIGN KEY (servicio_id) REFERENCES Servicio(servicio_id),
FOREIGN KEY (articulo_codigo) REFERENCES Articulo(articulo_codigo));


INSERT INTO tipocliente VALUES("comun"), ("preferencial"), ("casa");



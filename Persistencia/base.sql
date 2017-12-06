/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.7.20-log : Database - dan4a
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dan4a` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dan4a`;

/*Table structure for table `factura` */

DROP TABLE IF EXISTS `factura`;

CREATE TABLE `factura` (
  `oid` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `datosCabezal` varchar(50) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `factura` */

insert  into `factura`(`oid`,`numero`,`datosCabezal`) values 
(20,5005,'Datos Cabezal nuevo para 5005'),
(21,5006,'Datos Cabezal nuevo para 5006');

/*Table structure for table `linea` */

DROP TABLE IF EXISTS `linea`;

CREATE TABLE `linea` (
  `oid` int(11) NOT NULL,
  `numeroF` int(11) NOT NULL,
  `numeroLinea` int(11) NOT NULL,
  `datosLinea` varchar(50) NOT NULL,
  PRIMARY KEY (`numeroF`,`numeroLinea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `linea` */

insert  into `linea`(`oid`,`numeroF`,`numeroLinea`,`datosLinea`) values 
(20,5005,1,'Datos linea 1 - 5005'),
(21,5006,1,'L1 - 5006'),
(21,5006,2,'L2 - 5006');

/*Table structure for table `oid` */

DROP TABLE IF EXISTS `oid`;

CREATE TABLE `oid` (
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`valor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `oid` */

insert  into `oid`(`valor`) values 
(23);

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `oid` int(11) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usuario` */

insert  into `usuario`(`oid`,`nombre`,`password`) values 
(9,'CAMBIO!','CAMBIOP'),
(13,'Juan con MapeadorU','mp'),
(6,'Nuevo','pn'),
(8,'Nuevo2','pn2'),
(10,'Nuevo3','pn3'),
(12,'Nuevo4','pn4'),
(14,'Pedro con MapeadorU','mp');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

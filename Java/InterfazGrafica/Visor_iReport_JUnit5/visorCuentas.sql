-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.11-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para visor
CREATE DATABASE IF NOT EXISTS `visor` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `visor`;

-- Volcando estructura para tabla visor.cuentas
CREATE TABLE IF NOT EXISTS `cuentas` (
  `id` int(3) NOT NULL,
  `titular` varchar(30) NOT NULL,
  `fecha` date NOT NULL DEFAULT curdate(),
  `nacionalidad` varchar(15) NOT NULL,
  `saldo` double(22,0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla visor.cuentas: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` (`id`, `titular`, `fecha`, `nacionalidad`, `saldo`) VALUES
	(1, 'Eva Marchena Mejias', '2004-05-15', 'España', 2501),
	(2, 'Antonio José García Sanchez', '2008-12-30', 'España', 681),
	(3, 'Marta Almazán Marchena', '2008-02-04', 'España', 2016),
	(4, 'Elena Martínez Garrido', '1998-09-13', 'España', 2636),
	(5, 'Gema García Viñuales', '2003-09-15', 'España', 1830),
	(6, 'Almudena Pozo Díaz', '2008-08-23', 'Italia', 2521),
	(7, 'Sara Repeto García', '2020-12-10', 'Rumanía', 523),
	(13, 'Antono García Pérez', '2020-12-06', 'España', 5028),
	(14, 'Agustín Marchena Muñoz', '2020-06-21', 'España', 4444);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

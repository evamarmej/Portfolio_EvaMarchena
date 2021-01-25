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


-- Volcando estructura de base de datos para cm_smart_crud
CREATE DATABASE IF NOT EXISTS `cm_smart_crud` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `cm_smart_crud`;

-- Volcando estructura para tabla cm_smart_crud.tb_smart_crud
CREATE TABLE IF NOT EXISTS `tb_smart_crud` (
  `autoid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`autoid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla cm_smart_crud.tb_smart_crud: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_smart_crud` DISABLE KEYS */;
INSERT INTO `tb_smart_crud` (`autoid`, `firstname`, `lastname`, `gender`) VALUES
	(4, 'Eva', 'Marchena Mejías', 'Femenino'),
	(5, 'Antonio José', 'García Sánchez', 'Masculino'),
	(10, 'DDINT', 'Interfaces', 'Femenino');
/*!40000 ALTER TABLE `tb_smart_crud` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

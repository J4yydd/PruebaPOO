-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 01-12-2024 a las 23:18:14
-- Versión del servidor: 8.3.0
-- Versión de PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gannetbase`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agroquimico`
--

DROP TABLE IF EXISTS `agroquimico`;
CREATE TABLE IF NOT EXISTS `agroquimico` (
  `ID` int NOT NULL,
  `ALCANCE` int DEFAULT NULL,
  `CAPACIDAD` int DEFAULT NULL,
  `CATEGORIA` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `PRECIO` int DEFAULT NULL,
  `TIPOPLAGA` varchar(255) COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `agroquimico`
--

INSERT INTO `agroquimico` (`ID`, `ALCANCE`, `CAPACIDAD`, `CATEGORIA`, `NOMBRE`, `PRECIO`, `TIPOPLAGA`) VALUES
(1, 1000, 1, 'Herbicida', 'minecto', 750, 'plantas'),
(51, 1000, 1, 'fungicida', 'verango', 10000, 'senisilla'),
(151, 1000, 1, 'fungicida', 'talstar', 860, 'hoja ancha'),
(201, 1000, 8, 'incecticida', 'daconil', 1300, 'gusano'),
(251, 1050, 1, 'herbicida', 'spareFluid', 1250, 'pasto'),
(351, 3, 2, 'fffffassss', 'hhhffh', 123, 'dsdddd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sequence`
--

DROP TABLE IF EXISTS `sequence`;
CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) COLLATE utf8mb3_spanish_ci NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;

--
-- Volcado de datos para la tabla `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', 400);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

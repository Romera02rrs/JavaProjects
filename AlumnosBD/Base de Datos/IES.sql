-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 15, 2021 at 12:46 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `IES`
--

-- --------------------------------------------------------

--
-- Table structure for table `ALUMNOS`
--

CREATE TABLE `ALUMNOS` (
  `NIA` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `apellido` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `correo` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `ALUMNOS`
--

INSERT INTO `ALUMNOS` (`NIA`, `nombre`, `apellido`, `correo`, `telefono`) VALUES
(123456789, 'Ruben', 'Romera', 'ruben.romera@correo.com', 111111111),
(147258369, 'Jordi', 'Garcia', 'jordi.garcia@correo.com', 333333333),
(789456123, 'Joan', 'Pons', 'joan.pons@correo.com', 444444444),
(987654321, 'Joan', 'Molina', 'joan.molina@correo.com', 222222222);

-- --------------------------------------------------------

--
-- Table structure for table `ASIGNATURAS`
--

CREATE TABLE `ASIGNATURAS` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `abreviatura` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `horas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `ASIGNATURAS`
--

INSERT INTO `ASIGNATURAS` (`codigo`, `nombre`, `descripcion`, `abreviatura`, `horas`) VALUES
(1, 'Programacion', 'Programacion en Java.', 'Prog', 256),
(2, 'Lenguaje de Marcas', 'HTML, XML, XHTML, DTD, RSS, XSLT y mucho mas.', 'LMSGI', 56),
(3, 'Entornos de desarrollo', 'Entornos de desarrollo como Eclipse, Netbeans, IntelliJ y mucho mas.', 'EDD', 56),
(4, 'Base de datos', 'Gestion y almacenamiento de datos con gestores de base de datos.', 'BD', 156);

-- --------------------------------------------------------

--
-- Table structure for table `RESULTADOS`
--

CREATE TABLE `RESULTADOS` (
  `ALUMNOS_NIA` int(11) NOT NULL,
  `ASIGNATURAS_codigo` int(11) NOT NULL,
  `nota` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Dumping data for table `RESULTADOS`
--

INSERT INTO `RESULTADOS` (`ALUMNOS_NIA`, `ASIGNATURAS_codigo`, `nota`) VALUES
(123456789, 1, 5),
(123456789, 2, 4),
(123456789, 3, 4),
(123456789, 4, 2),
(147258369, 1, 8),
(147258369, 2, 6),
(147258369, 3, 9),
(147258369, 4, 4),
(789456123, 1, 9),
(789456123, 2, 1),
(789456123, 3, 2),
(789456123, 4, 8),
(987654321, 1, 3),
(987654321, 2, 7),
(987654321, 3, 6),
(987654321, 4, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ALUMNOS`
--
ALTER TABLE `ALUMNOS`
  ADD PRIMARY KEY (`NIA`);

--
-- Indexes for table `ASIGNATURAS`
--
ALTER TABLE `ASIGNATURAS`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `RESULTADOS`
--
ALTER TABLE `RESULTADOS`
  ADD PRIMARY KEY (`ALUMNOS_NIA`,`ASIGNATURAS_codigo`),
  ADD KEY `fk_ALUMNES_has_ASSIGNATURES_ASSIGNATURES1_idx` (`ASIGNATURAS_codigo`),
  ADD KEY `fk_ALUMNES_has_ASSIGNATURES_ALUMNES_idx` (`ALUMNOS_NIA`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `RESULTADOS`
--
ALTER TABLE `RESULTADOS`
  ADD CONSTRAINT `fk_ALUMNES_has_ASSIGNATURES_ALUMNES` FOREIGN KEY (`ALUMNOS_NIA`) REFERENCES `ALUMNOS` (`NIA`),
  ADD CONSTRAINT `fk_ALUMNES_has_ASSIGNATURES_ASSIGNATURES1` FOREIGN KEY (`ASIGNATURAS_codigo`) REFERENCES `ASIGNATURAS` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

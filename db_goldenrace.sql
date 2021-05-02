-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-05-2021 a las 23:15:32
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_goldenrace`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `creation_date` date DEFAULT NULL,
  `total_amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`id`, `creation_date`, `total_amount`) VALUES
(1, '2021-05-02', 8),
(2, '2021-04-01', 5),
(3, '2021-05-01', 3),
(4, '2021-02-01', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket_details`
--

CREATE TABLE `ticket_details` (
  `ticket_id` int(11) NOT NULL,
  `details_lineid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket_line`
--

CREATE TABLE `ticket_line` (
  `lineid` int(11) NOT NULL,
  `ticketid` int(11) NOT NULL,
  `amount` double NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ticket_line`
--

INSERT INTO `ticket_line` (`lineid`, `ticketid`, `amount`, `description`) VALUES
(1, 1, 5, 'First time'),
(2, 1, 3, 'prueba'),
(3, 3, 1, 'First time'),
(4, 3, 1, 'Second time'),
(5, 3, 1, 'Third time'),
(6, 4, 2, 'Only one time'),
(7, 2, 5, 'Second ticket');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ticket_details`
--
ALTER TABLE `ticket_details`
  ADD UNIQUE KEY `UK_ghbeq5ddm4x7wrl11vo8g5dmf` (`details_lineid`),
  ADD KEY `FKb1br3oee2cdhs88ogtbk15n1s` (`ticket_id`);

--
-- Indices de la tabla `ticket_line`
--
ALTER TABLE `ticket_line`
  ADD PRIMARY KEY (`lineid`),
  ADD KEY `fticketid` (`ticketid`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ticket_line`
--
ALTER TABLE `ticket_line`
  MODIFY `lineid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ticket_details`
--
ALTER TABLE `ticket_details`
  ADD CONSTRAINT `FKb1br3oee2cdhs88ogtbk15n1s` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`),
  ADD CONSTRAINT `FKffc3bastrukhor123eht43jsf` FOREIGN KEY (`details_lineid`) REFERENCES `ticket_line` (`lineid`);

--
-- Filtros para la tabla `ticket_line`
--
ALTER TABLE `ticket_line`
  ADD CONSTRAINT `fticketid` FOREIGN KEY (`ticketid`) REFERENCES `ticket` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

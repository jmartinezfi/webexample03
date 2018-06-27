CREATE TABLE `Marca` (
  `codigoMarc` int(11) NOT NULL,
  `nombreMarc` varchar(100) NOT NULL,
  `apellidoMarc` varchar(100) NOT NULL,
  `estadoMarc` varchar(100) NOT NULL
);
ALTER TABLE `Marca` ADD PRIMARY KEY (`codigoMarc`);
INSERT INTO `sistema_secuencias` (`ID_SECUENCIA`, `TABLA`, `SECUENCIA`, `SISTEMA`) VALUES (1, 'codigoMarc', '99', '1');
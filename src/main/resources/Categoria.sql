CREATE TABLE `Categoria` (
  `codigoCate` int(11) NOT NULL,
  `nombreCate` varchar(100) NOT NULL,
  `descripcionCate` varchar(200) NOT NULL,
  `detalleCate` varchar(100) NOT NULL,
  `estadoCate` varchar(100) NOT NULL
);
ALTER TABLE `Categoria` ADD PRIMARY KEY (`codigoCate`);
INSERT INTO `sistema_secuencias` (`ID_SECUENCIA`, `TABLA`, `SECUENCIA`, `SISTEMA`) VALUES (0, 'codigoCate', '99', '1');
CREATE TABLE `Producto` (
  `codigoProd` int(11) NOT NULL,
  `nombreProd` varchar(100) NOT NULL,
  `descripcionProd` varchar(100) NOT NULL,
  `codigoMarcProd` int(11) NOT NULL,
  `codigoCateProd` int(11) NOT NULL,
  `estadoProd` varchar(100) NOT NULL
);
ALTER TABLE `Producto` ADD PRIMARY KEY (`codigoProd`);
INSERT INTO `sistema_secuencias` (`ID_SECUENCIA`, `TABLA`, `SECUENCIA`, `SISTEMA`) VALUES (2, 'codigoProd', '99', '1');
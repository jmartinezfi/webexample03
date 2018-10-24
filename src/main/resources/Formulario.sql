CREATE TABLE `Formulario` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `version` varchar(10) NOT NULL,
  `jsp` longtext null,
  `bean` text,
  `descripcion` text NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL
);
ALTER TABLE `Formulario` ADD PRIMARY KEY (`codigo`);
INSERT INTO `sistema_secuencias` (`ID_SECUENCIA`, `TABLA`, `SECUENCIA`, `SISTEMA`) VALUES (0, 'codigo', '99', '1');
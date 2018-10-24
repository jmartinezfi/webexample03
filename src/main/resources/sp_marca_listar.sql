CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_marca_listar`()
BEGIN
SELECT * FROM marca;
END
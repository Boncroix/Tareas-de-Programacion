-- -----------------------------------------------------------------------------------------
-- Conjunto de datos de prueba para la aplicación JPA-JDBC 
-- -----------------------------------------------------------------------------------------

-- Entidad seccion
INSERT INTO seccion (id_seccion,descripcion) VALUES ('01','Perfumería');
INSERT INTO seccion (id_seccion,descripcion) VALUES ('02','Alimentación');
INSERT INTO seccion (id_seccion,descripcion) VALUES ('03','Bebidas');
INSERT INTO seccion (id_seccion,descripcion) VALUES ('04','Hogar');

-- Entidad producto
INSERT INTO producto (id_producto,descripcion,precio,id_seccion,stock_actual) VALUES ('0001','Perfume -Chavel Number 5-',100,'01',10);
INSERT INTO producto (id_producto,descripcion,precio,id_seccion,stock_actual) VALUES ('0002','Perfume -Dioor Nuit Noir-',50,'01',7);
INSERT INTO producto (id_producto,descripcion,precio,id_seccion,stock_actual) VALUES ('0003','Cereales -Desayuno de campeones-',13,'02',56);
INSERT INTO producto (id_producto,descripcion,precio,id_seccion,stock_actual) VALUES ('0004','Agua de colonia -Bulfari Fresh-',30,'01',3);
INSERT INTO producto (id_producto,descripcion,precio,id_seccion,stock_actual) VALUES ('0005','Pollo -Mi pechuga es tuya-',17,'02',24);
INSERT INTO producto (id_producto,descripcion,precio,id_seccion,stock_actual) VALUES ('0006','Morcilla picante -Estoy que ardo-',7,'02',13);
INSERT INTO producto (id_producto,descripcion,precio,id_seccion,stock_actual) VALUES ('0007','Agua con gas -Refresca más-',0.9,'03',38);
INSERT INTO producto (id_producto,descripcion,precio,id_seccion,stock_actual) VALUES ('0008','Cepillo -Stop pelusas-',16,'04',10);

-- Entidad empleado
INSERT INTO empleado (id_empleado,nombre,id_seccion,salario_anual) VALUES ('0001','Alonso Quijano ','01',25000);
INSERT INTO empleado (id_empleado,nombre,id_seccion,salario_anual) VALUES ('0002','Aldonza Lorenzo','02',28000);
INSERT INTO empleado (id_empleado,nombre,id_seccion,salario_anual) VALUES ('0003','Sancho Panza','01',20000);
INSERT INTO empleado (id_empleado,nombre,id_seccion,salario_anual) VALUES ('0004','Juan Palomeque','03',19000);
INSERT INTO empleado (id_empleado,nombre,id_seccion,salario_anual) VALUES ('0005','Sansón Carrasco ','02',30000);
INSERT INTO empleado (id_empleado,nombre,id_seccion,salario_anual) VALUES ('0006','Dulcinea Toboso  ','04',22500);


-- -----------------------------------------------------------------------------------------

INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (1,'Trujillo','La Libertad','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (2,'Amazonas','Bagua','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (3,'Ancash','Huaraz','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (4,'Apurimac','Andahuaylas','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (5,'Arequipa','Arequipa','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (6,'Ayacucho','Lucanas','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (7,'Cajamarca','Cajabamba','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (8,'Cusco','Anta','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (9,'Huancavelica','Angaraes','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (10,'Huanuco','Dos de Mayo','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (11,'Ica','Chincha','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
INSERT INTO ciudad (id_ciudad,provincia,departamento,fecha_Creacion) VALUES (12,'Junin','Satipo','2022-07-25') ON CONFLICT (id_ciudad) DO NOTHING;
--SELECT p.n_documento AS N_DOCU,p.fecha_pedido AS EMITIDO,
--		pro.descripcion AS PRODUCTO,SUM( dp.cantidad * dp.precio )TOTAL,
--		c.cliente_ruc AS RUC,c.cliente_apellidos AS APELLIDO,c.cliente_nombres AS NOMBRE
--FROM detalle_pedido dp INNER JOIN pedido p ON
--dp.id_pedido = p.id_pedido INNER JOIN producto pro ON
--dp.producto_id = pro.producto_id
--INNER JOIN cliente c ON c.cliente_id = p.cliente_id
--INNER JOIN categoria_producto catego ON catego.id_categoria =pro.id_categoria
--GROUP BY p.n_documento,p.fecha_pedido,TOTAL,
--pro.descripcion,pro.precio,
--c.cliente_ruc,c.cliente_apellidos,c.cliente_nombres;

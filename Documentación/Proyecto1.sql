/*INICAR BASE DE DATOS*/
CREATE DATABASE electronic_homesP1;
/*SCHEMAS*/
CREATE SCHEMA ControlAdmin;
CREATE SCHEMA ControlProduct;
CREATE SCHEMA ControlVenta;

/*TABLAS*/

CREATE TABLE ControlAdmin.Sucursal(
    codigo_id VARCHAR(8) NOT NULL,
    nombre VARCHAR (50) NOT NULL,
    PRIMARY KEY (codigo_id)
);

CREATE TABLE ControlAdmin.Empleado(
    cod_empleado VARCHAR(8) NOT NULL,
    nombre VARCHAR (50) NOT NULL,
    contraseña VARCHAR (50) NOT NULL,
    rango VARCHAR (10) NOT NULL,
    cod_sucursal VARCHAR(8) NOT NULL,
    PRIMARY KEY (cod_empleado),
    FOREIGN KEY (cod_sucursal) REFERENCES ControlAdmin.Sucursal(codigo_id)
);

CREATE TABLE ControlAdmin.Cliente(
    nit VARCHAR(13) NOT NULL,
    nombre VARCHAR (50) NOT NULL,
    apellido VARCHAR (50) NOT NULL,
    PRIMARY KEY (nit)
);

CREATE TABLE ControlProduct.Producto(
    sku VARCHAR(8) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    precio DECIMAL (8,2) NOT NULL,
    descripcion VARCHAR(250) NOT NULL,
    PRIMARY KEY (sku)
);

CREATE TABLE ControlProduct.Inventario(
    registro VARCHAR(8) NOT NULL,
    sku_producto VARCHAR(8) NOT NULL,
    cod_sucursal VARCHAR(8) NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (registro),
    FOREIGN KEY (sku_producto) REFERENCES ControlProduct.Producto(sku),
    FOREIGN KEY (cod_sucursal) REFERENCES ControlAdmin.Sucursal(codigo_id)
);

CREATE TABLE ControlVenta.Factura(
    no_factura VARCHAR(8) NOT NULL,
    cod_vendedor VARCHAR(8) NOT NULL,
    cod_sucursal VARCHAR(8) NOT NULL,
    nit_cliente VARCHAR(13) NOT NULL,
    fecha DATE NOT NULL,
    total DECIMAL (8,2) NOT NULL,
    PRIMARY KEY (no_factura),
    FOREIGN KEY (cod_vendedor) REFERENCES ControlAdmin.Empleado(cod_empleado),
    FOREIGN KEY (cod_sucursal) REFERENCES ControlAdmin.Sucursal(codigo_id),
    FOREIGN KEY (nit_cliente) REFERENCES ControlAdmin.Cliente(nit)
);

CREATE TABLE ControlVenta.Venta(
    registro VARCHAR(8) NOT NULL,
    num_factura VARCHAR(8) NOT NULL,
    sku_producto VARCHAR(8) NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (registro),
    FOREIGN KEY (sku_producto) REFERENCES ControlProduct.Producto(sku),
    FOREIGN KEY (num_factura) REFERENCES ControlVenta.Factura(no_factura)
);

/*INSERTS SUCURSALES*/
INSERT INTO ControlAdmin.Sucursal VALUES ('BC','Bodega Central');
INSERT INTO ControlAdmin.Sucursal VALUES ('SUC3','Sucursal Central');
INSERT INTO ControlAdmin.Sucursal VALUES ('SUN0','Sucursal Norte');
INSERT INTO ControlAdmin.Sucursal VALUES ('SUSU4','Sucursal Sur');

/*INSERTS PRODUCTOS*/

INSERT INTO ControlProduct.Producto VALUES ('P1','Refrigeradora Top Mount de 13 plg','LG','Refrigerador',4499.00,'Cajón Moist Balance Crisper y Multi Air Flow para mantener mas frescos los alimentos. Iluminación LED y compresor Inverter para ahorro de energía');
INSERT INTO ControlProduct.Producto VALUES ('P2','Refrigeradora Top Mount de 12 pgl','Samsung','Refrigerador',4999.00,'Frescura y humedad total en toda la nevera, alimentos congelados increíblemente sabrosos y sin olor.');
INSERT INTO ControlProduct.Producto VALUES ('P3','Refrigeradora Top Mount de 14 pgl','mabe','Refrigerador',5699.00,' Gran espacio interior que permite almacenar alimentos y recipientes de distintos tamaños. • Anaquel especial para almacenar botellas de hasta 3 litros. • Conveniente dispensador de agua con 2 litros de capacidad.');
INSERT INTO ControlProduct.Producto VALUES ('P4','Refrigeradora French Door de 20 plg','Whirlpool','Refrigerador',10499.00,'Refrigeradora French Door de 20 cúbicos con sistema de filtración EveryDrop, Whirlpool MWRF220SEHM.');
INSERT INTO ControlProduct.Producto VALUES ('P5','Refrigeradora Frost con dispensador de 7 pies','Hisense','Refrigerador',10499.00,'Congelador Independiente, Dispensador de agua, Deshielo semi automático, Anaqueles ajustables.');
INSERT INTO ControlProduct.Producto VALUES ('P6','Estufa a gas de 24", color negro.','Whirlpool','Estufa',2399.00,'Estufa a gas de 24", color negro. Whirlpool WEG60BK.');
INSERT INTO ControlProduct.Producto VALUES ('P7','Estufa a gas de 30", 6 quemadores, color negro.','Frigidaire','Estufa',3599.00,'Estufa a gas de 30", 6 quemadores, color negro. Frigidaire FKGI30L3MKB.');
INSERT INTO ControlProduct.Producto VALUES ('P8','Estufa eléctrica de 30", top cerámico','Whirlpool','Estufa',5799.00,'Estufa eléctrica de 30", top cerámico, acabado en acero.');
INSERT INTO ControlProduct.Producto VALUES ('P9','Estufa a gas de 30" con parrillas de hierro','mabe','Estufa',3999.00,'Parrillas de fundición que permiten mover las ollas con mayor facilidad.Quemadores potentes.Recubrimiento interior Easy Clean Pro tan fácil de limpiar como un vidrio.');
INSERT INTO ControlProduct.Producto VALUES ('P10','Estufa a gas de 30" con tecnología EasyClean','LG','Estufa',6999.00,'Estufa a gas de 30" con tecnología EasyClean™ y quemador Triple Flama UltraHeat™');
INSERT INTO ControlProduct.Producto VALUES ('P11','Lavadora de ropa, 37 libras de capacidad, blanca','Frigidaire','Lavadora',3599.00,'Lavadora de ropa, 37 libras de capacidad, tina de acero, color blanco.');
INSERT INTO ControlProduct.Producto VALUES ('P12','Lavadora de 42 lbs. tecnología dual storm','Frigidaire','Lavadora',3999.00,'Motor Inverter para ahorro de energía, Dual Storm para lavadas más eficientes y filtro atrapa motas.');
INSERT INTO ControlProduct.Producto VALUES ('P13','Lavadora de ropa, 44 libras, con Xpert System','Whirlpool','Lavadora',3999.00,'Lavadora de ropa, 44 libras de capacidad con Xpert System, tina de acero.');
INSERT INTO ControlProduct.Producto VALUES ('P14','Lavadora de ropa, 42 libras, blanca','Whirlpool','Lavadora',4299.00,'Lavadora de ropa, 42 libras de capacidad, blanca, 11 ciclos de lavado, tina de acero porcelanizado.');
INSERT INTO ControlProduct.Producto VALUES ('P15','Secadora eléctrica de 48 libras, color blanco. ','Samsung','Lavadora',4499.00,'Secadora de gran capacidad, la función Sensor Dry permite un ciclo de secado con la temperatura y el tiempo óptimos. Los sensores de humedad también protegen tu ropa y evitan el uso excesivo de energía.');
INSERT INTO ControlProduct.Producto VALUES ('P16','Samsung LH32BETBLG 32" Smart TV LED HD','Samsung','Televisión',2499.00,'Samsung LH32BETBLG 32" Smart LED TV HD, Pantalla LED de 32", High Definition, Sistema operativo: Tizen, Business TV app');
INSERT INTO ControlProduct.Producto VALUES ('P17','Toshiba 43V35KB 43" Smart LED Full HD','Toshiba','Televisión',2299.00,'TELEVISOR LED 43" SMART FULL HD, Pantalla LED de 43", Sistema Operativo VIDAA, Smart Full HD');
INSERT INTO ControlProduct.Producto VALUES ('P18','Sony KD55X80K 55" Smart (GoogleTV)','Sony','Televisión',7999.00,'Sony KD55X80K 55" Smart (GoogleTV) LED TV 4K-Ultra HD');
INSERT INTO ControlProduct.Producto VALUES ('P19','Toshiba 32V35KB 32" ','Toshiba','Televisión',1599.00,'Toshiba 32V35KB 32" Smart LED TV HD, Pantalla LED de 32", Sistema Operativo VIDAA, High Definition');
INSERT INTO ControlProduct.Producto VALUES ('P20','LG 70UP7070 70" Smart LED','LG','Televisión',6889.00,'Pantalla 4K real con resolución 4K UHD, Procesador de cuatro núcleos 4K.');
INSERT INTO ControlProduct.Producto VALUES ('P21','Montura de pared Barkan para TV','Barkan','Accesorio',1299.00,'Montura de pared Barkan para TV curva y plana de doble brazo 13" a 90"');
INSERT INTO ControlProduct.Producto VALUES ('P22','Estuche Samsung The Freestyle TV','Samsung','Accesorio',499.00,'Estuche Samsung The Freestyle TV');
INSERT INTO ControlProduct.Producto VALUES ('P23','RCA Cable HDMI Alta Velocidad 8K','RCA','Accesorio',125.00,'RCA Cable HDMI Alta Velocidad 8K para Gaming, Certificado para uso Gamer, 8K UHD, 6 Pies de largo.');
INSERT INTO ControlProduct.Producto VALUES ('P24','ROKU EXPRESS 4K','ROKU','Accesorio',349.00,'Ideal para TV 4K y HDR, Incluye cable HDMI de alta velocidad');
INSERT INTO ControlProduct.Producto VALUES ('P25','BarkanT71FS Soporte','Barkan','Accesorio',499.00,'BarkanT71FS Soporte para Smartphone/ Tablet con ajuste vertical');
INSERT INTO ControlProduct.Producto VALUES ('P26','Consola Nintendo Switch™ Modelo OLED','Nintendo','Gaming',4449.00,'Consola Nintendo Switch™ Modelo OLED, Vibrante pantalla OLED de 7" (17.78 cm), Soporte resistente, ajustable y amplio para disfrutar del modo semiportátil, Base con puerto LAN para conexión por cable, Almacenamiento interno de 64GB, Audio mejorado.');
INSERT INTO ControlProduct.Producto VALUES ('P27','Laptop HP Victus 16-d0506la de 16.1"','HP','Tecnologia',8799.00,'Laptop HP Victus 16-do506la, Pantalla FHD 16", Procesador Intel Core i5 11400H, Memoria RAM 8GB, Almacenamiento 512 GB SSD, Tarjeta gráfica Nvidia GeForce RTX3050 4GB, Sistema operativo Windows 11, Color Perf Blue, Chasis Calhoun.');
INSERT INTO ControlProduct.Producto VALUES ('P28','Consola PlayStation 5 Standard Edition','Sony','Gaming',7499.00,'Consola PlayStation 5 Standard Edition God of War Ragnarok Bundle, incluye cupón de juego completo de God of War Ragnarök.');
INSERT INTO ControlProduct.Producto VALUES ('P29','Juego PS5 Call of Duty','Sony','Gaming',719.00,'Juego PS5 Call of Duty: Modern Warfare 2, Género: Acción, Clasificación: Mature 17+, 1-2 jugadores (Local), Juego online opcional, Admite hasta 64 jugadores online que tengan PS Plus, Compatible con el Uso a distancia');
INSERT INTO ControlProduct.Producto VALUES ('P30','Control PS5 DualSense Inalámbrico','Sony','Gaming',999.00,'PS5 Control DualSense Inalámbrico + EA SPORTS™ FIFA 23 Contenido Digital, Control inalámbrico DualSense, Cupón para EA SPORTS FIFA 23, Cupón para EA SPORTSTFIFA 23 Ultimate Team, contenido digital*');

/*INSERTS INVENTARIO*/
INSERT INTO ControlProduct.Inventario VALUES ('I1','P1','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I2','P2','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I3','P3','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I4','P4','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I5','P5','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I6','P6','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I7','P7','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I8','P8','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I9','P9','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I10','P10','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I11','P11','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I12','P12','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I13','P13','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I14','P14','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I15','P15','SUC3',5);
INSERT INTO ControlProduct.Inventario VALUES ('I16','P16','SUC3',15);
INSERT INTO ControlProduct.Inventario VALUES ('I17','P17','SUC3',15);
INSERT INTO ControlProduct.Inventario VALUES ('I18','P18','SUC3',15);
INSERT INTO ControlProduct.Inventario VALUES ('I19','P19','SUC3',15);
INSERT INTO ControlProduct.Inventario VALUES ('I20','P20','SUC3',15);
INSERT INTO ControlProduct.Inventario VALUES ('I21','P21','SUC3',55);
INSERT INTO ControlProduct.Inventario VALUES ('I22','P22','SUC3',50);
INSERT INTO ControlProduct.Inventario VALUES ('I23','P23','SUC3',50);
INSERT INTO ControlProduct.Inventario VALUES ('I24','P24','SUC3',50);
INSERT INTO ControlProduct.Inventario VALUES ('I25','P25','SUC3',55);
INSERT INTO ControlProduct.Inventario VALUES ('I26','P26','SUC3',25);
INSERT INTO ControlProduct.Inventario VALUES ('I27','P27','SUC3',25);
INSERT INTO ControlProduct.Inventario VALUES ('I28','P28','SUC3',25);
INSERT INTO ControlProduct.Inventario VALUES ('I29','P29','SUC3',25);
INSERT INTO ControlProduct.Inventario VALUES ('I30','P30','SUC3',25);
INSERT INTO ControlProduct.Inventario VALUES ('I31','P1','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I32','P2','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I33','P3','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I34','P4','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I35','P5','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I36','P6','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I37','P7','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I38','P8','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I39','P9','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I40','P10','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I41','P11','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I42','P12','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I43','P13','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I44','P14','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I45','P15','BC',50);
INSERT INTO ControlProduct.Inventario VALUES ('I46','P16','BC',100);
INSERT INTO ControlProduct.Inventario VALUES ('I47','P17','BC',100);
INSERT INTO ControlProduct.Inventario VALUES ('I48','P18','BC',100);
INSERT INTO ControlProduct.Inventario VALUES ('I49','P19','BC',100);
INSERT INTO ControlProduct.Inventario VALUES ('I50','P20','BC',100);
INSERT INTO ControlProduct.Inventario VALUES ('I51','P21','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I52','P22','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I53','P23','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I54','P24','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I55','P25','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I56','P26','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I57','P27','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I58','P28','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I59','P29','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I60','P30','BC',200);
INSERT INTO ControlProduct.Inventario VALUES ('I61','P1','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I62','P2','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I63','P4','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I64','P5','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I65','P6','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I66','P8','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I67','P9','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I68','P10','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I69','P11','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I70','P12','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I71','P14','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I72','P15','SUN0',5);
INSERT INTO ControlProduct.Inventario VALUES ('I73','P16','SUN0',25);
INSERT INTO ControlProduct.Inventario VALUES ('I74','P18','SUN0',25);
INSERT INTO ControlProduct.Inventario VALUES ('I75','P19','SUN0',25);
INSERT INTO ControlProduct.Inventario VALUES ('I76','P20','SUN0',50);
INSERT INTO ControlProduct.Inventario VALUES ('I77','P21','SUN0',50);
INSERT INTO ControlProduct.Inventario VALUES ('I78','P22','SUN0',50);
INSERT INTO ControlProduct.Inventario VALUES ('I79','P23','SUN0',50);
INSERT INTO ControlProduct.Inventario VALUES ('I80','P24','SUN0',50);
INSERT INTO ControlProduct.Inventario VALUES ('I81','P25','SUN0',50);
INSERT INTO ControlProduct.Inventario VALUES ('I82','P26','SUN0',25);
INSERT INTO ControlProduct.Inventario VALUES ('I83','P28','SUN0',25);
INSERT INTO ControlProduct.Inventario VALUES ('I84','P29','SUN0',25);
INSERT INTO ControlProduct.Inventario VALUES ('I85','P30','SUN0',25);
INSERT INTO ControlProduct.Inventario VALUES ('I86','P2','SUSU4',5);
INSERT INTO ControlProduct.Inventario VALUES ('I87','P3','SUSU4',5);
INSERT INTO ControlProduct.Inventario VALUES ('I88','P4','SUSU4',5);
INSERT INTO ControlProduct.Inventario VALUES ('I89','P5','SUSU4',5);
INSERT INTO ControlProduct.Inventario VALUES ('I90','P9','SUSU4',5);
INSERT INTO ControlProduct.Inventario VALUES ('I91','P12','SUSU4',5);
INSERT INTO ControlProduct.Inventario VALUES ('I92','P13','SUSU4',5);
INSERT INTO ControlProduct.Inventario VALUES ('I93','P14','SUSU4',5);
INSERT INTO ControlProduct.Inventario VALUES ('I94','P18','SUSU4',15);
INSERT INTO ControlProduct.Inventario VALUES ('I95','P19','SUSU4',15);
INSERT INTO ControlProduct.Inventario VALUES ('I96','P20','SUSU4',15);
INSERT INTO ControlProduct.Inventario VALUES ('I97','P22','SUSU4',50);
INSERT INTO ControlProduct.Inventario VALUES ('I98','P25','SUSU4',55);
INSERT INTO ControlProduct.Inventario VALUES ('I99','P26','SUSU4',25);
INSERT INTO ControlProduct.Inventario VALUES ('I100','P28','SUSU4',25);

/*INSERTS DE EMPLEADOS*/
/*BODEGA*/
INSERT INTO ControlAdmin.Empleado VALUES ('E1','Alex Miranda','admin123','Admin','BC');
INSERT INTO ControlAdmin.Empleado VALUES ('E2','Wilson Chojolan','contra456','Bodega','BC');
INSERT INTO ControlAdmin.Empleado VALUES ('E3','Alison Alfaro','contra789','Bodega','BC');
INSERT INTO ControlAdmin.Empleado VALUES ('E4','Andre Pérez','contra123','Bodega','BC');
INSERT INTO ControlAdmin.Empleado VALUES ('E5','Jaylene González','contra123','Bodega','BC');
/*Sucursal Central*/
INSERT INTO ControlAdmin.Empleado VALUES ('E6','Samuel Ordoñez','inv456','Inventario','SUC3');
INSERT INTO ControlAdmin.Empleado VALUES ('E7','Yuvia Tay','contra456','Vendedor','SUC3');
INSERT INTO ControlAdmin.Empleado VALUES ('E8','Fredy De León','contra789','Vendedor','SUC3');
INSERT INTO ControlAdmin.Empleado VALUES ('E9','Mariita Mejía','contra123','Vendedor','SUC3');
/*Sucursal Norte*/
INSERT INTO ControlAdmin.Empleado VALUES ('E10','Diego Estrada','inv789','Inventario','SUN0');
INSERT INTO ControlAdmin.Empleado VALUES ('E11','Yosbin Matías','contra456','Vendedor','SUN0');
INSERT INTO ControlAdmin.Empleado VALUES ('E12','Mauricio Nimatuj','contra789','Vendedor','SUN0');
INSERT INTO ControlAdmin.Empleado VALUES ('E13','Marvin Sacalxot','contra123','Vendedor','SUN0');
/*Sucursal Sur*/
INSERT INTO ControlAdmin.Empleado VALUES ('E14','Massielle Coti','inv146','Inventario','SUSU4');
INSERT INTO ControlAdmin.Empleado VALUES ('E15','Tim Drake','contra456','Vendedor','SUSU4');
INSERT INTO ControlAdmin.Empleado VALUES ('E16','Dick Grayson','contra789','Vendedor','SUSU4');
INSERT INTO ControlAdmin.Empleado VALUES ('E17','Damian Wayne','contra123','Vendedor','SUSU4');

/*INSERTS DE CLIENTES*/
INSERT INTO ControlAdmin.Cliente VALUES ('0000000000001','Consumidor','Final');
INSERT INTO ControlAdmin.Cliente VALUES ('8240085741332','Valentina Laverde','de la Rosa');
INSERT INTO ControlAdmin.Cliente VALUES ('4824177307103','Óscar','de la Renta');
INSERT INTO ControlAdmin.Cliente VALUES ('7412629222074','Sara Teresa','Sánchez del Pinar');
INSERT INTO ControlAdmin.Cliente VALUES ('2362734054935','Efraín','de las Casas Mejía');
INSERT INTO ControlAdmin.Cliente VALUES ('9094453348926','Julieta','Ponce de León');
INSERT INTO ControlAdmin.Cliente VALUES ('9718279736257','Martín Elías','de los Ríos Acosta');
INSERT INTO ControlAdmin.Cliente VALUES ('1092153719388','Mónica Patricia','de Avalos Mendoza');

/*INSERTS DE FACTURA*/
INSERT INTO ControlVenta.Factura VALUES ('F1','E15','SUSU4','8240085741332','2023/3/9',12498.00);
INSERT INTO ControlVenta.Factura VALUES ('F2','E16','SUSU4','0000000000001','2023/3/9',7999.00);
INSERT INTO ControlVenta.Factura VALUES ('F3','E17','SUSU4','8240085741332','2023/3/9',7999.00);
INSERT INTO ControlVenta.Factura VALUES ('F4','E13','SUN0','0000000000001','2023/3/9',7999.00);
INSERT INTO ControlVenta.Factura VALUES ('F5','E13','SUN0','1092153719388','2023/3/9',7999.00);
INSERT INTO ControlVenta.Factura VALUES ('F6','E13','SUC3','9718279736257','2023/3/9',7999.00);

/*INSERTS DE VENTAS*/
INSERT INTO ControlVenta.Venta VALUES ('V1','F1','P2','1');
INSERT INTO ControlVenta.Venta VALUES ('V2','F1','P28','1');
INSERT INTO ControlVenta.Venta VALUES ('V3','F2','P18','1');
INSERT INTO ControlVenta.Venta VALUES ('V4','F3','P18','1');
INSERT INTO ControlVenta.Venta VALUES ('V5','F4','P18','1');
INSERT INTO ControlVenta.Venta VALUES ('V6','F5','P18','1');
/*DESPUES DE AÑADIR, SE DEBE DESCONTAR DEL INVENTARIO DE CADA LUGAR, Y VERIFICAR SI HAY*/

/*EXISTENCIA TOTALES DE PRODUCTOS EN TODAS LA TIENDAS*/
SELECT s.nombre, p.nombre, p.marca, i.cantidad  FROM ControlProduct.Inventario AS i INNER JOIN ControlAdmin.Sucursal AS s ON i.cod_sucursal=s.codigo_id INNER JOIN ControlProduct.Producto AS p ON i.sku_producto=p.sku;
/*EXISTENCIA TOTALES DE PRODUCTOS EN UNA TIENDA*/
SELECT p.nombre, p.marca, i.cantidad  FROM ControlProduct.Inventario AS i INNER JOIN ControlProduct.Producto AS p ON i.sku_producto=p.sku AND i.cod_sucursal='SUN0';
/*Top 10 productos más vendidos*/
SELECT p.nombre, sum(v.cantidad) FROM ControlVenta.Venta AS v INNER JOIN ControlProduct.Producto AS p ON v.sku_producto=p.sku GROUP BY p.nombre ORDER BY sum(v.cantidad) DESC LIMIT 10;
/*Top 10 clientes que más ganancias generan*/
SELECT c.nombre, c.apellido, sum(f.total) FROM ControlVenta.Factura AS f INNER JOIN ControlAdmin.Cliente AS c ON f.nit_cliente=c.nit GROUP BY c.nombre, c.apellido ORDER BY sum(f.total) DESC LIMIT 10;
/*Top 3 sucursales con más ventas*/
SELECT s.nombre, count() FROM ControlVenta.Factura AS f INNER JOIN ControlAdmin.Sucursal AS s ON f.cod_sucursal=s.nombre GROUP BY s.nombre ORDER BY sum(f.total) DESC LIMIT 3;



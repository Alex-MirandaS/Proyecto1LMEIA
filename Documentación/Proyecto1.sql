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
    precio DECIMAL (8,2) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
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
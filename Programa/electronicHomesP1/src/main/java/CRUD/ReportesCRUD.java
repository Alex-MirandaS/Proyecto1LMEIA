/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class ReportesCRUD {

    public ArrayList<String> reportModelChange(String typeReport, String suc) {
        String consult = getConsult(typeReport);
        ArrayList<String> returned = new ArrayList<>();

        try ( PreparedStatement presSt = Conexion.dbConection.prepareStatement(consult)) {
            presSt.setString(1, suc);
            ResultSet result = presSt.executeQuery();

            while (result.next()) {
                addValues(typeReport, returned, result);
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

    public ArrayList<String> reportModel(String typeReport) {
        String consult = getConsult(typeReport);
        ArrayList<String> returned = new ArrayList<>();

        try ( PreparedStatement presSt = Conexion.dbConection.prepareStatement(consult)) {
            ResultSet result = presSt.executeQuery();

            while (result.next()) {
                addValues(typeReport, returned, result);
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar"+e);
        }
        return returned;
    }

    private String getConsult(String typeReport) {
        String txt = "";
        switch (typeReport) {
            case "ProdMasV":
                txt = "SELECT p.nombre, count(*) FROM ControlVenta.Venta AS v INNER JOIN ControlProduct.Producto AS p ON v.sku_producto=p.sku GROUP BY p.nombre ORDER BY count(*) DESC LIMIT 10";
                break;
            case "ClieMasGan":
                txt = "SELECT c.nombre, c.apellido, sum(f.total) FROM ControlVenta.Factura AS f INNER JOIN ControlAdmin.Cliente AS c ON f.nit_cliente=c.nit GROUP BY c.nombre, c.apellido ORDER BY sum(f.total) DESC LIMIT 10";
                break;
            case "SucMasVen":
                txt = "SELECT s.nombre, sum(t.count) FROM tab_cont_fact AS t INNER JOIN ControlVenta.Factura AS f ON t.no_factura = f.no_factura INNER JOIN ControlAdmin.Sucursal AS s ON f.cod_sucursal = s.codigo_id GROUP BY s.nombre ORDER BY sum(t.count) DESC LIMIT 3";
                break;
            case "SucMasIng":
                txt = "SELECT s.nombre, sum(f.total) FROM ControlVenta.Factura AS f INNER JOIN ControlAdmin.Sucursal AS s ON f.cod_sucursal=s.codigo_id GROUP BY s.nombre ORDER BY sum(f.total) DESC LIMIT 3";
                break;
            case "EmpMasVen":
                txt = "SELECT e.cod_empleado ,e.nombre, sum(t.count) FROM tab_cont_fact AS t INNER JOIN ControlVenta.Factura AS f ON t.no_factura = f.no_factura INNER JOIN ControlAdmin.Empleado AS e ON f.cod_vendedor = e.cod_empleado GROUP BY e.nombre, e.cod_empleado ORDER BY sum(t.count) DESC LIMIT 3";
                break;
            case "EmpMasIng":
                txt = "SELECT e.nombre, sum(f.total) FROM ControlVenta.Factura AS f INNER JOIN ControlAdmin.Empleado AS e ON f.cod_vendedor=e.cod_empleado GROUP BY e.nombre ORDER BY sum(f.total) DESC LIMIT 3";
                break;
            case "ProMasIng":
                txt = "SELECT p.nombre, sum(p.precio) FROM ControlVenta.Venta AS v INNER JOIN ControlProduct.Producto AS p ON v.sku_producto=p.sku GROUP BY p.nombre ORDER BY sum(p.precio) DESC LIMIT 10";
                break;
            case "ProdMasVenSuc":
                txt = "SELECT p.nombre, count(*) FROM ControlVenta.Venta AS v INNER JOIN ControlProduct.Producto AS p ON v.sku_producto=p.sku INNER JOIN ControlVenta.Factura AS f ON v.num_factura=f.no_factura AND f.cod_sucursal= ? GROUP BY p.nombre ORDER BY count(*) DESC LIMIT 5";
                break;
            case "ProMasIngSuc":
                txt = "SELECT p.nombre, sum(p.precio) FROM ControlVenta.Venta AS v INNER JOIN ControlProduct.Producto AS p ON v.sku_producto=p.sku INNER JOIN ControlVenta.Factura AS f ON v.num_factura=f.no_factura AND f.cod_sucursal= ? GROUP BY p.nombre ORDER BY sum(p.precio) DESC LIMIT 5";
                break;
        }
        return txt;
    }

    private void addValues(String typeReport, ArrayList<String> returned, ResultSet result) throws SQLException {
        switch (typeReport) {
            case "ProdMasV":
                returned.add(result.getString("nombre"));
                returned.add(result.getString("count"));
                break;
            case "ClieMasGan":
                returned.add(result.getString("nombre"));
                returned.add(result.getString("apellido"));
                returned.add(result.getString("sum"));
                break;
            case "SucMasVen":
                returned.add(result.getString("nombre"));
                returned.add(result.getString("sum"));
                break;
            case "SucMasIng":
                returned.add(result.getString("nombre"));
                returned.add(result.getString("sum"));
                break;
            case "EmpMasVen":
                returned.add(result.getString("cod_empleado"));
                returned.add(result.getString("nombre"));
                returned.add(result.getString("sum"));
                break;
            case "EmpMasIng":
                returned.add(result.getString("nombre"));
                returned.add(result.getString("sum"));
                break;
            case "ProMasIng":
                returned.add(result.getString("nombre"));
                returned.add(result.getString("sum"));
                break;
            case "ProdMasVenSuc":
                returned.add(result.getString("nombre"));
                returned.add(result.getString("count"));
                break;
            case "ProMasIngSuc":
                returned.add(result.getString("nombre"));
                returned.add(result.getString("sum"));
                break;
        }
    }
}

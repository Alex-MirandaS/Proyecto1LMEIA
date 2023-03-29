/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Objects.Factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class FacturaCRUD extends ModelCRUD {

    public FacturaCRUD(String table) {
        super("ControlVenta.Factura ");
    }

    @Override
    public boolean insert(Object o) {
        Factura temp = (Factura) o;
        String consult = this.insertQ + this.table + "VALUES (?,?,?,?,?,?)";
        try ( PreparedStatement preSt = Conexion.dbConection.prepareStatement(consult)) {
            preSt.setString(1, temp.getNo_factura());
            preSt.setString(2, temp.getCod_vendedor());
            preSt.setString(3, temp.getCod_sucursal());
            preSt.setString(4, temp.getNit_cliente());
            preSt.setDate(5, temp.getFecha());
            preSt.setDouble(6, temp.getTotal());
            preSt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("ERROR AL INSERTAR EL REGISTRO: " + e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Object> seeAllData() {
        String consult = this.selectTQ + this.table;
        ArrayList<Object> returned = new ArrayList<>();

        try ( PreparedStatement presSt = Conexion.dbConection.prepareStatement(consult)) {
            ResultSet result = presSt.executeQuery();
            Factura temp;
            while (result.next()) {
                temp = new Factura(result.getString("no_factura"), result.getString("cod_vendedor"), result.getString("cod_sucursal"), result.getString("nit_cliente"), result.getDate("fecha"), result.getDouble("total"));
                returned.add(temp);
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

}

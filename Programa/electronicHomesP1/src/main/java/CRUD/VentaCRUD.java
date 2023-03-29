/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Objects.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class VentaCRUD extends ModelCRUD {

    public VentaCRUD(String table) {
        super("ControlVenta.Venta ");
    }

    @Override
    public boolean insert(Object o) {
        Venta temp = (Venta) o;
        String consult = this.insertQ + this.table + "VALUES (?,?,?,?)";
        try ( PreparedStatement preSt = Conexion.dbConection.prepareStatement(consult)) {
            preSt.setString(1, temp.getRegistro());
            preSt.setString(2, temp.getNum_factura());
            preSt.setString(3, temp.getSku_producto());
            preSt.setInt(4, temp.getCantidad());
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
            Venta temp;
            while (result.next()) {
                temp = new Venta(result.getString("registro"), result.getString("num_factura"), result.getString("sku_producto"), result.getInt("cantidad"));
                returned.add(temp);
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

}

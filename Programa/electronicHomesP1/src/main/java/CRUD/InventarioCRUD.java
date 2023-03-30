/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Objects.Inventario;
import Objects.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class InventarioCRUD extends ModelCRUD {

    public InventarioCRUD() {
        super("ControlProduct.Inventario ", 4);
    }

    @Override
    public boolean insert(Object o) {
        Inventario temp = (Inventario) o;
        String consult = this.insertQ + this.table + "VALUES (?,?,?,?)";
        try ( PreparedStatement preSt = Conexion.dbConection.prepareStatement(consult)) {
            preSt.setString(1, temp.getRegistro());
            preSt.setString(2, temp.getSku_producto());
            preSt.setString(3, temp.getCod_sucursal());
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
            Inventario temp;
            while (result.next()) {
                temp = new Inventario(result.getString("registro"), result.getString("sku_producto"), result.getString("cod_sucursal"), result.getInt("cantidad"));
                returned.add(temp);
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

    public ArrayList<Object> getProdSuc(String suc) {
        String consult = "SELECT p.sku, p.nombre, p.marca, p.categoria, p.precio, p.descripcion FROM ControlProduct.Inventario AS i INNER JOIN ControlProduct.Producto AS p ON i.sku_producto=p.sku AND i.cod_sucursal=?";
        ArrayList<Object> returned = new ArrayList<>();

        try ( PreparedStatement presSt = Conexion.dbConection.prepareStatement(consult)) {
            presSt.setString(1, suc);
            ResultSet result = presSt.executeQuery();
            Producto temp;
            while (result.next()) {
                temp = new Producto(result.getString("sku"), result.getString("nombre"), result.getString("marca"), result.getString("categoria"), result.getDouble("precio"), result.getString("descripcion"));
                returned.add(temp);
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

    @Override
    public boolean update(Object dataChange) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getData(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getSets(Object dataChange, Object dataOriginal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

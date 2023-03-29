/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Objects.Inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class InventarioCRUD extends ModelCRUD {

    public InventarioCRUD(String table) {
        super("ControlProduct.Inventario ");
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

}

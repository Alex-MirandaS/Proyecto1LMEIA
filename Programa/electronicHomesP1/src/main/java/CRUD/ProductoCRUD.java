/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Objects.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class ProductoCRUD extends ModelCRUD {
    
    public ProductoCRUD(String table) {
        super("ControlProduct.Producto ");
    }
    
    @Override
    public boolean insert(Object o) {
        Producto temp = (Producto) o;
        String consult = this.insertQ + this.table + "VALUES (?,?,?,?,?,?)";
        try ( PreparedStatement preSt = Conexion.dbConection.prepareStatement(consult)) {
            preSt.setString(1, temp.getSku());
            preSt.setString(2, temp.getNombre());
            preSt.setString(3, temp.getMarca());
            preSt.setString(4, temp.getCategoria());
            preSt.setDouble(5, temp.getPrecio());
            preSt.setString(6, temp.getDescripcion());
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
    
}

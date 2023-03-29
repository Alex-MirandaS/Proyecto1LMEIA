/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Objects.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class ClienteCRUD extends ModelCRUD {

    public ClienteCRUD(String table) {
        super("ControlAdmin.Cliente ");
    }

    @Override
    public boolean insert(Object o) {
        Cliente temp = (Cliente) o;
        String consult = this.insertQ + this.table + "VALUES (?,?,?)";
        try ( PreparedStatement preSt = Conexion.dbConection.prepareStatement(consult)) {
            preSt.setString(1, temp.getNit());
            preSt.setString(2, temp.getNombre());
            preSt.setString(3, temp.getApellido());
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
            Cliente temp;
            while (result.next()) {
                temp = new Cliente(result.getString("nit"), result.getString("nombre"),result.getString("apellido"));
                returned.add(temp);
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

}

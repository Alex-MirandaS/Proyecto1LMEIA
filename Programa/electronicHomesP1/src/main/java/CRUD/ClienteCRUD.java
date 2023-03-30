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

    public ClienteCRUD() {
        super("ControlAdmin.Cliente ", 3);
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
                temp = new Cliente(result.getString("nit"), result.getString("nombre"), result.getString("apellido"));
                returned.add(temp);
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

    @Override
    public boolean update(Object dataChange) {
        String consult = this.updateQ + this.table + "SET " + getSets(dataChange, getData(((Cliente) dataChange).getNit())) + this.whereQ + "= " + ((Cliente) dataChange).getNit();
        try ( PreparedStatement preSt = Conexion.dbConection.prepareStatement(consult)) {
            preSt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("ERROR AL EDITAR EL REGISTRO: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Object getData(String id) {
        String consult = this.selectTQ + this.table + this.whereQ + "nit = " + "'" + id + "'";
        Object returned = null;

        try ( PreparedStatement presSt = Conexion.dbConection.prepareStatement(consult)) {
            ResultSet result = presSt.executeQuery();
            while (result.next()) {
                returned = new Cliente(result.getString("nit"), result.getString("nombre"), result.getString("apellido"));
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

    @Override
    protected String getSets(Object dataChange, Object dataOriginal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

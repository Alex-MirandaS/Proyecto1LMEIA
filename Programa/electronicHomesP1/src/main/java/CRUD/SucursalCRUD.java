/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Objects.Sucursal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class SucursalCRUD extends ModelCRUD {

    public SucursalCRUD() {
        super("ControlAdmin.Sucursal ", 2);
    }

    @Override
    public boolean insert(Object o) {
        Sucursal temp = (Sucursal) o;
        String consult = this.insertQ + this.table + "VALUES (?,?)";
        try ( PreparedStatement preSt = Conexion.dbConection.prepareStatement(consult)) {
            preSt.setString(1, temp.getCodigo_id());
            preSt.setString(2, temp.getNombre());
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
            Sucursal temp;
            while (result.next()) {
                temp = new Sucursal(result.getString("codigo_id"), result.getString("nombre"));
                returned.add(temp);
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

    @Override
    public boolean update(Object dataChange) {
        return true;
    }

    @Override
    public Object getData(String id) {
        String consult = this.selectTQ + this.table + this.whereQ + "codigo_id = " + "'"+id+"'";
        Object returned = null;

        try ( PreparedStatement presSt = Conexion.dbConection.prepareStatement(consult)) {
            ResultSet result = presSt.executeQuery();
            while (result.next()) {
                returned = new Sucursal(result.getString("codigo_id"), result.getString("nombre"));
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }
    
        public Object getDataName(String id) {
        String consult = this.selectTQ + this.table + this.whereQ + "nombre = " + "'"+id+"'";
        Object returned = null;

        try ( PreparedStatement presSt = Conexion.dbConection.prepareStatement(consult)) {
            ResultSet result = presSt.executeQuery();
            while (result.next()) {
                returned = new Sucursal(result.getString("codigo_id"), result.getString("nombre"));
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;
    }

    @Override
    protected String getSets(Object dataChange, Object dataOriginal) {
        return "";
    }

}

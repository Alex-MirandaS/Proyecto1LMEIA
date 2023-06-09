/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import Conexion.Conexion;
import Objects.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class EmpleadoCRUD extends ModelCRUD {

    public EmpleadoCRUD() {
        super("ControlAdmin.Empleado ", 5);
    }

    @Override
    public boolean insert(Object o) {
        Empleado temp = (Empleado) o;
        String consult = this.insertQ + this.table + "VALUES (?,?,?,?,?)";
        try ( PreparedStatement preSt = Conexion.dbConection.prepareStatement(consult)) {
            preSt.setString(1, temp.getCod_empleado());
            preSt.setString(2, temp.getNombre());
            preSt.setString(3, temp.getContraseña());
            preSt.setString(4, temp.getRango());
            preSt.setString(5, temp.getCod_sucursal());
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
            Empleado temp;
            while (result.next()) {
                temp = new Empleado(result.getString("cod_empleado"), result.getString("nombre"), result.getString("contraseña"), result.getString("rango"), result.getString("cod_sucursal"));
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

        String consult = this.selectTQ + this.table + this.whereQ + "cod_empleado = " + "'" + id + "'";
        Object returned = null;

        try ( PreparedStatement presSt = Conexion.dbConection.prepareStatement(consult)) {
            ResultSet result = presSt.executeQuery();
            while (result.next()) {
                returned = new Empleado(result.getString("cod_empleado"), result.getString("nombre"), result.getString("contraseña"), result.getString("rango"), result.getString("cod_sucursal"));
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

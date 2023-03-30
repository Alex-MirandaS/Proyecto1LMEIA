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

    public FacturaCRUD() {
        super("ControlVenta.Factura ", 6);
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

    @Override
    public boolean update(Object dataChange) {
        String consult = this.updateQ + this.table + "SET " + getSets(dataChange, getData(((Factura) dataChange).getNo_factura())) + this.whereQ + "= " + ((Factura) dataChange).getNo_factura();
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
        String consult = this.selectTQ + this.table + this.whereQ + "no_factura = " + id;
        Object returned = null;

        try ( PreparedStatement presSt = Conexion.dbConection.prepareStatement(consult)) {
            ResultSet result = presSt.executeQuery();
            while (result.next()) {
                returned = new Factura(result.getString("no_factura"), result.getString("cod_vendedor"), result.getString("cod_sucursal"), result.getString("nit_cliente"), result.getDate("fecha"), result.getDouble("total"));
            }

        } catch (Exception e) {
            System.err.println("Error al visualizar");
        }
        return returned;

    }

    @Override
    protected String getSets(Object dataChange, Object dataOriginal) {
        String txt = "";
        ArrayList<String> array = new ArrayList<>();
        Factura change = (Factura) dataChange;
        Factura original = (Factura) dataOriginal;
        if (original.getTotal() != change.getTotal()) {
            array.add("total = " + change.getTotal());
        }

        if (original.getFecha() != change.getFecha()) {
            array.add("fecha = " + change.getFecha());
        }

        if (original.getCod_vendedor() != change.getCod_vendedor()) {
            array.add("cod_vendedor = " + change.getCod_vendedor());
        }

        if (original.getNit_cliente() != change.getNit_cliente()) {
            array.add("nit_cliente = " + change.getNit_cliente());
        }

        for (int i = 0; i < array.size(); i++) {
            if (i != array.size() - 1) {
                txt += array.get(i) + ", ";
            } else {
                txt += array.get(i);
            }

        }
        return txt;
    }

}

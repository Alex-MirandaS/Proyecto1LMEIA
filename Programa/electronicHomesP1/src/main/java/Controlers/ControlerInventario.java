/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import GUI.Inventario_I;
import Objects.Empleado;
import Objects.Inventario;
import Objects.Producto;
import Objects.Sucursal;
import Program.Principal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex
 */
public class ControlerInventario {

    private Principal p;
    private Inventario_I ventana;

    public ControlerInventario(Principal p) {
        this.p = p;
        this.ventana = p.getInventarioGUI();
    }

    public void initialData(Empleado e) {
        ventana.getCodSucursal().setText(e.getCod_sucursal());
        ventana.getNomSucursal().setText(((Sucursal) p.getSucCRUD().getData(e.getCod_sucursal())).getNombre());
        ventana.getCodEmpleado().setText(e.getCod_empleado());
        ventana.getNomEmpleado().setText(e.getNombre());
        fillSucursals(e.getCod_sucursal());
        changeTable();
    }

    private void changeTable() {
        JTable table = ventana.getTable();
        DefaultTableModel modelo = new DefaultTableModel();
        table.setModel(modelo);
        modelo.addColumn("SKU");
        modelo.addColumn("Nombre del Producto");
        modelo.addColumn("Sucursal Origen");
        modelo.addColumn("Existencias Sucursal Origen");
        modelo.addColumn("Cantidad Solicitada");
        modelo.fireTableDataChanged();
        p.getVendedorGUI().getTable().setEnabled(false);
        table.setVisible(true);
    }

    public void updateProducts() {
        ventana.getListProductos().removeAllItems();
        if (ventana.getList_sucursales().getSelectedItem() != null) {
            ArrayList<Object> a = p.getInvCRUD().getProdSuc(((Sucursal) p.getSucCRUD().getDataName("" + ventana.getList_sucursales().getSelectedItem())).getCodigo_id());
            for (int i = 0; i < a.size(); i++) {
                Producto product = (Producto) a.get(i);
                ventana.getListProductos().addItem(product.getNombre());
            }
        }
    }

    public void addRequest() {//REVISAR SI HAY EXISTENCIAS
        JTable table = ventana.getTable();
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();

        if (!ventana.getCodProd().getText().isBlank()) {
            if (!("" + ventana.getCantidad().getValue()).isBlank() && !((Integer.parseInt("" + ventana.getCantidad().getValue())) < 1)) {
                try {
                    Producto pro = (Producto) p.getProCRUD().getData(ventana.getCodProd().getText());
                    String sucOrigen = ""+ventana.getList_sucursales().getSelectedItem();
                    Inventario inv = p.getInvCRUD().getRegInv(pro.getSku(), sucOrigen);
                    String cant = ""+ventana.getCantidad().getValue();
                    modelo.addRow(new Object[]{pro.getSku(),pro.getNombre(), sucOrigen, inv.getCantidad(), cant});
                    modelo.fireTableDataChanged();
                    table.setVisible(true);
                } catch (Exception e) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "No ha ingresado la cantidad de productos aún");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningun código aún");
        }
    }

    public void selectProduct() {
        if (ventana.getListProductos().getSelectedItem() != null) {
            ventana.getCodProd().setText(((Producto) p.getProCRUD().getDataName("" + ventana.getListProductos().getSelectedItem())).getSku());
            fillCounts();
        }
    }

    private void fillCounts() {
        ventana.getCantidad().removeAll();
        int cantMax = p.getInvCRUD().getRegInv(ventana.getCodProd().getText(), ventana.getCodSucursal().getText()).getCantidad();
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMaximum(cantMax);
        nm.setMinimum(1);
        ventana.getCantidad().setModel(nm);
    }

    private void fillSucursals(String codSuc) {
        ventana.getList_sucursales().removeAllItems();
        ArrayList<Object> a = p.getSucCRUD().seeAllData();
        for (int i = 0; i < a.size(); i++) {
            Sucursal suc = (Sucursal) a.get(i);
            if (suc.getCodigo_id() != codSuc) {
                ventana.getList_sucursales().addItem(suc.getNombre());
            }
        }
    }

    private void fillProducts(String codSuc) {
        ArrayList<Object> a = p.getSucCRUD().seeAllData();
        for (int i = 0; i < a.size(); i++) {
            Sucursal suc = (Sucursal) a.get(i);
            if (suc.getCodigo_id() != codSuc) {
                ventana.getList_sucursales().addItem(suc.getNombre());
            }
        }
    }
}

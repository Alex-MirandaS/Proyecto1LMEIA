/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Objects.Cliente;
import Objects.Empleado;
import Objects.Factura;
import Objects.Producto;
import Objects.Sucursal;
import Program.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author alex
 */
public class ControlerVendedor {

    private Principal p;

    public ControlerVendedor(Principal p) {
        this.p = p;
    }

    public void initialData(Empleado e) {
        p.getVendedorGUI().getSucursal().setText(((Sucursal) p.getSucCRUD().getData(e.getCod_sucursal())).getNombre());
        p.getVendedorGUI().getNombreEmp().setText(e.getNombre());
        p.getVendedorGUI().getCodEmp().setText(e.getCod_empleado());
        //SI NO ESTA VACIA, SE CREA
        p.getVendedorGUI().getNoFact().setText("F" + p.getFacCRUD().seeAllData().size() + 1);
        LocalDate date = LocalDate.now();
        p.getVendedorGUI().getFechFact().setText("" + date);
        p.getVendedorGUI().getListProductos().removeAllItems();
        for (int i = 0; i < p.getInvCRUD().getProdSuc(e.getCod_sucursal()).size(); i++) {
            p.getVendedorGUI().getListProductos().addItem(((Producto) p.getInvCRUD().getProdSuc(e.getCod_sucursal()).get(i)).getNombre());
        }
        changeTable();
    }

    private void changeTable() {
        JTable table = p.getVendedorGUI().getTable();
        DefaultTableModel modelo = new DefaultTableModel();
        table.setModel(modelo);
        modelo.addColumn("Cantidad");
        modelo.addColumn("Nombre del Producto");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Total");
        modelo.fireTableDataChanged();
        p.getVendedorGUI().getTable().setEnabled(false);
        table.setVisible(true);
    }

    public void selectProduct() {
        if (p.getVendedorGUI().getListProductos().getSelectedItem() != null) {
            p.getVendedorGUI().getCodProd().setText(((Producto) p.getProCRUD().getDataName("" + p.getVendedorGUI().getListProductos().getSelectedItem())).getSku());
        }

    }

    public void verifyNit() {
        String nit = p.getVendedorGUI().getNit().getText();
        if (!nit.isBlank()) {
            Cliente clie = (Cliente) p.getCliCRUD().getData(nit);

            if (clie != null) {
                p.getVendedorGUI().getNombre().setText(clie.getNombre());
                p.getVendedorGUI().getApellido().setText(clie.getApellido());
                p.getVendedorGUI().getNit().setEditable(false);
                p.getVendedorGUI().getNombre().setEditable(false);
                p.getVendedorGUI().getApellido().setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "El cliente no existe en el registro, ingrese los datos");
                p.getVendedorGUI().getNombre().setEditable(true);
                p.getVendedorGUI().getApellido().setEditable(true);
                p.getVendedorGUI().getVerifyNit().setEnabled(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llene los campos necesarios");
        }
    }

    public void addClient() {
        if (!p.getVendedorGUI().getNombre().getText().isBlank()
                && !p.getVendedorGUI().getNit().getText().isBlank()
                && !p.getVendedorGUI().getApellido().getText().isBlank()) {
            try {
                Cliente clie = new Cliente(p.getVendedorGUI().getNombre().getText(),
                        p.getVendedorGUI().getNit().getText(),
                        p.getVendedorGUI().getApellido().getText());
                p.getCliCRUD().insert(clie);
                JOptionPane.showMessageDialog(null, "Cliente Registrado");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Se ingreso un valor no permitido, Intente de nuevo");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
        }
    }

    public void addPC() {//REVISAR SI HAY EXISTENCIAS
        JTable table = p.getVendedorGUI().getTable();
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();

        if (!p.getVendedorGUI().getCodProd().getText().isBlank()) {
            if (!p.getVendedorGUI().getCantProd().getText().isBlank()) {
                try {
                    Producto pro = (Producto) p.getProCRUD().getData(p.getVendedorGUI().getCodProd().getText());
                    int cant = Integer.parseInt(p.getVendedorGUI().getCantProd().getText());
                    modelo.addRow(new Object[]{cant, pro.getNombre(), pro.getPrecio(), cant * pro.getPrecio()});
                    modTotal();
                    modelo.fireTableDataChanged();
                    table.setVisible(true);
                } catch (Exception e) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "No ha ingresado ningun código aún");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningun código aún");
        }
    }

}

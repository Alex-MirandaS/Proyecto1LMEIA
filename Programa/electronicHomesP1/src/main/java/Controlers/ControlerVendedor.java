/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Objects.Cliente;
import Objects.Empleado;
import Objects.Factura;
import Objects.Inventario;
import Objects.Producto;
import Objects.Sucursal;
import Objects.Venta;
import Program.Principal;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
        p.getVendedorGUI().getNoFact().setText("F" + (p.getFacCRUD().seeAllData().size() + 1));
        LocalDate date = LocalDate.now();
        p.getVendedorGUI().getFechFact().setText("" + date);
        p.getVendedorGUI().getTotal().setText("0.00");
        p.getVendedorGUI().getNit().setText("");
        p.getVendedorGUI().getNombre().setText("");
        p.getVendedorGUI().getNombre().setEditable(false);
        p.getVendedorGUI().getApellido().setText("");
        p.getVendedorGUI().getApellido().setEditable(false);
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
        modelo.addColumn("SKU");
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
                    modelo.addRow(new Object[]{pro.getSku(), cant, pro.getNombre(), pro.getPrecio(), cant * pro.getPrecio()});
                    modTotal();
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

    private void modTotal() {
        JTable table = p.getVendedorGUI().getTable();
        double total = 0;
        int valor = table.getRowCount();
        for (int i = 0; i < valor; i++) {
            total += Double.parseDouble("" + table.getValueAt(i, 3));
        }
        p.getVendedorGUI().getTotal().setText("" + total);
        p.getVendedorGUI().getTotal().setVisible(true);
    }

    public void checkIn() {
        if (stateBill()) {
            addFactura();
            addVentas();
            updateInventario();
            initialData((Empleado) p.getEmpCRUD().getData(p.getVendedorGUI().getCodEmp().getText()));
        }
    }

    private boolean stateBill() {
        if (!p.getVendedorGUI().getNombre().getText().isBlank()
                && !p.getVendedorGUI().getApellido().getText().isBlank()
                && !p.getVendedorGUI().getNit().getText().isBlank()) {
            if (p.getVendedorGUI().getTable().getRowCount() != 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Aún no ha ingresado ningun producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese datos faltantes del cliente");
        }
        return false;
    }

    private void addFactura() {
        try {
            String noFac = p.getVendedorGUI().getNoFact().getText();
            String codVen = p.getVendedorGUI().getCodEmp().getText();
            String codSuc = ((Sucursal) p.getSucCRUD().getDataName(p.getVendedorGUI().getSucursal().getText())).getCodigo_id();//
            String nitCli = p.getVendedorGUI().getNit().getText();
            Date fecha = Date.valueOf(LocalDate.now());
            Double total = Double.parseDouble(p.getVendedorGUI().getTotal().getText());
            Factura fac = new Factura(noFac, codVen, codSuc, nitCli, fecha, total);
            p.getFacCRUD().insert(fac);
            JOptionPane.showMessageDialog(null, "Factura Registrada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ingreso un valor no permitido, Intente de nuevo");
            System.err.println(e);
        }

    }

    private void addVentas() {
        try {
            JTable table = p.getVendedorGUI().getTable();
            Venta ven;
            String noFac = p.getVendedorGUI().getNoFact().getText();
            for (int i = 0; i < table.getRowCount(); i++) {
                String codVen = "V" + (p.getVenCRUD().seeAllData().size() + 1);
                ven = new Venta(codVen, noFac, "" + table.getValueAt(i, 0), Integer.parseInt("" + table.getValueAt(i, 1)));
                p.getVenCRUD().insert(ven);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ingreso un valor no permitido, Intente de nuevo");
        }
    }

    private void updateInventario() {
        try {
            JTable table = p.getVendedorGUI().getTable();

            for (int i = 0; i < table.getRowCount(); i++) {
                String codVen = "V" + p.getVenCRUD().seeAllData().size() + 1;
                String codSuc = p.getVendedorGUI().getSucursal().getText();
                int exis = ((Inventario) p.getInvCRUD().getRegInv("" + table.getValueAt(i, 0), codSuc)).getCantidad() - Integer.parseInt("" + table.getValueAt(i, 1));
                p.getInvCRUD().updateExist("" + table.getValueAt(i, 0), codSuc, exis);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ingreso un valor no permitido, Intente de nuevo");
        }
    }

}

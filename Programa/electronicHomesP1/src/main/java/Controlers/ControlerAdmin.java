/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import GUI.TablaResultados;
import Objects.Cliente;
import Objects.Empleado;
import Objects.Sucursal;
import Program.Principal;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author alex
 */
public class ControlerAdmin {

    private Principal p;
    private String dato;

    public ControlerAdmin(Principal p) {
        this.p = p;
    }

    public void agData(String tipo) {
        changeTable(tipo);
    }

    public void savedInfo() {

        JTable table = p.getAdminGUI().getTable();
        switch (dato) {
            case "agSucursal":
                if (!convData(table.getValueAt(0, 0)).isBlank()
                        && !convData(table.getValueAt(0, 1)).isBlank()) {
                    try {
                        Sucursal suc = new Sucursal(convData(table.getValueAt(0, 0)), convData(table.getValueAt(0, 1)));
                        p.getSucCRUD().insert(suc);
                        JOptionPane.showMessageDialog(null, "Sucursal Registrada");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Se ingreso un valor no permitido, Intente de nuevo");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
                }
                break;
            case "agEmpleado":
                if (!convData(table.getValueAt(0, 0)).isBlank()
                        && !convData(table.getValueAt(0, 1)).isBlank()
                        && !convData(table.getValueAt(0, 2)).isBlank()) {
                    try {
                        Empleado emp = new Empleado(convData(table.getValueAt(0, 0)),
                                convData(table.getValueAt(0, 1)),
                                convData(table.getValueAt(0, 2)),
                                convData(table.getValueAt(0, 3)),
                                getCodeSucursal(convData(table.getValueAt(0, 4))));
                        p.getEmpCRUD().insert(emp);
                        JOptionPane.showMessageDialog(null, "Empleado Registrado");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Se ingreso un valor no permitido, Intente de nuevo");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
                }
                break;
            case "agCliente":
                if (!convData(table.getValueAt(0, 0)).isBlank()
                        && !convData(table.getValueAt(0, 1)).isBlank()
                        && !convData(table.getValueAt(0, 2)).isBlank()) {
                    try {
                        Cliente clie = new Cliente(convData(table.getValueAt(0, 0)),
                                convData(table.getValueAt(0, 1)),
                                convData(table.getValueAt(0, 2)));
                        p.getCliCRUD().insert(clie);
                        JOptionPane.showMessageDialog(null, "Cliente Registrado");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Se ingreso un valor no permitido, Intente de nuevo");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Faltan datos por ingresar");
                }
                break;
        }
    }

    private void changeTable(String tipo) {
        JTable table = p.getAdminGUI().getTable();
        DefaultTableModel modelo = new DefaultTableModel();
        table.setModel(modelo);
        switch (tipo) {
            case "agSucursal":
                modelo.addColumn("Codigo ID");
                modelo.addColumn("Nombre");
                modelo.addRow(new Object[]{"", ""});
                break;
            case "agEmpleado":
                modelo.addColumn("Codigo de Empleado");
                modelo.addColumn("Nombre");
                modelo.addColumn("Contraseña");
                modelo.addColumn("Rango");
                modelo.addColumn("Codigo de Sucursal");
                modelo.addRow(new Object[]{"E" + getLastEmpleado(), "", "", "Admin", ((Sucursal) p.getSucCRUD().seeAllData().get(0)).getNombre()});
                addCB(table, table.getColumnModel().getColumn(3), getRango());
                addCB(table, table.getColumnModel().getColumn(4), getNameSucursal());
                break;
            case "agCliente":
                modelo.addColumn("Nit");
                modelo.addColumn("Nombre");
                modelo.addColumn("Apellido");
                modelo.addRow(new Object[]{"", "", ""});
                break;
        }
        modelo.fireTableDataChanged();
        table.setVisible(true);
        dato = tipo;
    }

//    public void abrirReporteErrores() {
//
//        TablaResultados tabla = new TablaResultados();
//        DefaultTableModel modelo = new DefaultTableModel();
//        tabla.getTabla().setModel(modelo);
//        modelo.addColumn("CADENA DE ERROR");
//        modelo.addColumn("FILA");
//        modelo.addColumn("COLUMNA");
//
//        for (int i = 0; i < tokens.size(); i++) {
//            if (tokens.get(i).getTipo().equals(TipoToken.ERROR)) {
//                modelo.addRow(new Object[]{tokens.get(i).getValor(), tokens.get(i).getFila(), tokens.get(i).getColumna()});
//            }
//        }
//        tabla.setVisible(true);
//    }
    private Object getLastEmpleado() {
        return "" + (p.getEmpCRUD().seeAllData().size()+1);
    }

    private Object getRango() {
        JComboBox comb = new JComboBox();
        comb.addItem("Admin");
        comb.addItem("Bodega");
        comb.addItem("Empleado");
        comb.addItem("Inventario");
        return comb;
    }

    private Object getNameSucursal() {
        JComboBox comb = new JComboBox();
        ArrayList<Object> temp = p.getSucCRUD().seeAllData();
        for (int i = 0; i < temp.size(); i++) {
            comb.addItem(((Sucursal) temp.get(i)).getNombre());
        }
        return comb;
    }

    private void addCB(JTable table, TableColumn column, Object cb) {
        column.setCellEditor(new DefaultCellEditor((JComboBox) cb));
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setToolTipText("Seleccionar");
        column.setCellRenderer(render);
    }

    private String convData(Object valueAt) {
        String ret = "";
        if (valueAt instanceof JComboBox) {
            ret += "" + ((JComboBox) valueAt).getSelectedItem();
        } else {
            ret += "" + valueAt;
        }
        return ret;

    }

    private String getCodeSucursal(String name) {
        String cod = "";
        ArrayList<Object> temp = p.getSucCRUD().seeAllData();
        for (int i = 0; i < temp.size(); i++) {
            if (((Sucursal) temp.get(i)).getNombre().equals(name)) {
                cod = ((Sucursal) temp.get(i)).getCodigo_id();
            }
        }
        return cod;
    }

}

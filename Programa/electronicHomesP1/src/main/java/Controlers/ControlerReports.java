/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import GUI.TablaResultados;
import Objects.Sucursal;
import Program.Principal;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex
 */
public class ControlerReports {

    private Principal p;

    public ControlerReports(Principal p) {
        this.p = p;
    }

    public void launchReport(String r) {

        TablaResultados tabla = new TablaResultados(this);
        DefaultTableModel model = new DefaultTableModel();
        tabla.getTable().setModel(model);
        tabla.getComboChange().setEditable(false);

        switch (r) {
            case "ProdMasV":
                model.addColumn("Nombre");
                model.addColumn("Cantidad");
                break;
            case "ClieMasGan":
                model.addColumn("Nombre");
                model.addColumn("Apellido");
                model.addColumn("Ganancias");
                break;
            case "SucMasVen":
                model.addColumn("Nombre");
                model.addColumn("Cantidad de Ventas");
                break;
            case "SucMasIng":
                model.addColumn("Nombre");
                model.addColumn("Total de Ingresos");
                break;
            case "EmpMasVen":
                model.addColumn("Codigo");
                model.addColumn("Nombre");
                model.addColumn("Cantidad de Ventas");
                break;
            case "EmpMasIng":
                model.addColumn("Nombre");
                model.addColumn("Total de Ingresos");
                break;
            case "ProMasIng":
                model.addColumn("Nombre");
                model.addColumn("Total de Ingresos");
                break;
            case "ProdMasVenSuc":
                model.addColumn("Nombre");
                model.addColumn("Cantidad de Ventas");
                fillComboChange(tabla.getComboChange());
                tabla.getComboChange().setEditable(true);
                break;
            case "ProMasIngSuc":
                model.addColumn("Nombre");
                model.addColumn("Total de Ingresos");
                fillComboChange(tabla.getComboChange());
                tabla.getComboChange().setEditable(true);
                break;
        }
        fillRows(r, model, tabla);
        model.fireTableDataChanged();
        tabla.setVisible(true);
    }

    private void fillRows(String r, DefaultTableModel model, TablaResultados tabla) {
        ArrayList<String> temp = null;
        switch (r) {
            case "ProdMasV":
                temp = p.getRepCRUD().reportModel("ProdMasV");
                for (int i = 0; i < temp.size(); i += 2) {
                    model.addRow(new Object[]{temp.get(i), temp.get(i + 1)});
                }
                break;

            case "ClieMasGan":
                temp = p.getRepCRUD().reportModel("ClieMasGan");
                for (int i = 0; i < temp.size(); i += 3) {
                    model.addRow(new Object[]{temp.get(i), temp.get(i + 1), temp.get(i + 2)});
                }
                break;

            case "SucMasVen":
                temp = p.getRepCRUD().reportModel("SucMasVen");
                for (int i = 0; i < temp.size(); i += 2) {
                    model.addRow(new Object[]{temp.get(i), temp.get(i + 1)});
                }
                break;
            case "SucMasIng":
                temp = p.getRepCRUD().reportModel("SucMasIng");
                for (int i = 0; i < temp.size(); i += 2) {
                    model.addRow(new Object[]{temp.get(i), temp.get(i + 1)});
                }
                break;

            case "EmpMasVen":
                temp = p.getRepCRUD().reportModel("EmpMasVen");
                for (int i = 0; i < temp.size(); i += 3) {
                    model.addRow(new Object[]{temp.get(i), temp.get(i + 1), temp.get(i + 2)});
                }
                break;

            case "EmpMasIng":
                temp = p.getRepCRUD().reportModel("EmpMasIng");
                for (int i = 0; i < temp.size(); i += 2) {
                    model.addRow(new Object[]{temp.get(i), temp.get(i + 1)});
                }
                break;
            case "ProMasIng":
                temp = p.getRepCRUD().reportModel("ProMasIng");
                for (int i = 0; i < temp.size(); i += 2) {
                    model.addRow(new Object[]{temp.get(i), temp.get(i + 1)});
                }
                break;
            case "ProdMasVenSuc":
                temp = p.getRepCRUD().reportModelChange("ProdMasVenSuc", ((Sucursal) p.getSucCRUD().getDataName("" + tabla.getComboChange().getSelectedItem())).getCodigo_id());
                for (int i = 0; i < temp.size(); i += 2) {
                    model.addRow(new Object[]{temp.get(i), temp.get(i + 1)});
                }
                break;
            case "ProMasIngSuc":
                temp = p.getRepCRUD().reportModelChange("ProdMasVenSuc", ((Sucursal) p.getSucCRUD().getDataName("" + tabla.getComboChange().getSelectedItem())).getCodigo_id());
                for (int i = 0; i < temp.size(); i += 2) {
                    model.addRow(new Object[]{temp.get(i), temp.get(i + 1)});
                }
                break;
        }

    }

    private void fillComboChange(JComboBox<String> comboChange) {
        comboChange.removeAllItems();
        ArrayList<Object> a = p.getSucCRUD().seeAllData();
        for (int i = 0; i < a.size(); i++) {
            Sucursal suc = (Sucursal) a.get(i);
            comboChange.addItem(suc.getNombre());
        }
    }

    public void changeTable(TablaResultados aThis) {
        
    }

}

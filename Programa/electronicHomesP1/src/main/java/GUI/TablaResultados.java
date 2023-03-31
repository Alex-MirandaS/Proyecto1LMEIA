/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controlers.ControlerReports;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Alex
 */
public class TablaResultados extends javax.swing.JFrame {
    private ControlerReports r;
    public TablaResultados(ControlerReports r) {
        initComponents();
        this.r = r;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public JTable getTable() {
        return table;
    }

    public JComboBox<String> getComboChange() {
        return comboChange;
    }

    public void setComboChange(JComboBox<String> comboChange) {
        this.comboChange = comboChange;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboChange = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reporte");
        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("          ");
        getContentPane().add(jLabel1, java.awt.BorderLayout.LINE_END);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("          ");
        getContentPane().add(jLabel2, java.awt.BorderLayout.LINE_START);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("   ");
        getContentPane().add(jLabel3, java.awt.BorderLayout.PAGE_END);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("  ");
        getContentPane().add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("          ");
        jPanel2.add(jLabel5, java.awt.BorderLayout.LINE_START);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("   ");
        jPanel2.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("          ");
        jPanel2.add(jLabel7, java.awt.BorderLayout.LINE_END);

        comboChange.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        comboChange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboChange.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboChangeItemStateChanged(evt);
            }
        });
        jPanel2.add(comboChange, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        table.setBackground(new java.awt.Color(0, 0, 0));
        table.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        table.setForeground(new java.awt.Color(102, 102, 102));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboChangeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboChangeItemStateChanged
        r.changeTable(this);
    }//GEN-LAST:event_comboChangeItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboChange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

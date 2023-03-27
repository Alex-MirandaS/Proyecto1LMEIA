/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Main.Principal;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Alex
 */
public class PrincipalGUI extends javax.swing.JFrame {

    private Principal principal;

    public PrincipalGUI(Principal principal) {
        initComponents();
//        guardar.setEnabled(false);
//        reportes.setEnabled(false);
//        busqueda.setEnabled(false);
        this.principal = principal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        abrir = new javax.swing.JButton();
        reportes = new javax.swing.JButton();
        busqueda = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        guardarComo = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        acercaDe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        atras = new javax.swing.JButton();
        adelante = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ANALIZATEXT");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new java.awt.GridLayout(9, 1));

        nuevo.setBackground(new java.awt.Color(0, 0, 0));
        nuevo.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        nuevo.setForeground(new java.awt.Color(255, 255, 255));
        nuevo.setText("NUEVO");
        nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nuevoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nuevoMouseReleased(evt);
            }
        });
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevo);

        abrir.setBackground(new java.awt.Color(0, 0, 0));
        abrir.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        abrir.setForeground(new java.awt.Color(255, 255, 255));
        abrir.setText("ABRIR");
        abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                abrirMousePressed(evt);
            }
        });
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jPanel1.add(abrir);

        reportes.setBackground(new java.awt.Color(0, 0, 0));
        reportes.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        reportes.setForeground(new java.awt.Color(255, 255, 255));
        reportes.setText("REPORTES");
        reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reportesMousePressed(evt);
            }
        });
        reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesActionPerformed(evt);
            }
        });
        jPanel1.add(reportes);

        busqueda.setBackground(new java.awt.Color(0, 0, 0));
        busqueda.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        busqueda.setForeground(new java.awt.Color(255, 255, 255));
        busqueda.setText("BUSQUEDA");
        busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                busquedaMousePressed(evt);
            }
        });
        busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaActionPerformed(evt);
            }
        });
        jPanel1.add(busqueda);

        guardar.setBackground(new java.awt.Color(0, 0, 0));
        guardar.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("GUARDAR");
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guardarMousePressed(evt);
            }
        });
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar);

        guardarComo.setBackground(new java.awt.Color(0, 0, 0));
        guardarComo.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        guardarComo.setForeground(new java.awt.Color(255, 255, 255));
        guardarComo.setText("GUARDAR COMO");
        guardarComo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guardarComoMousePressed(evt);
            }
        });
        guardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComoActionPerformed(evt);
            }
        });
        jPanel1.add(guardarComo);

        salir.setBackground(new java.awt.Color(0, 0, 0));
        salir.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("SALIR");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                salirMousePressed(evt);
            }
        });
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir);

        acercaDe.setBackground(new java.awt.Color(0, 0, 0));
        acercaDe.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        acercaDe.setForeground(new java.awt.Color(255, 255, 255));
        acercaDe.setText("ACERCA DE");
        acercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                acercaDeMousePressed(evt);
            }
        });
        acercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeActionPerformed(evt);
            }
        });
        jPanel1.add(acercaDe);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        atras.setBackground(new java.awt.Color(0, 0, 0));
        atras.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        atras.setForeground(new java.awt.Color(255, 255, 255));
        atras.setText("<-");
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                atrasMousePressed(evt);
            }
        });
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        jPanel2.add(atras);

        adelante.setBackground(new java.awt.Color(0, 0, 0));
        adelante.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        adelante.setForeground(new java.awt.Color(255, 255, 255));
        adelante.setText("->");
        adelante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adelanteMousePressed(evt);
            }
        });
        jPanel2.add(adelante);

        jPanel1.add(jPanel2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        areaTexto.setBackground(new java.awt.Color(102, 102, 102));
        areaTexto.setColumns(20);
        areaTexto.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        areaTexto.setRows(5);
        jScrollPane2.setViewportView(areaTexto);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel4.setText("   ");
        jPanel3.add(jLabel4);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        principal.cargarArchivo();
//        guardar.setEnabled(false);
//        reportes.setEnabled(true);
//        busqueda.setEnabled(true);
    }//GEN-LAST:event_abrirActionPerformed

    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        principal.reportes();
    }//GEN-LAST:event_reportesActionPerformed

    private void busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaActionPerformed
        principal.busquedaPatrones();
    }//GEN-LAST:event_busquedaActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        principal.guardarArchivo();
//        guardar.setEnabled(false);
//        reportes.setEnabled(false);
//        busqueda.setEnabled(false);
//        abrir.setEnabled(true);
    }//GEN-LAST:event_guardarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void guardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarComoActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        principal.nuevoArchivo();
//        reportes.setEnabled(false);
//        busqueda.setEnabled(false);
//        guardar.setEnabled(false);
    }//GEN-LAST:event_nuevoActionPerformed

    private void nuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMousePressed

    }//GEN-LAST:event_nuevoMousePressed

    private void abrirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirMousePressed

    }//GEN-LAST:event_abrirMousePressed

    private void reportesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportesMousePressed

    }//GEN-LAST:event_reportesMousePressed

    private void busquedaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_busquedaMousePressed

    }//GEN-LAST:event_busquedaMousePressed

    private void guardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMousePressed

    }//GEN-LAST:event_guardarMousePressed

    private void guardarComoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarComoMousePressed

    }//GEN-LAST:event_guardarComoMousePressed

    private void salirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMousePressed

    }//GEN-LAST:event_salirMousePressed

    private void atrasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMousePressed

    }//GEN-LAST:event_atrasMousePressed

    private void adelanteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adelanteMousePressed

    }//GEN-LAST:event_adelanteMousePressed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atrasActionPerformed

    private void nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseClicked

    }//GEN-LAST:event_nuevoMouseClicked

    private void nuevoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseReleased

    }//GEN-LAST:event_nuevoMouseReleased

    private void acercaDeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acercaDeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_acercaDeMousePressed

    private void acercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeActionPerformed
        JOptionPane.showMessageDialog(null, principal.getDatosCreador());
    }//GEN-LAST:event_acercaDeActionPerformed

    public JTextArea getAreaTexto() {
        return areaTexto;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    private javax.swing.JButton acercaDe;
    private javax.swing.JButton adelante;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton atras;
    private javax.swing.JButton busqueda;
    private javax.swing.JButton guardar;
    private javax.swing.JButton guardarComo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton reportes;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}

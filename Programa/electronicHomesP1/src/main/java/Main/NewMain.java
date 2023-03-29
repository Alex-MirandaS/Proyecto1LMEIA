/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Conexion.Conexion;
import Program.Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Conexion con = new Conexion();
        if (con.initConexion()) {
            Principal principal = new Principal();
            principal.start();
        }else{
            JOptionPane.showMessageDialog(null, "ERROR AL CONECTAR");
        }
    }
    
}

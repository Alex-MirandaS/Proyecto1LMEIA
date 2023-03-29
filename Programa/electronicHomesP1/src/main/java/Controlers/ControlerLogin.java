/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlers;

import Objects.Empleado;
import Program.Principal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class ControlerLogin {

    private Principal p;

    public ControlerLogin(Principal p) {
        this.p = p;
    }

    public Empleado permitAccess(String user, String pass) {
        ArrayList<Object> empleados;
        if (!user.isEmpty() && !pass.isEmpty()) {
            empleados = p.getEmpCRUD().seeAllData();
            for (int i = 0; i < empleados.size(); i++) {
                if (user.equals(((Empleado) empleados.get(i)).getCod_empleado())) {
                    if (pass.equals(((Empleado) empleados.get(i)).getContraseña())) {
                        return (Empleado) empleados.get(i);
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña Incorrecta, Intente de nuevo");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Existe un Valor Vacio");
        }
        return null;
    }

}

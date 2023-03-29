/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Program;

import CRUD.EmpleadoCRUD;
import CRUD.SucursalCRUD;
import Controlers.ControlerAdmin;
import Controlers.ControlerLogin;
import GUI.Admin;
import GUI.Bodega;
import GUI.Caja_V;
import GUI.Inventario_I;
import GUI.Login;
import Objects.Empleado;

/**
 *
 * @author alex
 */
public class Principal {

    private EmpleadoCRUD empCRUD;
    private SucursalCRUD sucCRUD;

    private ControlerLogin ctrlLog;
    private ControlerAdmin ctrlAdmin;

    private Login logGUI;
    private Admin adminGUI;
    private Bodega bodegaGUI;
    private Caja_V vendedorGUI;
    private Inventario_I inventarioGUI;

    public Principal() {
        this.empCRUD = new EmpleadoCRUD();
        this.sucCRUD = new SucursalCRUD();
        this.ctrlLog = new ControlerLogin(this);
        this.ctrlAdmin = new ControlerAdmin(this);
        this.logGUI = new Login(this);
        this.adminGUI = new Admin(this);
        this.bodegaGUI = new Bodega(this);
        this.vendedorGUI = new Caja_V(this);
        this.inventarioGUI = new Inventario_I(this);
    }

    public void start() {
        logGUI.setVisible(true);
    }

    public void verifyAccess(String user, String pass) {
        Empleado userL = ctrlLog.permitAccess(user, pass);
        if (userL != null) {
            openForRole(userL);
            logGUI.setVisible(false);
        }
    }

    private void openForRole(Empleado user) {
        switch (user.getRango()) {
            case "Admin":
                adminGUI.setVisible(true);
                startAdmin(user);
                break;
            case "Bodega":
                bodegaGUI.setVisible(true);
                break;
            case "Vendedor":
                vendedorGUI.setVisible(true);
                break;
            case "Inventario":
                inventarioGUI.setVisible(true);
                break;
        }
    }

    private void startAdmin(Empleado user) {

    }

    public ControlerAdmin getCtrlAdmin() {
        return ctrlAdmin;
    }

    public void setCtrlAdmin(ControlerAdmin ctrlAdmin) {
        this.ctrlAdmin = ctrlAdmin;
    }

    public SucursalCRUD getSucCRUD() {
        return sucCRUD;
    }

    public EmpleadoCRUD getEmpCRUD() {
        return empCRUD;
    }

    public void setEmpCRUD(EmpleadoCRUD empCRUD) {
        this.empCRUD = empCRUD;
    }

    public Caja_V getVendedorGUI() {
        return vendedorGUI;
    }

    public void setVendedorGUI(Caja_V vendedorGUI) {
        this.vendedorGUI = vendedorGUI;
    }

    public Admin getAdminGUI() {
        return adminGUI;
    }

    public void setAdminGUI(Admin adminGUI) {
        this.adminGUI = adminGUI;
    }

}

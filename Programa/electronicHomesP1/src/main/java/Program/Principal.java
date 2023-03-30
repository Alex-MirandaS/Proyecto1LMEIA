/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Program;

import CRUD.ClienteCRUD;
import CRUD.EmpleadoCRUD;
import CRUD.FacturaCRUD;
import CRUD.InventarioCRUD;
import CRUD.ProductoCRUD;
import CRUD.SucursalCRUD;
import CRUD.VentaCRUD;
import Controlers.ControlerAdmin;
import Controlers.ControlerLogin;
import Controlers.ControlerVendedor;
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
    private ClienteCRUD cliCRUD;
    private FacturaCRUD facCRUD;
    private InventarioCRUD invCRUD;
    private ProductoCRUD proCRUD;
    private VentaCRUD venCRUD;

    private ControlerLogin ctrlLog;
    private ControlerAdmin ctrlAdmin;
    private ControlerVendedor ctrlVend;

    private Login logGUI;
    private Admin adminGUI;
    private Bodega bodegaGUI;
    private Caja_V vendedorGUI;
    private Inventario_I inventarioGUI;

    public Principal() {
        this.empCRUD = new EmpleadoCRUD();
        this.sucCRUD = new SucursalCRUD();
        this.cliCRUD = new ClienteCRUD();
        this.facCRUD = new FacturaCRUD();
        this.invCRUD = new InventarioCRUD();
        this.proCRUD = new ProductoCRUD();
        this.venCRUD = new VentaCRUD();
        //CONTROLERS
        this.ctrlLog = new ControlerLogin(this);
        this.ctrlAdmin = new ControlerAdmin(this);
        this.ctrlVend = new ControlerVendedor(this);
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
                break;
            case "Bodega":
                bodegaGUI.setVisible(true);
                break;
            case "Vendedor":
                startVendedor(user);
                vendedorGUI.setVisible(true);
                break;
            case "Inventario":
                inventarioGUI.setVisible(true);
                break;
        }
    }

    private void startVendedor(Empleado user) {
        ctrlVend.initialData(user);
    }

    public ControlerAdmin getCtrlAdmin() {
        return ctrlAdmin;
    }

    public void setCtrlAdmin(ControlerAdmin ctrlAdmin) {
        this.ctrlAdmin = ctrlAdmin;
    }

    public ControlerVendedor getCtrlVend() {
        return ctrlVend;
    }

    public void setCtrlVend(ControlerVendedor ctrlVend) {
        this.ctrlVend = ctrlVend;
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

    public ClienteCRUD getCliCRUD() {
        return cliCRUD;
    }

    public void setCliCRUD(ClienteCRUD cliCRUD) {
        this.cliCRUD = cliCRUD;
    }

    public FacturaCRUD getFacCRUD() {
        return facCRUD;
    }

    public void setFacCRUD(FacturaCRUD facCRUD) {
        this.facCRUD = facCRUD;
    }

    public InventarioCRUD getInvCRUD() {
        return invCRUD;
    }

    public void setInvCRUD(InventarioCRUD invCRUD) {
        this.invCRUD = invCRUD;
    }

    public ProductoCRUD getProCRUD() {
        return proCRUD;
    }

    public void setProCRUD(ProductoCRUD proCRUD) {
        this.proCRUD = proCRUD;
    }

    public VentaCRUD getVenCRUD() {
        return venCRUD;
    }

    public void setVenCRUD(VentaCRUD venCRUD) {
        this.venCRUD = venCRUD;
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

    public Bodega getBodegaGUI() {
        return bodegaGUI;
    }

    public void setBodegaGUI(Bodega bodegaGUI) {
        this.bodegaGUI = bodegaGUI;
    }

    public Inventario_I getInventarioGUI() {
        return inventarioGUI;
    }

    public void setInventarioGUI(Inventario_I inventarioGUI) {
        this.inventarioGUI = inventarioGUI;
    }

}

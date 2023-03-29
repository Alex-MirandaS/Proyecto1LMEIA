/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author alex
 */
public class Venta {

    private String registro, num_factura, sku_producto;
    private int cantidad;

    public Venta(String registro, String num_factura, String sku_producto, int cantidad) {
        this.registro = registro;
        this.num_factura = num_factura;
        this.sku_producto = sku_producto;
        this.cantidad = cantidad;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(String num_factura) {
        this.num_factura = num_factura;
    }

    public String getSku_producto() {
        return sku_producto;
    }

    public void setSku_producto(String sku_producto) {
        this.sku_producto = sku_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}

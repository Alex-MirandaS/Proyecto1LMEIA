/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author alex
 */
public class Inventario{
    private String registro, sku_producto, cod_sucursal;
    private int cantidad;

    public Inventario(String registro, String sku_producto, String cod_sucursal, int cantidad) {
        this.registro = registro;
        this.sku_producto = sku_producto;
        this.cod_sucursal = cod_sucursal;
        this.cantidad = cantidad;
    }
    
    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getSku_producto() {
        return sku_producto;
    }

    public void setSku_producto(String sku_producto) {
        this.sku_producto = sku_producto;
    }

    public String getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }      
    
}

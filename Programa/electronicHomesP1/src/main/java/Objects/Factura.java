/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.sql.Date;

/**
 *
 * @author alex
 */
public class Factura {

    private String no_factura, cod_vendedor, cod_sucursal, nit_cliente;
    private Date fecha;
    private double total;

    public Factura(String no_factura, String cod_vendedor, String cod_sucursal, String nit_cliente, Date fecha, double total) {
        this.no_factura = no_factura;
        this.cod_vendedor = cod_vendedor;
        this.cod_sucursal = cod_sucursal;
        this.nit_cliente = nit_cliente;
        this.fecha = fecha;
        this.total = total;
    }

    public String getNo_factura() {
        return no_factura;
    }

    public void setNo_factura(String no_factura) {
        this.no_factura = no_factura;
    }

    public String getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(String cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }

    public String getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(String cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public String getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(String nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author alex
 */
public class Sucursal {

    private String codigo_id, nombre;

    public Sucursal(String codigo_id, String nombre) {
        this.codigo_id = codigo_id;
        this.nombre = nombre;
    }

    public String getCodigo_id() {
        return codigo_id;
    }

    public void setCodigo_id(String codigo_id) {
        this.codigo_id = codigo_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

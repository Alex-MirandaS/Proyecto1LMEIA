/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public abstract class ModelCRUD {

    protected String insertQ = "INSERT INTO ";
    protected String deleteQ = "";
    protected String updateQ = "";
    protected String selectTQ = "SELECT * FROM ";
    protected String table;

    public ModelCRUD(String table) {
        this.table = table;
    }

    public abstract boolean insert(Object o);

    public abstract ArrayList<Object> seeAllData();

}

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
    protected String updateQ = "UPDATE ";
    protected String whereQ = " WHERE ";
    protected String selectTQ = "SELECT * FROM ";
    protected String table;
    protected int numColumns;

    public ModelCRUD(String table, int numColumns) {
        this.table = table;
        this.numColumns = numColumns;
    }

    public abstract boolean insert(Object o);

    public abstract boolean update(Object dataChange);

    public abstract ArrayList<Object> seeAllData();

    public abstract Object getData(String id);

    protected abstract String getSets(Object dataChange, Object dataOriginal);

}

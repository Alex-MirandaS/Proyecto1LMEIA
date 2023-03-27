/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alex
 */
public class Conexion {
    public static Connection dbConection;
    String url = "jdbc:postgresql://localhost:5432/electronic_homesp1";
    String user = "adminehp1";
    String pswrd = "admin123";
    
    public boolean initConexion(){
        try{
            dbConection = DriverManager.getConnection(url, user, pswrd);
            return true;
        }catch(Exception e){
            System.err.println("Error al conectar con la base de datos: "+ e.getMessage());
            return false;
        }
    }
    
    
}

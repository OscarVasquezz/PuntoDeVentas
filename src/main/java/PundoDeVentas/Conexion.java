/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PundoDeVentas;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Oz
 */
public class Conexion {
    Connection con;
    
    String url ="jdbc:mysql://localhost:3306/sistema_ventas";
    String user="root";
    String pass="";
    
    public Connection Conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            System.out.println("CONEXION EXITOSA");
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    /*
    public static void main(String[] args){
    Conexion con = new Conexion();
    System.out.println(con.Conectar());    
    }
    
    */
    
}

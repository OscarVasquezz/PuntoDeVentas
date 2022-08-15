/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PundoDeVentas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Oz
 */
public class VendedoresDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();

public int filtro (String nombre, String pass){
    String sql ="SELECT * FROM vendedor WHERE nombre="+"'"+nombre+"'"+" AND password="+"'"+pass+"'"+";";
        try{
            con =conectar.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            /*System.out.println(rs.next());
            System.out.println("Codigo: "+rs.getInt(1)+"");
            System.out.println("Nombre: "+rs.getString(2)+"");
            System.out.println("Caja: "+rs.getString(3)+"");
            System.out.println("Ventas: "+rs.getString(4)+"");
            System.out.println("Genero: "+rs.getString(5)+"");
            System.out.println("Password: "+rs.getString(6)+"");
            System.out.println("Password: "+rs.getString(7)+"");
            return rs.next();*/
           if (rs.next()){
               if(rs.getInt(7)==1){
                    return 1;
               }else{ return 0;}           
           }

        }catch(Exception e){
            
        }
        return -1;
}


public static void main(String[] args){
    VendedoresDAO dv=new VendedoresDAO();
    dv.filtro("Carlos Herrera", "LaPass");
}


}

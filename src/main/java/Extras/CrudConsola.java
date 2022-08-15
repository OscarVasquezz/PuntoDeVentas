/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Extras;

import PundoDeVentas.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Oz
 */
public class CrudConsola {

        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        Conexion conectar= new Conexion();
        
public void menu(){
          
            while(true){
                Scanner sp = new Scanner (System.in);
                System.out.println(".................................");
                System.out.println(".        MENU PRINCIPAL         .");
                System.out.println(".1. INSETAR                     .");
                System.out.println(".2. MODIFICAR                   .");
                System.out.println(".3. CONSULTAR                   .");
                System.out.println(".4. ELIMINAR                    .");
                System.out.println(".5. SALIR                       .");
                System.out.println("................................");
                int respuesta = sp.nextInt();
                CrudConsola bj = new CrudConsola();
                
                switch(respuesta){
                    case 1:
                        /*Insertar datos*/
                        System.out.println("Nombre del Alumno:");
                        String nombre = sp.nextLine();
                        System.out.println("Direccion del Alumno:");
                        String direccion = sp.nextLine();
                        System.out.println("Telefono del Alumno:");
                        String telefono = sp.nextLine();
                        /*Ejecucion de clases*/
                        bj.Insertar(nombre, direccion, telefono);

                        break;                        
                    case 2:
                        
                        /*Modificar Informacion en la base de datos*/
                        System.out.println("Ingresar Codigo de Alumno:");
                        int Codigo = sp.nextInt();
                        System.out.print("Ingresar nuevo Nombre del Alumno:");
                        String nombre2 = sp.nextLine();
                        System.out.print("Ingresar nueva Direccion del Alumno:");
                        String direccion2 = sp.nextLine();
                        System.out.print("Ingresar nuevo Telefono del Alumno:");
                        String telefono2 = sp.nextLine();
                        /*ejecucion de clases*/
                        bj.Modificar(Codigo,nombre2, direccion2, telefono2);
                        break;                        
                    case 3:
                        
                        bj.Consultar();
                        break;                        
                    case 4:
                        
                        int Codigo4=sp.nextInt();
                        bj.Eliminar(Codigo4);
                        break;
                    case 5:
                        
                        System.exit(0);          
                        break;
                    default:
                        throw new AssertionError();
                }
            }



}
        
        
/*Clase para listar informacion de base de datos*/
        public void Consultar(){
            String sql = "SELECT * FROM alumno";
            try{
                con = conectar.Conectar();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()){
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                }
            }catch(Exception e){                     
            }            
        }
/*Clase para insertar informacion de base de datos*/
        
        public void Insertar(String Nombre, String Direccion, String Telefono){
            String sql = "INSERT INTO alumno(Nombre,Direccion,Telefono)VALUES (?,?,?)";
            try{
                con = conectar.Conectar();
                ps = con.prepareStatement(sql);
                ps.setString(1,Nombre);
                ps.setString(2,Direccion);
                ps.setString(3,Telefono);
                ps.executeUpdate();            
            }catch(Exception e){                     
            }
        }
        
/*modificar de informacion en base de datos*/
        
        public void Modificar(int Codigo, String Nombre, String Direccion, String Telefono){
        String sql = "UPDATE alumno SET Nombre=?, Direccion=?, Telefono=? WHERE Codigo=?";

                        try{
                            con = conectar.Conectar();
                            ps = con.prepareStatement(sql);
                            ps.setInt(1,Codigo);
                            ps.setString(2,Nombre);
                            ps.setString(3,Direccion);
                            ps.setString(4,Telefono);
                            ps.executeUpdate();
                            //rs = ps.executeQuery();
                        }catch(Exception e){                     
                        }    
        }
        
        
        public void Eliminar(int Codigo){
        String sql = "DELETE FROM alumno WHERE Codigo=?";

                        try{
                            con = conectar.Conectar();
                            ps = con.prepareStatement(sql);
                            ps.setInt(1,Codigo);
                            ps.executeUpdate();
                        }catch(Exception e){                     
                        }    
        }
        
       
        
        public static void main(String[] args){
            CrudConsola bj = new CrudConsola();
            bj.menu();
        }
        
}

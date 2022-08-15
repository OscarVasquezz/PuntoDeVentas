/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PundoDeVentas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Oz
 */
public class Administrador extends JFrame{
    JTabbedPane pestañas = new JTabbedPane();
    JPanel sucursales = new JPanel();
    JPanel vendedores = new JPanel();
    JPanel clientes = new JPanel();
    JPanel productos = new JPanel();
    
    private void inicio(){
        setTitle("ADMINISTRADOR");//titulo de panel
        setDefaultCloseOperation(EXIT_ON_CLOSE);//cerrar toda ejecucion
        setLocationRelativeTo(null);
        setBounds(50, 175,700,800);//dimenciones de panel
        setVisible(true);//activando panel
        pestañas.addTab("Sucursales",sucursales);
        pestañas.addTab("Productos",productos);
        pestañas.addTab("Clientes",clientes);
        pestañas.addTab("Vendedores",vendedores);
        add(pestañas);
        
        
    }
    
    public void ejecutar(){
        inicio();
    }


}

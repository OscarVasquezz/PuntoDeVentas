/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PundoDeVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Oz
 */
public class Login extends JFrame{
    JPanel p1 = new JPanel();//creacion de panel
    JTextField t1 = new JTextField();//creacion de caja de texto
    JPasswordField t2 = new JPasswordField();//creacion caja de texto tipo pasword
    
    private void inicio(){
        setTitle("LOGIN");//titulo de panel
        setDefaultCloseOperation(EXIT_ON_CLOSE);//cerrar toda ejecucion
        setLocationRelativeTo(null);
        setBounds(50, 175,300,400);//dimenciones de panel
        setVisible(true);//activando panel
        p1.setLayout(null);
        add(p1);

//insertando texto y contenido de texto
        JLabel l1=new JLabel ("Nombre");
        JLabel l2=new JLabel ("Password");

        int x=50, y=75, l=80, h=40, lx=100, rh=15;

        l1.setBounds(x,y,l,h);//dimenciones de textos e insercion en panel
        p1.add(l1);
        t1.setBounds(x,y+40,l+lx,h-rh);//dimenciones de caja de texto e insercion en panel
        p1.add(t1);
        
        l2.setBounds(x,y+60,l,h);//dimenciones de textos e insercion en panel
        p1.add(l2);
        t2.setBounds(x,y+100,l+lx,h-rh);//dimenciones de caja de texto e insercion en panel
        p1.add(t2);
//Creacion de boton
        JButton b1 = new JButton("Ingresar");
        b1.setBounds(x,y+150,l+lx,h-rh);
        p1.add(b1);    
        
        ActionListener verificar = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                VendedoresDAO vd = new VendedoresDAO();
                int respuesta = vd.filtro(t1.getText(), t2.getText());
            
                switch (respuesta) {
                    case 1:
                        //System.out.println("Es Admin");
                        JOptionPane.showMessageDialog(null,"Es Admin");
                        break;
                    case 0:
                        //System.out.println("Es Vendedor");
                        JOptionPane.showMessageDialog(null,"Es Vendedor");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Datos Incorrectos");
                        break;
                }
            }        
        };
        b1.addActionListener(verificar);
    }
    
    public void ejecutar(){
        inicio();
    }
    
    public static void main(String[] args){
    Login l = new Login();
    l.ejecutar();
    }
}

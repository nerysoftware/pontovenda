/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author alvaro
 */
public class Conectar {
     
    Connection conect = null;

    public Connection conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/pontovenda", "root", "");
            System.out.println("CONECTADO AO BANCO DE DADOS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ao conectar!" + e);
        }
        return conect;
    } 

    
    //CONEXAO HOSPEDADA
   /* public Connection conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://mysql472.umbler.com:41890/pontovenda", "nery_db", "acessonery"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar!!" + e);
        }
        return conect; 
    }*/   
    
}
    


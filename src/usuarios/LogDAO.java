/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import principal.ConnectionFactory;


/**
 *
 * @author nerysoftware
 */
public class LogDAO {
    
           public void create(LogBEAN c){
        Connection con = ConnectionFactory.getConnection();
            PreparedStatement stnt = null; 
        try {
           
            
            stnt = con.prepareStatement("INSERT INTO log (nome_user,data,hora)VALUES(?,?,?)");
            
            stnt.setString(1,c.getNome_user());
            stnt.setString(2,c.getData());
            stnt.setString(3,c.getHora());
            
            System.out.println("log Salvo");
          
            
           
                 
            stnt.executeUpdate();
            
           // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(LogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        
    
}
                 
           }
           
           
            public List<LogBEAN> read() {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<LogBEAN> carga = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM log");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

               LogBEAN cargas = new LogBEAN();

                cargas.setId(rs.getInt("id"));
                cargas.setNome_user(rs.getString("nome_user"));
                cargas.setData(rs.getString("data"));
                cargas.setHora(rs.getString("hora"));
               
                
                carga.add(cargas);
                
            
            }     
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(LogBEAN.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return carga;
    
    }
           
}
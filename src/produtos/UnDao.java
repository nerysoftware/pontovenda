/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;


import cad_vendedor.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import os.Pedido;
import os.salva_pedido;
import principal.ConnectionFactory;

/**
 *
 * @author nerysoftware
 */
public class UnDao {
    
      public void create(UnBean c){
     Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null; 
        try {
        stmt = con.prepareStatement("INSERT INTO un_medida(un) VALUES (?)");
            stmt.setString(1,c.getUn());
           
            
          
            
              stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(UnDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        
 }
    
    
}
      
      
      public List<UnBean> read() {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<UnBean> un = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM un_medida");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                UnBean vender = new UnBean();

                vender.setId(rs.getInt("id"));              
                vender.setUn(rs.getString("un"));
              
                
                un.add(vender);
                
            
            }     
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(UnDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
          return un;
      
      
      
}
      
}




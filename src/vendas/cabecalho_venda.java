/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import principal.ConnectionFactory;

/**
 *
 * @author nerysoftware
 */
public class cabecalho_venda {
    public void create(cabecalho_bean c){
        Connection con = ConnectionFactory.getConnection();
            PreparedStatement stnt = null; 
        try {
           
            
            stnt = con.prepareStatement("INSERT INTO cabecalho_venda (nome_cliente,data_lancamento,vendedor)VALUES(?,?,?)");
            
            stnt.setString(1,c.getNome_cliente());
            stnt.setString(2,c.getData_lancamento());
            stnt.setString(3,c.getVendedor());
            
           
                 
            stnt.executeUpdate();
            
           // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(cabecalho_venda.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        
    
}
    }  
    
  
}


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
import javax.swing.JOptionPane;
import principal.ConnectionFactory;

/**
 *
 * @author nerysoftware
 */
public class itens_vendas {
    
    public void create(itens_bean c){
        Connection con = ConnectionFactory.getConnection();
            PreparedStatement stnt = null; 
        try {
           
            
            stnt = con.prepareStatement("INSERT INTO itens_venda(cod_cabecalho,codigo_itens,tipo,descricao,quantidade,valor,valor_total)VALUES(?,?,?,?,?,?,?)");
            
            stnt.setString(1,c.getCod_cabecalho());
            stnt.setString(2,c.getCod_itens()); 
            stnt.setString(3,c.getTipo());
            stnt.setString(4,c.getDescricao());
            stnt.setString(5,c.getQuantidade());;
            stnt.setString(6,c.getValor());        
            stnt.setString(7,c.getValor_total());
            
            
                    
    
           
                 
            stnt.executeUpdate();
            
//            JOptionPane.showMessageDialog(null, "ITENS");  
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
//            Logger.getLogger(cabecalho_venda.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        
    
}
   
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas_pagar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import os.OrdenCarregamento;
import principal.ConnectionFactory;

/**
 *
 * @author CLIENTE
 */
public class CpDao {
    
    public void create(CpBean c){
     Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null; 
        try {
            stmt = con.prepareStatement("INSERT INTO contas_pagar(descricao,data,valor,situacao) VALUES (?,?,?,?)");
           
            stmt.setString(1,c.getDescricao());
            stmt.setString(2,c.getData());
            stmt.setString(3,c.getValor());
            stmt.setString(4,c.getSituacao());
         
          
            
              stmt.executeUpdate();
//            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(NovoCp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        
 }
    
}
    
    
     public List<CpBean> read() {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<CpBean> carga = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM contas_pagar");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

             CpBean cargas = new CpBean();

                cargas.setId(rs.getInt("id"));
                cargas.setDescricao(rs.getString("descricao"));
                cargas.setData(rs.getString("data"));
                cargas.setValor(rs.getString("valor"));
                cargas.setSituacao(rs.getString("situacao"));
             
                
                carga.add(cargas);
                
            
            }     
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(CpBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return carga;
    
    }
    

    
}

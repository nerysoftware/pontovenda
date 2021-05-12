
package model.dao;

import principal.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.cabecalho_bean;
import view.Consulta;



public class cabecalho_dao {
    
    public void create(cabecalho_bean c){
        Connection con = ConnectionFactory.getConnection();
            PreparedStatement stnt = null; 
        try {
           
            
            stnt = con.prepareStatement("INSERT INTO cabecalho_os (nome_cliente,data_lancamento)VALUES(?,?)");
            
            stnt.setString(1,c.getNome_cliente());
            stnt.setString(2,c.getData_lancamento());
            
           
                 
            stnt.executeUpdate();
            
           // JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(cabecalho_dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        
    
}
         
    }  
          
    public List<cabecalho_bean> read() {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<cabecalho_bean> listar = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM cabecalho_os");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                cabecalho_bean listaCabecalho = new cabecalho_bean();

                listaCabecalho.setId(rs.getInt("id"));
                listaCabecalho.setNome_cliente(rs.getString("nome_cliente"));
                listaCabecalho.setData_lancamento(rs.getString("datacontrato"));
                
                
                listar.add(listaCabecalho);
                
            
            }     
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listar;
    
    }
    
   
    public List<cabecalho_bean> readForDesc(String sql2) {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<cabecalho_bean> cabecalhoDesc = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement(sql2);
//            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                cabecalho_bean cabecalho = new cabecalho_bean();

                cabecalho.setId(rs.getInt("id"));
                cabecalho.setNome_cliente(rs.getString("nome_cliente"));
                cabecalho.setData_lancamento(rs.getString("data_lancamento"));
                
               
                
                cabecalhoDesc.add(cabecalho);
                
                        //JOptionPane.showMessageDialog(null, "tudo ok aqui");  
            }     
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cabecalhoDesc;
    
    }
    
    
    
    
} 
        


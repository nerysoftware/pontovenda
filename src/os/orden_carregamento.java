/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

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


/**
 *
 * @author alvaro
 */
public class orden_carregamento {
    public void create(OrdenCarregamento cr){
        
        Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null; 
        try {
            stmt = con.prepareStatement("INSERT INTO carga(id_pedido,cliente,endereco,itens,status) VALUES (?,?,?,?,?)");
            stmt.setString(1,cr.getId_pedido());
            stmt.setString(2,cr.getCliente());
            stmt.setString(3,cr.getEndereco());
            stmt.setString(4,cr.getProduto());
            stmt.setString(5,cr.getStatus());
          
            
              stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!"); 
            
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(salva_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        
 }
}
    public List<OrdenCarregamento> read() {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<OrdenCarregamento> carga = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM carga");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                OrdenCarregamento cargas = new OrdenCarregamento();

                cargas.setId_oc(rs.getInt("id_oc"));
                cargas.setId_pedido(rs.getString("id_pedido"));
                cargas.setCliente(rs.getString("cliente"));
                cargas.setEndereco(rs.getString("endereco"));
                cargas.setProduto(rs.getString("itens"));
                cargas.setStatus(rs.getString("status"));
                
                carga.add(cargas);
                
            
            }     
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(OrdenCarregamento.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return carga;
    
    }
    
    public List<OrdenCarregamento> readForDesc(String desc) {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<OrdenCarregamento> carga = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM carga WHERE id_oc AND cliente LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                OrdenCarregamento cargas = new OrdenCarregamento();

                cargas.setId_oc(rs.getInt("id_oc"));
                cargas.setId_pedido(rs.getString("id_pedido"));
                cargas.setCliente(rs.getString("cliente"));
                cargas.setEndereco(rs.getString("endereco"));
                cargas.setProduto(rs.getString("itens"));
                cargas.setStatus(rs.getString("status"));
                
                carga.add(cargas);
                
            
            }     
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return carga;
    
    }
        
    }
    



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



public class salva_pedido {
    public void create(Pedido c){
     Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null; 
        try {
        stmt = con.prepareStatement("INSERT INTO pedidos(cliente,produtos,endereco) VALUES (?,?,?)");
            stmt.setString(1,c.getCliente());
            stmt.setString(2,c.getProdutos());
            stmt.setString(3,c.getEndereco());
          
            
              stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(salva_pedido.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        
 }
}
 public List<Pedido> read() {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<Pedido> carga = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM pedidos");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Pedido cargas = new Pedido();

                cargas.setId(rs.getInt("id"));              
                cargas.setCliente(rs.getString("cliente"));
                cargas.setProdutos(rs.getString("produto"));
                cargas.setEndereco(rs.getString("endereco"));
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
 public List<Pedido> readForDesc(String desc) {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<Pedido> pedidos = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement("SELECT * FROM pedidos WHERE id LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                Pedido produto = new Pedido();

                produto.setId(rs.getInt("id"));
                produto.setCliente(rs.getString("cliente"));
                produto.setProdutos(rs.getString("produtos"));
                produto.setEndereco(rs.getString("endereco"));
                pedidos.add(produto);
                
            
            }     
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pedidos;
    
    }
}

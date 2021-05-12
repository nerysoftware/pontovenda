/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import model.bean.itens_bean;
import view.Consulta;
import view.ContratoAlterar;

/**
 *
 * @author asnsoftware
 */
public class itens_dao {

   public void create(itens_bean c){
        Connection con = ConnectionFactory.getConnection();
            PreparedStatement stnt = null; 
        try {
           
            
            stnt = con.prepareStatement("INSERT INTO itens_os(cod_cabecalho,codigo_itens,quantidade,valor,situacao,valor_total)VALUES(?,?,?,?,?,?)");
            
            stnt.setString(1,c.getCod_cabecalho());
            stnt.setString(2,c.getCod_itens());
            stnt.setString(3,c.getQuantidade());
            stnt.setString(4,c.getValor());
            stnt.setString(5,c.getSituacao());
            stnt.setString(6,c.getValor_total());
            
            
                    
            
           
                 
            stnt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(cabecalho_dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stnt);
        
    
}
   
    }
   
    public List<itens_bean> read(String desc) {
            
            Connection con = ConnectionFactory.getConnection();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<itens_bean> listar = new ArrayList<>();
        
        try {
            
            
            stmt = con.prepareStatement(desc);
//            stmt.setString(1, desc);
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                itens_bean listaItens = new itens_bean();

                listaItens.setId(rs.getInt("id"));
                listaItens.setCod_itens(rs.getString("codigo_itens"));
                listaItens.setQuantidade(rs.getString("quantidade"));
                listaItens.setValor(rs.getString("valor"));
                listaItens.setValor_total(rs.getString("valor_total"));
                listaItens.setSituacao(rs.getString("situacao"));
                
                
                listar.add(listaItens);
                
            
            }     
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
            Logger.getLogger(ContratoAlterar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listar;
    
    }
  
   
   
    
}

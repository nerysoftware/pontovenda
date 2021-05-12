/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import principal.ConnectionFactory;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.cabecalho_bean;
import model.bean.itens_bean;
import model.dao.cabecalho_dao;
import model.dao.itens_dao;




/**
 *
 * @author asnsoftware
 */
public class Contrato extends javax.swing.JFrame {

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;            
            ResultSet rs = null;
             
    
    public Contrato() {
        initComponents();
        //buscarProduto("select * from produto");
     
      
    }
    
    public void limparCampos(){
         DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();

       // while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        //}
        Txt_BuscaCliente.setText("");
        Txt_BuscaProduto.setText("");
        Txt_quantidade.setText("");
        Txt_valor.setText("");
       // ComboProduto.("");
       
    }
    
    
    public void salvarCabecalho(){
        
      
       
     
        cabecalho_bean c = new cabecalho_bean();
        cabecalho_dao dao = new cabecalho_dao(); 
        
       
              
        c.setNome_cliente((String)Metodos.separadorDoisCampoCB_retona_Codigo(ComboCliente));
        c.setData_lancamento(txt_data.getText());
        dao.create(c);
        
        
        
         
        selectMax();
        salvarItens();
         //limparCampos();
         
          JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
      
   }  
    
    public void salvarItens(){
        
        
        itens_bean c = new itens_bean();
        itens_dao dao = new itens_dao();
        
       
       
        
        for (int i = 0; i < Tabela.getRowCount(); i++) {  
        
        c.setCod_cabecalho(TxtCod_cabecalho.getText());
        c.setCod_itens((String) Tabela.getValueAt(i, 0));
        c.setQuantidade((String) Tabela.getValueAt(i,1));
        c.setValor((String) Tabela.getValueAt(i,2) );
        c.setSituacao((String)Tabela.getValueAt(i,3));
        c.setValor_total(TxtTotal.getText());
       
         
        dao.create(c);
       
        }
        
         //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");  
         //dao.create(c);
          
    }
    
    public void selectMax(){
        try {
                Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pontovenda","root","acessonery");
                PreparedStatement p = con.prepareStatement(" SELECT * FROM cabecalho_os  WHERE id = (SELECT MAX(id) FROM cabecalho_os)");
                    ResultSet r = p.executeQuery();
                
                 ///TxtCod_cabecalho.setText(r.getString ("Id"));

               
              
                while (r.next()){
                    TxtCod_cabecalho.setText(r.getString ("Id"));
                 

                }
            } catch (SQLException ex) {

                Logger.getLogger(Contrato.class.getName()).log(Level.SEVERE, null, ex);

            }

    }

    
    public void getSum(){
       double count=0;
       for (int i=0; i<=Tabela.getRowCount()-1;i++) {
       count+=Double.parseDouble(Tabela.getValueAt(i, 4).toString());
    }   
      TxtTotal.setText(String.valueOf(count));
    }
    
    
    public void bucarCliente(String sql){
               
//       String sql = "select * from cliente";


       try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
               ComboCliente.removeAllItems();
               
            while (rs.next()){
             
                ComboCliente.addItem(rs.getString("codigo_us")+"-"+rs.getString("nome_us"));
                ComboCliente.showPopup();
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Contrato.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
    }
    
    public void buscarProduto(String sql){
       
        
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            ComboProduto.removeAllItems();
               
            while (rs.next()){
             
                ComboProduto.addItem(rs.getString("codigo_pro")+"-"+rs.getString("nome_pro"));
                
               // ComboProduto.showPopup();
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Contrato.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
       
       
    } 
        
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        TxtCod_cabecalho = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        ComboProduto = new javax.swing.JComboBox<>();
        Txt_BuscaProduto = new javax.swing.JTextField();
        Txt_quantidade = new javax.swing.JTextField();
        Txt_valor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ComboCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_data = new javax.swing.JFormattedTextField();
        Txt_BuscaCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ComboBoxStatus = new javax.swing.JComboBox<>();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Quantidade", "Valor UN", "Situação", "Total"
            }
        ));
        jScrollPane1.setViewportView(Tabela);

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ComboProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        Txt_BuscaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_BuscaProdutoKeyPressed(evt);
            }
        });

        jLabel1.setText("qnt");

        jLabel2.setText("valor");

        jLabel3.setText("Produto");

        ComboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel4.setText("Cliente");

        jLabel5.setText("Data Lançamento");

        try {
            txt_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        Txt_BuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_BuscaClienteActionPerformed(evt);
            }
        });
        Txt_BuscaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_BuscaClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_BuscaClienteKeyReleased(evt);
            }
        });

        jLabel7.setText("Pesquisa");

        TxtTotal.setEditable(false);
        TxtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setText("Total:");

        ComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ABERTO\t", "FECHADO", "CANCELADO" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(Txt_BuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(99, 99, 99)
                                                .addComponent(jLabel3)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel2))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(Txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2))))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(TxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Txt_BuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(54, 54, 54)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_BuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_BuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(Txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Date sistemaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        txt_data.setText(formato.format(sistemaData));
    }//GEN-LAST:event_formWindowOpened

    private void Txt_BuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_BuscaClienteActionPerformed
//       bucarCliente("select * from cliente where nome like '%"+ Txt_BuscaCliente.getText()+"%'");
    }//GEN-LAST:event_Txt_BuscaClienteActionPerformed

    private void Txt_BuscaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_BuscaClienteKeyReleased
       
    }//GEN-LAST:event_Txt_BuscaClienteKeyReleased

    private void Txt_BuscaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_BuscaClienteKeyPressed
    
        
        bucarCliente("select * from usuarios where nome_us like '%"+ Txt_BuscaCliente.getText()+"%'");
         //bucarCliente("select * from cliente where nome like '%"+ Metodos.separadorDoisCampoCB_retona_Codigo(ComboCliente)+ "%'");
    
    }//GEN-LAST:event_Txt_BuscaClienteKeyPressed

    private void Txt_BuscaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_BuscaProdutoKeyPressed
 //bucarCliente("SELECT * FROM cabecalholocacao WHERE cod_cliente ='" + Metodos.separadorDoisCampoCB_retona_Codigo(ComboCliente)+ "'");      
  buscarProduto("select * from produtos where nome_pro like '%"+ Txt_BuscaProduto.getText()+"%'");
    }//GEN-LAST:event_Txt_BuscaProdutoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     salvarCabecalho(); 
     salvarItens();
     
   // selectMax();
   
    dispose();
    Contrato frame = new Contrato();
    frame.setVisible(true);
     
       // salvarItens();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) Tabela.getModel();
        tabela.addRow(new String[]{(String)ComboProduto.getSelectedItem(), Txt_quantidade.getText(),Txt_valor.getText(),(String)ComboBoxStatus.getSelectedItem(),String.valueOf(Double.parseDouble( Txt_quantidade.getText())*Double.parseDouble( Txt_valor.getText()))});
        getSum();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Contrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
                new Contrato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxStatus;
    private javax.swing.JComboBox<Object> ComboCliente;
    private javax.swing.JComboBox<String> ComboProduto;
    private javax.swing.JTable Tabela;
    private javax.swing.JTextField TxtCod_cabecalho;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JTextField Txt_BuscaCliente;
    private javax.swing.JTextField Txt_BuscaProduto;
    private javax.swing.JTextField Txt_quantidade;
    private javax.swing.JTextField Txt_valor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JFormattedTextField txt_data;
    // End of variables declaration//GEN-END:variables
}

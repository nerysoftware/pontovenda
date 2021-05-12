/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import os.OC;
import os.OrdenCarregamento;
import os.orden_carregamento;
import produtos.FrmListaProd;
import relatorios.ConnectionFactory;
import static vendas.FrmCaixa.tabela;


import vendas.VendasSql;

/**
 *
 * @author alvaro
 */
public final class ContasReceber extends javax.swing.JFrame {

  

    /**
     * Creates new form CantasReceber
     */
    public ContasReceber() {
        initComponents();
        TabelaTitulo.getTableHeader().setDefaultRenderer(new financeiro.EstiloTabelaHeaderCP());
        TabelaTitulo.setDefaultRenderer(Object.class, new financeiro.EstiloTabelaRendererCP());       
        TabelaTitulo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        
       // limparCampos();
    }
   //METODO DE SOMA
    public void getSum(){
     double count=0;
       for (int i=0; i<=TabelaTitulo.getRowCount()-1;i++) {
       count+=Double.parseDouble(TabelaTitulo.getValueAt(i, 4).toString());
    }   
      total.setText(String.valueOf(count));
    }
    
    void limparCampos() {
        if (TabelaTitulo.getSelectedRow() > -1) {
            TabelaTitulo.removeRowSelectionInterval(TabelaTitulo.getSelectedRow(), TabelaTitulo.getSelectedRow());
        }
        data.setDate(null);
        buscar.setText("");
        //FinanceiroSql.listar("");
    }
    
    public void cancelar(){
          try {
      for (int i = 0; i < TabelaTitulo.getRowCount(); i++) {
          
         
             Connection con = (Connection) ConnectionFactory.getConnection();
           // Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pontovenda","root","acessonery");
            PreparedStatement p = con.prepareStatement(" update vendas set situacao = ? where numero_ven = ? ");
             
            
             p.setString(2, id.getText());
             p.setString(1 , StatusAberto.getText());
            // p.setString(1,(String) TabelaTitulo.getValueAt(i, 0));
            // p.setString(1,(String) TabelaTitulo.getValueAt(i, 3));
                       
         
                
             p.execute();      
	     p.close();
         
              readJTableForDesc(buscar.getText()); 
            
            }  
            
            
             
             
            
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Dados Alterados Com Sucesso");
        
    }
 public void baixar(){
   try {
      for (int i = 0; i < TabelaTitulo.getRowCount(); i++) {
      
     Connection con = (Connection) ConnectionFactory.getConnection();
            //Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pontovenda","root","acessonery");
            PreparedStatement p = con.prepareStatement(" update vendas set situacao = ? where numero_ven = ? ");
             
            
             p.setString(2, id.getText());
             p.setString(1 , STATUS.getText());
            // p.setString(1,(String) TabelaTitulo.getValueAt(i, 0));
            // p.setString(1,(String) TabelaTitulo.getValueAt(i, 3));
                       
         
                
             p.execute();      
	     p.close();
         
              readJTableForDesc(buscar.getText()); 
            
            }  
            
            
             
             
            
        } catch (SQLException ex) {
            Logger.getLogger(ContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Dados Alterados Com Sucesso");
        
 } 
    
    
  public void calcular() {
         Double soma = 0.0;
  for (int i = 0 ; i < TabelaTitulo.getColumnCount() ; i++)
  {
     if (TabelaTitulo.getValueAt(i, 0).equals(true))
     {
      Double valor =(Double) TabelaTitulo.getValueAt(i, 3 );
      soma += valor;
     }
   total.setText(String.valueOf(soma));
  //valorTotal = 0;
}
 
}
   
  
  public void readJTableForDesc(String desc){
        DefaultTableModel modelo = (DefaultTableModel) TabelaTitulo.getModel();
        modelo.setNumRows(0);
        FinanceiroSql pdao = new FinanceiroSql();
       
        for (Financeiro p : pdao.readForDesc(desc)) {
        
            modelo.addRow(new Object[]{
            p.getPrimaryKey(),
            p.getCliente(),
            p.getData(),
            p.getSituacao(),
            p.getTotal()
         
            
           
       });
    
    
    }
  }
   public void BuscarSituacao(String status,String nome){
        DefaultTableModel modelo = (DefaultTableModel) TabelaTitulo.getModel();
        modelo.setNumRows(0);
        FinanceiroSql pdao = new FinanceiroSql();
       
        for (Financeiro p : pdao.BuscarSituacao(status,nome)) {
        
            modelo.addRow(new Object[]{
            p.getPrimaryKey(),
            p.getCliente(),
            p.getData(),
            p.getSituacao(),
            p.getTotal()
         
            
           
       });
   
    
    }
  }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StatusAberto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        codigoL1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaTitulo = new javax.swing.JTable();
        data = new com.toedter.calendar.JDateChooser();
        buscF = new javax.swing.JButton();
        ventasH = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        NomeT1 = new javax.swing.JLabel();
        ComboBoxStatus = new org.bolivia.combo.SComboBoxBlue();
        STATUS = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        atualizar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        buscF1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contas a Receber");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        StatusAberto.setText("ABERTO");

        jPanel1.setBackground(new java.awt.Color(0, 204, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBackground(new java.awt.Color(34, 102, 145));
        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setOpaque(false);
        buscar.setPhColor(new java.awt.Color(255, 255, 255));
        buscar.setPlaceholder("NOME DO CLIENTE");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 180, -1));

        codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/buscarL.png"))); // NOI18N
        jPanel1.add(codigoL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 52));

        TabelaTitulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NÚMERO VENDA", "CLIENTE", "DATA", "SITUAÇÃO", "VALOR"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabelaTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaTituloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaTitulo);
        if (TabelaTitulo.getColumnModel().getColumnCount() > 0) {
            TabelaTitulo.getColumnModel().getColumn(0).setResizable(false);
            TabelaTitulo.getColumnModel().getColumn(1).setResizable(false);
            TabelaTitulo.getColumnModel().getColumn(2).setResizable(false);
            TabelaTitulo.getColumnModel().getColumn(3).setResizable(false);
            TabelaTitulo.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 950, 290));

        data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 150, 30));

        buscF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buscF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/buscaF1.png"))); // NOI18N
        buscF.setToolTipText("Buscar");
        buscF.setBorder(null);
        buscF.setBorderPainted(false);
        buscF.setContentAreaFilled(false);
        buscF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscF.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscF.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/buscaF2.png"))); // NOI18N
        buscF.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscFActionPerformed(evt);
            }
        });
        jPanel1.add(buscF, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, -1));

        ventasH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ventasH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/vendasH.png"))); // NOI18N
        ventasH.setToolTipText("Buscar");
        ventasH.setBorder(null);
        ventasH.setBorderPainted(false);
        ventasH.setContentAreaFilled(false);
        ventasH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ventasH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ventasH.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/vendasH1.png"))); // NOI18N
        ventasH.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ventasH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasHActionPerformed(evt);
            }
        });
        jPanel1.add(ventasH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        limpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar.png"))); // NOI18N
        limpiar.setText("Limpar Campos");
        limpiar.setBorder(null);
        limpiar.setBorderPainted(false);
        limpiar.setContentAreaFilled(false);
        limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar1.png"))); // NOI18N
        limpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        jPanel1.add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        total.setBackground(new java.awt.Color(254, 254, 254));
        total.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        total.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 140, 30));

        NomeT1.setBackground(new java.awt.Color(254, 254, 254));
        NomeT1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        NomeT1.setForeground(new java.awt.Color(240, 240, 240));
        NomeT1.setText("Total :");
        jPanel1.add(NomeT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, -1, -1));

        ComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABERTO", "BAIXADO", " " }));
        ComboBoxStatus.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        ComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxStatusActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 120, -1));

        STATUS.setEditable(false);
        STATUS.setText("BAIXADO");
        jPanel1.add(STATUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 60, 20));

        id.setEditable(false);
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 60, 20));

        atualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar.png"))); // NOI18N
        atualizar.setText("BAIXAR");
        atualizar.setBorder(null);
        atualizar.setBorderPainted(false);
        atualizar.setContentAreaFilled(false);
        atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar1.png"))); // NOI18N
        atualizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar1.png"))); // NOI18N
        atualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });
        jPanel1.add(atualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar.png"))); // NOI18N
        cancelar.setText("CANCELAR BAIXA");
        cancelar.setBorder(null);
        cancelar.setBorderPainted(false);
        cancelar.setContentAreaFilled(false);
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar1.png"))); // NOI18N
        cancelar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar1.png"))); // NOI18N
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, -1, -1));

        buscF1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buscF1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/buscaF1.png"))); // NOI18N
        buscF1.setToolTipText("Buscar");
        buscF1.setBorder(null);
        buscF1.setBorderPainted(false);
        buscF1.setContentAreaFilled(false);
        buscF1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscF1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscF1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/buscaF2.png"))); // NOI18N
        buscF1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscF1ActionPerformed(evt);
            }
        });
        jPanel1.add(buscF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUSCAR POR DATA:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BUSCAR POR SITUAÇÃO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BUSCAR POR NOME:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(StatusAberto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(StatusAberto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buscFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscFActionPerformed
    
       //BuscarSituacao((String) ComboBoxStatus.getSelectedItem());
    BuscarSituacao((String)ComboBoxStatus.getSelectedItem(),buscar.getText()); 
getSum();
       
    }//GEN-LAST:event_buscFActionPerformed

    private void ventasHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasHActionPerformed
        Date sistemaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataH = formato.format(sistemaData);
        FinanceiroSql.listar(dataH);
        data.setDate(null);
    }//GEN-LAST:event_ventasHActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limparCampos();
    }//GEN-LAST:event_limpiarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       // getSum();
    }//GEN-LAST:event_formWindowOpened

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
  if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          readJTableForDesc(buscar.getText()); 
getSum();
            }

                    // TODO add your handling code here:
    }//GEN-LAST:event_buscarKeyPressed

    private void TabelaTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaTituloMouseClicked
id.setText(TabelaTitulo.getValueAt(TabelaTitulo.getSelectedRow(),0).toString());  
//STATUS.setText(TabelaTitulo.getValueAt(TabelaTitulo.getSelectedRow(),3).toString());  // TODO add your handling code here:
    }//GEN-LAST:event_TabelaTituloMouseClicked

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
     if  ( JOptionPane.showConfirmDialog(this, "Deseja realmente baixar esse titulo?")==0){
           baixar();
     }else{
        // JOptionPane.showMessageDialog(this, "CANCELADO");
              }  
          
        
        
    }//GEN-LAST:event_atualizarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
       if  ( JOptionPane.showConfirmDialog(this, "Deseja realmente CANCELAR a baixa desse titulo?")==0){
           cancelar();
     }else{
        // JOptionPane.showMessageDialog(this, "CANCELADO");
              }    // TODO add your handling code here:
    }//GEN-LAST:event_cancelarActionPerformed

    private void ComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxStatusActionPerformed

    private void buscF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscF1ActionPerformed
 if (data.getDate() == null) {
            FinanceiroSql.listar("");
        } else {
            String formato = data.getDateFormatString();
            Date date = data.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
           FinanceiroSql.listar(String.valueOf(sdf.format(date)));
            getSum();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_buscF1ActionPerformed


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
            java.util.logging.Logger.getLogger(ContasReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContasReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContasReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContasReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContasReceber().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.bolivia.combo.SComboBoxBlue ComboBoxStatus;
    private javax.swing.JLabel NomeT1;
    private javax.swing.JTextField STATUS;
    private javax.swing.JTextField StatusAberto;
    public static javax.swing.JTable TabelaTitulo;
    private javax.swing.JButton atualizar;
    private javax.swing.JButton buscF;
    private javax.swing.JButton buscF1;
    private app.bolivia.swing.JCTextField buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel codigoL1;
    private com.toedter.calendar.JDateChooser data;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel total;
    private javax.swing.JButton ventasH;
    // End of variables declaration//GEN-END:variables
}

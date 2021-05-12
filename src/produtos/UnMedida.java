/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;

import com.mysql.jdbc.Connection;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hugov
 */
public class UnMedida extends javax.swing.JInternalFrame {

   

   
    public UnMedida() {
        initComponents();
        TabelaUn.getTableHeader().setDefaultRenderer(new principal.EstiloTabelaHeader());
        TabelaUn.setDefaultRenderer(Object.class, new principal.EstiloTabelaRenderer());
        
        TabelaUn.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       readJTable();
       
        
    }  
    
    public void limparCampos(){
        id.setText("");
        TxtNome.setText("");
    }
     
 public void readJTable(){
        
        DefaultTableModel modelo = (DefaultTableModel) TabelaUn.getModel();
        modelo.setNumRows(0);
        UnDao pdao = new UnDao();
       
        for (UnBean p : pdao.read()) {
        
            modelo.addRow(new Object[]{
            p.getId(),
            p.getUn(),
     
       });                       
    
        }
    
 }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaUn = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        enviar = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        TxtNome = new javax.swing.JTextField();
        deletar = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setName("UNIDADE DE MEDIDA"); // NOI18N
        setPreferredSize(new java.awt.Dimension(715, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TabelaUn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaUn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabelaUn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaUnMouseClicked(evt);
            }
        });
        TabelaUn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TabelaUnKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaUn);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/Enviar.png"))); // NOI18N
        enviar.setText("SALVAR");
        enviar.setBorder(null);
        enviar.setBorderPainted(false);
        enviar.setContentAreaFilled(false);
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        enviar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/regis2.png"))); // NOI18N
        enviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        jPanel4.add(enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 120, 100));

        id.setEditable(false);
        jPanel4.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 40, 30));

        TxtNome.setText(" ");
        jPanel4.add(TxtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 170, 30));

        deletar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/Enviar.png"))); // NOI18N
        deletar.setText("EXCLUIR");
        deletar.setBorder(null);
        deletar.setBorderPainted(false);
        deletar.setContentAreaFilled(false);
        deletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deletar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/regis2.png"))); // NOI18N
        deletar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });
        jPanel4.add(deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 120, 100));

        alterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/Enviar.png"))); // NOI18N
        alterar.setText("ALTERAR");
        alterar.setBorder(null);
        alterar.setBorderPainted(false);
        alterar.setContentAreaFilled(false);
        alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alterar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/regis2.png"))); // NOI18N
        alterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });
        jPanel4.add(alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 120, 100));

        jButton1.setText("LIMPAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel1.setText("UNIDADE DE MEDIDA");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("UNIDADE DE MEDIDA");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

       
    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
           
    
     UnBean t = new UnBean();
     UnDao dao = new UnDao();
        
        t.setUn(TxtNome.getText());
        
      
         dao.create(t);
         readJTable();
limparCampos();
   
    }//GEN-LAST:event_enviarActionPerformed

    private void TabelaUnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaUnKeyPressed
     
           
// TODO add your handling code here:
    }//GEN-LAST:event_TabelaUnKeyPressed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
      try {
        
        if  ( JOptionPane.showConfirmDialog(this, "Confirma?")==0)
              {
              
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pontovenda","root","acessonery");
            //Objeto para enviar comandos sql
            PreparedStatement p = con.prepareStatement("delete from un_medida where id = ?");
            //Envia o comando e guarda em um objeto ResultSet (Resultado)
            p.setString(1, TabelaUn.getValueAt(TabelaUn.getSelectedRow(), 0 ).toString() );
            p.execute();
                readJTable();
        
              JOptionPane.showMessageDialog(this, "APAGADO COM SUCESSO");
           limparCampos();
              }
              else{
              JOptionPane.showMessageDialog(this, "CANCELADO");
              }  
      }catch (SQLException ex) {
        
            Logger.getLogger(UnMedida.class.getName()).log(Level.SEVERE, null, ex); 
            
      }
    }//GEN-LAST:event_deletarActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
      try {
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pontovenda","root","acessonery");
            PreparedStatement p = con.prepareStatement(" update un_menida set un =? where id = ? ");
             
             //id não pode ser alterado
             
             p.setString(2,id.getText());
             p.setString(1,TxtNome.getText());
             
             
             p.execute();      
	     p.close();
              readJTable();
   limparCampos();
        
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);  
 
        }
        JOptionPane.showMessageDialog(this, "Dados Alterados Com Sucesso"); 
            // TODO add your handling code here:
                                            

    }//GEN-LAST:event_alterarActionPerformed

    private void TabelaUnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaUnMouseClicked
     id.setText(TabelaUn.getValueAt(TabelaUn.getSelectedRow(),0).toString()); 
     TxtNome.setText(TabelaUn.getValueAt(TabelaUn.getSelectedRow(),1).toString());
    }//GEN-LAST:event_TabelaUnMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
limparCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TabelaUn;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JButton alterar;
    private javax.swing.JButton deletar;
    private javax.swing.JButton enviar;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void fechartela(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ListSelectionModel;
import vendas.FrmCaixa;
;


/**
 *
 * @author hugov
 */
public class FrmListaUser extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmListaProd
     */
    public FrmListaUser() {
        initComponents();
        tabelaUser.getTableHeader().setDefaultRenderer(new principal.EstiloTabelaHeader());
        tabelaUser.setDefaultRenderer(Object.class, new principal.EstiloTabelaRenderer());
        
        tabelaUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        UsuariosSql.listarCat("");
        
        
        tipo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (tipo.getSelectedIndex() == 0) {
                   
                    UsuariosSql.listarCat("");
                }
                
                
                 
                 if (tipo.getSelectedIndex() == 1) {
                   
                    UsuariosSql.listarCat(tipo.getSelectedItem().toString());
                }
                 
                 if (tipo.getSelectedIndex() == 2) {
                   
                     UsuariosSql.listarCat(tipo.getSelectedItem().toString());
                }
                 
                 if (tipo.getSelectedIndex() == 3) {
                   
                     UsuariosSql.listarCat(tipo.getSelectedItem().toString());
                }
                 
               
                 
               
                  
                 
                
            }
        });
    }
    
    
    
    public void calcular() {
        String pre;
        String quan;
        double total = 0;
        double preco;
        int quantidade;
        double calc = 0.0;

        for (int i = 0; i < vendas.FrmCaixa.tabela.getRowCount(); i++) {
            pre = vendas.FrmCaixa.tabela.getValueAt(i, 3).toString();
            quan = vendas.FrmCaixa.tabela.getValueAt(i, 4).toString();
            preco = Double.parseDouble(pre);
            quantidade = Integer.parseInt(quan);
            calc = preco * quantidade;
            total = total + calc;
            vendas.FrmCaixa.tabela.setValueAt(Math.rint(calc * 100) / 100, i, 5);

        }
        vendas.FrmCaixa.total.setText("" + Math.rint(total * 100) / 100);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUser = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        codigoL1 = new javax.swing.JLabel();
        tipoL = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();
        tipo = new org.bolivia.combo.SComboBoxBlue();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(715, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabelaUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME USUÁRIO", "SEXO", "TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaUserKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUser);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBackground(new java.awt.Color(34, 102, 145));
        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setOpaque(false);
        buscar.setPhColor(new java.awt.Color(255, 255, 255));
        buscar.setPlaceholder("CÓDIGO/NOME");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jPanel4.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/buscarL.png"))); // NOI18N
        jPanel4.add(codigoL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 52));

        tipoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios/tipousL.png"))); // NOI18N
        jPanel4.add(tipoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, 52));

        enviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios/regis1.png"))); // NOI18N
        enviar.setText("Adicionar");
        enviar.setBorder(null);
        enviar.setBorderPainted(false);
        enviar.setContentAreaFilled(false);
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enviar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        enviar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios/regis2.png"))); // NOI18N
        enviar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        jPanel4.add(enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 140, 100));

        tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO DE USUARIO", "ADMINISTRADOR", "NORMAL", "CLIENTE" }));
        tipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 183, -1));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
         buscar.setText(buscar.getText().toUpperCase());
         UsuariosSql.listarCat(buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
    FrmCaixa.TxtCliente.setText(tabelaUser.getValueAt(tabelaUser.getSelectedRow(),1).toString()); 
     dispose();
            
    }//GEN-LAST:event_enviarActionPerformed

    private void tabelaUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaUserKeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
     enviarActionPerformed(null);  
     }  
    }//GEN-LAST:event_tabelaUserKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField buscar;
    private javax.swing.JLabel codigoL1;
    private javax.swing.JButton enviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tabelaUser;
    private org.bolivia.combo.SComboBoxBlue tipo;
    private javax.swing.JLabel tipoL;
    // End of variables declaration//GEN-END:variables
}

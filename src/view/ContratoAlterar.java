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
import view.Consulta;

/**
 *
 * @author asnsoftware
 */
public class ContratoAlterar extends javax.swing.JFrame {

    Consulta consultar;

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ContratoAlterar(String codcabecalho) {
        initComponents();
 carregaCabecalho("select * from itens_venda inner join produtos on itens_venda.id= produtos.codigo_pro where itens_venda.cod_cabecalho='"+codcabecalho+"'");
//        carregaCabecalho("select * from cabecalhovenda inner join usuarios on cabecalhovenda.nome_cliente = usuarios.codigo_us where cabecalhovenda.id ='"+codcabecalho+"'");
        CarregarTabelaItens("select * from cabecalhovenda inner join usuarios on cabecalhovenda.nome_cliente = usuarios.codigo_us where cabecalhovenda.id ='"+codcabecalho+"'");

    }

    private ContratoAlterar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void CarregarTabelaItens(String sql) {

        DefaultTableModel modelo = (DefaultTableModel) TabelaAlterar.getModel();
        modelo.setNumRows(0);
        itens_dao pdao = new itens_dao();
        System.out.println(sql);
        for (itens_bean p : pdao.read(sql)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getCod_itens(),
                p.getQuantidade(),
                p.getValor(),
                p.getSituacao(),
                p.getValor_total()
                

            });

        }
    }

    
    public void limparCampos() {
        DefaultTableModel modelo = (DefaultTableModel) TabelaAlterar.getModel();

        modelo.removeRow(0);
        //}
        Txt_BuscaCliente.setText("");
        Txt_BuscaProduto.setText("");
        Txt_quantidade.setText("");
        Txt_valor.setText("");


    }


    public void salvarCabecalho() {

        cabecalho_bean c = new cabecalho_bean();
        cabecalho_dao dao = new cabecalho_dao();

        c.setNome_cliente((String) ComboCliente.getSelectedItem());
        c.setData_lancamento(txt_data.getText());
        dao.create(c);

        selectMax();
        salvarItens();
        //limparCampos();

        JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

    }

    public void salvarItens() {

        itens_bean c = new itens_bean();
        itens_dao dao = new itens_dao();

        for (int i = 0; i < TabelaAlterar.getRowCount(); i++) {

            c.setCod_cabecalho(TxtCod_cabecalho.getText());
            c.setCod_itens((String) TabelaAlterar.getValueAt(i, 0));
            c.setQuantidade((String) TabelaAlterar.getValueAt(i, 1));
            c.setValor((String) TabelaAlterar.getValueAt(i, 2));
            c.setSituacao((String) TabelaAlterar.getValueAt(i, 3));
            c.setValor_total(TxtTotal.getText());

            dao.create(c);

        }

       
    }

    public void selectMax() {
        try {
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pontovenda", "root", "");
            PreparedStatement p = con.prepareStatement(" SELECT * FROM cabecalhovenda  WHERE id = (SELECT MAX(id) FROM cabecalhovenda)");
            ResultSet r = p.executeQuery();

            ///TxtCod_cabecalho.setText(r.getString ("Id"));
            while (r.next()) {
                TxtCod_cabecalho.setText(r.getString("Id"));

            }
        } catch (SQLException ex) {

            Logger.getLogger(ContratoAlterar.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void getSum() {
        double count = 0;
        for (int i = 0; i <= TabelaAlterar.getRowCount() - 1; i++) {
            count += Double.parseDouble(TabelaAlterar.getValueAt(i, 4).toString());
        }
        TxtTotal.setText(String.valueOf(count));
    }

    public void bucarCliente(String sql) {

//       String sql = "select * from cliente";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            ComboCliente.removeAllItems();

            while (rs.next()) {

                ComboCliente.addItem(rs.getString("codigo_us") + "-" + rs.getString("nome_us"));
                ComboCliente.showPopup();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContratoAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void buscarProduto(String sql) {

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            ComboProduto.removeAllItems();

            while (rs.next()) {

                ComboProduto.addItem(rs.getString("codigo_pro") + "-" + rs.getString("nome_pro"));
                // ComboProduto.showPopup();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContratoAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void carregaCabecalho(String sql) {

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.first();

            LB_Codigo.setText( rs.getString("Id"));
            ComboCliente.setEditable(true);
         ComboCliente.setSelectedItem(rs.getString("codigo_us")+"-"+rs.getString("usuarios.nome_us"));
          ComboCliente.setEditable(false);
        txt_data.setText(rs.getString("datacontrato"));
        } catch (SQLException ex) {
            Logger.getLogger(ContratoAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void alterar(){
        
        try {
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost/mercado","root","");
            PreparedStatement p = con.prepareStatement(" update cabecalholocacao set cod_cliente =?, datacontrato = ? where id = ? ");
             
             //id não pode ser alterado
             
             p.setString(3,LB_Codigo.getText());
             p.setString(1,Metodos.separadorDoisCampoCB_retona_Codigo(ComboCliente));
             p.setString(2,txt_data.getText());                     
           
             
             p.execute();      
	     p.close();
            
        
        } catch (SQLException ex) {
            Logger.getLogger(ContratoAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Dados Alterados Com Sucesso"); 
            // TODO add your handling code here:
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
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaAlterar = new javax.swing.JTable();
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
        LB_Codigo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CONTRATO DE LOCAÇÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel6)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Alterar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TabelaAlterar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Produto", "Quantidade", "Valor UN", "Situação", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaAlterar);

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

        LB_Codigo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LB_Codigo.setText("jLabel9");

        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
                                                .addComponent(ComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(593, 593, 593)
                                                .addComponent(jLabel8)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_BuscaCliente)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(LB_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23))
                            .addComponent(txt_data))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addComponent(LB_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_BuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                    .addComponent(Txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
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

        bucarCliente("select * from cliente where nome like '%" + Txt_BuscaCliente.getText() + "%'");


    }//GEN-LAST:event_Txt_BuscaClienteKeyPressed

    private void Txt_BuscaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_BuscaProdutoKeyPressed
        buscarProduto("select * from produto where nome like '%" + Txt_BuscaProduto.getText() + "%'");
    }//GEN-LAST:event_Txt_BuscaProdutoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 alterar();   

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) TabelaAlterar.getModel();
        tabela.addRow(new String[]{(String) ComboProduto.getSelectedItem(), Txt_quantidade.getText(), Txt_valor.getText(), (String) ComboBoxStatus.getSelectedItem(), String.valueOf(Double.parseDouble(Txt_quantidade.getText()) * Double.parseDouble(Txt_valor.getText()))});
        getSum();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
        
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mercado","root","");
            //Objeto para enviar comandos sql
            PreparedStatement p = con.prepareStatement("delete from itenslocacao where id = ? ");
            
             p.setString(1, TabelaAlterar.getValueAt(TabelaAlterar.getSelectedRow(), 0 ).toString() );
             
            p.execute();
          dispose();
   
     
            
             
             
             JOptionPane.showMessageDialog(this, "Item removido");
             
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ContratoAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }
             
              
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ContratoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContratoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContratoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContratoAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContratoAlterar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxStatus;
    private javax.swing.JComboBox<Object> ComboCliente;
    private javax.swing.JComboBox<String> ComboProduto;
    private javax.swing.JLabel LB_Codigo;
    private javax.swing.JTable TabelaAlterar;
    private javax.swing.JTextField TxtCod_cabecalho;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JTextField Txt_BuscaCliente;
    private javax.swing.JTextField Txt_BuscaProduto;
    private javax.swing.JTextField Txt_quantidade;
    private javax.swing.JTextField Txt_valor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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

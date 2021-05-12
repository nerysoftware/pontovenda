/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import principal.ConnectionFactory;
import principal.MenuPrincipal;
import usuarios.PermicaoUser;
import static vendas.FrmCaixa.total;

/**
 *
 * @author hugov
 */
public class FrmProdutos extends javax.swing.JInternalFrame {

    
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement stmt = null;            
           ResultSet rs = null;
    
    public FrmProdutos() {
        initComponents();
        tabelaProdutos.getTableHeader().setDefaultRenderer(new principal.EstiloTabelaHeader());
        tabelaProdutos.setDefaultRenderer(Object.class, new principal.EstiloTabelaRenderer());
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        limparCampos();
        BuscaTipo("select * from tipo_produto");
         BuscarUn("select * from un_medida");
        
        //INICIALIZAÇÃO DOS COMPONENTES
        tabelaProdutos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (tabelaProdutos.getSelectedRow() != -1) {
                    atualizarDados();
                    //selecionarRegistro = true;
                }
            }
        });
    }
    
  
  
    
    public void BuscaTipo(String sql){
          try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
               tipo.removeAllItems();
               
            while (rs.next()){
             
              tipo.addItem(rs.getString("nome"));
             // Nome_empresa.showPopup();
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
       
          
    
}
    public void margem(){
     Double vtotal;
     Double margem, resultado;
     vtotal= Double.parseDouble(valorcompra.getText());
     margem = Double.parseDouble(porcentagem.getText());
     resultado = vtotal +(vtotal*margem)/100;
     valorvenda.setText(resultado.toString());

    }
  
   
    
    void atualizarDados() {
        int linha = tabelaProdutos.getSelectedRow();
        codigo.setText(tabelaProdutos.getValueAt(linha, 0).toString());
        ean.setText(tabelaProdutos.getValueAt(linha, 1).toString());
        nome.setText(tabelaProdutos.getValueAt(linha, 2).toString());
        estoque.setText(tabelaProdutos.getValueAt(linha, 3).toString());
        valorcompra.setText(tabelaProdutos.getValueAt(linha, 4).toString());
        porcentagem.setText(tabelaProdutos.getValueAt(linha, 5).toString());
        valorvenda.setText(tabelaProdutos.getValueAt(linha, 6).toString());
        tipo.setSelectedItem(tabelaProdutos.getValueAt(linha, 7).toString());
        un.setSelectedItem(tabelaProdutos.getValueAt(linha, 8).toString());
       
    }
    
    
    void limparCampos() {
        if (tabelaProdutos.getSelectedRow() > -1) {
            tabelaProdutos.removeRowSelectionInterval(tabelaProdutos.getSelectedRow(), tabelaProdutos.getSelectedRow());
        }
        codigo.setText("");
        nome.setText("");
       
        tipo.setSelectedItem("DIVERSOS");
        un.setSelectedItem("UN");
        valorcompra.setText("");
        valorvenda.setText("");
        porcentagem.setText("");
        estoque.setText("");
        TxtCest.setText("");
        txtNcm.setText("");
        ean.setText("");
        ProdutosSql.listar("");
        ProdutosSql.gerarId();
    }
    
    
    void selecionarLinha(String id) {
        for (int i = 0; i < tabelaProdutos.getRowCount(); i++) {
            if (id.equals(tabelaProdutos.getValueAt(i, 0))) {
                tabelaProdutos.setRowSelectionInterval(i, i);
                break;
            }
        }

    }
    
    public void BuscarUn(String sql){
             try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
                un.removeAllItems();
               
            while (rs.next()){
             
              un.addItem(rs.getString("un"));
             // Nome_empresa.showPopup();
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        registrar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        excluirT = new javax.swing.JButton();
        calcular = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        codigoL1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tipo = new org.bolivia.combo.SComboBoxBlue();
        nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        porcentagem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        valorcompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        valorvenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        estoque = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        deletar = new javax.swing.JButton();
        un = new org.bolivia.combo.SComboBoxBlue();
        deletar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ean = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        tabelaimposto = new org.bolivia.combo.SComboBoxBlue();
        jLabel8 = new javax.swing.JLabel();
        txtNcm = new javax.swing.JTextField();
        TxtCest = new javax.swing.JTextField();
        NCM = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel11.setText("jLabel11");

        setClosable(true);
        setMaximizable(true);
        setMinimumSize(new java.awt.Dimension(500, 800));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaProdutos.setAutoCreateRowSorter(true);
        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "CÓDIGO DE BARRA", "NOME DO PRODUTO", "ESTOQUE", "PREÇO DE CUSTO", "MARGEM DE LUCRO", "PREÇO DE VENDA", "TIPO PRODUTO", "UN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabelaProdutos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 316, 1270, 220));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/regis1.png"))); // NOI18N
        registrar.setText("Registrar");
        registrar.setBorder(null);
        registrar.setBorderPainted(false);
        registrar.setContentAreaFilled(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/regis2.png"))); // NOI18N
        registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        atualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar.png"))); // NOI18N
        atualizar.setBorder(null);
        atualizar.setBorderPainted(false);
        atualizar.setContentAreaFilled(false);
        atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizar.setLabel("Atualizar");
        atualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar1.png"))); // NOI18N
        atualizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar1.png"))); // NOI18N
        atualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagar.png"))); // NOI18N
        excluir.setBorder(null);
        excluir.setBorderPainted(false);
        excluir.setContentAreaFilled(false);
        excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluir.setLabel("Excluir");
        excluir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagar1.png"))); // NOI18N
        excluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        limpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar.png"))); // NOI18N
        limpar.setBorder(null);
        limpar.setBorderPainted(false);
        limpar.setContentAreaFilled(false);
        limpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limpar.setLabel("Limpar Campos");
        limpar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar1.png"))); // NOI18N
        limpar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        excluirT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        excluirT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagarT.png"))); // NOI18N
        excluirT.setBorder(null);
        excluirT.setBorderPainted(false);
        excluirT.setContentAreaFilled(false);
        excluirT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluirT.setEnabled(false);
        excluirT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirT.setLabel("Excluir Tudo");
        excluirT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagarT1.png"))); // NOI18N
        excluirT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluirT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirTActionPerformed(evt);
            }
        });

        calcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/calculator_78382 (1).png"))); // NOI18N
        calcular.setText("Calcular %");
        calcular.setBorder(null);
        calcular.setBorderPainted(false);
        calcular.setContentAreaFilled(false);
        calcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calcular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        calcular.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/1486504359-calculate-business-finance-calculator-device-math_81327.png"))); // NOI18N
        calcular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atualizar)
                .addGap(10, 10, 10)
                .addComponent(excluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpar)
                .addGap(18, 18, 18)
                .addComponent(excluirT)
                .addGap(26, 26, 26)
                .addComponent(calcular)
                .addContainerGap(406, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calcular)
                    .addComponent(registrar)
                    .addComponent(atualizar)
                    .addComponent(excluir)
                    .addComponent(limpar)
                    .addComponent(excluirT))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 980, 120));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "BUSCAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.setBackground(new java.awt.Color(34, 102, 145));
        buscar.setBorder(null);
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setOpaque(false);
        buscar.setPhColor(new java.awt.Color(255, 255, 255));
        buscar.setPlaceholder("CÓDIGO/NOME");
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jPanel4.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 180, -1));

        codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/buscarL.png"))); // NOI18N
        jPanel4.add(codigoL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 280, 52));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, 290, 110));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigo.setBackground(new java.awt.Color(0, 102, 153));
        codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        codigo.setForeground(new java.awt.Color(255, 255, 255));
        codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo.setOpaque(false);
        codigo.setPlaceholder("CODIGO");
        codigo.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoKeyTyped(evt);
            }
        });
        jPanel2.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));

        tipo.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jPanel2.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 140, -1));

        nome.setBackground(new java.awt.Color(0, 102, 153));
        nome.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        nome.setForeground(new java.awt.Color(255, 255, 255));
        nome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 220, 30));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel1.setText("CÓDIGO DE BARRA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        porcentagem.setBackground(new java.awt.Color(0, 102, 153));
        porcentagem.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        porcentagem.setForeground(new java.awt.Color(255, 255, 255));
        porcentagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        porcentagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                porcentagemKeyPressed(evt);
            }
        });
        jPanel2.add(porcentagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 120, 30));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel2.setText("MARGEM DE LUCRO %");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        valorcompra.setBackground(new java.awt.Color(0, 102, 153));
        valorcompra.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        valorcompra.setForeground(new java.awt.Color(255, 255, 255));
        valorcompra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(valorcompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 110, 30));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel3.setText("VALOR DE CUSTO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        valorvenda.setBackground(new java.awt.Color(0, 102, 153));
        valorvenda.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        valorvenda.setForeground(new java.awt.Color(255, 255, 255));
        valorvenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(valorvenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 110, 30));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel4.setText("VALOR DE VENDA");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        estoque.setBackground(new java.awt.Color(0, 102, 153));
        estoque.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        estoque.setForeground(new java.awt.Color(255, 255, 255));
        estoque.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(estoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 100, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("ESTOQUE");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        deletar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/Enviar.png"))); // NOI18N
        deletar.setBorder(null);
        deletar.setBorderPainted(false);
        deletar.setContentAreaFilled(false);
        deletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deletar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/cancelar2.png"))); // NOI18N
        deletar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });
        jPanel2.add(deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 60, 80));

        un.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jPanel2.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 140, -1));

        deletar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/Enviar.png"))); // NOI18N
        deletar1.setBorder(null);
        deletar1.setBorderPainted(false);
        deletar1.setContentAreaFilled(false);
        deletar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deletar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/cancelar2.png"))); // NOI18N
        deletar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deletar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletar1ActionPerformed(evt);
            }
        });
        jPanel2.add(deletar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 60, 100));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("TIPO DE PRODUTO");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("UNIDADE DE MEDIDA");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        ean.setBackground(new java.awt.Color(0, 102, 153));
        ean.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        ean.setForeground(new java.awt.Color(255, 255, 255));
        ean.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(ean, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 220, 30));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel9.setText("NOME / DESCRIÇÃO");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jTabbedPane1.addTab("PRINCIPAL", jPanel2);

        tabelaimposto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TRIBUTADO", "SUBSTITUIDO", " ", " " }));
        tabelaimposto.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        jLabel8.setText("TABELA DE IMPOSTO");

        txtNcm.setBackground(new java.awt.Color(0, 102, 153));
        txtNcm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNcm.setForeground(new java.awt.Color(255, 255, 255));
        txtNcm.setText("99999999");
        txtNcm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TxtCest.setBackground(new java.awt.Color(0, 102, 153));
        TxtCest.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TxtCest.setForeground(new java.awt.Color(255, 255, 255));
        TxtCest.setText("9999999");
        TxtCest.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        NCM.setText("NCM");

        jLabel10.setText("CEST");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tabelaimposto, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNcm)
                            .addComponent(NCM))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(TxtCest, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(973, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabelaimposto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NCM)
                    .addComponent(jLabel10))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNcm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        txtNcm.getAccessibleContext().setAccessibleName("");
        txtNcm.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane1.addTab("TRIBUTAÇÃO", jPanel5);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1280, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    boolean selecionarRegistro = false;
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
    
        if (selecionarRegistro) {
            JOptionPane.showMessageDialog(this, "O código: " + this.codigo.getText() + "\n já está registrado.", "Inserir Registro", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        } else {
            
            if (codigo.getText().equals("") || nome.getText().equals("") || tipo.getSelectedItem().equals("TIPO PRODUTO")
                     || valorvenda.equals("")) {
                JOptionPane.showMessageDialog(this, "Todos os campos\nsão obrigatórios.", "Inserir Registro", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            } else {
                produtos.Produtos us = new Produtos();
                us.setPrimaryKey(codigo.getText());
                us.setTipo(tipo.getSelectedItem().toString());
                us.setNome(nome.getText());
                us.setQuant_pro(estoque.getText());
                us.setValorcompra(valorcompra.getText());
                us.setMargem_lucro(porcentagem.getText());
                us.setValor(valorvenda.getText());
                us.setUn(un.getSelectedItem().toString()); 
                us.setNcm(txtNcm.getText());        
                us.setCest(TxtCest.getText());                
                us.setEan(ean.getText());
                
                int op = ProdutosSql.registrar(us);
                if (op != 0) {
                    String id = codigo.getText();
                    
                    selecionarLinha(id);
                   
                    JOptionPane.showMessageDialog(this, "Inserido com Sucesso.", "Inserir Registro", 0,
                            new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    
                    limparCampos();
                }
                
            }
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
     if (tabelaProdutos.getRowCount() > 0) {
            if (tabelaProdutos.getSelectedRowCount() > 0) {
                
                if (codigo.getText().equals("") || nome.getText().equals("") 
                        || tipo.getSelectedItem().equals("TIPO PRODUTO") || valorvenda.equals("")) {
                    JOptionPane.showMessageDialog(this, "Preecha os campos.", "Editar", 0,
                            new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                } else if (JOptionPane.showConfirmDialog(this, "Deseja alterar o registro?", "Editar", JOptionPane.YES_NO_OPTION, 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png"))) == JOptionPane.YES_OPTION) {
                    produtos.Produtos us = new Produtos();
                    us.setPrimaryKey(codigo.getText());                  
                    us.setTipo(tipo.getSelectedItem().toString());
                    us.setNome(nome.getText()); 
                    us.setQuant_pro(estoque.getText()); 
                    us.setValorcompra(valorcompra.getText());
                    us.setMargem_lucro(porcentagem.getText());
                    us.setValor(valorvenda.getText());
                    us.setUn(un.getSelectedItem().toString()); 
                    us.setNcm(txtNcm.getText());        
                    us.setCest(TxtCest.getText());                
                    us.setEan(ean.getText());
                    int opc = ProdutosSql.atualizar(us);
                    if (opc != 0) {
                        String id = codigo.getText();
                        limparCampos();
                        selecionarLinha(id);
                        JOptionPane.showMessageDialog(this, "Registro Atualizado.", "Editar", 0,
                                new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro.", "Editar", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Não há registro para alterar.", "Editar", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        }   
    }//GEN-LAST:event_atualizarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
    if (tabelaProdutos.getRowCount() > 0) {
            if (tabelaProdutos.getSelectedRowCount() > 0) {
                if (JOptionPane.showConfirmDialog(this, "Deseja Excluir?", "Excluir", JOptionPane.YES_NO_OPTION, 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png"))) == JOptionPane.YES_OPTION) {
                    int linha = tabelaProdutos.getSelectedRow();
                    String id = tabelaProdutos.getValueAt(linha, 0).toString();
                    int elimina = ProdutosSql.eliminar(id);
                    if (elimina != 0) {
                        limparCampos();
                        JOptionPane.showMessageDialog(this, "Registro excluido.", "Excluir", 0,
                                new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro.", "Excluir", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para exclusão.", "Excluir", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void excluirTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirTActionPerformed
    

     
        if (tabelaProdutos.getRowCount() > 0) {
            if (
                    JOptionPane.showConfirmDialog(this, "Deseja excluir todos os produtos?", "Excluir", JOptionPane.YES_NO_OPTION, 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/alerta.png"))) == JOptionPane.YES_OPTION)
                
            {
                
                int eliminaT = ProdutosSql.eliminaTodos();
                if (eliminaT != 0) {
                    limparCampos();
                    JOptionPane.showMessageDialog(this, "Registros excluidos.", "Excluir", 0,
                            new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    
                    
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para excluir.", "Excluir", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        } 
    }//GEN-LAST:event_excluirTActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
      limparCampos();
    }//GEN-LAST:event_limparActionPerformed

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked

    }//GEN-LAST:event_buscarMouseClicked

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
     ProdutosSql.listar(buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
margem();   
    }//GEN-LAST:event_calcularActionPerformed

    private void deletar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletar1ActionPerformed
 UnMedida tela = new UnMedida();
        MenuPrincipal.carregador.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_deletar1ActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        TipoProduto tela = new TipoProduto();
        MenuPrincipal.carregador.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_deletarActionPerformed

    private void codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoKeyTyped

    private void codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoKeyReleased

    private void porcentagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentagemKeyPressed
 if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      margem();  
     }          // TODO add your handling code here:
    }//GEN-LAST:event_porcentagemKeyPressed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
TbImposto frame = new TbImposto();
frame.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NCM;
    private javax.swing.JTextField TxtCest;
    private javax.swing.JButton atualizar;
    private app.bolivia.swing.JCTextField buscar;
    private javax.swing.JButton calcular;
    public static final app.bolivia.swing.JCTextField codigo = new app.bolivia.swing.JCTextField();
    private javax.swing.JLabel codigoL1;
    private javax.swing.JButton deletar;
    private javax.swing.JButton deletar1;
    private javax.swing.JTextField ean;
    private javax.swing.JTextField estoque;
    private javax.swing.JButton excluir;
    private javax.swing.JButton excluirT;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField porcentagem;
    private javax.swing.JButton registrar;
    public static javax.swing.JTable tabelaProdutos;
    private org.bolivia.combo.SComboBoxBlue tabelaimposto;
    private org.bolivia.combo.SComboBoxBlue tipo;
    private javax.swing.JTextField txtNcm;
    private org.bolivia.combo.SComboBoxBlue un;
    private javax.swing.JTextField valorcompra;
    private javax.swing.JTextField valorvenda;
    // End of variables declaration//GEN-END:variables
}

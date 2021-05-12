/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;


import com.mysql.jdbc.Connection;

import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import static org.codehaus.groovy.ast.tools.GeneralUtils.stmt;
import pedido.FramePedido;
import principal.Conectar;
import principal.MenuPrincipal;
import static principal.MenuPrincipal.carregador;
import produtos.FrmListaProd;
import static produtos.FrmProdutos.codigo;
import relatorios.ConnectionFactory;
import usuarios.FrmListaUser;
import usuarios.FrmUsuarios;
import static usuarios.FrmUsuarios.codigo;
import usuarios.PermicaoUser;

/**
 *
 * @author hugov
 */
public class FrmCaixa extends javax.swing.JInternalFrame {

           Connection conn = (Connection) ConnectionFactory.getConnection();
           PreparedStatement stmt = null;            
           ResultSet rs = null;
       
           
    public boolean estaFechado(Object obj) {
        JInternalFrame[] ativos = carregador.getAllFrames();
        boolean fechado = true;
        int i = 0;
        while (i < ativos.length && fechado) {
            if (ativos[i] == obj) {
                fechado = false;
            }
            i++;
        }
        return fechado;
    }

    
     public void buscarProduto(String sql){
       
        
        
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
       
               
            while (rs.next()){
               
                TXTCODIGO.setText(rs.getString("codigo_pro"));
                TXTTIPO.setText(rs.getString("tipo_pro"));
                TxtProduto.setText(rs.getString("nome_pro"));
                Txt_valor.setText(rs.getString("valor_pro"));
                REAL.setText(rs.getString("quant_pro"));
               
                
               // ComboProduto.showPopup();
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
       
       
    } 
        
     
    public FrmCaixa() {
        initComponents();
        BuscaEmpresa("select * from cad_empresa where id = '1'");
        BuscaVendedor("select * from vendedor");
        FrmCaixa.tabela.getTableHeader().setDefaultRenderer(new principal.EstiloTabelaHeader());
        FrmCaixa.tabela.setDefaultRenderer(Object.class, new principal.EstiloTabelaRenderer());
        codigo.grabFocus(); 
        FrmCaixa.tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        limparCampos();
        

            
    }

    
    
    public static String dataAtual() {
        Date data = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/YYYY");
        return formatoData.format(data);

    }
    
    
    
    public void descontoPorcentagem(){
     Double vtotal;
     Double margem, resultado;
     vtotal= Double.parseDouble(total.getText());
     margem = Double.parseDouble(descPorcent.getText());
     resultado = vtotal - (vtotal*margem)/100;
     total.setText(resultado.toString());
        
    }
    
    public void desconto(){
      Double vtotal;
     Double desconto, resultado;
     vtotal = Double.parseDouble(total.getText());
     desconto = Double.parseDouble(desc.getText());
     resultado = (vtotal-desconto);
     total.setText(resultado.toString());
        
    }
    
    public void acrecimo(){
     Double vtotal;
     Double Acrecimo, resultado;
     vtotal = Double.parseDouble(total.getText());
     Acrecimo = Double.parseDouble(acrecimo.getText());
     resultado = (vtotal+Acrecimo);
     total.setText(resultado.toString());
        
        
    }
    public void acrecimoPor(){
     Double vtotal;
     Double margem, resultado;
     vtotal= Double.parseDouble(total.getText());
     margem = Double.parseDouble(acrecimoPor.getText());
     resultado = vtotal + (vtotal*margem)/100;
     total.setText(resultado.toString());
        
    }
    
    public void baixarEstoque(){
       
        
        
      
        
        
    }

    void limparCampos() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        recebido.setText("0.00");
        troco.setText("0.00");
        total.setText("0.00");
        data.setText("");
        desc.setText("0.00");
        descPorcent.setText("0.00");
        acrecimo.setText("0.00");
        acrecimoPor.setText("0.00");
        data.setText(dataAtual());
        ComboBoxVendedor.setSelectedItem("1-DIVERSOS");
        VendasSql.numeros();
    }
    
    public void permiacao(){
        PermicaoUser frame = new PermicaoUser();
        frame.setVisible(true);
    }
    
    public void BuscaVendedor(String sql){
         try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
//               TxtRazao.removeAllItems();
               
            while (rs.next()){
             
              ComboBoxVendedor.addItem(rs.getString("id")+"-"+rs.getString("nome"));
             // Nome_empresa.showPopup();
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void BuscaEmpresa(String sql){
          try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
//               TxtRazao.removeAllItems();
               
            while (rs.next()){
             
              TxtRazao.setText(rs.getString("id")+"-"+rs.getString("nome"));
             // Nome_empresa.showPopup();
            }
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    
 public void getSum(){
       double count=0;
       for (int i=0; i<=tabela.getRowCount()-1;i++) {
       count+=Double.parseDouble(tabela.getValueAt(i, 5).toString());
    }   
      total.setText(String.valueOf(count));
 } 
    public void imprimir(){
     Connection con = (Connection) ConnectionFactory.getConnection();
        
        String src = "C:\\NerySoftware\\src\\relatorios\\pedido.jasper";
        
        JasperPrint jaspertPrint = null;
        
        try {
            
            jaspertPrint = JasperFillManager.fillReport(src, null, conn);
            
        } catch (JRException ex) {
            System.out.println("Error: "+ex);
        }
        
        JasperViewer view = new JasperViewer(jaspertPrint,false);
        
        view.setVisible(true);
     
        
    }
    


    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        enviar = new javax.swing.JButton();
        TxtCliente = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        Txt_quantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtRazao = new javax.swing.JLabel();
        TXTTIPO = new javax.swing.JTextField();
        TxtProduto = new javax.swing.JTextField();
        Txt_valor = new javax.swing.JTextField();
        TXTCODIGO = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        numFac = new app.bolivia.swing.JCTextField();
        TxtCod_cabecalho = new javax.swing.JTextField();
        total = new app.bolivia.swing.JCTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        calculo = new javax.swing.JButton();
        vender = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        busca = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        recebido = new javax.swing.JTextField();
        descPorcent = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        acrecimoPor = new javax.swing.JTextField();
        acrecimo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        troco = new javax.swing.JTextField();
        modalidade = new org.bolivia.combo.SComboBoxBlue();
        data = new app.bolivia.swing.JCTextField();
        ComboBoxVendedor = new org.bolivia.combo.SComboBoxBlue();
        situacao = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        REAL = new javax.swing.JTextField();
        Operador = new javax.swing.JLabel();

        jTextField6.setText("jTextField6");

        setClosable(true);
        setMaximizable(true);
        setTitle("Caixa");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios/regis1.png"))); // NOI18N
        enviar.setText("Selecione o cliente [F1]:");
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
        enviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enviarKeyPressed(evt);
            }
        });
        jPanel2.add(enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 100));

        TxtCliente.setBorder(null);
        TxtCliente.setText("DIVERSOS");
        TxtCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtCliente.setOpaque(false);
        TxtCliente.setPhColor(new java.awt.Color(255, 255, 255));
        TxtCliente.setPlaceholder("RECIBIDO");
        jPanel2.add(TxtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 150, 30));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 30, 20));

        codigo.setBackground(new java.awt.Color(0, 102, 153));
        codigo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        codigo.setForeground(new java.awt.Color(255, 255, 255));
        codigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoKeyPressed(evt);
            }
        });
        jPanel2.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 190, 40));

        Txt_quantidade.setBackground(new java.awt.Color(0, 102, 153));
        Txt_quantidade.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Txt_quantidade.setForeground(new java.awt.Color(255, 255, 255));
        Txt_quantidade.setText("1");
        Txt_quantidade.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(Txt_quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 70, 40));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel4.setText("QUANTIDADE");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel5.setText("CODIGO / CODIGO DE BARRA");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, 832, 110));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/Shoppingcart-01-icon.png"))); // NOI18N

        TxtRazao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TxtRazao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(TxtRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 110));

        TXTTIPO.setText("jTextField3");
        jPanel1.add(TXTTIPO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 10, -1));

        TxtProduto.setText("jTextField4");
        jPanel1.add(TxtProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 0, -1));

        Txt_valor.setText("jTextField5");
        jPanel1.add(Txt_valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 10, -1));

        TXTCODIGO.setText("jTextField2");
        jPanel1.add(TXTCODIGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 10, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel15.setText("NÚMERO DE VENDA");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        jLabel15.getAccessibleContext().setAccessibleName("NÚMERO DA VENDA");

        numFac.setEditable(false);
        numFac.setBackground(new java.awt.Color(0, 102, 153));
        numFac.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        numFac.setForeground(new java.awt.Color(255, 255, 255));
        numFac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numFac.setOpaque(false);
        numFac.setPhColor(new java.awt.Color(255, 255, 255));
        numFac.setPlaceholder("TROCO");
        jPanel6.add(numFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 130, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 80, 227, 80));
        jPanel1.add(TxtCod_cabecalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        total.setEditable(false);
        total.setBackground(new java.awt.Color(255, 255, 255));
        total.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        total.setText("0.00");
        total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        total.setOpaque(false);
        total.setPhColor(new java.awt.Color(255, 255, 255));
        total.setPlaceholder("TOTAL");
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, 170, 80));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "TIPO PRODUTO", "DESCRIÇÃO", "VALOR", "QUANTIDADE", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 830, 210));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        calculo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        calculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/calcu.png"))); // NOI18N
        calculo.setBorder(null);
        calculo.setContentAreaFilled(false);
        calculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        calculo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/calcu2.png"))); // NOI18N
        calculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        calculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculoActionPerformed(evt);
            }
        });

        vender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        vender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/vender.png"))); // NOI18N
        vender.setBorder(null);
        vender.setContentAreaFilled(false);
        vender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vender.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vender.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/vender2.png"))); // NOI18N
        vender.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/cancelar.png"))); // NOI18N
        excluir.setBorder(null);
        excluir.setContentAreaFilled(false);
        excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/cancelar2.png"))); // NOI18N
        excluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/etornar.png"))); // NOI18N
        cancelar.setBorder(null);
        cancelar.setContentAreaFilled(false);
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/etornar2.png"))); // NOI18N
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        busca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        busca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/produto.png"))); // NOI18N
        busca.setBorder(null);
        busca.setContentAreaFilled(false);
        busca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        busca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        busca.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nfce/produto2.png"))); // NOI18N
        busca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaActionPerformed(evt);
            }
        });
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscaKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel6.setText("FINALIZAR");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel7.setText("CALCULAR");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel8.setText("CANCELAR");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel9.setText("EXTORNA");

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel10.setText("PRODUTOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vender)
                    .addComponent(jLabel6))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calculo)
                    .addComponent(jLabel7))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(excluir)
                    .addComponent(jLabel8))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelar)
                    .addComponent(jLabel9))
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(busca))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelar)
                    .addComponent(busca)
                    .addComponent(excluir)
                    .addComponent(calculo)
                    .addComponent(vender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 830, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setName("0.00"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel11.setText("VALOR CLIENTE");

        desc.setBackground(new java.awt.Color(0, 102, 153));
        desc.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        desc.setForeground(new java.awt.Color(255, 255, 255));
        desc.setText("0.00");
        desc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descKeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel13.setText("DESCONTO $");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel12.setText("TROCO");

        recebido.setBackground(new java.awt.Color(0, 102, 153));
        recebido.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        recebido.setForeground(new java.awt.Color(255, 255, 255));
        recebido.setText("0.00");
        recebido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        recebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                recebidoKeyPressed(evt);
            }
        });

        descPorcent.setBackground(new java.awt.Color(0, 102, 153));
        descPorcent.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        descPorcent.setForeground(new java.awt.Color(255, 255, 255));
        descPorcent.setText("0.00");
        descPorcent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        descPorcent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descPorcentKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel14.setText("DESCONTO %");

        acrecimoPor.setBackground(new java.awt.Color(0, 102, 153));
        acrecimoPor.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        acrecimoPor.setForeground(new java.awt.Color(255, 255, 255));
        acrecimoPor.setText("0.00");
        acrecimoPor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        acrecimoPor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                acrecimoPorKeyPressed(evt);
            }
        });

        acrecimo.setBackground(new java.awt.Color(0, 102, 153));
        acrecimo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        acrecimo.setForeground(new java.awt.Color(255, 255, 255));
        acrecimo.setText("0.00");
        acrecimo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        acrecimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                acrecimoKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel16.setText("ACRECIMO %");

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel17.setText("ACRECIMO $");

        troco.setBackground(new java.awt.Color(0, 102, 153));
        troco.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        troco.setForeground(new java.awt.Color(255, 255, 255));
        troco.setText("0.00");
        troco.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        troco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                trocoKeyPressed(evt);
            }
        });

        modalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DINHEIRO", "A PRAZO", "CARTÃO DE CREDITO", "CARTÃO DE DEBITO", " " }));
        modalidade.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(descPorcent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(acrecimoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(acrecimo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recebido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(troco, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(modalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recebido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(troco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descPorcent, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acrecimoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acrecimo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 220, 240));

        data.setEditable(false);
        data.setBorder(null);
        data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        data.setOpaque(false);
        data.setPhColor(new java.awt.Color(255, 255, 255));
        data.setPlaceholder("DATA");
        jPanel1.add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 160, -1));

        ComboBoxVendedor.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jPanel1.add(ComboBoxVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 162, -1));

        situacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        situacao.setText("ABERTO");
        jPanel1.add(situacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("VENDEDOR:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        REAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REALActionPerformed(evt);
            }
        });
        jPanel1.add(REAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, 10, -1));

        Operador.setText("USUARIO");
        jPanel1.add(Operador, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    produtos.FrmListaProd lista;
    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
        if (estaFechado(lista)) {
            lista = new FrmListaProd();
            principal.MenuPrincipal.carregador.add(lista);

            lista.toFront();
            lista.setVisible(true);
        } else {
            lista.toFront();

        }

    }//GEN-LAST:event_buscaActionPerformed

    private void calculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculoActionPerformed
        if (tabela.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Operação não realizada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (recebido.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Insira um valor.", "Cobrança", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        } else {
            double recebi = Double.parseDouble(recebido.getText());
            double tot = Double.parseDouble(total.getText());

            if (recebi < tot) {
                JOptionPane.showMessageDialog(this, "Valor Inválido para essa venda", "Compra", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            } else {
                this.troco.setText(String.valueOf(recebi - tot));
            }
        }
    }//GEN-LAST:event_calculoActionPerformed

    private void venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderActionPerformed
      finalizarvenda();
//if (tabela.getRowCount() < 1) {
//    
//            JOptionPane.showMessageDialog(this, "Impossível realizar a venda.", "Erro", JOptionPane.ERROR_MESSAGE);
//        } else {
//           for (int i = 0; i < tabela.getRowCount(); i++) { 
//            Vendas v = new Vendas();
//            selectMax();
//            v.setPrimaryKey(numFac.getText());
//            v.setItens((String) tabela.getValueAt(i, 2));   
//            v.setTotal(total.getText());
//            v.setData(data.getText());
//            v.setCliente(TxtCliente.getText());
//            v.setModalidede(modalidade.getSelectedItem().toString());
//            v.setQuantidade((String) tabela.getValueAt(i, 4));
//            v.setCabecalho(TxtCod_cabecalho.getText());
//
//            
////            try{
////                Conectar cc = new Conectar();
////                 cc.conexao();
////                PreparedStatement ps;
////    
//    
////    public static int registrar(Vendas uc) {
////        int rsu = 0;
////        String sql = Vendas.REGISTRAR;
////        try {
//
//
////            ps = cc.conexao().prepareStatement("insert into vendas (numero_ven,\n" +
////                 "total_ven,\n" +
////                 "data_ven,\n" +
////                 "itens_vend,\n" +
////                 "cliente_vend,\n" +
////"quantidade) values (?,?,?,?,?,?)");
////            ps.setString(1, v.getPrimaryKey());          
////            ps.setString(2, v.getItens());
////            ps.setString(3, v.getTotal());
////            ps.setString(4, v.getData());
////            ps.setString(5, v.getCliente());
////            ps.setString(6, v.getQuantidade());
////            
////            ps.executeUpdate();
////                System.out.println("ok");
////}
////catch(Exception ex){
////    System.out.println("erro: \n"+ex);
////}
//            int opc = VendasSql.registrar(v);
//             if (JOptionPane.showConfirmDialog(this, "Deseja imprmir está venda?", "Imprimir", JOptionPane.YES_NO_OPTION, 0,
//                    new ImageIcon(getClass().getResource("/imagens/usuarios/print-icon.png"))) == JOptionPane.YES_OPTION) {
//                 
//                   imprimir();
//            }
//            if (opc != 0) {
//                finalizarvenda();
//                limparCampos();
//                JOptionPane.showMessageDialog(this, "Venda Efetuada.", "Venda", 0,new ImageIcon(getClass().getResource("/imagens/vendas/realizada.png")));
//               TxtCliente.setText("DIVERSOS");
//            }else {
//                limparCampos();
//                JOptionPane.showMessageDialog(this, "Venda Efetuada.", "Venda", 0,new ImageIcon(getClass().getResource("/imagens/vendas/realizada.png")));
//               TxtCliente.setText("DIVERSOS");
//            }
//        }
//       
// 
//        }

    }//GEN-LAST:event_venderActionPerformed
   public void salvarItens(){
       itens_bean c = new itens_bean();
       itens_vendas dao = new itens_vendas();
        
       
       
        
        for (int i = 0; i < tabela.getRowCount(); i++) {  
        
        c.setCod_cabecalho(TxtCod_cabecalho.getText());
        c.setCod_itens((String) tabela.getValueAt(i, 0));
        c.setTipo((String) tabela.getValueAt(i, 1));
        c.setDescricao((String) tabela.getValueAt(i,2));
        c.setValor((String)tabela.getValueAt(i,3));
        c.setQuantidade((String) tabela.getValueAt(i,4) );
        c.setValor_total(total.getText());
       
         
        dao.create(c);
        }  
   }
   
   
   
   public void FinalizaFinal(){
       if (tabela.getRowCount() < 1) {
    
            JOptionPane.showMessageDialog(this, "Impossível realizar a venda.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
           for (int i = 0; i < tabela.getRowCount(); i++) { 
            Vendas v = new Vendas();
          
            v.setPrimaryKey(numFac.getText());
            v.setItens((String) tabela.getValueAt(i, 2));   
            v.setTotal(total.getText());
            v.setData(data.getText());
            v.setCliente(TxtCliente.getText());
            v.setModalidede(modalidade.getSelectedItem().toString());
            v.setQuantidade((String) tabela.getValueAt(i, 4));
            v.setCabecalho(TxtCod_cabecalho.getText());
            v.setSituacao(situacao.getText());

            
            int opc = VendasSql.registrar(v);
             if (JOptionPane.showConfirmDialog(this, "Deseja imprmir está venda?", "Imprimir", JOptionPane.YES_NO_OPTION, 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/print-icon.png"))) == JOptionPane.YES_OPTION) {
                 
                   imprimir();
            }
            if (opc != 0) {
//                finalizarvenda();
                limparCampos();
                JOptionPane.showMessageDialog(this, "Venda Efetuada.", "Venda", 0,new ImageIcon(getClass().getResource("/imagens/vendas/realizada.png")));
               TxtCliente.setText("DIVERSOS");
              
            }else {
                limparCampos();
                JOptionPane.showMessageDialog(this, "Venda Efetuada.", "Venda", 0,new ImageIcon(getClass().getResource("/imagens/vendas/realizada.png")));
               TxtCliente.setText("DIVERSOS");
            }
        }
       
 
        }
   }
   
    public void finalizarvenda(){
     cabecalho_bean c = new cabecalho_bean();
     cabecalho_venda dao = new cabecalho_venda();
     
     c.setNome_cliente(TxtCliente.getText());
     c.setData_lancamento(data.getText());
     c.setVendedor(ComboBoxVendedor.getSelectedItem().toString());
     dao.create(c);
     
        selectMax();
        salvarItens();
        FinalizaFinal();
//        cabecalhoVenda();
        
        
         //limparCampos();
         
//          JOptionPane.showMessageDialog(null, "Salvo com sucesso!");   
     
      
}
  
//public void cabecalhoVenda(){
//    cabecalho2 c = new cabecalho2();
//    cabecalho_dao dao = new cabecalho_dao();
//    
//    c.setCabecalho(TxtCod_cabecalho.getText());
//    dao.create(c);
//    
//     JOptionPane.showMessageDialog(null, "CABECALHO");
//}  

    public void selectMax(){
          try {
               Connection con = (Connection) ConnectionFactory.getConnection();
        
                PreparedStatement p = con.prepareStatement(" SELECT * FROM cabecalho_venda  WHERE id = (SELECT MAX(id) FROM cabecalho_venda)");
                    ResultSet r = p.executeQuery();
                
                 ///TxtCod_cabecalho.setText(r.getString ("Id"));

               
              
                while (r.next()){
                    TxtCod_cabecalho.setText(r.getString ("Id"));
                 

                }
            } catch (SQLException ex) {

                Logger.getLogger(FrmCaixa.class.getName()).log(Level.SEVERE, null, ex);

            }
        
    }
    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
 
        if (tabela.getRowCount() > 0) {
            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                modelo.removeRow(linha);
                FrmListaProd lp = new FrmListaProd();
                lp.calcular();
            } else {
                JOptionPane.showMessageDialog(this, "Selecionar uma Linha.", "Venda", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há registro para excluir.", "Venda", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        }
        
        
    }//GEN-LAST:event_excluirActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
      // permiacao();
        
        if  ( JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar esta venda?")==0)
              {
                 
        limparCampos();
        
         JOptionPane.showMessageDialog(this, "VENDA CANCELADA!");
        
              }else{
             
              
              }
    }//GEN-LAST:event_cancelarActionPerformed

    private void buscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            if (estaFechado(lista)) {
                lista = new FrmListaProd();
                principal.MenuPrincipal.carregador.add(lista);

                lista.toFront();
                lista.setVisible(true);
            } else {
                lista.toFront();

            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_buscaKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            if (estaFechado(lista)) {
                lista = new FrmListaProd();
                principal.MenuPrincipal.carregador.add(lista);

                lista.toFront();
                lista.setVisible(true);
            } else {
                lista.toFront();

            }

        }        // TODO add your handli  // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyPressed
      usuarios.FrmListaUser lista_us;
    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
         if (estaFechado(lista_us)) {
            lista_us = new FrmListaUser();
            principal.MenuPrincipal.carregador.add(lista_us);

            lista_us.toFront();
            lista_us.setVisible(true);
        } else {
            lista_us.toFront();

        } 
    }//GEN-LAST:event_enviarActionPerformed

    private void enviarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enviarKeyPressed
     if(evt.getKeyCode() == KeyEvent.VK_F1){
      enviarActionPerformed(null);  
     }               // TODO add your handling code here:
    }//GEN-LAST:event_enviarKeyPressed

    private void descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      desconto();  
     }   
    }//GEN-LAST:event_descKeyPressed

    private void recebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recebidoKeyPressed
           if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       if (tabela.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Operação não realizada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (recebido.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Insira um valor.", "Cobrança", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        } else {
            double recebi = Double.parseDouble(recebido.getText());
            double tot = Double.parseDouble(total.getText());

            if (recebi < tot) {
                JOptionPane.showMessageDialog(this, "Valor Inválido para essa venda", "Compra", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            } else {
                this.troco.setText(String.valueOf(recebi - tot));
            }
        } 
     }  
        
       // TODO add your handling code here:
    }//GEN-LAST:event_recebidoKeyPressed

    private void descPorcentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descPorcentKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      descontoPorcentagem();  
     }    // TODO add your handling code here:
    }//GEN-LAST:event_descPorcentKeyPressed

    private void acrecimoPorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acrecimoPorKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
     acrecimoPor(); 
     } 
        
        
    }//GEN-LAST:event_acrecimoPorKeyPressed

    private void acrecimoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acrecimoKeyPressed
    
             if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      acrecimo();
     } 
        
      
    }//GEN-LAST:event_acrecimoKeyPressed

    private void trocoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trocoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_trocoKeyPressed

    private void codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyPressed
      
          if(evt.getKeyCode() == KeyEvent.VK_F2){
            if (estaFechado(lista)) {
            lista = new FrmListaProd();
            principal.MenuPrincipal.carregador.add(lista);

            lista.toFront();
            lista.setVisible(true);
        } else {
            lista.toFront();

        }
       }
        
          
           if(evt.getKeyCode() == KeyEvent.VK_F1){
           
           if (estaFechado(lista_us)) {
            lista_us = new FrmListaUser();
            principal.MenuPrincipal.carregador.add(lista_us);

            lista_us.toFront();
            lista_us.setVisible(true);
        } else {
            lista_us.toFront();

        } 
       }
       
          
          
        if(evt.getKeyCode() == KeyEvent.VK_F5){
           
             finalizarvenda();
       }
       
   if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        buscarProduto("select * from produtos where ean like'%"+ codigo.getText()+"%'"); 
     
          
       DefaultTableModel Tabela = (DefaultTableModel) tabela.getModel();
        Tabela.addRow(new String[]{TXTCODIGO.getText(),TXTTIPO.getText(),TxtProduto.getText(),Txt_valor.getText(), Txt_quantidade.getText(),String.valueOf(Double.parseDouble( Txt_quantidade.getText())*Double.parseDouble( Txt_valor.getText())),REAL.getText()});
           getSum();
            codigo.setText("");
            Txt_quantidade.setText("1");
            //"select * from produtos where codigo_pro like '%"+ codigo.getText()+"%'"
   }
        
      
    
    }//GEN-LAST:event_codigoKeyPressed

    private void REALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REALActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_REALActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.bolivia.combo.SComboBoxBlue ComboBoxVendedor;
    private javax.swing.JLabel Operador;
    private javax.swing.JTextField REAL;
    private javax.swing.JTextField TXTCODIGO;
    private javax.swing.JTextField TXTTIPO;
    public static app.bolivia.swing.JCTextField TxtCliente;
    private javax.swing.JTextField TxtCod_cabecalho;
    private javax.swing.JTextField TxtProduto;
    private javax.swing.JLabel TxtRazao;
    private javax.swing.JTextField Txt_quantidade;
    private javax.swing.JTextField Txt_valor;
    private javax.swing.JTextField acrecimo;
    private javax.swing.JTextField acrecimoPor;
    private javax.swing.JButton busca;
    private javax.swing.JButton calculo;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codigo;
    private app.bolivia.swing.JCTextField data;
    private javax.swing.JTextField desc;
    private javax.swing.JTextField descPorcent;
    private javax.swing.JButton enviar;
    private javax.swing.JButton excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private org.bolivia.combo.SComboBoxBlue modalidade;
    public static app.bolivia.swing.JCTextField numFac;
    public static javax.swing.JTextField recebido;
    private javax.swing.JLabel situacao;
    public static javax.swing.JTable tabela;
    public static app.bolivia.swing.JCTextField total;
    public static javax.swing.JTextField troco;
    private javax.swing.JButton vender;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import financeiro.ContasReceber;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
import principal.barra;

/**
 *
 * @author hugov
 */
public class FrmUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmUsuarios
     */
    public FrmUsuarios() {
        initComponents();
        tabelaUsuarios.getTableHeader().setDefaultRenderer(new principal.EstiloTabelaHeader());
        tabelaUsuarios.setDefaultRenderer(Object.class, new principal.EstiloTabelaRenderer());
        tabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        limparCampos();
        
        //INICIALIZAÇÃO DOS COMPONENTES
        
        sexo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (sexo.getSelectedItem().equals("SEXO")) {
                   lblSexo.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/tipousL.png")));
                    
                }
                if (sexo.getSelectedItem().equals("Masculino")) {
                    lblSexo.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/masL.png")));
                    
                }
                if (sexo.getSelectedItem().equals("Feminino")) {
                    lblSexo.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/femL.png")));
                   
                }
            }
        });
        tipo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (tipo.getSelectedItem().equals("TIPO USUARIO")) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/tipousL.png")));
                }
                if (tipo.getSelectedItem().equals("ADMINISTRADOR")) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/administrador.png")));
                }
                if (tipo.getSelectedItem().equals("NORMAL")) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/normal.png")));
                }
                 if (tipo.getSelectedItem().equals("CLIENTE")) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/normal.png")));
                }
                 if (tipo.getSelectedItem().equals("FORNECEDOR")) {
                    tipoL.setIcon(new ImageIcon(getClass().getResource("/imagens/usuarios/normal.png")));
                }
            }
        });
        
        tabelaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (tabelaUsuarios.getSelectedRow() != -1) {
                    atualizarDados();
                    
                }
            }
        });

    }
    
//     public void WebServic(){
//     String cep;
//        
//        cep = TxtCep.getText();//JOptionPane.showInputDialog(null, "Qual seu cep?");
//        
//        WebTarget w = ClientBuilder.newBuilder().build()
//                         .target("https://viacep.com.br/ws/");
//       
//      Endereco e = w.path(cep)
//           .path("json")
//            .request()
//            .get(Endereco.class);
//         JOptionPane.showMessageDialog(null, "Endereço localizado!");
//         JOptionPane.showMessageDialog(null,e.getLogradouro());
//         TxtRua.setText(e.getLogradouro());
//         TxtUf.setText(e.getUf());
//         TxtBairro.setText(e.getBairro());
//         TxtCidade.setText(e.getLocalidade());
//         
//    }  
       
   
    
    void atualizarDados() {
        int linha = tabelaUsuarios.getSelectedRow();
        codigo.setText(tabelaUsuarios.getValueAt(linha, 0).toString());
        nome.setText(tabelaUsuarios.getValueAt(linha, 1).toString());
        sexo.setSelectedItem(tabelaUsuarios.getValueAt(linha, 2).toString());
        tipo.setSelectedItem(tabelaUsuarios.getValueAt(linha, 3).toString());
        senha.setText(tabelaUsuarios.getValueAt(linha, 4).toString());
        TxtCep.setText(tabelaUsuarios.getValueAt(linha, 5).toString());
        TxtRua.setText(tabelaUsuarios.getValueAt(linha, 6).toString());
        TxtUf.setText(tabelaUsuarios.getValueAt(linha, 7).toString());
         TxtBairro.setText(tabelaUsuarios.getValueAt(linha, 8).toString());
        TxtCidade.setText(tabelaUsuarios.getValueAt(linha, 9).toString());
        
        
        
        
    }
    
    void limparCampos() {
        if (tabelaUsuarios.getSelectedRow() > -1) {
            tabelaUsuarios.removeRowSelectionInterval(tabelaUsuarios.getSelectedRow(), tabelaUsuarios.getSelectedRow());
        }
        codigo.setText("");
        nome.setText("");
        sexo.setSelectedItem("SEXO");
        tipo.setSelectedItem("TIPO USUARIO");
        senha.setText("");
        buscar.setText("");
        TxtCidade.setText("");
        TxtBairro.setText("");
        TxtUf.setText("");
        TxtRua.setText("");
        TxtCep.setText("");
        UsuariosSql.listarUsuario("");
        UsuariosSql.gerarId();
    }
void selecionarLinha(String id) {
        for (int i = 0; i < tabelaUsuarios.getRowCount(); i++) {
            if (id.equals(tabelaUsuarios.getValueAt(i, 0))) {
                tabelaUsuarios.setRowSelectionInterval(i, i);
                break;
            }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        registrar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        excluirT = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buscar = new app.bolivia.swing.JCTextField();
        codigoL1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        codigo = new app.bolivia.swing.JCTextField();
        codigoL = new javax.swing.JLabel();
        nome = new app.bolivia.swing.JCTextField();
        nomeL = new javax.swing.JLabel();
        tipo = new org.bolivia.combo.SComboBoxBlue();
        senha = new jpass.JRPasswordField();
        tipoL = new javax.swing.JLabel();
        nomeL1 = new javax.swing.JLabel();
        sexo = new org.bolivia.combo.SComboBoxBlue();
        lblSexo = new javax.swing.JLabel();
        registrar1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        TxtCep = new app.bolivia.swing.JCTextField();
        TxtBairro = new javax.swing.JTextField();
        TxtRua = new javax.swing.JTextField();
        TxtUf = new javax.swing.JTextField();
        codigoL2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(900, 520));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "SEXO", "TIPO", "SENHA", "CEP", "RUA", "ESTADO", "BAIRRO", "CIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabelaUsuarios);
        if (tabelaUsuarios.getColumnModel().getColumnCount() > 0) {
            tabelaUsuarios.getColumnModel().getColumn(8).setResizable(false);
            tabelaUsuarios.getColumnModel().getColumn(9).setResizable(false);
        }

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

        excluirT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        excluirT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagarT.png"))); // NOI18N
        excluirT.setBorder(null);
        excluirT.setBorderPainted(false);
        excluirT.setContentAreaFilled(false);
        excluirT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluirT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirT.setLabel("Excluir Tudo");
        excluirT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagarT1.png"))); // NOI18N
        excluirT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluirT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirTActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atualizar)
                .addGap(31, 31, 31)
                .addComponent(excluir)
                .addGap(18, 18, 18)
                .addComponent(excluirT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpar)
                .addContainerGap(437, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrar)
            .addComponent(atualizar)
            .addComponent(excluir)
            .addComponent(excluirT)
            .addComponent(limpar)
        );

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
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });
        jPanel4.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/buscarL.png"))); // NOI18N
        jPanel4.add(codigoL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 52));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigo.setEditable(false);
        codigo.setBackground(new java.awt.Color(34, 102, 145));
        codigo.setBorder(null);
        codigo.setForeground(new java.awt.Color(255, 255, 255));
        codigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        codigo.setOpaque(false);
        codigo.setPhColor(new java.awt.Color(255, 255, 255));
        codigo.setPlaceholder("CÓDIGO");
        jPanel2.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, -1));

        codigoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/codigoL.png"))); // NOI18N
        jPanel2.add(codigoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 52));

        nome.setBackground(new java.awt.Color(34, 102, 145));
        nome.setBorder(null);
        nome.setForeground(new java.awt.Color(255, 255, 255));
        nome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nome.setOpaque(false);
        nome.setPhColor(new java.awt.Color(255, 255, 255));
        nome.setPlaceholder("NOME USUARIO");
        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomeKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });
        jPanel2.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 180, -1));

        nomeL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios/nomUs.png"))); // NOI18N
        jPanel2.add(nomeL, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 52));

        tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO USUARIO", "ADMINISTRADOR", "NORMAL", "CLIENTE", "FORNECEDOR" }));
        tipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 183, -1));

        senha.setBackground(new java.awt.Color(34, 102, 145));
        senha.setBorder(null);
        senha.setForeground(new java.awt.Color(255, 255, 255));
        senha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        senha.setName(""); // NOI18N
        senha.setOpaque(false);
        senha.setPhColor(new java.awt.Color(255, 255, 255));
        senha.setPlaceholder("SENHA");
        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });
        senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaKeyPressed(evt);
            }
        });
        jPanel2.add(senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 180, -1));

        tipoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios/tipousL.png"))); // NOI18N
        tipoL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(tipoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, 52));

        nomeL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios/senha.png"))); // NOI18N
        jPanel2.add(nomeL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, 52));

        sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SEXO", "Feminino", "Masculino" }));
        sexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 183, -1));

        lblSexo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuarios/sexoL.png"))); // NOI18N
        lblSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 52));

        registrar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/Money-Increase-icon.png"))); // NOI18N
        registrar1.setText("CONTAS A RECEBER");
        registrar1.setBorder(null);
        registrar1.setBorderPainted(false);
        registrar1.setContentAreaFilled(false);
        registrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registrar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/dollar-rotation-icon.png"))); // NOI18N
        registrar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        registrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(registrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 140, -1));

        jTabbedPane1.addTab("Principal", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtCep.setBackground(new java.awt.Color(34, 102, 145));
        TxtCep.setBorder(null);
        TxtCep.setForeground(new java.awt.Color(255, 255, 255));
        TxtCep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtCep.setOpaque(false);
        TxtCep.setPhColor(new java.awt.Color(255, 255, 255));
        TxtCep.setPlaceholder("CEP");
        TxtCep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtCepMouseClicked(evt);
            }
        });
        TxtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtCepKeyReleased(evt);
            }
        });
        jPanel5.add(TxtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 180, -1));

        TxtBairro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel5.add(TxtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 110, 40));

        TxtRua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TxtRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtRuaActionPerformed(evt);
            }
        });
        jPanel5.add(TxtRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 130, 40));

        TxtUf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel5.add(TxtUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 50, 40));

        codigoL2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/buscarL.png"))); // NOI18N
        jPanel5.add(codigoL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 250, 52));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("BAIRRO:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("RUA:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ESTADO:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, -1, -1));

        TxtCidade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel5.add(TxtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 100, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CIDADE:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        jTabbedPane1.addTab("Endereço", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

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

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
   
   
    }//GEN-LAST:event_nomeKeyReleased

    private void nomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyTyped
    
  
    }//GEN-LAST:event_nomeKeyTyped
 boolean selecionarRegistro = false;
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
  
        if (selecionarRegistro) {
            JOptionPane.showMessageDialog(this, "O código: " + this.codigo.getText() + "\n já está registrado.", "Usuarios", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        } else {
            String sen = new String(senha.getPassword());
            if (codigo.getText().equals("") || nome.getText().equals("") || sexo.getSelectedItem().equals("SEXO")
                    || tipo.getSelectedItem().equals("TIPO USUARIO") || senha.equals("")) {
                JOptionPane.showMessageDialog(this, "Todos os campos\nsão obrigatórios.", "Usuarios", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            } else {
                usuarios.Usuarios us = new Usuarios();
                us.setPrimaryKey(codigo.getText());
                us.setNome(nome.getText());
                us.setSexo(sexo.getSelectedItem().toString());
                us.setTipouser(tipo.getSelectedItem().toString());
                us.setCep(TxtCep.getText());
                us.setRua(TxtRua.getText());
                us.setBairro(TxtBairro.getText());
                us.setUf(TxtUf.getText());
                us.setCidade(TxtCidade.getText());
                        
                us.setSenha(sen);
                int op = UsuariosSql.registrarUsuario(us);
                if (op != 0) {
                    String id = codigo.getText();
                    limparCampos();
                    selecionarLinha(id);
                    JOptionPane.showMessageDialog(this, "Usuário Inserido com Sucesso.", "Usuarios", 0,
                            new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                }
            }   
        }
    }//GEN-LAST:event_registrarActionPerformed
    
    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
     if (tabelaUsuarios.getRowCount() > 0) {
            if (tabelaUsuarios.getSelectedRowCount() > 0) {
                String sen = new String(senha.getPassword());
                if (codigo.getText().equals("") || nome.getText().equals("") || sexo.getSelectedItem().equals("SEXO")
                        || tipo.getSelectedItem().equals("TIPO USUARIO") || senha.equals("")) {
                    JOptionPane.showMessageDialog(this, "Preecha os campos.", "Usuarios", 0,
                            new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                } else if (JOptionPane.showConfirmDialog(this, "Deseja alterar o registro?", "Usuarios", JOptionPane.YES_NO_OPTION, 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png"))) == JOptionPane.YES_OPTION) {
                    usuarios.Usuarios us = new Usuarios();
                    us.setPrimaryKey(codigo.getText());
                    us.setNome(nome.getText());
                    us.setSexo(sexo.getSelectedItem().toString());
                    us.setTipouser(tipo.getSelectedItem().toString());
                    us.setSenha(sen);
                    int opc = UsuariosSql.atualizarUsuario(us);
                    if (opc != 0) {
                        String id = codigo.getText();
                        limparCampos();
                        selecionarLinha(id);
                        JOptionPane.showMessageDialog(this, "Registro Atualizado.", "Usuarios", 0,
                                new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro.", "Usuarios", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Não há registro para alterar.", "Usuarios", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        }   
    }//GEN-LAST:event_atualizarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
       if (tabelaUsuarios.getRowCount() > 0) {
            if (tabelaUsuarios.getSelectedRowCount() > 0) {
                if (JOptionPane.showConfirmDialog(this, "Deseja Excluir?", "Usuarios", JOptionPane.YES_NO_OPTION, 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png"))) == JOptionPane.YES_OPTION) {
                    int linha = tabelaUsuarios.getSelectedRow();
                    String id = tabelaUsuarios.getValueAt(linha, 0).toString();
                    int elimina = UsuariosSql.eliminarUsuario(id);
                    if (elimina != 0) {
                        limparCampos();
                        JOptionPane.showMessageDialog(this, "Registro excluido.", "Usuarios", 0,
                                new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro.", "Usuarios", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para exclusão.", "Usuarios", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void excluirTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirTActionPerformed
    if (tabelaUsuarios.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Deseja excluir todos os usuários?", "Usuarios", JOptionPane.YES_NO_OPTION, 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png"))) == JOptionPane.YES_OPTION) {
                int eliminaT = UsuariosSql.eliminaTodos();
                if (eliminaT != 0) {
                    limparCampos();
                    JOptionPane.showMessageDialog(this, "Registros excluidos.", "Usuarios", 0,
                            new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    
                    
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para excluir.", "Usuarios", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        }
    }//GEN-LAST:event_excluirTActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
    limparCampos();
    }//GEN-LAST:event_limparActionPerformed

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
    limparCampos();
    }//GEN-LAST:event_buscarMouseClicked

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
    
    UsuariosSql.listarUsuario(buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaKeyPressed
       
    }//GEN-LAST:event_senhaKeyPressed

    private void registrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar1ActionPerformed
     ContasReceber frame = new ContasReceber();
     frame.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_registrar1ActionPerformed

    private void TxtCepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtCepMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCepMouseClicked

    private void TxtCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCepKeyReleased
if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      
      // WebServic(); 
       
     
    }        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCepKeyReleased

    private void TxtRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtRuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtBairro;
    private app.bolivia.swing.JCTextField TxtCep;
    private javax.swing.JTextField TxtCidade;
    private javax.swing.JTextField TxtRua;
    private javax.swing.JTextField TxtUf;
    private javax.swing.JButton atualizar;
    private app.bolivia.swing.JCTextField buscar;
    public static app.bolivia.swing.JCTextField codigo;
    private javax.swing.JLabel codigoL;
    private javax.swing.JLabel codigoL1;
    private javax.swing.JLabel codigoL2;
    private javax.swing.JButton excluir;
    private javax.swing.JButton excluirT;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JButton limpar;
    private app.bolivia.swing.JCTextField nome;
    private javax.swing.JLabel nomeL;
    private javax.swing.JLabel nomeL1;
    private javax.swing.JButton registrar;
    private javax.swing.JButton registrar1;
    private jpass.JRPasswordField senha;
    private org.bolivia.combo.SComboBoxBlue sexo;
    public static javax.swing.JTable tabelaUsuarios;
    private org.bolivia.combo.SComboBoxBlue tipo;
    private javax.swing.JLabel tipoL;
    // End of variables declaration//GEN-END:variables
}

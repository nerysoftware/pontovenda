/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import backu_mysql.JF_Mysql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import produtos.FrmProdutos;
import relatorios.relatorio_produto;
import relatorios.relatorio_vend;
import usuarios.FrmUsuarios;
import vendas.FrmCaixa;
import vendas.FrmVendas;

/**
 *
 * @author hugov
 */
public class MenuPrincipalP extends javax.swing.JFrame {
    
 
    
    public boolean estaFechado(Object obj){
        JInternalFrame[] ativo = carregador.getAllFrames();
        boolean fechado = true;
        int i = 0;
        while(i < ativo.length && fechado) {
            if (ativo [i] == obj){
                fechado = false;
                
            }
            
            i++;
        }
        return fechado;
    }
    
    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistemaHora = new Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat formato = new SimpleDateFormat(pmAm);
            Calendar now = Calendar.getInstance();
            hora.setText(String.format(formato.format(sistemaHora), now));
        }
    }

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipalP() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        painelCabecalho = new javax.swing.JPanel();
        hora = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();
        userConect = new javax.swing.JLabel();
        logouser = new javax.swing.JLabel();
        logodesconect = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        carregador = new principal.Carregador();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("© Nery Software - Administrador");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        painelPrincipal.setPreferredSize(new java.awt.Dimension(1280, 640));
        painelPrincipal.setLayout(new java.awt.BorderLayout());

        painelCabecalho.setBackground(new java.awt.Color(0, 0, 51));
        painelCabecalho.setPreferredSize(new java.awt.Dimension(1280, 125));
        painelCabecalho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setText("HORA");
        painelCabecalho.add(hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 225, -1));

        data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        data.setForeground(new java.awt.Color(255, 255, 255));
        data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        data.setText("DIA - MES - ANO");
        painelCabecalho.add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 225, -1));

        desc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        desc.setForeground(new java.awt.Color(255, 255, 255));
        desc.setText("Sair . . .");
        desc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        desc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descMouseClicked(evt);
            }
        });
        painelCabecalho.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 100, -1, -1));

        userConect.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userConect.setForeground(new java.awt.Color(255, 255, 255));
        userConect.setText("USUARIO");
        painelCabecalho.add(userConect, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 101, -1));

        logouser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logouser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/conectado.png"))); // NOI18N
        painelCabecalho.add(logouser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        logodesconect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logodesconect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/desconec.png"))); // NOI18N
        logodesconect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logodesconectMouseClicked(evt);
            }
        });
        painelCabecalho.add(logodesconect, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 90, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/email-2-icon.png"))); // NOI18N
        jButton1.setText("EMAIL");
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPreferredSize(new java.awt.Dimension(100, 120));
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/email-icon.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        painelCabecalho.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, 120));

        btnProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/Shopping-bag-blue-icon.png"))); // NOI18N
        btnProduto.setText("PRODUTOS");
        btnProduto.setBorder(null);
        btnProduto.setContentAreaFilled(false);
        btnProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProduto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProduto.setName("btnProduto"); // NOI18N
        btnProduto.setPreferredSize(new java.awt.Dimension(100, 120));
        btnProduto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/Add-item-icon.png"))); // NOI18N
        btnProduto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });
        painelCabecalho.add(btnProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 120));

        btnCaixa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCaixa.setForeground(new java.awt.Color(255, 255, 255));
        btnCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/Cash-register-icon.png"))); // NOI18N
        btnCaixa.setText("CAIXA");
        btnCaixa.setBorder(null);
        btnCaixa.setContentAreaFilled(false);
        btnCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCaixa.setName("btnCaixa"); // NOI18N
        btnCaixa.setPreferredSize(new java.awt.Dimension(100, 120));
        btnCaixa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/shop-cart-add-icon_1.png"))); // NOI18N
        btnCaixa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });
        painelCabecalho.add(btnCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backu_mysql/Time-Machine-Drive-icon.png"))); // NOI18N
        jButton2.setText("REALIZAR BACKUP");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPreferredSize(new java.awt.Dimension(100, 120));
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/backu_mysql/iDisk-Drive-icon.png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        painelCabecalho.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 130, -1));

        painelPrincipal.add(painelCabecalho, java.awt.BorderLayout.PAGE_START);

        carregador.setName("carregador"); // NOI18N
        painelPrincipal.add(carregador, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelPrincipal);

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descMouseClicked
 if (JOptionPane.showConfirmDialog(this, "Deseja fechar a sessão do usuário?", "Fechar Sessão", JOptionPane.YES_NO_OPTION, 0,
                new ImageIcon(getClass().getResource("/imagens/principal/info.png"))) == JOptionPane.YES_OPTION) {
            this.dispose(); 
            Login login = new Login();
            login.setLocationRelativeTo(null);
            login.setVisible(true);  
            
         }        
    }//GEN-LAST:event_descMouseClicked
    produtos.FrmProdutos tela;
    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        
        if(estaFechado(tela)){
            tela = new FrmProdutos();
            carregador.add(tela).setLocation(150,3);         
            tela.show();                    
        }else{         
                tela.show();
                tela.toFront();
        }
        
    }//GEN-LAST:event_btnProdutoActionPerformed
   usuarios.FrmUsuarios tela1;   vendas.FrmCaixa tela2;
    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
       if(estaFechado(tela2)){
            tela2 = new FrmCaixa();
        carregador.add(tela2).setLocation(20,3);
        tela2.show();
       }else{
           tela2.show();
           tela2.toFront();
       }
        
    }//GEN-LAST:event_btnCaixaActionPerformed
  vendas.FrmVendas tela3;
    private void logodesconectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logodesconectMouseClicked
       if (JOptionPane.showConfirmDialog(this, "Deseja fechar a sessão do usuário?", "Fechar Sessão", JOptionPane.YES_NO_OPTION, 0,
                new ImageIcon(getClass().getResource("/imagens/principal/info.png"))) == JOptionPane.YES_OPTION) {
            this.dispose(); 
            Login login = new Login();
            login.setLocationRelativeTo(null);
            login.setVisible(true);  
            
         }         // TODO add your handling code here:
    }//GEN-LAST:event_logodesconectMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setExtendedState(MAXIMIZED_BOTH);  
        
        Date sistemaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
        data.setText(formato.format(sistemaData));
        
        //HORA DO SISTEMA
        Timer hr = new Timer(100, new MenuPrincipalP.horas());
        hr.start();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   EnviarEmail frame = new  EnviarEmail();
   frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JF_Mysql frame = new JF_Mysql();
         frame.setVisible(true);
          // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(MenuPrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuPrincipalP tela = new MenuPrincipalP();
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnProduto;
    public static principal.Carregador carregador;
    private javax.swing.JLabel data;
    private javax.swing.JLabel desc;
    private javax.swing.JLabel hora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel logodesconect;
    private javax.swing.JLabel logouser;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelPrincipal;
    public static javax.swing.JLabel userConect;
    // End of variables declaration//GEN-END:variables
}

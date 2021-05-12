/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import usuarios.LogBEAN;
import usuarios.LogDAO;



/**
 *
 * @author hugov
 */
public class Login extends javax.swing.JFrame {
    
    SplashScreen inicio;
    String nomeDoAudio;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        dataHora();
        
       
    }
    
   public void play(String nomeDoAudio){
        URL url = Login.class.getResource(nomeDoAudio+".wav");
        AudioClip audio = Applet.newAudioClip(url);
        audio.play();
    }
    
    
    public Login(SplashScreen inicio){
        this.inicio = inicio;
        setProgress(0, "Carregando componentes do sistema");
        initComponents();
        setProgress(20, "Conectando ao banco de dados!");
        setProgress(40, "Carregando os módulos");
        setProgress(60, "Carregamento de módulos concluidos");
        setProgress(80, "Carregando interfaces");
        setProgress(90, "Interface carregada");
        setProgress(100,"Bem vindo ao sistema!!");
    }
    
    public void log(){
        LogBEAN c = new LogBEAN();
        LogDAO dao = new LogDAO();
        
        c.setNome_user(usuario.getText());
        c.setData(Txt_data.getText());
        c.setHora(Txt_hora.getText());
        dao.create(c);
        
        
        
}
    
     class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistemaHora = new Date();
            String pmAm = "HH:mm:ss";
            SimpleDateFormat formato = new SimpleDateFormat(pmAm);
            Calendar now = Calendar.getInstance();
            Txt_hora.setText(String.format(formato.format(sistemaHora), now));
        }
    }

    void setProgress(int percent,String informacao){
        inicio.getJLabel().setText(informacao);
        inicio.getJProgressBar().setValue(percent);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível carregar a inicialização");
        }
    }
    
    
  
   
public void dataHora(){
        Date sistemaData = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
        Txt_data.setText(formato.format(sistemaData));
        
          
        //HORA DO SISTEMA
        Timer hr = new Timer(100, new Login.horas());
        hr.start();        // TODO add your handling code here:
        
          
}
  
    

    //iniciando a conexão
    Conectar con = new Conectar();
    Connection cn = con.conexao();
    //altenticação de usuario
    public void Logar(String id,String senha){
        String dado = null;
        try {
            String sql = "SELECT nome_us FROM usuarios WHERE nome_us = '" +id+ "' ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.first()){
                String sql1 = "SELECT senha FROM usuarios WHERE senha = '" +senha+ "' ";
                Statement st1 = cn.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);
                if(rs1.first()){
                    String sql2 = "SELECT tipo_us FROM usuarios WHERE nome_us = '" +id+ "' "
                            + "and senha = '" +senha+ "' ";
                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql2);
                    
                    while(rs2.next()){
                        dado = rs2.getString(1);
                        
                    }
                    
                    if (dado.equals("ADMINISTRADOR")){
                        String sql3 = "SELECT nome_us FROM usuarios WHERE nome_us = '" +id+ "' ";
                        Statement st3 = cn.createStatement();
                        ResultSet rs3 = st3.executeQuery(sql3);
                        
                         while(rs3.next()){
                         dado = rs3.getString(1);                            
                         }
                         
                         dispose();
                         
                         System.out.println("USUARIO LOGADO");
                         MenuPrincipal menu = new MenuPrincipal();
                        
                    
                          
                          menu.userConect.setText(dado);
                          menu.setLocationRelativeTo(null);
                          menu.setVisible(true);
                          
                    }else{
                        String sql4 = "SELECT nome_us FROM usuarios WHERE nome_us = '" +id+ "' ";
                        Statement st4 = cn.createStatement();
                        ResultSet rs4 = st4.executeQuery(sql4);
                        
                         while(rs4.next()){
                         dado = rs4.getString(1);                            
                         }
                         
                         dispose();
                         MenuPrincipalP menuP = new MenuPrincipalP();
                       
                    
                          
                          menuP.userConect.setText(dado);
                          menuP.setLocationRelativeTo(null);
                          menuP.setVisible(true);
                          
                    }
                    
                    
                }else{
                     JOptionPane.showMessageDialog(this, "Senha Incorreta!", "Login", 0);
                    System.out.println("ERRO NA SENHA");
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "O usuário não existe no banco de dados!", "Login", 0);
                    System.out.println("USUARIO INVALIDO");
            }
            
            
            
        } catch (Exception e) {
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

        hora = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        painelLogin = new javax.swing.JPanel();
        painelImgCab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Txt_data = new javax.swing.JLabel();
        Txt_hora = new javax.swing.JLabel();
        usuario = new app.bolivia.swing.JCTextField();
        jLabel4 = new javax.swing.JLabel();
        senha = new jpass.JRPasswordField();
        jButton2 = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        hora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hora.setForeground(new java.awt.Color(255, 255, 255));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setText("HORA");

        data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        data.setForeground(new java.awt.Color(255, 255, 255));
        data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        data.setText("DIA - MES - ANO");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocation(new java.awt.Point(0, 0));
        setName("telaPrincipal"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelLogin.setLayout(new java.awt.BorderLayout());

        painelImgCab.setBackground(new java.awt.Color(0, 0, 0));
        painelImgCab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 0, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas/iconevalor.png"))); // NOI18N
        jLabel1.setAutoscrolls(true);
        painelImgCab.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, 180));

        Txt_data.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Txt_data.setForeground(new java.awt.Color(255, 255, 255));
        Txt_data.setText("DATA");
        painelImgCab.add(Txt_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 190, 20));

        Txt_hora.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Txt_hora.setForeground(new java.awt.Color(255, 255, 255));
        Txt_hora.setText("HORA");
        painelImgCab.add(Txt_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 190, 20));

        usuario.setBackground(new java.awt.Color(34, 102, 145));
        usuario.setBorder(null);
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usuario.setName("usuario"); // NOI18N
        usuario.setOpaque(false);
        usuario.setPhColor(new java.awt.Color(255, 255, 255));
        usuario.setPlaceholder("USUARIO");
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioKeyReleased(evt);
            }
        });
        painelImgCab.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 160, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/campoLoginUs.png"))); // NOI18N
        painelImgCab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

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
        painelImgCab.add(senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 180, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/sair2.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setPreferredSize(new java.awt.Dimension(135, 45));
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/sair1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        painelImgCab.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));

        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/entrar2.png"))); // NOI18N
        btnEntrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEntrar.setBorderPainted(false);
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.setName("btnEntrar"); // NOI18N
        btnEntrar.setPreferredSize(new java.awt.Dimension(135, 45));
        btnEntrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/entrar1.png"))); // NOI18N
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        painelImgCab.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/campoLoginPass.png"))); // NOI18N
        jLabel5.setName("txtSenha"); // NOI18N
        painelImgCab.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/principal/gifP.gif"))); // NOI18N
        painelImgCab.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 570));

        painelLogin.add(painelImgCab, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(painelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 508, 481));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyReleased
       
    }//GEN-LAST:event_usuarioKeyReleased

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
       String us = usuario.getText();
       String pass = senha.getText();
          if(us.equals("") || pass.equals("")){
           JOptionPane.showMessageDialog(this, "Preencha os Campos", "Login", 0);
                    
            
         }else{
          Logar(us, pass); 
       }
          
//          log();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyPressed
       
    }//GEN-LAST:event_usuarioKeyPressed

    private void senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         btnEntrarActionPerformed(null);   
       }// TODO add your handling code here:
    }//GEN-LAST:event_senhaKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    dataHora();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login tela = new Login();
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Txt_data;
    private javax.swing.JLabel Txt_hora;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel data;
    private javax.swing.JLabel hora;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel painelImgCab;
    private javax.swing.JPanel painelLogin;
    private jpass.JRPasswordField senha;
    private app.bolivia.swing.JCTextField usuario;
    // End of variables declaration//GEN-END:variables
}

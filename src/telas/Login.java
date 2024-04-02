package telas;
import java.sql.*;
import dal.Mod_conexao;
import javax.swing.JOptionPane;
//importando o módulo responsável pela conexão padrão com o banco de dados

public class Login extends javax.swing.JFrame {
//objeto Login com interface (JFrame)
    
    Connection conexaoBD = null;
    PreparedStatement executarComando = null;
    ResultSet respostaBD = null;
    //variáveis de conexão que ainda receberão seus respectivos valores
    
    public Login() {
    //método 'Login' onde puxamos a conexão com o servidor do BD 
    //ao executar a página
        initComponents();
        conexaoBD = Mod_conexao.conexao();
        //importando o método de conexão do objeto Mod_conexao
       
        if (conexaoBD != null){
        //confirmando se a conexão foi estabelecida e exibindo no front-end
        //através de ícones
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Valido.png")));
        }
        else{
            lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Invalido.png")));
        }
    }
    
    public void Logar(){
        String comandoSQLSearch ="SELECT * FROM tbl_user WHERE email=? AND senha=?";
        //variável com o valor do comando SQL
        try{
            executarComando = conexaoBD.prepareStatement(comandoSQLSearch);
            //abrindo uma query no SQL
            
            executarComando.setString(1, input_user.getText());
            executarComando.setString(2, input_password.getText());
            //enviando os comandos para o JDBC
            
            respostaBD = executarComando.executeQuery();
            
            if(respostaBD.next()){
                Home telaPrincipal = new Home();
                //iniciando uma nova área, neste caso, Home
                
                telaPrincipal.setVisible(true);
                //tornando-a vísivel
                
                Home.lblUserName.setText(respostaBD.getString(2));
                //colocando o nome do usuário logado em exibição na label 'UserName' pelo index da coluna (2)
                
                this.dispose();
                //fechando a janela de login
                conexaoBD.close();
                //fechando a conexão com o banco de dados (boas práticas)
            }else{
                JOptionPane.showMessageDialog(rootPane, "Usuário/Senha inválido!", "Erro de autenticação SQL", JOptionPane.WARNING_MESSAGE);
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        input_user = new javax.swing.JTextField();
        lbl_titleUser = new javax.swing.JLabel();
        lbl_titlePassword = new javax.swing.JLabel();
        input_password = new javax.swing.JTextField();
        btn_login = new javax.swing.JButton();
        lbl_status = new javax.swing.JLabel();
        lbl_welcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login de Usuário");
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        setForeground(java.awt.Color.darkGray);
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("Tela_de_Login"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        input_user.setFont(getFont());
        input_user.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        input_user.setToolTipText("");
        input_user.setBorder(null);
        input_user.setMargin(new java.awt.Insets(4, 30, 4, 8));
        input_user.setMaximumSize(new java.awt.Dimension(200, 200));
        input_user.setMinimumSize(new java.awt.Dimension(100, 25));
        input_user.setPreferredSize(new java.awt.Dimension(180, 30));
        input_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_userActionPerformed(evt);
            }
        });

        lbl_titleUser.setFont(getFont());
        lbl_titleUser.setText("Usuário");

        lbl_titlePassword.setFont(getFont());
        lbl_titlePassword.setText("Senha");

        input_password.setFont(getFont());
        input_password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        input_password.setToolTipText("");
        input_password.setBorder(null);
        input_password.setMargin(new java.awt.Insets(4, 30, 4, 8));
        input_password.setMaximumSize(new java.awt.Dimension(200, 200));
        input_password.setMinimumSize(new java.awt.Dimension(100, 25));
        input_password.setPreferredSize(new java.awt.Dimension(180, 30));
        input_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_passwordActionPerformed(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(153, 153, 153));
        btn_login.setFont(getFont());
        btn_login.setText("Login");
        btn_login.setAlignmentY(0.0F);
        btn_login.setBorderPainted(false);
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_login.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btn_login.setMaximumSize(new java.awt.Dimension(90, 30));
        btn_login.setMinimumSize(new java.awt.Dimension(85, 30));
        btn_login.setName("Botão de Login"); // NOI18N
        btn_login.setPreferredSize(new java.awt.Dimension(85, 30));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        lbl_status.setFont(getFont());
        lbl_status.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Valido.png"))); // NOI18N
        lbl_status.setText("STATUS");

        lbl_welcome.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lbl_welcome.setText("Bem-vindo ao BD Agenda!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_titleUser, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(lbl_titlePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(input_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(input_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_welcome))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(281, 281, 281))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lbl_welcome)
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(input_user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_titleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_titlePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        btn_login.getAccessibleContext().setAccessibleDescription("Botão pra enviar os dados para o Server");

        getAccessibleContext().setAccessibleDescription("Interface ");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void input_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_passwordActionPerformed

    private void input_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_userActionPerformed
        
        
    }//GEN-LAST:event_input_userActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        Logar();
    }//GEN-LAST:event_btn_loginActionPerformed

    public static void main(String args[]) {
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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JTextField input_password;
    private javax.swing.JTextField input_user;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_titlePassword;
    private javax.swing.JLabel lbl_titleUser;
    private javax.swing.JLabel lbl_welcome;
    // End of variables declaration//GEN-END:variables
}

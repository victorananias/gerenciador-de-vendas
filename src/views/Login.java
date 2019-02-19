package views;

import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import controllers.UsuariosController;

public class Login extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	public Login() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        painelInterno = new javax.swing.JPanel();
        jBtEntrar = new javax.swing.JButton();
        jLabelLogin = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        painelFundo.setBackground(new java.awt.Color(254, 254, 254));
        painelFundo.setPreferredSize(new java.awt.Dimension(1100, 600));

        painelInterno.setBackground(new java.awt.Color(232, 232, 232));
        painelInterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 232, 232)));
        painelInterno.setAlignmentX(0.0F);
        painelInterno.setAlignmentY(0.0F);
        painelInterno.setOpaque(false);

        jBtEntrar.setText("Entrar");
        jBtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEntrarActionPerformed(evt);
            }
        });

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLogin.setText("Usuário:");

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSenha.setText("Senha:");

        campoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoUsuarioKeyPressed(evt);
            }
        });

        campoSenha.setMinimumSize(new java.awt.Dimension(200, 26));
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
        });

        jLabelTitle.setBackground(new java.awt.Color(239, 239, 241));
        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitle.setText("Entre com seu Usuário e Senha");
        jLabelTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 239, 241), 10));
        jLabelTitle.setOpaque(true);

        javax.swing.GroupLayout painelInternoLayout = new javax.swing.GroupLayout(painelInterno);
        painelInterno.setLayout(painelInternoLayout);
        painelInternoLayout
                .setHorizontalGroup(painelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addGroup(painelInternoLayout.createSequentialGroup().addGap(52, 52, 52)
                                .addGroup(painelInternoLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jBtEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(painelInternoLayout.createSequentialGroup()
                                                .addGroup(painelInternoLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelLogin).addComponent(jLabelSenha))
                                                .addGap(18, 18, 18)
                                                .addGroup(painelInternoLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(campoUsuario).addComponent(campoSenha,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        painelInternoLayout.setVerticalGroup(painelInternoLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInternoLayout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addGroup(painelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(18, 18, 18)
                        .addGroup(painelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGap(24, 24, 24)
                        .addComponent(jBtEntrar).addContainerGap()));

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
                painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        painelFundoLayout.createSequentialGroup().addContainerGap(355, Short.MAX_VALUE)
                                .addComponent(painelInterno, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(349, 349, 349)));
        painelFundoLayout
                .setVerticalGroup(painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelFundoLayout.createSequentialGroup().addGap(171, 171, 171)
                                .addComponent(painelInterno, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(167, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelFundo,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(painelFundo,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtEntrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtEntrarActionPerformed
        if (campoUsuario.getText().equals("") || new String(campoSenha.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique os campos e tente novamente.");
            return;
        }

        boolean login = false;

        try {
            login = new UsuariosController().login(this.campoUsuario.getText(), new String(this.campoSenha.getPassword()));
        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro ao verificar login.");
        }

        if (!login){
            JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos.");
            return;
        }

        new Menu().setVisible(true);

        Login.this.dispose();
    }//GEN-LAST:event_jBtEntrarActionPerformed

    private void campoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jBtEntrar.doClick();
        }
    }//GEN-LAST:event_campoSenhaKeyPressed

    private void campoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            campoSenha.requestFocus();
        }
    }//GEN-LAST:event_campoUsuarioKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JButton jBtEntrar;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JPanel painelFundo;
    private javax.swing.JPanel painelInterno;
    // End of variables declaration//GEN-END:variables
}

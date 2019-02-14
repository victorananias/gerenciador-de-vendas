package views;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import helpers.Senha;
import models.Usuario;

public class AlteracaoSenha extends javax.swing.JFrame {
    private static final long serialVersionUID = 1188706350689865290L;
    private Usuario usuario;

    public AlteracaoSenha(Usuario usuario) {
        this.usuario = usuario;
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void checkPasswordChars() {
        if (new String(jPassword1.getPassword()).equals("")) {
            jLabelPassword1.setText("Campo obrigatório");
        } else if (jPassword1.getPassword().length < 8) {
            jLabelPassword1.setText("Mínimo 8 caracteres");
        } else {
            jLabelPassword1.setText("");
        }
    }

    private boolean checkPassword(JPasswordField field, JLabel label) {
        if (new String(field.getPassword()).equals("")) {
            label.setText("Campo obrigatório");
            return false;
        } 
        
        if (field.getPassword().length < 8) {
            label.setText("Mínimo 8 caracteres");
            return false;
        }

        label.setText("");

        return true;
    }

    private boolean isPasswordsEquals() {
        boolean passowordEquals = new String(this.jPassword1.getPassword()).equals(new String(this.jPassword2.getPassword()));
        
        if (!passowordEquals) {
            jLabelPassword1.setText("");
            jLabelPassword2.setText("Senhas não coincidem.");
            return false;
        }

        return true;
    }

    private void limpaAvisos() {
        jLabelPassword1.setText("");
        jLabelPassword2.setText("");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jBtVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPassword1 = new javax.swing.JPasswordField();
        jPassword2 = new javax.swing.JPasswordField();
        jLabelPassword1 = new javax.swing.JLabel();
        jLabelPassword2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Senha");

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Alterar Senha");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jBtVoltar.setText("Voltar");
        jBtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarActionPerformed(evt);
            }
        });

        jLabel2.setText("Repita a Senha:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel1.setText("Nova Senha:");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 30));

        jPassword1.setMinimumSize(new java.awt.Dimension(10, 19));
        jPassword1.setPreferredSize(new java.awt.Dimension(185, 30));

        jPassword2.setPreferredSize(new java.awt.Dimension(185, 30));
        jPassword2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPassword2FocusLost(evt);
            }
        });

        jLabelPassword1.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelPassword1.setForeground(java.awt.Color.red);

        jLabelPassword2.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelPassword2.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jBtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel3).addGap(226, 226, 226))))
                .addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addGap(245, 245, 245)
                                        .addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabelPassword1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelPassword2, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 185,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(197, 197, 197)))))
                        .addGroup(jPanel2Layout.createSequentialGroup().addGap(116, 116, 116)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 166, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(51, 51, 51).addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 17,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 17,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtVoltar).addComponent(jButtonSalvar))
                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSalvarActionPerformed
        this.limpaAvisos();
        
        if (!this.checkPassword(jPassword1, jLabelPassword1) || !this.checkPassword(jPassword2, jLabelPassword2)) {
            return;
        }

        if (!this.isPasswordsEquals()) {
            JOptionPane.showMessageDialog(null, "Verifique os campos e tente novamente");
            return;
        }

        try {
            this.usuario.setSenha(Senha.encrypt(new String(jPassword1.getPassword())));
            this.usuario.save();

            JOptionPane.showMessageDialog(null, "Senha alterada");
            AlteracaoSenha.this.dispose();

        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha.");
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jBtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarActionPerformed
        AlteracaoSenha.this.dispose();
        new Usuarios().setVisible(true);
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jPassword2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPassword2FocusLost
        this.checkPasswordChars();
    }//GEN-LAST:event_jPassword2FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtVoltar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelPassword2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JPasswordField jPassword1;
    // End of variables declaration//GEN-END:variables
}

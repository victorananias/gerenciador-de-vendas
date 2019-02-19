
package views;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import controllers.UsuariosController;
import helpers.Senha;

public class CadastroUsuario extends javax.swing.JFrame {
    private static final long serialVersionUID = -675651608089314887L;

    public CadastroUsuario() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private boolean isLoginValid() {
        boolean invalid = jFormattedTextLogin.getText().equals("");
        
        jLabelAvisoLogin.setText("");

        if (invalid) {
            jLabelAvisoLogin.setText("Campo obrigatório");
        }

        return !invalid;
    }

    private boolean isNomeValid() {
        boolean invalid = jFormattedTextNome.getText().equals("");

        jLabelAvisoNome.setText("");

        if (invalid) {
            jLabelAvisoNome.setText("Campo obrigatório");
        }

        return !invalid;
    }

    private boolean isCpfValid() {
        boolean invalid = jTextCpf.getText().length() != 11;

        jLabelAvisoCpf.setText("");

        if (invalid) {
            jLabelAvisoCpf.setText("CPF inválido");
        }

        return !invalid;
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
        boolean passowordEquals = new String(
            this.jPassword1.getPassword()).equals(new String(this.jPassword2.getPassword())
        );
        
        if (!passowordEquals) {
            jLabelPassword1.setText("");
            jLabelPassword2.setText("Senhas não coincidem.");
            return false;
        }

        return true;
    }

    private void clearForm() {
        jFormattedTextNome.setText("");
        jFormattedTextLogin.setText("");
        jTextCpf.setText("");
        jPassword2.setText("");
        jPassword1.setText("");
    }

    private boolean isFormValid() {
        boolean valid = isLoginValid() 
            && isNomeValid() 
            && isCpfValid() 
            && checkPassword(jPassword1, jLabelPassword1) 
            && checkPassword(jPassword2, jLabelPassword2) 
            && isPasswordsEquals();

        return valid;
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jBtSalvar = new javax.swing.JButton();
        jLabelTipo = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jFormattedTextNome = new javax.swing.JFormattedTextField();
        jLabelTitle = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jPassword1 = new javax.swing.JPasswordField();
        jPassword2 = new javax.swing.JPasswordField();
        jLabelConfirmarSenha = new javax.swing.JLabel();
        jLabelAvisoLogin = new javax.swing.JLabel();
        jLabelAvisoNome = new javax.swing.JLabel();
        jLabelAvisoCpf = new javax.swing.JLabel();
        jLabelPassword1 = new javax.swing.JLabel();
        jLabelPassword2 = new javax.swing.JLabel();
        jFormattedTextLogin = new javax.swing.JFormattedTextField();
        jTextCpf = new javax.swing.JTextField();
        jBtVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuários");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 600));

        jLabelNome.setText("Nome:");
        jLabelNome.setPreferredSize(new java.awt.Dimension(105, 30));

        jLabelLogin.setBackground(java.awt.Color.white);
        jLabelLogin.setText("Login:");
        jLabelLogin.setOpaque(true);
        jLabelLogin.setPreferredSize(new java.awt.Dimension(120, 30));

        jLabelCpf.setText("CPF");
        jLabelCpf.setPreferredSize(new java.awt.Dimension(120, 30));

        jBtSalvar.setText("Salvar");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jLabelTipo.setText("Tipo:");
        jLabelTipo.setPreferredSize(new java.awt.Dimension(120, 30));

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Admin" }));
        jComboBoxTipo.setMinimumSize(new java.awt.Dimension(85, 30));
        jComboBoxTipo.setPreferredSize(new java.awt.Dimension(120, 30));

        jFormattedTextNome.setPreferredSize(new java.awt.Dimension(185, 30));
        jFormattedTextNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextNomeFocusLost(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitle.setText("Cadastro de Usuários");
        jLabelTitle.setPreferredSize(new java.awt.Dimension(500, 30));

        jLabelSenha.setText("Senha:");
        jLabelSenha.setPreferredSize(new java.awt.Dimension(120, 30));

        jPassword1.setPreferredSize(new java.awt.Dimension(185, 30));
        jPassword1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPassword1FocusLost(evt);
            }
        });
        jPassword2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPassword2FocusLost(evt);
            }
        });

        jPassword2.setPreferredSize(new java.awt.Dimension(185, 30));
        jPassword2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPassword2FocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jPassword2FocusLost(evt);
            }
        });

        jLabelConfirmarSenha.setText("Confirmar Senha:");
        jLabelConfirmarSenha.setPreferredSize(new java.awt.Dimension(120, 30));

        jLabelAvisoLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelAvisoLogin.setForeground(java.awt.Color.red);
        jLabelAvisoLogin.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAvisoNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelAvisoNome.setForeground(java.awt.Color.red);
        jLabelAvisoNome.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelAvisoCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelAvisoCpf.setForeground(java.awt.Color.red);
        jLabelAvisoCpf.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelPassword1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelPassword1.setForeground(java.awt.Color.red);
        jLabelPassword1.setPreferredSize(new java.awt.Dimension(185, 30));

        jLabelPassword2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelPassword2.setForeground(java.awt.Color.red);
        jLabelPassword2.setPreferredSize(new java.awt.Dimension(185, 30));

        jFormattedTextLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextLoginActionPerformed(evt);
            }
        });
        jFormattedTextNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextNomeKeyTyped(evt);
            }
        });

        jTextCpf.setPreferredSize(new java.awt.Dimension(185, 30));
        jTextCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCpfKeyTyped(evt);
            }
        });

        jBtVoltar.setText("Voltar");
        jBtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jBtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(
                                                jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                        .createSequentialGroup().addGap(0, 365, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false).addComponent(jLabelSenha,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabelConfirmarSenha,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        111, Short.MAX_VALUE))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPassword1,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jPassword2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabelNome,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabelLogin,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabelCpf,
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jFormattedTextNome,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(jTextCpf,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addComponent(
                                                                                        jFormattedTextLogin,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        185,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabelTipo,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jComboBoxTipo,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                        .addComponent(
                                                                                jLabelAvisoCpf,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                jLabelPassword1,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jLabelPassword2,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jLabelAvisoLogin,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jLabelAvisoNome,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                                .addGap(212, 212, 212))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(200, 200, 200)))))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(40, 40, 40).addComponent(jLabelTitle)
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelAvisoLogin, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jFormattedTextLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelAvisoNome, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFormattedTextNome, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(27, 27, 27)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelAvisoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelTipo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jPassword1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPassword1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtVoltar).addComponent(jBtSalvar))
                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtSalvarActionPerformed
        if (!this.isFormValid()) {
            JOptionPane.showMessageDialog(null, "Verifique os campos e tente novamente");
            return;
        }

        try {
            new UsuariosController().cadastraUsuario(
                jFormattedTextLogin.getText(), 
                jFormattedTextNome.getText(),
                jTextCpf.getText(), 
                Senha.encrypt(new String(jPassword1.getPassword())), 
                jComboBoxTipo.getSelectedItem().toString()
            );

        } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.");
        }
        
        JOptionPane.showMessageDialog(null, "Usuário Cadastrado");
        
        this.clearForm();
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jPassword2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPassword2FocusGained
        jLabelPassword1.setText("");
    }//GEN-LAST:event_jPassword2FocusGained

    private void jPassword1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPassword1FocusLost
        this.checkPassword(jPassword1, jLabelPassword1);
    }//GEN-LAST:event_jPassword1FocusLost

    private void jPassword2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPassword2FocusLost
        this.checkPassword(jPassword2, jLabelPassword2);
    }//GEN-LAST:event_jPassword2FocusLost

    private void jFormattedTextLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextLoginFocusLost
        this.isLoginValid();
    }//GEN-LAST:event_jFormattedTextLoginFocusLost

    private void jFormattedTextNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextNomeFocusLost
        this.isNomeValid();
    }//GEN-LAST:event_jFormattedTextNomeFocusLost

    private void jBtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarActionPerformed
        CadastroUsuario.this.dispose();
        new Usuarios().setVisible(true);
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jTextCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCpfKeyTyped
        if(!String.valueOf(evt.getKeyChar()).matches("[0-9]")){
            evt.consume();
        }
    }//GEN-LAST:event_jTextCpfKeyTyped

    private void jFormattedTextNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextNomeKeyTyped
        if(!String.valueOf(evt.getKeyChar()).matches("[a-zA-Z ]")){
            evt.consume();
        }
    }//GEN-LAST:event_jFormattedTextNomeKeyTyped

    private void jFormattedTextLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtVoltar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JFormattedTextField jFormattedTextNome;
    private javax.swing.JFormattedTextField jFormattedTextLogin;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelConfirmarSenha;
    private javax.swing.JLabel jLabelAvisoLogin;
    private javax.swing.JLabel jLabelAvisoNome;
    private javax.swing.JLabel jLabelAvisoCpf;
    private javax.swing.JLabel jLabelPassword1;
    private javax.swing.JLabel jLabelPassword2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword1;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JTextField jTextCpf;
    // End of variables declaration//GEN-END:variables
}

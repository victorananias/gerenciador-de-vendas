/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JOptionPane;
import helpers.MascaraMonetaria;
import controllers.ProdutosController;

public class CadastroProduto extends javax.swing.JFrame {
   
    private static final long serialVersionUID = 1L;

    public CadastroProduto() {
        this.initComponents();
        this.setLocationRelativeTo(null);
    }

    private void verificaProdNome() {
        if (jTextNome.getText().equals("")) {
            jLabelAviso1.setText("Campo Obrigatório");
        } else {
            jLabelAviso1.setText("");
        }
    }

    private void limparDados() {
        jTextNome.setText("");
        jTextPrecoProd.setText("");
        jTextQntProd.setText("");
        jRBtPerecivel.setSelected(true);
        jRBtN.setSelected(false);
    }

    private void initComponents() {

        btGroupTipo = new javax.swing.ButtonGroup();
        jPanelPrincipal = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelQuantidade = new javax.swing.JLabel();
        jLabelPreco = new javax.swing.JLabel();
        jTextQntProd = new javax.swing.JTextField();
        jBtSalvar = new javax.swing.JButton();
        jLabelTipo = new javax.swing.JLabel();
        jRBtPerecivel = new javax.swing.JRadioButton();
        jRBtN = new javax.swing.JRadioButton();
        jTextNome = new javax.swing.JTextField();
        jLabelAviso1 = new javax.swing.JLabel();
        jBtVoltar = new javax.swing.JButton();
        jTextPrecoProd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        jPanelPrincipal.setBackground(new java.awt.Color(254, 254, 254));
        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(1100, 600));

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelTitle.setText("Cadastro de Produtos");

        jLabelNome.setText("Nome: ");
        jLabelNome.setPreferredSize(new java.awt.Dimension(150, 26));

        jLabelQuantidade.setText("Quantidade:");
        jLabelQuantidade.setPreferredSize(new java.awt.Dimension(150, 26));

        jLabelPreco.setText("Preço:");
        jLabelPreco.setPreferredSize(new java.awt.Dimension(150, 26));

        jTextQntProd.setPreferredSize(new java.awt.Dimension(190, 26));
        jTextQntProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextQntProdKeyTyped(evt);
            }
        });

        jBtSalvar.setText("Salvar");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jLabelTipo.setText("Tipo:");
        jLabelTipo.setPreferredSize(new java.awt.Dimension(110, 26));

        btGroupTipo.add(jRBtPerecivel);
        jRBtPerecivel.setSelected(true);
        jRBtPerecivel.setText("Perecível");
        jRBtPerecivel.setActionCommand("P");

        btGroupTipo.add(jRBtN);
        jRBtN.setText("Não Perecível");
        jRBtN.setActionCommand("N");

        jTextNome.setPreferredSize(new java.awt.Dimension(185, 26));
        jTextNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextNomeFocusLost(evt);
            }
        });
        jTextNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNomeKeyTyped(evt);
            }
        });

        jLabelAviso1.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelAviso1.setForeground(java.awt.Color.red);
        jLabelAviso1.setPreferredSize(new java.awt.Dimension(185, 26));

        jBtVoltar.setText("Voltar");
        jBtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarActionPerformed(evt);
            }
        });

        jTextPrecoProd.setPreferredSize(new java.awt.Dimension(185, 26));
        jTextPrecoProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPrecoProdKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup().addContainerGap().addGroup(jPanelPrincipalLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jBtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addGap(0, 387, Short.MAX_VALUE)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanelPrincipalLayout.createSequentialGroup()
                                                
                                                        .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 117, javax.swing.GroupLayout.DEFAULT_SIZE)
                                                        .addGap(450, 450, 450))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanelPrincipalLayout.createSequentialGroup().addGroup(jPanelPrincipalLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanelPrincipalLayout.createSequentialGroup()
                                                                        .addGroup(jPanelPrincipalLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanelPrincipalLayout
                                                                                        .createSequentialGroup()
                                                                                        .addComponent(jLabelQuantidade,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(jTextQntProd,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                185,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanelPrincipalLayout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                        .addGroup(jPanelPrincipalLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabelPreco,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        Short.MAX_VALUE)
                                                                                                .addComponent(
                                                                                                        jTextPrecoProd,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jPanelPrincipalLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabelNome,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jTextNome,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGap(18, 18, 18).addComponent(jLabelAviso1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                                                .addComponent(jLabelTipo,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jRBtPerecivel).addGap(18, 18, 18)
                                                                .addGroup(jPanelPrincipalLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jBtSalvar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                105,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jRBtN))))
                                                        .addGap(180, 180, 180)))))));
        jPanelPrincipalLayout.setVerticalGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrincipalLayout.createSequentialGroup().addGap(70, 70, 70).addComponent(jLabelTitle)
                        .addGap(50, 50, 50)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelAviso1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                        .addGroup(jPanelPrincipalLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelPrincipalLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextQntProd, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelPrincipalLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelPreco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextPrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelPrincipalLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelTipo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jRBtPerecivel).addComponent(jRBtN))))
                        .addGap(18, 18, 18).addComponent(jBtSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(jBtVoltar).addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtSalvarActionPerformed
        this.verificaProdNome();

        if (jTextNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo \"Nome do Produto\"\n"
                    +"precisa ser preenchido.","Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (jTextQntProd.getText().equals("")) {
            jTextQntProd.setText("0");
        }

        if (jTextPrecoProd.getText().equals("")) {
            jTextPrecoProd.setText("0");
        }

        try {
            new ProdutosController().cadastrarProduto(jTextNome.getText(),
                    btGroupTipo.getSelection().getActionCommand(), Integer.parseInt(jTextQntProd.getText()),
                    MascaraMonetaria.rm(jTextPrecoProd.getText()));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto.", "Aviso",
                JOptionPane.INFORMATION_MESSAGE);
        } 
        
        JOptionPane.showMessageDialog(null, "Produto Cadastrado", "Aviso",
                JOptionPane.INFORMATION_MESSAGE);
        
        this.limparDados();
        
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jTextNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextNomeFocusLost
        this.verificaProdNome();
    }//GEN-LAST:event_jTextNomeFocusLost

    private void jTextNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNomeKeyTyped

    }//GEN-LAST:event_jTextNomeKeyTyped

    private void jTextQntProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextQntProdKeyTyped
        if(!(evt.getKeyChar()+"").matches("[0-9]")){
            evt.consume();
        }
    }//GEN-LAST:event_jTextQntProdKeyTyped

    private void jBtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarActionPerformed
        CadastroProduto.this.dispose();        
        new Estoque().setVisible(true);
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jTextPrecoProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecoProdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecoProdKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btGroupTipo;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtVoltar;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelAviso1;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JRadioButton jRBtN;
    private javax.swing.JRadioButton jRBtPerecivel;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextPrecoProd;
    private javax.swing.JTextField jTextQntProd;
    // End of variables declaration//GEN-END:variables
}

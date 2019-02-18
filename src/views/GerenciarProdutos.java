package views;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controllers.ProdutosController;
import models.Produto;

public class GerenciarProdutos extends javax.swing.JFrame {
    private static final long serialVersionUID = -6891848241748222515L;
    private ArrayList<Produto> produtos;

    DefaultTableModel modelTbProdutos = new DefaultTableModel(new Object[][] {},
            new Object[] { "Código", "Produto", "Em Estoque" }) {
        private static final long serialVersionUID = -7915648948932774004L;
        boolean[] canEdit = new boolean[] { false, false, false, false };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

    public GerenciarProdutos() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.updateTable();
    }

    private void initComponents() {

        JLayeredPanePrincipal = new javax.swing.JLayeredPane();
        jLabelTitle = new javax.swing.JLabel();
        jBtAdicionar = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTbProd = new javax.swing.JTable();
        jBtRemover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBtVoltar = new javax.swing.JButton();
        jTextPesquisa = new javax.swing.JTextField();
        jBtLimpar = new javax.swing.JButton();
        jTextQntProd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Produtos");

        JLayeredPanePrincipal.setBackground(new java.awt.Color(254, 254, 254));
        JLayeredPanePrincipal.setOpaque(true);
        JLayeredPanePrincipal.setPreferredSize(new java.awt.Dimension(1100, 600));

        jLabelTitle.setText("Pesquisar:");

        jBtAdicionar.setText("Adicionar");
        jBtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarActionPerformed(evt);
            }
        });

        jBtSalvar.setText("Salvar");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jTbProd.setModel(this.modelTbProdutos);

        jTbProd.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTbProd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTbProd.setMaximumSize(new java.awt.Dimension(202, 220));
        jTbProd.setMinimumSize(new java.awt.Dimension(202, 220));
        jTbProd.getTableHeader().setReorderingAllowed(false);
        jScrollPane.setViewportView(jTbProd);

        jBtRemover.setText("Remover");
        jBtRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRemoverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Qnt:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Gerenciar Produtos");

        jBtVoltar.setText("Voltar");
        jBtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarActionPerformed(evt);
            }
        });

        jTextPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPesquisaKeyTyped(evt);
            }
        });

        jBtLimpar.setText("Limpar");
        jBtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLimparActionPerformed(evt);
            }
        });

        jTextQntProd.setText("1");
        jTextQntProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextQntProdKeyTyped(evt);
            }
        });

        JLayeredPanePrincipal.setLayer(jLabelTitle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jBtAdicionar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jBtSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jScrollPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jBtRemover, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jBtVoltar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jTextPesquisa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jBtLimpar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JLayeredPanePrincipal.setLayer(jTextQntProd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JLayeredPanePrincipalLayout = new javax.swing.GroupLayout(JLayeredPanePrincipal);
        JLayeredPanePrincipal.setLayout(JLayeredPanePrincipalLayout);
        JLayeredPanePrincipalLayout.setHorizontalGroup(JLayeredPanePrincipalLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JLayeredPanePrincipalLayout.createSequentialGroup()
                        .addGroup(JLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JLayeredPanePrincipalLayout.createSequentialGroup().addContainerGap()
                                        .addComponent(jBtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(JLayeredPanePrincipalLayout.createSequentialGroup().addGap(407, 407, 407)
                                        .addComponent(jLabel3).addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                .addGroup(JLayeredPanePrincipalLayout.createSequentialGroup().addGap(132, 132, 132)
                        .addGroup(JLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(JLayeredPanePrincipalLayout.createSequentialGroup().addComponent(jLabelTitle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 153,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtLimpar))
                                .addGroup(JLayeredPanePrincipalLayout.createSequentialGroup().addComponent(
                                        jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 692,
                                        javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                                        .addGroup(JLayeredPanePrincipalLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(JLayeredPanePrincipalLayout.createSequentialGroup().addGap(6, 6, 6)
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextQntProd))
                                                .addComponent(jBtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jBtRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(148, Short.MAX_VALUE)));
        JLayeredPanePrincipalLayout.setVerticalGroup(JLayeredPanePrincipalLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(JLayeredPanePrincipalLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(jLabel3)
                        .addGap(50, 50, 50)
                        .addGroup(JLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelTitle).addComponent(jBtLimpar))
                        .addGap(18, 18, 18)
                        .addGroup(JLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 318,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        JLayeredPanePrincipalLayout.createSequentialGroup().addGroup(JLayeredPanePrincipalLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextQntProd, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jBtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jBtRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(187, 187, 187)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(JLayeredPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtVoltar).addComponent(jBtSalvar))
                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(JLayeredPanePrincipal,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(JLayeredPanePrincipal,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearTable() {
        // atribuindo zero para o número de linhas
        modelTbProdutos.setNumRows(0);
    }

    private void procurarLinha(String palavra) {

        for (int i = 0; i < jTbProd.getRowCount(); i++) {
            String codProd = jTbProd.getValueAt(i, 1).toString();

            if (codProd.contains(palavra)) {
                jTbProd.setRowSelectionInterval(i, i);
                break;
            }

        }
    }
    

    private void adicionarTbProd() {
        int linhaP = jTbProd.getSelectedRow();
        int qntprod = Integer.parseInt(jTextQntProd.getText());
        int qntAnteriorP = Integer.parseInt(jTbProd.getValueAt(linhaP, 2).toString());
        int novaQntP = qntAnteriorP + qntprod;

        modelTbProdutos.setValueAt(novaQntP, linhaP, 2);
    }

    private void updateTable() {
        this.produtos = new ArrayList<>();

        try {
            this.produtos = new ProdutosController().buscarProdutos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos.");
        }

        for (int i = 0; i < produtos.size(); i++) {
            modelTbProdutos.addRow(new String[]{
                String.valueOf(produtos.get(i).getId()),
                String.valueOf(produtos.get(i).getNome()),
                String.valueOf(produtos.get(i).getQuantidade())});
        }

        jTbProd.setModel(modelTbProdutos);
    }
    
    private void updateProdutos(){

        for (int i = 0; i < produtos.size(); i++) {
            try {
                Produto produto = produtos.get(i);
                produto.setQuantidade(Integer.parseInt(this.jTbProd.getValueAt(i, 2).toString()));
                produto.save();
                
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque.");
            }

        }
    }
    
    private void jBtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarActionPerformed
        if (jTbProd.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
            return;
        }

        if (jTextQntProd.getText() == null){
            JOptionPane.showMessageDialog(null, "Você não digitou uma quantidade");
            return;
        }

        this.adicionarTbProd();
    }//GEN-LAST:event_jBtAdicionarActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        this.updateProdutos();
        JOptionPane.showMessageDialog(null, "Salvo");
        this.clearTable();
        this.updateTable();
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRemoverActionPerformed
        int row = jTbProd.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
            return;
        }

        if (jTextQntProd.getText() == null){
            JOptionPane.showMessageDialog(null, "Você não digitou uma quantidade");
            return;
        }

        int estoque = Integer.parseInt(jTbProd.getValueAt(row, 2).toString());
        int qnt = Integer.parseInt(jTextQntProd.getText());
        int novaQnt = estoque - qnt;

        if (novaQnt < 0) {
            modelTbProdutos.setValueAt(0, row ,2 );
            return;
        }

        modelTbProdutos.setValueAt(novaQnt, row ,2 );

    }//GEN-LAST:event_jBtRemoverActionPerformed

    private void jBtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarActionPerformed
        new Estoque().setVisible(true);
        GerenciarProdutos.this.dispose();
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jTextPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPesquisaKeyTyped
        procurarLinha(jTextPesquisa.getText());
    }//GEN-LAST:event_jTextPesquisaKeyTyped

    private void jBtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLimparActionPerformed
        jTextPesquisa.setText("");
    }//GEN-LAST:event_jBtLimparActionPerformed

    private void jTextQntProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextQntProdKeyTyped
        if(!(evt.getKeyChar()+"").matches("[0-9]")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextQntProdKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAdicionar;
    private javax.swing.JButton jBtLimpar;
    private javax.swing.JButton jBtRemover;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtVoltar;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane JLayeredPanePrincipal;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTbProd;
    private javax.swing.JTextField jTextPesquisa;
    private javax.swing.JTextField jTextQntProd;
    // End of variables declaration//GEN-END:variables
}


package views;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import helpers.MascaraMonetaria;
import controllers.ProdutosController;
import controllers.VendasController;
import models.Produto;
import models.Venda;

public class Vendas extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Produto> produtos = new ArrayList<>();

    DefaultTableModel modelTbCarrinho = new DefaultTableModel(new Object[][] {},
            new Object[] { "Código", "Produto", "Quantidade", "Preço" }) {
        private static final long serialVersionUID = 1L;
        boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };
    
    DefaultTableModel modelTbEstoque = new DefaultTableModel(new Object[][] {},
            new Object[] { "Código", "Produto", "Em Estoque", "Preço Unidade" }) {
        private static final long serialVersionUID = 1L;
        boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };
    
    public Vendas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.updateTbEstoque();
    }
    
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTextPesquisa = new javax.swing.JTextField();
        jBtAdicionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTbCarrinho = new javax.swing.JTable();
        jBtSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbEstoque = new javax.swing.JTable();
        jBtRemover = new javax.swing.JButton();
        jBtLimparCarrinho = new javax.swing.JButton();
        jLabelQnt = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jBtMenu = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jLabelPesquisar = new javax.swing.JLabel();
        jBtLimparPesquisar = new javax.swing.JButton();
        jTextQntProd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vendas");

        jLayeredPane1.setBackground(new java.awt.Color(254, 254, 254));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1100, 600));

        jTextPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPesquisaKeyTyped(evt);
            }

            // public void keyPressed(java.awt.event.KeyEvent evt) {
            //     jTextPesquisaKeyPressed(evt);
            // }
        });

        jBtAdicionar.setText("+");
        jBtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarActionPerformed(evt);
            }
        });

        jTbCarrinho.setModel(modelTbCarrinho);
        // jTbCarrinho.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

        // }, new String[] { "Código", "Produto", "Quantidade", "Preço" }) {
        //     private static final long serialVersionUID = 1L;
        //     Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
        //             java.lang.String.class };
        //     boolean[] canEdit = new boolean[] { false, false, false, false };

        //     public Class getColumnClass(int columnIndex) {
        //         return types[columnIndex];
        //     }

        //     public boolean isCellEditable(int rowIndex, int columnIndex) {
        //         return canEdit[columnIndex];
        //     }
        // });
        jTbCarrinho.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTbCarrinho);
        if (jTbCarrinho.getColumnModel().getColumnCount() > 0) {
            jTbCarrinho.getColumnModel().getColumn(0).setResizable(false);
            jTbCarrinho.getColumnModel().getColumn(1).setResizable(false);
            jTbCarrinho.getColumnModel().getColumn(2).setResizable(false);
            jTbCarrinho.getColumnModel().getColumn(3).setResizable(false);
        }

        jBtSalvar.setText("Salvar");
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jTbEstoque.setModel(modelTbEstoque);
        // jTbEstoque.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

        // }, new String[] { "Código", "Produto", "Em Estoque", "Preço Unidade" }) {
        //     private static final long serialVersionUID = 1L;
        //     Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
        //             java.lang.String.class };
        //     boolean[] canEdit = new boolean[] { false, false, false, false };

        //     public Class getColumnClass(int columnIndex) {
        //         return types[columnIndex];
        //     }

        //     public boolean isCellEditable(int rowIndex, int columnIndex) {
        //         return canEdit[columnIndex];
        //     }
        // });
        jTbEstoque.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTbEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTbEstoque.setMaximumSize(new java.awt.Dimension(202, 220));
        jTbEstoque.setMinimumSize(new java.awt.Dimension(202, 220));
        jTbEstoque.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTbEstoque);

        jBtRemover.setText("-");
        jBtRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRemoverActionPerformed(evt);
            }
        });

        jBtLimparCarrinho.setText("Limpar");
        jBtLimparCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLimparCarrinhoActionPerformed(evt);
            }
        });

        jLabelQnt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelQnt.setText("Qnt:");

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitle.setText("Vendas");

        jBtMenu.setText("Menu");
        jBtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtMenuActionPerformed(evt);
            }
        });

        jLabelTotal.setBackground(java.awt.Color.white);
        jLabelTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTotal.setText(" Total: R$");
        jLabelTotal.setBorder(new javax.swing.border.LineBorder(java.awt.Color.lightGray, 1, true));
        jLabelTotal.setOpaque(true);

        jLabelPesquisar.setText("Pesquisar:");

        jBtLimparPesquisar.setText("Limpar");
        jBtLimparPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLimparPesquisarActionPerformed(evt);
            }
        });

        jTextQntProd.setText("1");
        jTextQntProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextQntProdKeyTyped(evt);
            }
        });

        jLayeredPane1.setLayer(jTextPesquisa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtAdicionar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtRemover, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtLimparCarrinho, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelQnt, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelTitle, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtMenu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabelPesquisar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jBtLimparPesquisar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextQntProd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(jLayeredPane1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGroup(jLayeredPane1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(24, 24, 24)
                                .addGroup(jLayeredPane1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 82,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10).addComponent(jBtLimparPesquisar))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jLayeredPane1Layout.createSequentialGroup().addContainerGap().addComponent(jBtMenu,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(35, 35, 35)
                                        .addGroup(jLayeredPane1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                        .addComponent(jLabelQnt)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextQntProd))
                                                .addComponent(jBtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25)
                                        .addGroup(jLayeredPane1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                        .addComponent(jBtLimparCarrinho,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(43, 43, 43).addComponent(jBtRemover,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jLayeredPane1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 460,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(13, 13, 13)
                                        .addComponent(jLabelTitle)))
                        .addContainerGap(13, Short.MAX_VALUE)));
        jLayeredPane1Layout.setVerticalGroup(jLayeredPane1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(41, 41, 41).addComponent(jLabelTitle)
                        .addGap(108, 108, 108)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelQnt).addComponent(jTextQntProd,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18).addComponent(jBtAdicionar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap(143, Short.MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtLimparPesquisar).addComponent(jLabelTotal,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jLayeredPane1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(
                                        jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtLimparCarrinho).addComponent(jBtRemover))
                        .addGap(82, 82, 82)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBtMenu).addComponent(jBtSalvar))
                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtSalvarActionPerformed
        if (jTbCarrinho.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "O carrinho está vazio");
            return;
        }

        Venda venda = new Venda();

        for (int i = 0; i < jTbCarrinho.getRowCount(); i++) {
            venda.addItem(
                Integer.parseInt(jTbCarrinho.getValueAt(i, 0).toString()),
                Integer.parseInt(jTbCarrinho.getValueAt(i, 2).toString()),
                MascaraMonetaria.rm(jTbCarrinho.getValueAt(i, 3).toString())
            );
        }

        try {
            new VendasController().registrarVenda(venda);
            JOptionPane.showMessageDialog(null, "Venda registrada.");

            modelTbEstoque.setRowCount(0);
            modelTbCarrinho.setRowCount(0);
        } catch (SQLException e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao registrar venda.");
        }

        this.updateTbEstoque();
        this.updateJLabelTotal();
    }// GEN-LAST:event_jBtSalvarActionPerformed
    
    private void jBtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarActionPerformed
        int row = jTbEstoque.getSelectedRow();

        if (row == -1){
            JOptionPane.showMessageDialog(null, "Selecione uma produto do estoque.");
            return;
        }

        int qtdEstoque = Integer.parseInt(jTbEstoque.getValueAt(row, 2).toString());
        int qtdEscolhida = Integer.parseInt(jTextQntProd.getText());
        
        if (qtdEscolhida < 1) {
            JOptionPane.showMessageDialog(null, "Você não digitou uma quantidade válida.");
            return;
        }

        if (qtdEscolhida > qtdEstoque) {
            JOptionPane.showMessageDialog(null, "A quantidade escolhida é maior que a quantidade disponível.");
            return;
        }

        int linhaCarrinho = -1;
        
        for (int i = 0; i < modelTbCarrinho.getRowCount(); i++) {
            if (jTbEstoque.getValueAt(row, 0).toString().equals(jTbCarrinho.getValueAt(i, 0).toString())) {
                linhaCarrinho = i;
                break;
            }
        }

        Produto produto = this.produtos.get(row);

        if (linhaCarrinho >= 0) {
            int qtdCarrinho = qtdEscolhida + Integer.parseInt(jTbCarrinho.getValueAt(linhaCarrinho, 2).toString());
            modelTbCarrinho.setValueAt(qtdCarrinho, linhaCarrinho, 2);
            modelTbCarrinho.setValueAt(MascaraMonetaria.add(qtdCarrinho * produto.getValor()), linhaCarrinho, 3);
        } else {
            modelTbCarrinho.addRow(new String[]{
                String.valueOf(produto.getId()),
                String.valueOf(produto.getNome()),
                String.valueOf(qtdEscolhida),
                String.valueOf(MascaraMonetaria.add(produto.getValor() * qtdEscolhida))
            });
        }
        
        modelTbEstoque.setValueAt(qtdEstoque - qtdEscolhida, row, 2);

        this.updateJTables();
        this.updateJLabelTotal();
    }// GEN-LAST:event_jBtAdicionarActionPerformed

    private void jBtRemoverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBtRemoverActionPerformed
        int row = jTbCarrinho.getSelectedRow();
        int qtdCarrinho = 0;
        int qtdEstoque = 0;
        int linhaEstoque = -1;

        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Você não selecionou um produto do carrinho.");
            return;
        }

        qtdCarrinho = Integer.parseInt(jTbCarrinho.getValueAt(row, 2).toString());
        int quantidadeEscolhida = Integer.parseInt(jTextQntProd.getText());

        if (quantidadeEscolhida < 1) {
            JOptionPane.showMessageDialog(null, "Você não digitou uma quantidade válida.");
            return;
        }

        if (quantidadeEscolhida > qtdCarrinho) {
            qtdEstoque += qtdCarrinho;
            qtdCarrinho = 0;
        } else {
            qtdCarrinho -= quantidadeEscolhida;
            qtdEstoque += quantidadeEscolhida;
        }

        linhaEstoque = this.getRowById(modelTbEstoque, Integer.parseInt(jTbCarrinho.getValueAt(row, 0).toString()));

        int quantidadeAnterior = Integer.parseInt(jTbEstoque.getValueAt(linhaEstoque, 2).toString());
        double valor = this.produtos.get(linhaEstoque).getValor();
        qtdEstoque += quantidadeAnterior;

        modelTbEstoque.setValueAt(qtdEstoque, linhaEstoque, 2);

        if (qtdCarrinho == 0) {
            modelTbCarrinho.removeRow(row);
        } else {
            modelTbCarrinho.setValueAt(qtdCarrinho, row, 2);
            modelTbCarrinho.setValueAt(MascaraMonetaria.add(qtdCarrinho * valor), row, 3);
        }

        this.updateJTables();
        this.updateJLabelTotal();
    }//GEN-LAST:event_jBtRemoverActionPerformed

    private void jBtLimparCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLimparCarrinhoActionPerformed
        modelTbCarrinho.setNumRows(0);
        modelTbEstoque.setNumRows(0);
    }//GEN-LAST:event_jBtLimparCarrinhoActionPerformed

    private void jBtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtMenuActionPerformed
        Vendas.this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_jBtMenuActionPerformed

    private void jTextPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPesquisaKeyTyped
        pesquisar(jTextPesquisa.getText());
    }//GEN-LAST:event_jTextPesquisaKeyTyped

    // private void jTextPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPesquisaKeyPressed
        
    // }//GEN-LAST:event_jTextPesquisaKeyPressed

    private void jBtLimparPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLimparPesquisarActionPerformed
        jTextPesquisa.setText("");
    }//GEN-LAST:event_jBtLimparPesquisarActionPerformed

    private void jTextQntProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextQntProdKeyTyped
        if (!Character.toString(evt.getKeyChar()).matches("[0-9]")){
            evt.consume();
        }
    }//GEN-LAST:event_jTextQntProdKeyTyped

    private int getRowById(DefaultTableModel model, int id) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (Integer.parseInt(jTbEstoque.getValueAt(i, 0).toString()) == id) {
                return i;
            }
        }
        
        return -1;
    }

    private void updateTbEstoque() {
        try {
            this.produtos = new ProdutosController().buscarProdutosEmEstoque();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos.");
        }
        
        for (int i = 0; i < produtos.size(); i++) {
            modelTbEstoque.addRow(new String[]{
                String.valueOf(produtos.get(i).getId()),
                String.valueOf(produtos.get(i).getNome()),
                String.valueOf(produtos.get(i).getQuantidade()),
                String.valueOf(MascaraMonetaria.add(produtos.get(i).getValor())
            )});
        }

        jTbEstoque.setModel(modelTbEstoque);
    }
    
    private void updateJLabelTotal(){
        double total = 0;

        for (int i = 0; i < jTbCarrinho.getRowCount(); i++) {
            total = total + MascaraMonetaria.rm(jTbCarrinho.getValueAt(i, 3).toString());
        }

        jLabelTotal.setText("  Total: " + MascaraMonetaria.add(total));
    }
    
    private void pesquisar(String palavra){
        for (int i = 0; i < jTbEstoque.getRowCount(); i++){
            String nome = jTbEstoque.getValueAt(i, 1).toString();
            
            if (nome.contains(palavra)){
                jTbEstoque.setRowSelectionInterval(i, i);
                break;
            }
        }
    }

    private void updateJTables() {
        jTbCarrinho.setModel(modelTbCarrinho);
        jTbEstoque.setModel(modelTbEstoque);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAdicionar;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtLimparCarrinho;
    private javax.swing.JButton jBtLimparPesquisar;
    private javax.swing.JButton jBtMenu;
    private javax.swing.JButton jBtRemover;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JLabel jLabelQnt;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTbEstoque;
    private javax.swing.JTable jTbCarrinho;
    private javax.swing.JTextField jTextPesquisa;
    private javax.swing.JTextField jTextQntProd;
    // End of variables declaration//GEN-END:variables
}

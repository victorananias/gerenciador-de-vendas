package dao;

import models.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO extends DAO{
    
    public void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO produtos(id, nome, tipo, quantidade, valor)"
                +" VALUES(?,?,?,?,?)";
        
        try {
            insert(
                    sql,
                    produto.getId(),
                    produto.getNome(),
                    produto.getTipo(),
                    produto.getQuantidade(),
                    produto.getValor());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto "+e);
        }
    }
    
    public ArrayList<Produto> buscarProdutos() {
        try {
            return buscar("");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto "+erro);
            return null;
        }
    }
    
    public Produto buscarProduto(int id) {
        ArrayList<Produto> resultado = null;
        try {
            resultado = buscar("where id="+id);
            return resultado.get(0);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos "+erro);
            return null;
        }
    }
    
    public ArrayList<Produto> buscar(String where) throws SQLException {
        ArrayList<Produto> lista = new ArrayList();
        
        String sql = "SELECT id, nome, tipo, quantidade, valor"
                + " FROM produtos "+where;
        
        PreparedStatement pStmt = getConexao().prepareStatement(sql);
        ResultSet resultado = pStmt.executeQuery();

        while (resultado.next()) {
            Produto produto = new Produto();
            produto.setId(resultado.getInt("id"));
            produto.setNome(resultado.getString("nome"));
            produto.setQuantidade(resultado.getInt("quantidade"));
            produto.setTipo(resultado.getString("tipo"));
            produto.setValor(resultado.getDouble("valor"));
            lista.add(produto);
        }
        
        resultado.close();
        pStmt.close();
        getConexao().close();
            
        return lista;
    }
    
    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos set nome = ?, tipo = ?, valor = ? where id = ?";
        try {
            update(sql, produto.getId(), produto.getNome(), produto.getTipo(), produto.getValor());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar informações do produto "+erro);
        }
    }
    
    public void atualizarQuantidade(int id, int quantidade) {
        String sql = "UPDATE produtos SET quantidade = ? WHERE id = ?";
        try {
            this.update(sql, id, quantidade);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar quantidade do produto "+erro);
        }
    }
}

package dao;

import models.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import core.Database;
import core.MySqlConnection;

public class ProdutoDAO extends DAO{
    
    public void cadastrarProduto(Produto produto) {
        Database db = new Database(new MySqlConnection().getConnection());

        String sql = "INSERT INTO produtos(id, nome, tipo, quantidade, valor)"
                +" VALUES(?,?,?,?,?)";
        
        try {
        // db.addToInsert("nome", produto.getNome()).addToInsert("tipo", produto.getTipo())
        //         .addToInsert("quantidade", produto.getQuantidade()).addToInsert("valor", produto.getValor())
        //         .insertInto("produtos");

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
    
    public ArrayList<Produto> getAll() {
        ArrayList<Produto> list = new ArrayList<Produto>();
        
    	Database db = new Database(new MySqlConnection().getConnection());
    	
    	db.select("*", "produtos").get();

        try {
			while (db.next()) {
			    Produto produto = this.makeProduto(db.getResult());
			    list.add(produto);
            }
            
		} catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar quantidade do produto " + erro.toString());
		}

        db.close();
            
        return list;
    }
    
    public Produto find(int id) {
        Database db = new Database(new MySqlConnection().getConnection());

        Produto produto = null;

        db.select("*", "produtos").where("id", "=", Integer.toString(id)).get();

        try {
            while (db.next()) {
                produto = this.makeProduto(db.getResult());
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto " + erro.toString());
        }

        db.close();
            
        return produto;
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

    private Produto makeProduto(ResultSet result) throws SQLException {

    	Produto produto = new Produto();
	    produto.setId(result.getInt("id"));
	    produto.setNome(result.getString("nome"));
	    produto.setQuantidade(result.getInt("quantidade"));
	    produto.setTipo(result.getString("tipo"));
	    produto.setValor(result.getDouble("valor"));
	    
    	return produto;
    }
}

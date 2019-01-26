package dao;

import models.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO extends DAO{
    
    
    
    public ArrayList<Produto> all() {
        ArrayList<Produto> list = new ArrayList<Produto>();
        
        String sql = "SELECT * FROM produtos";

        try {
            this.select(sql);
            
			while (this.nextResult()) {
			    list.add(this.makeProduto(this.result()));
            }

            this.closeConnection();
            
		} catch (SQLException error) {
            System.out.println(error.toString());
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos. ");
		}
            
        return list;
    }
    
    public Produto find(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        Produto produto = new Produto();

        try {
            this.select(sql, id);
            
			if (this.nextResult()) {
			    produto = this.makeProduto(this.result());
            }

            this.closeConnection();

            
		} catch (SQLException error) {
            System.out.println(error.toString());
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos. ");
        }
        
        return produto;
    }
    
    public void update(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, tipo = ?, quantidade = ?, valor = ? WHERE id = ?";

        try {
            this.update(
                sql,
                produto.getNome(),
                produto.getTipo(),
                produto.getQuantidade(),
                produto.getValor(),
                produto.getId()
            );

        } catch (SQLException error) {
            System.out.println(error.toString());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar informações do produto. ");
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

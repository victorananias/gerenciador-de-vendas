package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Produto {
    
    private int id;
    private String nome;
    private String tipo;
    private int quantidade;
    private double valor;
    
    public static Produto build(ResultSet row) throws SQLException {
    	Produto produto = new Produto();
    	
	    produto.setId(row.getInt("id"));
	    produto.setNome(row.getString("nome"));
	    produto.setQuantidade(row.getInt("quantidade"));
	    produto.setTipo(row.getString("tipo"));
	    produto.setValor(row.getDouble("valor"));
	    
    	return produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
     
}

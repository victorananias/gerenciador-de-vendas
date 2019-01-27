package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;

public class Produto {
    
    private int id;
    private String nome;
    private String tipo;
    private int quantidade;
    private double valor;

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
    
    public static Produto find(int id) throws SQLException {
        DAO db = new DAO();
        
        String sql = "SELECT * FROM produtos WHERE id = ?";
        Produto produto = new Produto();

        db.select(sql, id);
        
        if (db.nextResult()) {
            produto = Produto.make(db.result());
        }

        db.closeConnection();
        
        return produto;
    }

    public void save() throws SQLException {
        if (this.getId() != 0) {
            this.update();
        } else {
            this.insert();
        }
    }

    public void insert() throws SQLException {

        DAO db = new DAO();

        String sql = "INSERT INTO produtos(nome, tipo, quantidade, valor) VALUES(?, ?, ?, ?)";
        
        db.insert(
            sql,
            this.nome,
            this.tipo,
            this.quantidade,
            this.valor
        );

        this.setId(db.getLastInsertedId());
    }
    
    public void update() throws SQLException {
        String sql = "UPDATE produtos SET nome = ?, tipo = ?, quantidade = ?, valor = ? WHERE id = ?";

        DAO db = new DAO();

        db.update(
            sql,
            this.nome,
            this.tipo,
            this.quantidade,
            this.valor,
            this.id
        );
    }
    
    public static ArrayList<Produto> all() throws SQLException {
        ArrayList<Produto> list = new ArrayList<Produto>();
        
        String sql = "SELECT * FROM produtos";
        DAO db = new DAO();

        db.select(sql);
        
        while (db.nextResult()) {
            list.add(Produto.make(db.result()));
        }

        db.closeConnection();
            
        return list;
    }

    public static Produto make(ResultSet result) throws SQLException {
        Produto produto = new Produto();
        
	    produto.setId(result.getInt("id"));
	    produto.setNome(result.getString("nome"));
	    produto.setQuantidade(result.getInt("quantidade"));
	    produto.setTipo(result.getString("tipo"));
	    produto.setValor(result.getDouble("valor"));
	    
    	return produto;
    }
     
}

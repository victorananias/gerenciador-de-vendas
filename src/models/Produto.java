package models;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void save() throws SQLException {
        if (this.getId() != 0) return;

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
     
}

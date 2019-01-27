/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;

import dao.DAO;

/**
 *
 * @author victor
 */
public class ItemVenda {
    
    private int id;
    private int quantidade;
    private double valor;
    private int produto_id;
    private int vendaId;
    private String nomeProduto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getProdutoId() {
        return produto_id;
    }

    public void setProdutoId(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public Produto getProduto() throws SQLException {
        DAO db = new DAO();
        
        String sql = "SELECT * FROM produtos WHERE id = ?";

        Produto produto = new Produto();

        db.select(sql, this.produto_id);
        
        if (db.nextResult()) {
            produto = Produto.make(db.result());
        }

        db.closeConnection();
        
        return produto;
    }
    
    public void save() throws SQLException {
        String sql = "INSERT INTO itens_venda(produto_id, quantidade, valor, venda_id)  VALUES(?,?,?,?)";

        DAO db = new DAO();

        db.keepConnectionOpen();
        
        db.insert(
            sql,
            this.getProdutoId(),
            this.getQuantidade(),
            this.getValor(),
            this.getVendaId()
        );
        
        String sqlUpdate = "UPDATE produtos SET quantidade = quantidade - ? where id = ?";
        
        db.update(sqlUpdate, this.getQuantidade(), this.getProdutoId());

        db.closeConnection();
    }

}

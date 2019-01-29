/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import app.DB;

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
    private Produto produto;

    public int getId() {
        return id;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
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
    
    public Produto getProduto() throws SQLException {
        if (produto != null) {
            return this.produto;
        }

        DB db = new DB();
        
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

        DB db = new DB();

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

    public static ItemVenda make(ResultSet resultSet) throws SQLException {
        ItemVenda item = new ItemVenda();

        item.setProduto(Produto.make(resultSet));

        item.setId(resultSet.getInt("iv_id"));
        item.setQuantidade(resultSet.getInt("iv_quantidade"));
        item.setValor(resultSet.getDouble("iv_valor"));
        item.setProdutoId(resultSet.getInt("iv_produto_id"));
        item.setVendaId(resultSet.getInt("iv_venda_id"));

        return item;
    }

}

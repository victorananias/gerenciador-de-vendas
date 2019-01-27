package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Produto;

public class ProdutosController extends Produto {

    public void cadastrarProduto(String nome, String tipo, int quantidade, double valor) throws SQLException {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setTipo(tipo);
        produto.setQuantidade(quantidade);
        produto.setValor(valor);
        produto.save();
    }
    
    public ArrayList<Produto> buscarProdutos() throws SQLException {
        return Produto.all();
    }
    
    public Produto buscarProduto(int codigo) throws SQLException {
        return Produto.find(codigo);
    }
    
    public void atualizarProduto(int id, String nome, String tipo, int quantidade, double valor) 
        throws SQLException {

        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome(nome);
        produto.setTipo(tipo);
        produto.setQuantidade(quantidade);
        produto.setValor(valor);
        produto.save();
    }
    
}

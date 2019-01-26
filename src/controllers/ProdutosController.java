package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.ProdutoDAO;
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
    
    public ArrayList<Produto> buscarProdutos() {
        return new ProdutoDAO().all();
    }
    
    public Produto buscarProduto(int codigo) {
        return new ProdutoDAO().find(codigo);
    }
    
    public void atualizarInfoProduto(Produto produto) {
        new ProdutoDAO().update(produto);
    }
    
    public void atualizarQuantidadeProduto(Produto produto) {
        new ProdutoDAO().update(produto);
    }
    
}

package controllers;

import java.util.ArrayList;
import dao.ProdutoDAO;
import models.Produto;

public class ProdutosController extends Produto{
    
    public void cadastrarProduto(Produto produto) {
        new ProdutoDAO().insert(produto);
    }
    
    public ArrayList<Produto> buscarProdutos() {
        return new ProdutoDAO().getAll();
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

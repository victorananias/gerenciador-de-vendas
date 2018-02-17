package Controllers;

import java.util.ArrayList;
import DAO.ProdutoDAO;
import Models.Produto;

public class ProdutosController extends Produto{
    
    public void cadastrarProduto(Produto produto) {
        new ProdutoDAO().cadastrarProduto(produto);
    }
    
    public ArrayList<Produto> buscarProdutos() {
        return new ProdutoDAO().buscarProdutos();
    }
    
    public Produto buscarProduto(int codigo) {
        return new ProdutoDAO().buscarProduto(codigo);
    }
    
    public void atualizarInfoProduto(Produto produto) {
        new ProdutoDAO().atualizarInfo(produto);
    }
    
    public void atualizarQuantidadeProduto(Produto produto) {
        new ProdutoDAO().atualizarQuantidade(produto);
    }
    
}

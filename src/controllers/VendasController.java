/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ItemVendaDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import models.ItemVenda;
import models.Produto;
import models.Usuario;
import models.Venda;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class VendasController {
    
    public void registrarVenda(Venda venda, ArrayList<ItemVenda> listaItens) {
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.registrarVenda(venda);
        int idVenda = vendaDAO.getUltimoIdInserido();
        registrarItensVenda(listaItens, idVenda);
}
    
    public void registrarItensVenda(ArrayList<ItemVenda> lista, int idVenda) {
        lista.forEach((item) -> {
            item.setVendaId(idVenda);

            Produto produto = new ProdutoDAO().find(item.getProdutoId());

            produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
            new ProdutoDAO().update(produto);
            
            new ItemVendaDAO().registrarItemVenda(item);

        });
    }
    
    public ArrayList<Venda> buscarVendasUsuario(Usuario usuario) {
        if (usuario.getTipo().equals("Admin")) {
            return new VendaDAO().buscarVendas();
        } else {
            return new VendaDAO().buscarVendasUsuario(usuario.getId());
        }
    }
    
    public ArrayList<ItemVenda> buscarItensVenda(int idVenda) {
        return new ItemVendaDAO().buscarItensVenda(idVenda);
    }
    
}

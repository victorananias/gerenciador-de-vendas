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

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class VendasController {

    public void registrarVenda(Venda venda, ArrayList<ItemVenda> listaItens) {
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.insert(venda);
        int idVenda = vendaDAO.getLastInsertedId();
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

    public ArrayList<Venda> buscarVendasUsuario(Usuario usuario) throws SQLException {
        if (usuario.getTipo().equals("Admin")) {
            return new VendaDAO().getAll();
        } else {
            return usuario.getVendas();
        }
    }
    
    public ArrayList<ItemVenda> buscarItensVenda(int idVenda) {
        return new ItemVendaDAO().buscarItensVenda(idVenda);
    }
    
}

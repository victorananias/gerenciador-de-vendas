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
    
    public void registrarItensVenda(ArrayList<ItemVenda> listaItens, int idVenda) {
        System.out.println(idVenda);
        listaItens.stream().map((item) -> {
            item.setVendaId(idVenda);
            return item;
        }).map((item) -> {
            new ItemVendaDAO().registrarItemVenda(item);
            return item;
        }).forEach((item) -> {
            new ProdutoDAO().atualizarQuantidade(item.getProdutoId(), item.getQuantidade());
        });
    }
    
    public ArrayList<Venda> buscarVendasUsuario(Usuario usuario) {
        if(usuario.getTipo().equals("Admin")) {
            return new VendaDAO().buscarVendas();
        }
        else {
            return new VendaDAO().buscarVendasUsuario(usuario.getId());
        }
    }
    
    public ArrayList<ItemVenda> buscarItensVenda(int idVenda) {
        return new ItemVendaDAO().buscarItensVenda(idVenda);
    }
    
}
